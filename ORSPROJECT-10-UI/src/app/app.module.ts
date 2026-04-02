import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { RoleComponent } from './role/role.component';
import { UserComponent } from './user/user.component';
import { CollegeComponent } from './college/college.component';
import { CourseComponent } from './course/course.component';
import { SubjectComponent } from './subject/subject.component';
import { StudentComponent } from './student/student.component';
import { MarksheetComponent } from './marksheet/marksheet.component';
import { TimetableComponent } from './timetable/timetable.component';
import { FacultyComponent } from './faculty/faculty.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { FooterComponent } from './footer/footer.component';
import { NavbarComponent } from './navbar/navbar.component';
import {HTTP_INTERCEPTORS, HttpClient, HttpClientModule} from '@angular/common/http';
import {FormsModule} from '@angular/forms';
import { EndpointServiceService } from './endpoint-service.service';
import { HttpServiceService } from './http-service.service';
import { ServiceLocatorService } from './service-locator.service';
import { AuthServiceService } from './auth-service.service';
import { RoleListComponent } from './role/role-list.component';
import { UserListComponent } from './user/user-list.component';
import { CollegeListComponent } from './college/college-list.component';
import { CourseListComponent } from './course/course-list.component';
import { SubjectListComponent } from './subject/subject-list.component';
import { StudentListComponent } from './student/student-list.component';
import { TimetableListComponent } from './timetable/timetable-list.component';
import { MarksheetListComponent } from './marksheet/marksheet-list.component';
import { FacultyListComponent } from './faculty/faculty-list.component';
import { LoginComponent } from './login/login.component';
import { ForgotpasswordComponent } from './login/forgotpassword.component';
import { TranslateLoader, TranslateModule } from '@ngx-translate/core';
import { TranslateHttpLoader } from '@ngx-translate/http-loader';
import { GetmarksheetComponent } from './marksheet/getmarksheet.component';
import { MarksheetmeritListComponent } from './marksheet/marksheetmerit-list.component';
import { MyprofileComponent } from './user/myprofile.component';




export function HttpLoaderFactory(http: HttpClient) {
  return new TranslateHttpLoader(http, './assets/i18n/', '.json');
}

@NgModule({
  declarations: [
    AppComponent,
    RoleComponent,
    UserComponent,
    CollegeComponent,
    CourseComponent,
    SubjectComponent,
    StudentComponent,
    MarksheetComponent,
    TimetableComponent,
    FacultyComponent,
    DashboardComponent,
    FooterComponent,
    NavbarComponent,
    RoleListComponent,
    UserListComponent,
    CollegeListComponent,
    CourseListComponent,
    SubjectListComponent,
    StudentListComponent,
    TimetableListComponent,
    MarksheetListComponent,
    FacultyListComponent,
    LoginComponent,
    ForgotpasswordComponent,
    GetmarksheetComponent,
    MarksheetmeritListComponent,
    MyprofileComponent,

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    TranslateModule.forRoot({
      loader:{
        provide: TranslateLoader,
        useFactory:HttpLoaderFactory,
        deps: [HttpClient]

      }
    }),
    FormsModule
      
  ],
  providers: [
    {
      provide: HTTP_INTERCEPTORS, useClass: AuthServiceService, multi: true
    },
    HttpServiceService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }