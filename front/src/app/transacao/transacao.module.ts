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
import { TransacaoCadastroComponent } from './transacao-cadastro/transacao-cadastro.component';
import { InputNumberModule } from 'primeng/inputnumber';
import { DropdownModule } from 'primeng/dropdown';

@NgModule({
  declarations: [
    TransacaoCadastroComponent,
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
    InputNumberModule,
    SharedModule,
    DropdownModule
  ],
  exports: [
    TransacaoCadastroComponent,    
  ]
})
export class TransacaoModule { }
