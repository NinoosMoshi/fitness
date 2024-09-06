import { Component } from '@angular/core';
import { DemoAngularZorroModules } from '../../DemoAngularZorroModules';
import { SharedModule } from '../../shared/shared.module';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { NzMessageService } from 'ng-zorro-antd/message';
import { UserService } from '../../service/user.service';

@Component({
  selector: 'app-activity',
  standalone: true,
  imports: [SharedModule],
  templateUrl: './activity.component.html',
  styleUrl: './activity.component.scss'
})
export class ActivityComponent {

  gridStyle = {
    width: '100%',
    textAlign: 'center'
  };

  activityForm!: FormGroup;
  activities: any;

  constructor(private fb: FormBuilder, private message: NzMessageService, private userService: UserService) { }

  ngOnInit() {
    this.activityForm = this.fb.group({
      caloriesBurned: [null, [Validators.required]],
      distance: [null, [Validators.required]],
      steps: [null, [Validators.required]],
      date: [null, [Validators.required]],
    })

    this.getAllActivities();
  }


  submitForm() {
    this.userService.postActivity(this.activityForm.value).subscribe({
      next: res => {
        this.message.success("Activity posted successfully", { nzDuration: 5000 });
        this.activityForm.reset();
        this.getAllActivities();
      },
      error: err => {
        this.message.error("Error while posting Activity", { nzDuration: 5000 });
      }
    })
  }


  getAllActivities() {
    this.userService.getActivities().subscribe({
      next: res => {
        this.activities = res;
      },
      error: err => {
        this.message.error("Error while getting all Activities", { nzDuration: 5000 });
      }
    })
  }


}
