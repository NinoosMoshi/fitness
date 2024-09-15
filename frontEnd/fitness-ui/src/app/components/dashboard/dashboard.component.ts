import { Component, OnInit } from '@angular/core';
import { UserService } from '../../service/user.service';
import { NzMessageService } from 'ng-zorro-antd/message';

@Component({
  selector: 'app-dashboard',
  standalone: true,
  imports: [],
  templateUrl: './dashboard.component.html',
  styleUrl: './dashboard.component.scss'
})
export class DashboardComponent implements OnInit{

  statsData:any;


  constructor(private userService:UserService){}

  ngOnInit(): void {
    this.getStats();
  }

  getStats(){
    this.userService.getStats().subscribe({
      next:res =>{
        console.log(res)
        this.statsData = res
      },
      error:err =>{
        console.log(err.message)
      }
    })
  }

}
