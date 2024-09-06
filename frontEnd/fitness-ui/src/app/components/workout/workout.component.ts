import { Component } from '@angular/core';
import { SharedModule } from '../../shared/shared.module';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { NzMessageService } from 'ng-zorro-antd/message';
import { UserService } from '../../service/user.service';

@Component({
  selector: 'app-workout',
  standalone: true,
  imports: [SharedModule],
  templateUrl: './workout.component.html',
  styleUrl: './workout.component.scss'
})
export class WorkoutComponent {

  gridStyle = {
    width: '100%',
    textAlign: 'center'
  };

  workoutForm!: FormGroup;
  workouts: any

  listOfType: any[] = ["Cardio", "Strength", "Flexibility", "HIIT", "Pilates", "Dance", "Swimming", "Cycling", "Running", "Walking",
    "Boxing", "CrossFit", "Rowing", "Stretching", "Martuak Arts", "Gymnastics", "Climbing", "Plyometrics"
  ]

  constructor(private fb: FormBuilder, private message: NzMessageService, private userService: UserService) { }

  ngOnInit() {
    this.workoutForm = this.fb.group({
      type: [null, [Validators.required]],
      duration: [null, [Validators.required]],
      date: [null, [Validators.required]],
      caloriesBurned: [null, [Validators.required]],
    })

    this.getAllWorkouts();
  }


  submitForm(){
    this.userService.postWorkout(this.workoutForm.value).subscribe({
      next: res => {
        this.message.success("Workout posted successfully", { nzDuration: 5000 });
        this.workoutForm.reset();
        this.getAllWorkouts();
      },
      error: err => {
        this.message.error("Error while posting workout", { nzDuration: 5000 });
      }
    })
  }



  getAllWorkouts(){
    this.userService.getWorkouts().subscribe({
      next:res =>{
         this.workouts = res
      },
      error:err =>{
        this.message.error("Error while getting all Activities", { nzDuration: 5000 });
      }
    })
  }


}
