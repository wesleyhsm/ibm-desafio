import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Cliente, Pessoa, Transacao } from '../core/model';

export class PessoaFiltro {
  nome?: string;
  pagina: number = 0;
  itensPorPagina: number = 5;
}

@Injectable({
  providedIn: 'root'
})
export class TransacaoService {
  pessoasUrl = 'http://localhost:8080/v1/transacao';
  transacaoUrl = 'http://localhost:8080/v1/transacao';
  transacaoTipoUrl = 'http://localhost:8080/v1/transacao/tipo';

  constructor(private http: HttpClient) { }

    cadastrar(transacao: Transacao) {
    const headers = new HttpHeaders()      
      .append('Content-Type', 'application/json');

    return this.http.post<Cliente>(this.transacaoUrl, transacao, { headers }).toPromise();
  }

  tipoTransacoes(): Promise<any> {
    const headers = new HttpHeaders()
    .append('Content-Type', 'application/json');

    return this.http.get(this.transacaoTipoUrl, { headers })
      .toPromise()      
      .then((response: any) => {         
        return response;
      });
  }

  pesquisar(filtro: PessoaFiltro): Promise<any> {

    const headers = new HttpHeaders()
      .append('Authorization', 'Basic YWRtaW5AYWxnYW1vbmV5LmNvbTphZG1pbg==');

    let params = new HttpParams()
      .set('page', filtro.pagina)
      .set('size', filtro.itensPorPagina);

    if (filtro.nome) {
      params = params.set('nome', filtro.nome);
    }

    return this.http.get(`${this.pessoasUrl}`, { headers, params })
      .toPromise()
      .then((response: any) => {
        const pessoas = response['content'];

        const resultado = {
          pessoas,
          total: response['totalElements']
        };

        return resultado;
      });
  }

  listarTodas(): Promise<any> {
    const headers = new HttpHeaders()
      .append('Authorization', 'Basic YWRtaW5AYWxnYW1vbmV5LmNvbTphZG1pbg==');

    return this.http.get(this.pessoasUrl, { headers })
      .toPromise()
      .then((response: any) => response['content']);
  }

  excluir(codigo: number): Promise<void> {
    const headers = new HttpHeaders()
      .append('Authorization', 'Basic YWRtaW5AYWxnYW1vbmV5LmNvbTphZG1pbg==');

    return this.http.delete<void>(`${this.pessoasUrl}/${codigo}`, { headers }).toPromise();
  }

  mudarStatus(codigo: number, ativo: boolean): Promise<void> {
    const headers = new HttpHeaders()
      .append('Authorization', 'Basic YWRtaW5AYWxnYW1vbmV5LmNvbTphZG1pbg==')
      .append('Content-Type', 'application/json');

    return this.http.put<void>(`${this.pessoasUrl}/${codigo}/ativo`, ativo, { headers })
      .toPromise();
  }

  adicionar(pessoa: Pessoa): Promise<Pessoa> {
    const headers = new HttpHeaders()
      .append('Authorization', 'Basic YWRtaW5AYWxnYW1vbmV5LmNvbTphZG1pbg==')
      .append('Content-Type', 'application/json');

    return this.http.post<Pessoa>(this.pessoasUrl, pessoa, { headers })
      .toPromise();
  }
}