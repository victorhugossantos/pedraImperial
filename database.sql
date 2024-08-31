-- CRIAÇÃO DA TABELA MORADORES
CREATE TABLE IF NOT EXISTS moradores (
  id SERIAL PRIMARY KEY,
  nome VARCHAR(100) NOT NULL,
  cpf VARCHAR(14) NOT NULL, 
  telefone VARCHAR(15),
  email VARCHAR(100),
  bloco VARCHAR(3) NOT NULL,
  unidade INTEGER NOT NULL
);

-- CRIAÇÃO DA TABELA VEÍCULOS
CREATE TABLE IF NOT EXISTS veiculos (
  id SERIAL PRIMARY KEY,
  placa VARCHAR(10) UNIQUE NOT NULL, 
  modelo VARCHAR(50), 
  cor VARCHAR(20),
  id_morador INT,
  FOREIGN KEY (id_morador) REFERENCES moradores(id)
);

-- CRIAÇÃO DA TABELA VISITANTES
CREATE TABLE IF NOT EXISTS visitantes (
  id SERIAL PRIMARY KEY,
  nome VARCHAR(100) NOT NULL,
  cpf VARCHAR(14) NOT NULL, 
  data_entrada TIMESTAMP NOT NULL,
  data_saida TIMESTAMP,
  id_morador INT,
  FOREIGN KEY (id_morador) REFERENCES moradores(id)
);

-- CRIAÇÃO DA TABELA ACESSOS
CREATE TABLE IF NOT EXISTS acessos (
  id SERIAL PRIMARY KEY,
  id_veiculo INT,
  data_entrada TIMESTAMP NOT NULL,
  data_saida TIMESTAMP,
  autorizado_por VARCHAR(100),
  FOREIGN KEY (id_veiculo) REFERENCES veiculos(id)
);
