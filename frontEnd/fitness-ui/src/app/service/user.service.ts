import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private BASE_URL = 'http://localhost:8080/api';

  constructor(private http: HttpClient) { }


  postActivity(activityDTO: any): Observable<any> {
    return this.http.post(`${this.BASE_URL}/activity`, activityDTO);
  }


  getActivities(): Observable<any> {
    return this.http.get<any>(`${this.BASE_URL}/activities`);
  }

  postWorkout(workoutDTO: any): Observable<any> {
    return this.http.post(`${this.BASE_URL}/workout`, workoutDTO);
  }

  getWorkouts(): Observable<any> {
    return this.http.get<any>(`${this.BASE_URL}/workouts`);
  }


  postGoal(goalDTO: any): Observable<any> {
    return this.http.post(`${this.BASE_URL}/goal`, goalDTO);
  }

  // http://localhost:8080/api/goals
  getGoals():Observable<any>{
    return this.http.get<any>(`${this.BASE_URL}/goals`);
  }


  // http://localhost:8080/api/goal/status/{id}
  updateGoalStatus(id:number):Observable<any>{
    return this.http.get<any>(`${this.BASE_URL}/goal/status/${id}`);
  }



}
