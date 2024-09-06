import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { DemoAngularZorroModules } from '../DemoAngularZorroModules';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { RouterLink, RouterOutlet } from '@angular/router';



@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    DemoAngularZorroModules,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    RouterLink,
    RouterOutlet
  ],
  exports: [
    CommonModule,
    DemoAngularZorroModules,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    RouterLink,
    RouterOutlet
  ]
})
export class SharedModule { }
