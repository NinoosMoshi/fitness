import { Component, OnInit } from '@angular/core';
import { UserService } from '../../service/user.service';
import { NzMessageService } from 'ng-zorro-antd/message';
import { SharedModule } from '../../shared/shared.module';

@Component({
  selector: 'app-dashboard',
  standalone: true,
  imports: [SharedModule],
  templateUrl: './dashboard.component.html',
  styleUrl: './dashboard.component.scss'
})
export class DashboardComponent implements OnInit{

  statsData:any;
  workouts:any;
  activities:any;


  constructor(private userService:UserService){}

  ngOnInit(): void {
    this.getStats();
    this.getGraphStats();
  }

  getStats(){
    this.userService.getStats().subscribe({
      next:res =>{
        this.statsData = res
      },
      error:err =>{
        console.log(err.message)
      }
    })
  }


  getGraphStats(){
    this.userService.getGraphStats().subscribe({
      next:res => {
        this.workouts = res.workouts;
        this.activities = res.activities;
        console.log(this.workouts, this.activities)
      },
      error:err =>{
        console.log(err.message)
      }
    })
  }

}
