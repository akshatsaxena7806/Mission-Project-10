import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { SignupComponent } from './login/signup.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { UserComponent } from './user/user.component';
import { UserListComponent } from './user/user-list.component';
import { RoleComponent } from './role/role.component';
import { CollegeComponent } from './college/college.component';
import { StudentComponent } from './student/student.component';
import { MarksheetComponent } from './marksheet/marksheet.component';
import { SubjectComponent } from './subject/subject.component';
import { CourseComponent } from './course/course.component';
import { TimetableComponent } from './timetable/timetable.component';
import { FacultyComponent } from './faculty/faculty.component';
import { RoleListComponent } from './role/role-list.component';
import { CollegeListComponent } from './college/college-list.component';
import { StudentListComponent } from './student/student-list.component';
import { MarksheetListComponent } from './marksheet/marksheet-list.component';
import { CourseListComponent } from './course/course-list.component';
import { SubjectListComponent } from './subject/subject-list.component';
import { TimetableListComponent } from './timetable/timetable-list.component';
import { FacultyListComponent } from './faculty/faculty-list.component';
import { ForgotpasswordComponent } from './login/forgotpassword.component';
import { MarksheetmeritListComponent } from './marksheet/marksheetmerit-list.component';
import { GetmarksheetComponent } from './marksheet/getmarksheet.component';
import { MyprofileComponent } from './user/myprofile.component';
import { ChangepasswordComponent } from './change-password/change-password.component';
import { ARObjectComponent } from './arobject/arobject.component';
import { ARObjectListComponent } from './arobject/arobject-list.component';
import { LanguageListComponent } from './language/language-list.component';
import { LanguageComponent } from './language/language.component';
import { DroneListComponent } from './drone/drone-list.component';
import { DroneComponent } from './drone/drone.component';
import { LiveStreamingComponent } from './live-streaming/live-streaming.component';
import { LiveStreamingListComponent } from './live-streaming/live-streaming-list.component';
import { GenderComponent } from './gender/gender.component';
import { GenderListComponent } from './gender/gender-list.component';
import { EmployeeListComponent } from './employee/employee-list.component';
import { EmployeeComponent } from './employee/employee.component';
import { AchievementbadgeComponent } from './achievementbadge/achievementbadge.component';
import { AchievementbadgeListComponent } from './achievementbadge/achievementbadge-list.component';
import { weatherSystemComponent } from './weathersystem/weathersystem.component';
import { WeatherSystemListComponent } from './weathersystem/weathersystem-list.component';
import { BusReservationComponent } from './busreservation/busreservation.component';
import { BusReservationListComponent } from './busreservation/bus-reservation-list.component';
import { ElectricityBillComponent } from './electricity-bill/electricity-bill.component';
import { ElectricityBillListComponent } from './electricity-bill/electricity-bill-list.component';



const routes: Routes = [
  {
    path: '',
    pathMatch: 'full',
    redirectTo: 'dashboard'
  },
  {
    path: 'dashboard',
    component: DashboardComponent
  },
  {
    path: 'login',
    component: LoginComponent
  },
  {
    path: 'signup',
    component: SignupComponent
  },
  {
    path: 'user',
    component: UserComponent
  },
  {
    path: 'user/:id',
    component: UserComponent
  },
  {
    path: 'userlist',
    component: UserListComponent
  },
  {
    path: 'role',
    component: RoleComponent
  },
  {
    path: 'role/:id',
    component: RoleComponent
  },
  {
    path: 'rolelist',
    component: RoleListComponent
  },
  {
    path: 'college',
    component: CollegeComponent
  },
  {
    path: 'college/:id',
    component: CollegeComponent
  },
  {
    path: 'collegelist',
    component: CollegeListComponent
  },
  {
    path: 'student',
    component: StudentComponent
  },
  {
    path: 'student/:id',
    component: StudentComponent
  },
  {
    path: 'studentlist',
    component: StudentListComponent
  },
  {
    path: 'marksheet',
    component: MarksheetComponent
  },
  {
    path: 'marksheet/:id',
    component: MarksheetComponent
  },
  {
    path: 'marksheetlist',
    component: MarksheetListComponent
  },
  {
    path: 'course',
    component: CourseComponent
  },
  {
    path: 'course/:id',
    component: CourseComponent
  },
  {
    path: 'courselist',
    component: CourseListComponent
  },
  {
    path: 'subject',
    component: SubjectComponent
  },
  {
    path: 'subject/:id',
    component: SubjectComponent
  },
  {
    path: 'subjectlist',
    component: SubjectListComponent
  },
  {
    path: 'timetable',
    component: TimetableComponent
  },
  {
    path: 'timetable/:id',
    component: TimetableComponent
  },
  {
    path: 'timetablelist',
    component: TimetableListComponent
  },
  {
    path: 'faculty',
    component: FacultyComponent
  },
  {
    path: 'faculty/:id',
    component: FacultyComponent
  },
  {
    path: 'facultylist',
    component: FacultyListComponent
  },
  {
    path: 'forgotpassword',
    component: ForgotpasswordComponent
  },
   {
    path: 'marksheetmerit-list',
    component: MarksheetmeritListComponent

  },
  {
    path: 'getmarksheet',
    component: GetmarksheetComponent

  },
  {
    path:'myprofile',
    component: MyprofileComponent
  },
  {
   path:'myprofile/:id',
    component: MyprofileComponent
  },
  {
  path:'changepassword',
  component:ChangepasswordComponent
  },
  {
    path:'ARObject',
    component:ARObjectComponent
  },
  {
   path:'ARObject/:id',
    component: ARObjectComponent
  },
  {
  path:'ARObjectlist',
  component:ARObjectListComponent
  },
  {
    path:'Language',
    component:LanguageComponent
  },
  {
   path:'Language/:id',
    component:LanguageComponent
  },
  {
  path:'Languagelist',
  component:LanguageListComponent
  },
  {
    path:'Drone',
    component:DroneComponent
  },
  {
   path:'Drone/:id',
    component:DroneComponent
  },
  {
  path:'Dronelist',
  component:DroneListComponent
  },
  {
    path:'LiveStreaming',
    component:LiveStreamingComponent
  },
  {
   path:'LiveStreaming/:id',
    component:LiveStreamingComponent
  },
  {
  path:'LiveStreaminglist',
  component:LiveStreamingListComponent
  },
  {
    path:'Gender',
    component:GenderComponent
  },
  {
   path:'Gender/:id',
    component:GenderComponent
  },
  {
  path:'Genderlist',
  component:GenderListComponent
  },
 {
    path:'Employee',
    component:EmployeeComponent
  },
  {
   path:'Employee/:id',
    component:EmployeeComponent
  },
  {
  path:'Employeelist',
  component:EmployeeListComponent
  },
  {
    path:'achievement',
    component:AchievementbadgeComponent
  },
  {
   path:'achievement/:id',
    component:AchievementbadgeComponent
  },
  {
  path:'achievementlist',
  component:AchievementbadgeListComponent
  },
  {
    path:'Weather',
    component:weatherSystemComponent
  },
  {
   path:'Weather/:id',
    component:weatherSystemComponent
  },
  {
  path:'Weatherlist',
  component:WeatherSystemListComponent
  },
  {
    path:'BusReservation',
    component:BusReservationComponent
  },
  {
   path:'BusReservation/:id',
    component:BusReservationComponent
  },
  {
  path:'BusReservationList',
  component:BusReservationListComponent
  },
  {
   path:'ElectricityBill',
    component:ElectricityBillComponent
  },
  {
   path:'ElectricityBill/:id',
    component:ElectricityBillComponent
  },
  {
  path:'ElectricityBillList',
  component:ElectricityBillListComponent
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes, { useHash: true })],
  exports: [RouterModule]
})
export class AppRoutingModule { }