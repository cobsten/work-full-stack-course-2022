import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AdminService } from '../admin.service';
import { Admin } from 'src/Objects';
import { CustomValidator } from '../validators/CustomValidator';
import { take } from 'rxjs';

@Component({
  selector: 'app-registration-form',
  templateUrl: './registration-form.component.html',
  styleUrls: ['./registration-form.component.scss']
})
export class RegistrationFormComponent implements OnInit {
  submitted = false;
  registrationForm!: FormGroup;
  constructor(private formBuilder: FormBuilder, private router: Router, private adminService: AdminService) { }

  ngOnInit(): void {
    this.registrationForm = this.formBuilder.group({
      name: ['', [Validators.required, Validators.pattern("[a-zA-Z ]*")]],
      email: ['', [Validators.required, Validators.email]],
      passphrase: ['', Validators.required]
    })
  }
  onSubmit() {
    this.submitted = true;

    if (this.registrationForm.invalid) {
      console.log("Invalid details, form data not submitted!");
      console.log(JSON.stringify(this.registrationForm.value));
      return;
    }
    //Async email too expensive
    let user: Admin = this.registrationForm.value;
    let emailExist: boolean;
    this.adminService.isEmailTaken(user.email).pipe(
      take(1)
    ).subscribe((exists: boolean) => {
      if(exists){
        console.log('Email already exists');
        this.registrationForm.controls['email'].setErrors({'exist': true});
        return;
      }
      console.log('Registered Successfully :-) ' + JSON.stringify(user));
      this.adminService.createUser(user).subscribe(
        {
          next: (v) => console.log(v),
          error: (e) => console.error(e),
          complete: () => console.info('complete')
        }
      );
    });
  }
}

// Business Requirements:
// F. New administrators to register.

// As a New Administrator, I should be able to register myself to keep track and work on the air transport system.
// • An error message is displayed if all the details are not filled
// • An error message is displayed if the email id is already in use by some other user
// • An error message is displayed if the name contains numbers or special characters
// • Password should be a combination of at least an uppercase alphabet, lowercase
// alphabets, a digit, and a special character.
// • A new account is created if all the fields that have been entered by the user are proper.
// • The user should be able to login with his/her emailId and password