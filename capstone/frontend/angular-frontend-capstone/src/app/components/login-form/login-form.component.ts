import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { take } from 'rxjs';
import { Admin } from 'src/Objects';
import { AdminService } from '../../services/admin.service';
import { CustomValidator } from '../../validators/CustomValidator';
import { AuthService } from '../../auth/auth.service';

@Component({
  selector: 'app-login-form',
  templateUrl: './login-form.component.html',
  styleUrls: ['./login-form.component.scss']
})
export class LoginFormComponent implements OnInit{
  submitted = false;
  form!: FormGroup;
  constructor(private formBuilder: FormBuilder, private router: Router, private adminService: AdminService, private authService: AuthService) { }

  ngOnInit(): void {
    this.form = this.formBuilder.group({
      email: ['', Validators.required],
      passphrase: ['', [Validators.required,CustomValidator.createPasswordValidator()]]
    })
  }
  onSubmit() {
    this.submitted = true;
    if (this.form.invalid) {
      console.log("Invalid details, form data not submitted!");
      console.log(JSON.stringify(this.form.value));
      return;
    }
    let user: Admin = this.form.value;
    this.authService.login(user);
    this.router.navigate(['']);
  }
}
