import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';

import { MessageService } from 'primeng/api';

import { ErrorHandlerService } from 'src/app/core/error-handler.service';
import { Cliente } from 'src/app/core/model';
import { ClienteService } from '../cliente.service';

@Component({
  selector: 'app-cliente-cadastro',
  templateUrl: './cliente-cadastro.component.html',
  styleUrls: ['./cliente-cadastro.component.css']
})
export class ClienteCadastroComponent implements OnInit {

  cliente = new Cliente();
  
  constructor(
    private clienteService: ClienteService,
    private messageService: MessageService,
    private errorHandler: ErrorHandlerService
  ) { }

  ngOnInit() {
  }

  salvar(form: NgForm) {    
    this.clienteService.cadastrar(this.cliente)
      .then(() => {
        this.messageService.add({ severity: 'success', detail: 'Cliente adicionado com sucesso!' });

        form.reset();
        this.cliente = new Cliente();
      })
      .catch(erro => {
        var strMail = 'cliente.email_UNIQUE';
        var strConta = 'conta.numero_UNIQUE';
        if(erro.error.detail.indexOf(strMail) != -1){
          this.errorHandler.handle("E-mail já cadastrado, favor inserir outro.")
        }else if(erro.error.detail.indexOf(strConta) != -1){
          this.errorHandler.handle("Número da conta já cadastrado, favor inserir outro.")
        } else {
          this.errorHandler.handle(erro)
        }
      });
  }

}