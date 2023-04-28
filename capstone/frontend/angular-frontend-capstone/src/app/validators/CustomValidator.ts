import { Injectable } from "@angular/core";
import { AbstractControl, AsyncValidatorFn, ValidationErrors, ValidatorFn } from "@angular/forms";
import { AdminService } from "../admin.service";
import { Observable, catchError, map, of } from "rxjs";

export class CustomValidator {

  static createUsernameExistsValidator(adminService: AdminService): AsyncValidatorFn {
    return (control: AbstractControl): Observable<ValidationErrors | null> => {
      return adminService
        .isEmailTaken(control.value)
        .pipe(

          map((result: boolean) => {
            console.log(JSON.stringify(result))
            return result ? { usernameAlreadyExists: true } : null
          }
          )
        );
    };
  }
  static createPasswordValidator(): ValidatorFn {
    return (control: AbstractControl): ValidationErrors | null => {

      const capital = /[A-Z]+/;
      const small = /[a-z]+/;
      const digit = /[0-9]+/;
      const specialChar = /[*+_()=+\-]+/
      const valid = capital.test(control.value) &&
        small.test(control.value) &&
        digit.test(control.value) &&
        specialChar.test(control.value)
      return valid ? null : { pattern: true }
    }
  }
}