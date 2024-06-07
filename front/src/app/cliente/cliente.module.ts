import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';

import { ButtonModule } from 'primeng/button';
import { InputMaskModule } from 'primeng/inputmask';
import { InputTextModule } from 'primeng/inputtext';
import { TableModule } from 'primeng/table';
import { TooltipModule } from 'primeng/tooltip';
import { SharedModule } from '../shared/shared.module';

import { ClienteCadastroComponent } from './cliente-cadastro/cliente-cadastro.component';

@NgModule({
  declarations: [
    ClienteCadastroComponent,
    ],
  imports: [
    CommonModule,
    FormsModule,
    RouterModule,

    InputTextModule,
    ButtonModule,
    TableModule,
    TooltipModule,
    InputMaskModule,

    SharedModule
  ],
  exports: [
    ClienteCadastroComponent,    
  ]
})
export class ClienteModule { }
