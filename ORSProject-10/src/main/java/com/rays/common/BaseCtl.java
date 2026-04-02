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

public class BaseCtl<T extends BaseDTO, F extends BaseForm, S extends BaseServiceInt<T>> {

	@Autowired
	protected S service;

	@Value("${page.size}")
	private int pageSize = 0;

	protected UserContext userContext = null;

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

	@ModelAttribute
	public void setUserContext(HttpSession session) {

		userContext = (UserContext) session.getAttribute("usercontext");

		if (userContext == null) {
			UserDTO dto = new UserDTO();
			dto.setLoginId("sunilos@gmail.com");
			userContext = new UserContext(dto);

		}

	}

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
