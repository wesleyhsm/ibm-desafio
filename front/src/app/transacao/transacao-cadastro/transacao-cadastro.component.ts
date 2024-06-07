import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';

import { MessageService } from 'primeng/api';

import { ErrorHandlerService } from 'src/app/core/error-handler.service';
import { Transacao } from 'src/app/core/model';
import { TransacaoService } from '../transacao.service';

@Component({
  selector: 'app-transacao-cadastro',
  templateUrl: './transacao-cadastro.component.html',
  styleUrls: ['./transacao-cadastro.component.css']
})
export class TransacaoCadastroComponent implements OnInit {

  transacao = new Transacao();
  transassoes: String[] = [];
  
  constructor(
    private transacaoService: TransacaoService,
    private messageService: MessageService,
    private errorHandler: ErrorHandlerService
  ) { }

  ngOnInit() {
    this.buscarTipoTransacao();  
  }

  buscarTipoTransacao(){    
    this.transacaoService.tipoTransacoes().then((dados: any) => {
      this.transassoes = dados;
    });
  }

  salvar(form: NgForm) {
    if(this.transacao.tipo === 'CREDITO' || this.transacao.tipo === 'DEBITO') {
      this.transacaoService.cadastrar(this.transacao)
      .then(() => {
        this.messageService.add({ severity: 'success', detail: 'Transação realizada com sucesso!' });

        form.reset();
        this.transacao = new Transacao();
      })
      .catch(erro => { this.errorHandler.handle(erro.error.detail) });
    } else {
      this.messageService.add({ severity: 'error', detail: 'Selecione o tipo da transação' })
    }    
  }
}