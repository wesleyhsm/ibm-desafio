import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { RouterModule, Routes } from '@angular/router';

import { AppComponent } from './app.component';
import { CoreModule } from './core/core.module';
import { LancamentoCadastroComponent } from './lancamentos/lancamento-cadastro/lancamento-cadastro.component';
import { LancamentosPesquisaComponent } from './lancamentos/lancamentos-pesquisa/lancamentos-pesquisa.component';
import { LancamentosModule } from './lancamentos/lancamentos.module';
import { PessoasPesquisaComponent } from './pessoas/pessoas-pesquisa/pessoas-pesquisa.component';
import { PessoasModule } from './pessoas/pessoas.module';
import { ClienteModule } from './cliente/cliente.module';
import { ClienteCadastroComponent } from './cliente/cliente-cadastro/cliente-cadastro.component';
import { TransacaoCadastroComponent } from './transacao/transacao-cadastro/transacao-cadastro.component';
import { TransacaoModule } from './transacao/transacao.module';
import { ExtratoModule } from './extrato/extrato.module';
import { ExtratoConsultarComponent } from './extrato/extrato-consultar/extrato-consultar.component';

const routes: Routes = [
  { path: 'lancamentos', component: LancamentosPesquisaComponent },
  { path: 'lancamentos/:codigo', component: LancamentoCadastroComponent },
  { path: 'lancamentos/novo', component: LancamentoCadastroComponent },
  { path: 'pessoas', component: PessoasPesquisaComponent },
  { path: 'cliente', component: ClienteCadastroComponent },
  { path: 'transacao', component: TransacaoCadastroComponent },
  { path: 'extrato', component: ExtratoConsultarComponent },
];

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    HttpClientModule,
    RouterModule.forRoot(routes),

    CoreModule,
    LancamentosModule,
    PessoasModule,
    ClienteModule,
    TransacaoModule,
    ExtratoModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
