package com.rays.common;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.rays.dto.UserDTO;

/**
 * Abstract base controller providing common REST endpoints
 * for save, get, delete, and search operations.
 *
 * @param <T> DTO type extending {@link BaseDTO}
 * @param <F> Form type extending {@link BaseForm}
 * @param <S> Service type extending {@link BaseServiceInt}
 * @author Akshat Saxena
 */
public class BaseCtl<T extends BaseDTO, F extends BaseForm, S extends BaseServiceInt<T>> {

    /** Service layer for business logic and data access. */
    @Autowired
    protected S service;

    /** Page size loaded from application properties. */
    @Value("${page.size}")
    private int pageSize = 0;

    /** Current logged-in user context. */
    protected UserContext userContext = null;

    /**
     * Validates form input and returns error response if validation fails.
     *
     * @param bindingResult binding result holding validation errors
     * @return {@link ORSResponse} with success flag and field errors if any
     */
    public ORSResponse validate(BindingResult bindingResult) {

        ORSResponse res = new ORSResponse(true);

        if (bindingResult.hasErrors()) {

            res.setSuccess(false);

            Map<String, String> errors = new HashMap<String, String>();

            List<FieldError> list = bindingResult.getFieldErrors();

            list.forEach(e -> {
                errors.put(e.getField(), e.getDefaultMessage());
            });
            res.addInputError(errors);
        }
        return res;

    }

    /**
     * Sets the user context from the HTTP session before each request.
     * Falls back to a default user if session has no context.
     *
     * @param session current HTTP session
     */
    @ModelAttribute
    public void setUserContext(HttpSession session) {

        userContext = (UserContext) session.getAttribute("usercontext");

        if (userContext == null) {
            UserDTO dto = new UserDTO();
            dto.setLoginId("sunilos@gmail.com");
            userContext = new UserContext(dto);

        }

    }

    /**
     * Saves or updates an entity based on whether an ID is present.
     * Performs duplicate key validation before persisting.
     *
     * @param form          form object containing entity data
     * @param bindingResult validation result
     * @return {@link ORSResponse} with success status and saved entity data
     */
    @PostMapping("/save")
    public ORSResponse save(@RequestBody @Valid F form, BindingResult bindingResult) {

        ORSResponse res = new ORSResponse();

        res = validate(bindingResult);

        if (res.isSuccess() == false) {

            return res;
        }

        try {
            T dto = (T) form.getDTO();

            if (dto.getId() != null) {

                T existDto1 = service.findByUniqueKey(dto.getUniqueKey(), dto.getUniqueValue(), userContext);

                if (existDto1 != null && dto.getId() != existDto1.getId()) {
                    res.setSuccess(false);
                    res.addMessage(dto.getLabel() + "alrady exixt");
                    return res;

                }
                System.out.println("CHECK CODE ============> " + existDto1.getUniqueKey() + existDto1.getUniqueValue());
                service.save(dto, userContext);
                res.setSuccess(true);
                res.addMessage(dto.getTableName() + "data updated successfully");
                res.addData(dto.getId());

            } else {
                if (dto.getUniqueKey() != null && !dto.getUniqueKey().equals("")) {
                    System.out.println("ors object created" + dto.getUniqueKey() + " " + dto.getUniqueValue());
                    T existDto = service.findByUniqueKey(dto.getUniqueKey(), dto.getUniqueValue(), userContext);
                    System.out.println("ors object created" + existDto);
                    if (existDto != null && dto.getId() != existDto.getId()) {
                        System.out.println("ors object c" + res);
                        res.setSuccess(false);
                        res.addMessage(dto.getLabel() + "alrady exist");
                        return res;
                    }

                }
                service.add(dto, userContext);

                res.addMessage(dto.getLabel() + "data added successfully");

            }
            res.addData(dto);

        } catch (Exception e) {
            System.out.println("ors objectE created" + res);
            res.setSuccess(false);
            res.addMessage(e.getMessage());
            e.printStackTrace();
        }
        System.out.println("ors object FINAL" + res);
        return res;
    }

    /**
     * Retrieves a single entity by its primary key.
     *
     * @param id primary key of the entity
     * @return {@link ORSResponse} with entity data or not-found message
     */
    @GetMapping("/get/{id}")
    public ORSResponse get(@PathVariable long id) {

        ORSResponse res = new ORSResponse(true);
        T dto = (T) service.findById(id, userContext);

        if (dto != null) {
            res.addData(dto);

        } else {
            res.setSuccess(false);
            res.addMessage("record not found");

        }

        return res;
    }

    /**
     * Deletes multiple entities by their IDs and returns the updated page.
     *
     * @param ids    array of entity IDs to delete
     * @param pageNo current page number for refreshed results
     * @param form   form object used to re-fetch the updated list
     * @return {@link ORSResponse} with deletion status and updated list
     */
    @PostMapping("deleteMany/{ids}")
    public ORSResponse deleteMany(@PathVariable String[] ids, @RequestParam("pageNo") String pageNo,
            @RequestBody F form) {

        ORSResponse res = new ORSResponse(true);
        try {
            for (String id : ids) {
                service.delete(Long.parseLong(id), userContext);
            }

            T dto = (T) form.getDTO();

            List<T> list = service.search(dto, Integer.parseInt(pageNo), pageSize, userContext);

            List<T> nextList = service.search(dto, Integer.parseInt(pageNo + 1), pageSize, userContext);

            if (list.size() == 0) {
                res.setSuccess(false);
                res.addMessage("Record not found..!!");
            } else {
                res.setSuccess(true);
                res.addMessage("Records Deleted Successfully");
                res.addData(list);
                res.addResult("nextListSize", nextList.size());
            }
        } catch (Exception e) {
            res.setSuccess(false);
            res.addMessage(e.getMessage());
        }
        return res;
    }

    /**
     * Searches entities based on filter criteria with pagination.
     *
     * @param form   form object containing search filters
     * @param pageNo page number to retrieve (zero-based)
     * @return {@link ORSResponse} with matched records or not-found message
     */
    @PostMapping("/search/{pageNo}")
    public ORSResponse search(@RequestBody F form, @PathVariable int pageNo) {

        pageNo = (pageNo < 0) ? 0 : pageNo;

        ORSResponse res = new ORSResponse();

        T dto = (T) form.getDTO();

        List<T> list = service.search(dto, pageNo, pageSize, userContext);

        System.out.println(list);
        try {
            if (list.size() == 0) {
                res.setSuccess(false);
                res.addMessage("record not found");

            } else {
                res.setSuccess(true);
                res.addData(list);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;

    }
}