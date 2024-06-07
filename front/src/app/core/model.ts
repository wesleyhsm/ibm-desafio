export class Endereco {
  logradouro?: string;
  numero?: string;
  complemento?: string;
  bairro?: string;
  cep?: string;
  cidade?: string;
  estado?: string;
}

export class Pessoa {
  codigo?: number;
  nome?: string;
  endereco = new Endereco();
  ativo = true;
}

export class Categoria {
  codigo?: number;
}

export class Lancamento {
  codigo?: number;
  tipo = 'RECEITA';
  descricao?: string;
  dataVencimento?: Date;
  dataPagamento?: Date;
  valor?: number;
  observacao?: string;
  pessoa = new Pessoa();
  categoria = new Categoria();
}

export class Cliente {
  codigo?: number;
  nome?: string;
  email?: string;
  idade?: number;
  numeroConta?: number;
}

export class Transacao {  
  tipo?: string;  
  valor?: number;
  numeroConta: number = 0;
}

export class Conta {    
  saldo?: number;
  dataAtualizacao?: Date;
}

export class TransacaoExtrato {  
  tipo?: string;  
  valor?: number;
  data?: Date;
  numeroConta: number = 0;
  cliente?: ClienteExtrato = new ClienteExtrato();  
}

export class ClienteExtrato {   
  nome?: string;
  email?: string;
  idade?: number;
  conta?: Conta = new Conta();
}