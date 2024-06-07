import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';

import { MessageService } from 'primeng/api';

import { ErrorHandlerService } from 'src/app/core/error-handler.service';
import { Cliente, ClienteExtrato, Conta, Transacao, TransacaoExtrato } from 'src/app/core/model';
import { ExtratoService } from '../extrato.service';
import { DatePipe } from '@angular/common';

@Component({
  selector: 'app-extrato-consultar',
  templateUrl: './extrato-consultar.component.html',
  styleUrls: ['./extrato-consultar.component.css']
})
export class ExtratoConsultarComponent implements OnInit {

  transacao = new Transacao();
  cliente = new ClienteExtrato();  
  conta = new Conta();
  transacoes: Array<TransacaoExtrato> = new Array<TransacaoExtrato>();
  dataFormatada: any = '';

  constructor(
    private extratoService: ExtratoService,
    private messageService: MessageService,
    private errorHandler: ErrorHandlerService
  ) { }

  ngOnInit() {    
  }

  buscarTransacoesPorConta(form: NgForm){
    this.extratoService.todasTransacoesPorConta(this.transacao.numeroConta).then((dados: any) => {      
      this.transacoes = dados;
      this.cliente = this.transacoes[0].cliente || this.cliente;
      this.conta = this.cliente.conta || this.conta;

      const datepipe: DatePipe = new DatePipe('pt-BR');
      let formattedDate = datepipe.transform(this.conta.dataAtualizacao, 'dd/MM/YYYY HH:mm:ss');
      this.dataFormatada = formattedDate;
    });
  }  
}