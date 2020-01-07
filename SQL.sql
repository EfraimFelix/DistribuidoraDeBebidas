drop database if exists `alpha_parnaiba`;
create database alpha_parnaiba;

drop user if exists `teste`;
create user 'teste'@'%' identified by '123';

grant all on *.* to 'teste'@'%' with grant option;
flush privileges;

use alpha_parnaiba;
create table TB_Cliente (
    IdTB_Cliente int not null auto_increment,
    Cliente_Nome varchar(64) not null,
    Cliente_Telefone varchar(15) null,
    Cliente_Endereco varchar(64) not null,
    Cliente_Numero int not null,
    Cliente_Complemento varchar(32) null,
    Cliente_Bairro varchar(64) not null,
    Cliente_Cidade varchar(64) not null,
    Cliente_Estado varchar(2) null,
    Cliente_CEP varchar(10) null,
    Cliente_Sexo varchar(10) null,
    Cliente_Pessoa_F_J varchar(8) null,
    Cliente_CPF_CNPJ varchar(20) null,
    Cliente_Nascimento date null,
    primary key (idTB_Cliente)
    );
create table TB_Estoque (
    TB_Produto_idTB_Produto int not null,
    Estoque_QuantidadeAtual int,
    Estoque_ValorUnitario double(12,2),
    primary key (TB_Produto_idTB_Produto)
    );
create table TB_Fornecedor (
    IdTB_Fornecedor int not null auto_increment,
    Fornecedor_Nome varchar(64) not null,
    Fornecedor_Telefone varchar(16),
    Fornecedor_Email varchar(64),
    Fornecedor_CNPJ varchar(20),
    Fornecedor_CEP varchar(10),
    Fornecedor_Endereco varchar(64),
    Fornecedor_Bairro varchar(64),
    Fornecedor_Cidade varchar(64),
    Fornecedor_Estado varchar(3),
    primary key (idTB_Fornecedor)
    );
create table TB_Cargo (
    IdTB_Cargo int not null auto_increment,
    Cargo_Descricao varchar(64) not null,
    primary key (idTB_Cargo)
    );
create table TB_Funcionario (
    IdTB_Funcionario int not null auto_increment,
    Funcionario_Nome varchar(64) not null,
    Funcionario_Telefone varchar(16) not null,
    TB_Cargo_idTB_Cargo int,
    Funcionario_Salario double(12 , 2 ) not null,
    Funcionario_Bairro varchar(32) null,
    Funcionario_Cidade varchar(64) null,
    Funcionario_Estado varchar(2) null,
    Funcionario_CEP varchar(20) null,
    Funcionario_Sexo varchar(10) null,
    Funcionario_CPF varchar(20) null,
    Funcionario_Nascimento date null,
    primary key (idTB_Funcionario)
    );
create table TB_Marca (
    IdTB_Marca int not null auto_increment,
    Marca_Descricao varchar(64),
    primary key (IdTB_Marca)
    );
create table TB_TipoVenda(
	IdTB_TipoVenda int not null auto_increment,
	TipoVenda_Tipo varchar(32),
	primary key (IdTB_TipoVenda)
    );
create table TB_TipoConta(
	IdTB_TipoConta int not null auto_increment,
	TipoConta_Tipo varchar(32),
	primary key (IdTB_TipoConta)
    );
create table TB_TipoPagamento(
	IdTB_TipoPagamento int not null auto_increment,
	TipoPagamento_Tipo varchar(32),
	primary key (IdTB_TipoPagamento)
    );
create table TB_Usuario(
	IdTB_Usuario int not null auto_increment,
	TB_TipoConta_idTB_TipoConta int not null,
	Usuario_Nome varchar(32),
	Usuario_Email varchar(64),
	Usuario_Senha varchar(32),
	primary key (IdTB_Usuario)
    );
create table TB_ItensPedidoCompra (
    TB_Pedido_idTB_PedidoCompra int not null,
    TB_Produto_idTB_Produto int not null,
    ItensPedidoCompra_Quantidade int,
	ItensPedidoCompra_ValorCusto double(12,6),
    ItensPedidoCompra_ValorUnitario double(12,6),
    ItensPedidoCompra_ValorTotal double(12,2),
    ItensPedido_Operacao varchar(6),
    primary key (TB_Produto_idTB_Produto , TB_Pedido_idTB_PedidoCompra)
    );
create table TB_ItensPedidoVenda (
    TB_Pedido_idTB_PedidoVenda int not null,
    TB_Produto_idTB_Produto int not null,
    ItensPedidoVenda_Quantidade int,
    ItensPedidoVenda_ValorUnitario double(12,6),
    ItensPedidoVenda_ValorTotal double(12,2),
    primary key (TB_Produto_idTB_Produto , TB_Pedido_idTB_PedidoVenda)
    ); 
create table TB_Pagamento (
    TB_PedidoVenda_idTB_PedidoVenda int not null,
    TB_TipoPagamento_idTB_TipoPagamento int,
    Pagamento_ValorRecebido double(12,2),
    Pagamento_Troco double(12,2),
    Pagamento_Status boolean,
    Pagamento_Hora time,
	Pagamento_Data date,
	primary key (TB_PedidoVenda_IdTB_PedidoVenda)
    );
create table TB_Entrega (
    TB_PedidoVenda_idTB_PedidoVenda int not null,
    TB_Funcionario_idTB_Funcionario int,
    Entrega_Status boolean,
    Entrega_Hora time,
	Entrega_Data date,
	primary key (TB_PedidoVenda_IdTB_PedidoVenda)
);
create table TB_PedidoVenda (
    IdTB_PedidoVenda int not null auto_increment,
    TB_Cliente_idTB_Cliente int,
    PedidoVenda_frete double(12,2),
	PedidoVenda_PorcentagemDesconto double(5,2),
    PedidoVenda_ValorDesconto double(12,2),
    PedidoVenda_Total double(12,2),
    TB_TipoVenda_idTB_TipoVenda int not null,
    PedidoVenda_Hora time,
	PedidoVenda_Data date,
	primary key (idTB_PedidoVenda)
);
create table TB_PedidoCompra (
    IdTB_PedidoCompra int not null auto_increment,
    TB_Fornecedor_idTB_Fornecedor int,
    PedidoCompra_frete double(12,2),
	PedidoCompra_PorcentagemDesconto double(5,2),
    PedidoCompra_ValorDesconto double(12,2),
    PedidoCompra_Total double(12,2),
    PedidoCompra_Hora time,
	PedidoCompra_Data date,
	primary key (idTB_PedidoCompra)
);
create table TB_Produto (
    IdTB_Produto int not null auto_increment,
    Produto_Descricao varchar(64),
    TB_Marca_idTB_Marca int,
    Produto_EstoqueMinimo int default 0,
    primary key (idTB_Produto)
);

create table TB_ItensCliente(
    TB_Cliente_idTB_Cliente int not null,
    TB_Produto_idTB_Produto int not null,
    ItensCliente_ValorUnitario Double(12,2) not null,
    primary key (TB_Cliente_idTB_Cliente,TB_Produto_idTB_Produto)
    );
	
create table TB_ConfirmaEntregaCompra(
	TB_PedidoCompra_idTB_PedidoCompra int not null,
	ConfirmaEntregaCompra_Status boolean,
    ConfirmaEntregaCompra_Hora time,
	ConfirmaEntregaCompra_Data date,
	primary key (TB_PedidoCompra_idTB_PedidoCompra)
);
-- ---------------------------- INSERÇÃO DE DADOS PRIMARIOS ----------------------------

insert into TB_TipoConta (TipoConta_Tipo) 
values ('Administrador'); 
insert into TB_TipoConta (TipoConta_Tipo) 
values ('Comum');

insert into TB_TipoVenda (TipoVenda_Tipo) 
values ('Local'); 
insert into TB_TipoVenda (TipoVenda_Tipo) 
values ('Entrega');

insert into TB_TipoPagamento (TipoPagamento_Tipo)
values ('Dinheiro'); 
insert into TB_TipoPagamento (TipoPagamento_Tipo) 
values ('Cartão de Crédito');
insert into TB_TipoPagamento (TipoPagamento_Tipo) 
values ('Cartão de Débito');
 
insert into TB_Usuario (Usuario_Nome, Usuario_Email, TB_TipoConta_IdTB_TipoConta, Usuario_Senha) 
 values ('admin', '', 1, '827ccb0eea8a706c4c34a16891f84e7b');


-- ----------------------------- PROCEDURES DO CLIENTE----------------------------
 -- Procedure Inserir Cliente

DELIMITER $$
drop procedure if exists `alpha_parnaiba`.`inserirCliente` $$
create procedure `alpha_parnaiba`.`inserirCliente` (
  
  in C_Cliente_Nome varchar(64),
  in C_Cliente_Telefone varchar(15),
  in C_Cliente_Endereco varchar(64),
  in C_Cliente_Numero int,
  in C_Cliente_Complemento varchar(32),
  in C_Cliente_Bairro varchar(64),
  in C_Cliente_Cidade varchar(64),
  in C_Cliente_Estado varchar(2),
  in C_Cliente_CEP varchar(10),
  in C_Cliente_Sexo varchar(10),
  in C_Cliente_Pessoa_F_J varchar(8),
  in C_Cliente_CPF_CNPJ varchar(20),
  in C_Cliente_Nascimento date,
  out msg varchar(40)
  )
begin

insert into TB_Cliente (Cliente_Nome, Cliente_Telefone, Cliente_Endereco, Cliente_Numero, Cliente_Complemento, Cliente_Bairro, Cliente_Cidade, Cliente_Estado, Cliente_CEP, Cliente_Sexo, Cliente_Pessoa_F_J, Cliente_CPF_CNPJ, Cliente_Nascimento) 
 values (C_Cliente_Nome, C_Cliente_Telefone, C_Cliente_Endereco, C_Cliente_Numero, C_Cliente_Complemento, C_Cliente_Bairro, C_Cliente_Cidade, C_Cliente_Estado, C_Cliente_CEP, C_Cliente_Sexo, C_Cliente_Pessoa_F_J, C_Cliente_CPF_CNPJ, C_Cliente_Nascimento);
set msg='Cliente cadastrado com sucesso!';

end $$
Delimiter ;
-- --------------------------------------------------------------------
 -- Procedure Alterar Cliente
DELIMITER $$
drop procedure if exists `alpha_parnaiba`.`alterarCliente` $$
create procedure `alpha_parnaiba`.`alterarCliente` (
  in C_IdTB_Cliente int,
  in C_Cliente_Nome varchar(64),
  in C_Cliente_Telefone varchar(15),
  in C_Cliente_Endereco varchar(64),
  in C_Cliente_Numero int,
  in C_Cliente_Complemento varchar(32),
  in C_Cliente_Bairro varchar(64),
  in C_Cliente_Cidade varchar(64),
  in C_Cliente_Estado varchar(2),
  in C_Cliente_CEP varchar(10),
  in C_Cliente_Sexo varchar(10),
  in C_Cliente_Pessoa_F_J varchar(8),
  in C_Cliente_CPF_CNPJ varchar(20),
  in C_Cliente_Nascimento date,
  out msg varchar(40)
  )
begin

update TB_Cliente set  Cliente_Nome=C_Cliente_Nome,
					   Cliente_Telefone=C_Cliente_Telefone,
					   Cliente_Endereco=C_Cliente_Endereco,
                       Cliente_Numero=C_Cliente_Numero,
                       Cliente_Complemento=C_Cliente_Complemento,
					   Cliente_Bairro=C_Cliente_Bairro,
					   Cliente_Cidade=C_Cliente_Cidade,
                       Cliente_Estado=C_Cliente_Estado,
					   Cliente_CEP=C_Cliente_CEP,
					   Cliente_Sexo=C_Cliente_Sexo,
                       Cliente_Pessoa_F_J=C_Cliente_Pessoa_F_J,
					   Cliente_CPF_CNPJ=C_Cliente_CPF_CNPJ,
					   Cliente_Nascimento=C_Cliente_Nascimento									  
                       where IdTB_Cliente=C_IdTB_Cliente;  
                       set msg='Cliente alterado com sucesso!';
end $$
Delimiter ;
-- --------------------------------------------------------------------


 -- Procedure Excluir Cliente

DELIMITER $$
drop procedure if exists `alpha_parnaiba`.`excluirCliente` $$
create procedure `alpha_parnaiba`.`excluirCliente` (

 in C_IdTB_Cliente int,
out msg varchar(40)

)
begin

delete from TB_Cliente  where IdTB_Cliente = C_IdTB_Cliente;
set msg='Cliente excluido com sucesso!';
end $$
Delimiter ;
-- --------------------------------------------------------------------


 -- Procedure Listar Todos Clientes

DELIMITER $$
drop procedure if exists `alpha_parnaiba`.`listarTodosClientes` $$
create procedure `alpha_parnaiba`.`listarTodosClientes` ()
begin

select * from TB_Cliente;
end $$
Delimiter ;
-- --------------------------------------------------------------------

 -- Procedure Consultar Cliente

DELIMITER $$
drop procedure if exists `alpha_parnaiba`.`BuscarCliente` $$
create procedure `alpha_parnaiba`.`BuscarCliente` (
	in C_Cliente_Campo varchar(32),
    in C_Cliente_Consulta varchar(80)
)
begin

select * from tb_cliente where C_Cliente_Campo like 1;
end $$
Delimiter ;
-- ----------------------------FIM PROCEDURES DO CLIENTE--------------------------------
            
	
-- -----------------------------PROCEDURES DO ESTOQUE-----------------------------------

 -- Procedure Listar Todos Estoque

DELIMITER $$
drop procedure if exists `alpha_parnaiba`.`listarTodosEstoque` $$
create procedure `alpha_parnaiba`.`listarTodosEstoque` ()
begin

select E.TB_Produto_idTB_Produto as IdProduto,
       P.Produto_Descricao as ProdutoNome,
       m.Marca_Descricao as Marca,
       E.Estoque_QuantidadeAtual as QuantidadeAtual,
       p.Produto_EstoqueMinimo as EstoqueMin,
       E.Estoque_ValorUnitario as ValorUnit
from TB_Estoque as E 
inner join TB_Produto as P on P.IdTB_Produto = E.TB_Produto_IdTB_Produto
left join tb_marca as m on m.IdTB_Marca = P.TB_Marca_idTB_Marca;

end $$
Delimiter ;

DELIMITER $$
drop procedure if exists `alpha_parnaiba`.`cadastroAlteracaoEstoqueCompra` $$
create procedure `alpha_parnaiba`.`cadastroAlteracaoEstoqueCompra` (
in E_idProduto int,
in E_Quantidade int,
in E_ValorUnit double(12,2)
)
begin
declare idprodutoestoque int;
declare qtd int;

set idprodutoestoque=(select TB_Produto_idTB_Produto from tb_estoque where TB_Produto_idTB_Produto=E_idProduto);
set qtd=(SELECT SUM(Estoque_QuantidadeAtual) FROM tb_estoque where TB_Produto_idTB_Produto =E_idProduto);

if(idprodutoestoque = E_idProduto) then
     update TB_Estoque set  Estoque_QuantidadeAtual=qtd+E_Quantidade,
							Estoque_ValorUnitario=E_ValorUnit
							where TB_Produto_idTB_Produto = E_idProduto;                    
else
     insert into TB_Estoque (TB_Produto_idTB_Produto, Estoque_QuantidadeAtual,Estoque_ValorUnitario)values(E_idProduto,E_Quantidade,E_ValorUnit);
end if;
end $$
Delimiter ;

DELIMITER $$
drop procedure if exists `alpha_parnaiba`.`AlteracaoEstoqueVenda` $$
create procedure `alpha_parnaiba`.`AlteracaoEstoqueVenda` (
in E_idProduto int,
in E_Quantidade int
)
begin
declare qtd int;
set qtd=(SELECT SUM(Estoque_QuantidadeAtual) FROM tb_estoque WHERE Tb_produto_idTB_produto =E_idProduto);
     
     update TB_Estoque set  Estoque_QuantidadeAtual=qtd-E_Quantidade 
							where TB_Produto_idTB_Produto = E_idProduto;
end $$
Delimiter ;

-- -----------------------------FIM PROCEDURES DO ESTOQUE---------------------------------

-- -----------------------------PROCEDURES DO FORNECEDOR-----------------------------------

 -- Procedure Inserir Fornecedor

DELIMITER $$
drop procedure if exists `alpha_parnaiba`.`inserirFornecedor` $$
create procedure `alpha_parnaiba`.`inserirFornecedor` (

 
 in F_Fornecedor_Nome varchar(64),
 in F_Fornecedor_Telefone varchar(16),
 in F_Fornecedor_Email varchar(64),
 in F_Fornecedor_CNPJ varchar(20),
 in F_Fornecedor_CEP varchar(10),
 in F_Fornecedor_Endereco varchar(64),
 in F_Fornecedor_Bairro varchar(64),
 in F_Fornecedor_Cidade varchar(64),
 in F_Fornecedor_Estado varchar(2),
 out msg varchar(40)
)
begin

insert into TB_Fornecedor (Fornecedor_Nome, Fornecedor_Telefone, Fornecedor_Email, Fornecedor_CNPJ, Fornecedor_CEP, Fornecedor_Endereco, Fornecedor_Bairro, Fornecedor_Cidade, Fornecedor_Estado) 
 values (F_Fornecedor_Nome, F_Fornecedor_Telefone, F_Fornecedor_Email, F_Fornecedor_CNPJ, F_Fornecedor_CEP, F_Fornecedor_Endereco, F_Fornecedor_Bairro, F_Fornecedor_Cidade, F_Fornecedor_Estado);
set msg='Fornecedor cadastrado com sucesso!';
end $$
Delimiter ;
-- --------------------------------------------------------------------

 -- Procedure Alterar Fornecedor

DELIMITER $$
drop procedure if exists `alpha_parnaiba`.`alterarFornecedor` $$
create procedure `alpha_parnaiba`.`alterarFornecedor` (

 in F_IdTB_Fornecedor int,
 in F_Fornecedor_Nome varchar(64),
 in F_Fornecedor_Telefone varchar(16),
 in F_Fornecedor_Email varchar(64),
 in F_Fornecedor_CNPJ varchar(20),
 in F_Fornecedor_CEP varchar(10),
 in F_Fornecedor_Endereco varchar(64),
 in F_Fornecedor_Bairro varchar(64),
 in F_Fornecedor_Cidade varchar(64),
 in F_Fornecedor_Estado varchar(64),
 out msg varchar(40)
 
)
begin
update TB_Fornecedor set    Fornecedor_Nome=F_Fornecedor_Nome,
							Fornecedor_Telefone=F_Fornecedor_Telefone,
							Fornecedor_Email=F_Fornecedor_Email,
							Fornecedor_CNPJ=F_Fornecedor_CNPJ,
							Fornecedor_CEP=F_Fornecedor_CEP,
							Fornecedor_Endereco=F_Fornecedor_Endereco,
							Fornecedor_Bairro=F_Fornecedor_Bairro,
							Fornecedor_Cidade=F_Fornecedor_Cidade,
							Fornecedor_Estado=F_Fornecedor_Estado                            
							where F_IdTB_Fornecedor = idTB_Fornecedor;
							set msg='Fornecedor alterado com sucesso!';
end $$
Delimiter ;
-- --------------------------------------------------------------------


 -- Procedure Excluir Fornecedor

DELIMITER $$
drop procedure if exists `alpha_parnaiba`.`excluirFornecedor` $$
create procedure `alpha_parnaiba`.`excluirFornecedor` (

 in F_IdTB_Fornecedor int,
out msg varchar(40)
)
begin

delete from TB_Fornecedor  where IdTB_Fornecedor = F_IdTB_Fornecedor;
set msg='Fornecedor excluido com sucesso!';
end $$
Delimiter ;
-- --------------------------------------------------------------------


 -- Procedure Listar Todos Fornecedor

DELIMITER $$
drop procedure if exists `alpha_parnaiba`.`listarTodosFornecedor` $$
create procedure `alpha_parnaiba`.`listarTodosFornecedor` ()
begin

select * from TB_Fornecedor;
        
end $$
Delimiter ;
-- --------------------------------------------------------------------

 -- Procedure Consultar Fornecedor

DELIMITER $$
drop procedure if exists `alpha_parnaiba`.`BuscarFornecedor` $$
create procedure `alpha_parnaiba`.`BuscarFornecedor` (

	in F_Fornecedor_Consulta varchar(100), 
    in F_Fornecedor_Campo varchar(100)

)
begin

select * from TB_Estoque where F_Fornecedor_Campo like F_Fornecedor_Consulta;

end $$
Delimiter ;

-- Procedure Consultar FornecedorPorNome

DELIMITER $$
drop procedure if exists `alpha_parnaiba`.`BuscarFornecedorPorNome` $$
create procedure `alpha_parnaiba`.`BuscarFornecedorPorNome` (

	in F_Fornecedor_Consulta varchar(100)

)
begin

select * from TB_Fornecedor where Fornecedor_Nome like F_Fornecedor_Consulta;

end $$
Delimiter ;

-- -----------------------------FIM PROCEDURES DO FORNECEDOR---------------------------------

-- ----------------------------- PROCEDURES DO CARGO----------------------------

-- Procedure inserir Cargo
DELIMITER $$
drop procedure if exists `alpha_parnaiba`.`inserirCargo` $$
create procedure `alpha_parnaiba`.`inserirCargo` (
  in C_Cargo_Descricao varchar(64),
  out msg varchar(100)
  )
begin
declare descteste int;
set descteste=(select IdTB_Cargo from Tb_Cargo where Cargo_Descricao=C_Cargo_Descricao);
if(descteste>=1) then 
set msg='Este cargo ja foi cadastrado!';
else
insert into TB_Cargo (Cargo_Descricao) 
 values (C_Cargo_Descricao);
 set msg='Cargo cadastrado com sucesso!';
end if;

end $$
Delimiter ;

-- Procedure Excluir Cargo

DELIMITER $$
drop procedure if exists `alpha_parnaiba`.`excluirCargo` $$
create procedure `alpha_parnaiba`.`excluirCargo` (

 in P_IdTB_Cargo int,
out msg varchar(40)
)
begin
declare testecargo int;
set testecargo=(select Cargo_Descricao from Tb_Cargo where Produto_Nome=P_Produto_Nome);

delete from TB_Produto  where IdTB_Produto = P_IdTB_Produto;
set msg='Produto excluido com sucesso!';
end $$
Delimiter ;
-- -----------------------------FIM PROCEDURES DO CARGO---------------------------------

-- ----------------------------- PROCEDURES DO FUNCIONARIO----------------------------

 -- Procedure Inserir Funcionario


DELIMITER $$
drop procedure if exists `alpha_parnaiba`.`inserirFuncionario` $$
create procedure `alpha_parnaiba`.`inserirFuncionario` (
  in F_Funcionario_Nome varchar(64),
  in F_Funcionario_Telefone varchar(16),
  in F_Funcionario_Cargo varchar(32),
  in F_Funcionario_Salario double(20,2),
  in F_Funcionario_Bairro varchar(32),
  in F_Funcionario_Cidade varchar(64),
  in F_Funcionario_Estado varchar(2),
  in F_Funcionario_CEP varchar(20),
  in F_Funcionario_Sexo varchar(10),
  in F_Funcionario_CPF varchar(20),
  in F_Funcionario_Nascimento date,
  out msg varchar(40)
  )
begin
declare idcargo int;
set idcargo = (Select IdTB_Cargo from tb_cargo where Cargo_Descricao=F_Funcionario_Cargo);
insert into TB_Funcionario (Funcionario_Nome, Funcionario_Telefone, TB_Cargo_idTB_Cargo, Funcionario_Salario, Funcionario_Bairro, Funcionario_Cidade, Funcionario_Estado, Funcionario_CEP, Funcionario_Sexo, Funcionario_CPF, Funcionario_Nascimento) 
 values (F_Funcionario_Nome, F_Funcionario_Telefone, idcargo, F_Funcionario_Salario, F_Funcionario_Bairro, F_Funcionario_Cidade, F_Funcionario_Estado, F_Funcionario_CEP, F_Funcionario_Sexo, F_Funcionario_CPF, F_Funcionario_Nascimento);
set msg='Funcionário cadastrado com sucesso!';
end $$
Delimiter ;
-- --------------------------------------------------------------------

 -- Procedure Alterar Funcionario

DELIMITER $$
drop procedure if exists `alpha_parnaiba`.`alterarFuncionario` $$
create procedure `alpha_parnaiba`.`alterarFuncionario` (
  in F_IdTB_Funcionario int,
  in F_Funcionario_Nome varchar(64),
  in F_Funcionario_Telefone varchar(16),
  in F_Funcionario_Cargo varchar(255),
  in F_Funcionario_Salario double(20,2),
  in F_Funcionario_Bairro varchar(32),
  in F_Funcionario_Cidade varchar(64),
  in F_Funcionario_Estado varchar(2),
  in F_Funcionario_CEP varchar(20),
  in F_Funcionario_Sexo varchar(10),
  in F_Funcionario_CPF varchar(20),
  in F_Funcionario_Nascimento date,
  out msg varchar(40)
  )
begin

declare IdCargo int;
 set IdCargo=(select (idTB_Cargo) from Tb_Cargo where Cargo_Descricao= F_Funcionario_Cargo);
 
update TB_Funcionario set Funcionario_Nome=F_Funcionario_Nome,
					Funcionario_Telefone=F_Funcionario_Telefone,
                    TB_Cargo_idTB_Cargo=IdCargo,
                    Funcionario_Salario=F_Funcionario_Salario,
					Funcionario_Bairro=F_Funcionario_Bairro,
					Funcionario_Cidade=F_Funcionario_Cidade,
                    Funcionario_Estado=F_Funcionario_Estado,
					Funcionario_CEP=F_Funcionario_CEP,
					Funcionario_Sexo=F_Funcionario_Sexo,
					Funcionario_CPF=F_Funcionario_CPF,
					Funcionario_Nascimento=F_Funcionario_Nascimento									  
                   where IdTB_Funcionario=F_IdTB_Funcionario;
                   set msg='Funcionário Atualizado com sucesso!';

end $$
Delimiter ;
-- --------------------------------------------------------------------

 -- Procedure Excluir Funcionario

DELIMITER $$
drop procedure if exists `alpha_parnaiba`.`excluirFuncionario` $$
create procedure `alpha_parnaiba`.`excluirFuncionario` (

 in F_IdTB_Funcionario int,
 out msg varchar(40)
)
begin

delete from TB_Funcionario  where IdTB_Funcionario = F_IdTB_Funcionario;
set msg='Funcionário excluido com sucesso!';
end $$
Delimiter ;
-- --------------------------------------------------------------------


 -- Procedure Listar Todos Funcionarios

DELIMITER $$
drop procedure if exists `alpha_parnaiba`.`listarTodosFuncionarios` $$
create procedure `alpha_parnaiba`.`listarTodosFuncionarios` ()
begin

select f.IdTB_Funcionario as Id,
	   f.Funcionario_Nome as Nome,
       f.Funcionario_Telefone as Telefone,
       c.Cargo_Descricao as Cargo,
       f.Funcionario_Salario as Salario,
       f.Funcionario_Bairro as Bairro,
       f.Funcionario_Cidade as Cidade,
       f.Funcionario_Estado as Uf,
       f.Funcionario_CEP as CEP,
       f.Funcionario_Sexo as Sexo,
       f.Funcionario_CPF as CPF,
       f.Funcionario_Nascimento as Nascimento

 from TB_Funcionario as f
 inner join TB_Cargo as c
 on f.TB_Cargo_idTB_Cargo=c.IdTB_Cargo;
 
end $$
Delimiter ;
-- --------------------------------------------------------------------

 -- Procedure Consultar Funcionario

DELIMITER $$
drop procedure if exists `alpha_parnaiba`.`BuscarFuncionario` $$
create procedure `alpha_parnaiba`.`BuscarFuncionario` (
    in F_Funcionario_Campo varchar(100),
	in F_Funcionario_Consulta varchar(100)
)
begin

select * from TB_Funcionario where F_Funcionario_Campo like CONCAT('%',F_Funcionario_Consulta,'%'); 

end $$
Delimiter ;
create view 

-- ----------------------------FIM PROCEDURES DO FUNCIONARIO--------------------------------



-- ----------------------------- PROCEDURES DO PEDIDOS----------------------------

 -- Procedure Inserir Pedidos


DELIMITER $$
drop procedure if exists `alpha_parnaiba`.`inserirPedidos` $$
create procedure `alpha_parnaiba`.`inserirPedidos` (

  in P_TB_Estoque_idTB_Estoque integer,
  in P_TB_Vendas_idTB_Vendas integer,
  in P_Ped_DataEntrada date,
  in P_Ped_ValorTotal double(6,2),
  in P_Ped_Quantidade int,
  out msg varchar(40)
  )
begin

insert into TB_Pedidos (TB_Estoque_idTB_Estoque, TB_Vendas_idTB_Vendas, Ped_DataEntrada, Ped_ValorTotal, Ped_Quantidade) 
				    values (P_TB_Estoque_idTB_Estoque, P_TB_Vendas_idTB_Vendas, P_Ped_DataEntrada, P_Ped_ValorTotal, P_Ped_Quantidade);
set msg='Cliente cadastrado com sucesso!';
end $$
Delimiter ;
-- --------------------------------------------------------------------

-- -----------------------------PROCEDURES DE MARCA-----------------------------------

 -- Procedure Inserir Marca

DELIMITER $$
drop procedure if exists `alpha_parnaiba`.`inserirMarca` $$
create procedure `alpha_parnaiba`.`inserirMarca` (
 in M_Marca_Descricao varchar(64),
 out msg varchar(40)
)
begin
declare verificamarca varchar(64);
 set verificamarca=(select (Marca_Descricao) from Tb_Marca where Marca_Descricao=M_Marca_Descricao);
 
 if(verificamarca = M_Marca_Descricao) then  
set msg='Esta marca ja foi cadastrada!';
else
insert into TB_Marca (Marca_Descricao) 
 values (M_Marca_Descricao); 
set msg='Marca cadastrada com sucesso!';

end if;
 

end $$
Delimiter ;
-- -----------------------------FIM PROCEDURES DE MARCA---------------------------------


-- ----------------------------- PROCEDURES DO PRODUTO----------------------------
 -- Procedure Inserir Produto

DELIMITER $$
drop procedure if exists `alpha_parnaiba`.`inserirProduto` $$
create procedure `alpha_parnaiba`.`inserirProduto` (
  
  in P_Produto_Descricao varchar(64),
  in P_Marca Varchar(64),
  in P_Produto_EstoqueMinimo int,
  out msg varchar(64)  
  )
begin
declare verificaproduto varchar(64);
declare marca int;
 set verificaproduto=(select (Produto_Descricao) from Tb_Produto where Produto_Descricao=P_Produto_Descricao order by IdTB_Produto desc limit 1);
 set marca=(select (idTB_Marca) from Tb_Marca where Marca_Descricao=P_Marca);
  
 if(verificaproduto =P_Produto_Descricao) then 
 
set msg='Este nome de produto ja foi cadastrado!';

else 
insert into TB_Produto (Produto_Descricao,TB_Marca_idTB_Marca,Produto_EstoqueMinimo ) 
 values (P_Produto_Descricao, marca,P_Produto_EstoqueMinimo);
 
set msg='Produto cadastrado com sucesso!';

end if;
end $$
Delimiter ;
-- --------------------------------------------------------------------
 -- Procedure Alterar Produto
DELIMITER $$
drop procedure if exists `alpha_parnaiba`.`alterarProduto` $$
create procedure `alpha_parnaiba`.`alterarProduto` (
  in P_IdTB_Produto int,
  in P_Produto_Descricao varchar(64),
  in P_Marca varchar(64),
  in P_Produto_EstoqueMinimo int,
  out msg varchar(40)  
  )
begin
declare IdMarca int;
set IdMarca=(select (idTB_Marca) from TB_Marca where Marca_Descricao=P_Marca);
update TB_Produto set  Produto_Descricao=P_Produto_Descricao,
					   TB_Marca_idTB_Marca=IdMarca,
                       Produto_EstoqueMinimo=P_Produto_EstoqueMinimo					   
                       where IdTB_Produto=P_IdTB_Produto;  
                       set msg='Produto alterado com sucesso!';
end $$
Delimiter ;
-- --------------------------------------------------------------------


 -- Procedure Excluir Produto

DELIMITER $$
drop procedure if exists `alpha_parnaiba`.`excluirProduto` $$
create procedure `alpha_parnaiba`.`excluirProduto` (

 in P_IdTB_Produto int,
out msg varchar(40)

)
begin
declare verificaproduto int;
set verificaproduto=(select (TB_Pedido_idTB_PedidoVenda) from TB_ItensPedidoVenda where TB_Produto_idTB_Produto=P_IdTB_Produto);
if(verificaproduto >=1) then 
set msg='Este produto está relacionado com algum pedido';
else
delete from TB_Produto  where IdTB_Produto = P_IdTB_Produto;
set msg='Produto excluido com sucesso!';
end if;
end $$
Delimiter ;
-- --------------------------------------------------------------------


 -- Procedure Listar Todos Produtos

DELIMITER $$
drop procedure if exists `alpha_parnaiba`.`listarTodosProdutos` $$
create procedure `alpha_parnaiba`.`listarTodosProdutos` ()
begin
select p.IdTB_Produto as Id,
	   p.Produto_Descricao as Descricao,
       m.Marca_Descricao as Marca,
       p.Produto_EstoqueMinimo as EstoqueMinimo
 from TB_Produto as p
 inner join TB_Marca as m
 on p.TB_Marca_idTB_Marca=m.IdTB_Marca;
end $$
Delimiter ;
-- --------------------------------------------------------------------

 -- Procedure Consultar Produto

DELIMITER $$
drop procedure if exists `alpha_parnaiba`.`BuscarProduto` $$
create procedure `alpha_parnaiba`.`BuscarProduto` (
	in P_Produto_Campo varchar(20),
    in P_Produto_Consulta varchar(20)
)
begin
select * from tb_produto where P_Produto_Campo like '%P_Produto_Consulta%';

end $$
Delimiter ;
-- ----------------------------FIM PROCEDURES DO PRODUTO--------------------------------


-- -----------------------------PROCEDURES DO CONFIRMAENTREGACOMPRA-----------------------------------

DELIMITER $$
drop procedure if exists `alpha_parnaiba`.`confirmaEntregaCompra` $$
create procedure `alpha_parnaiba`.`confirmaEntregaCompra` (
	in CC_TB_PedidoCompra_idTB_PedidoCompra int,
    in CC_ConfirmaEntregaCompra_Hora time,
	in CC_ConfirmaEntregaCompra_Data date,
    out msg varchar(40)
)
begin

update TB_ConfirmaEntregaCompra set  TB_PedidoCompra_idTB_PedidoCompra=CC_TB_PedidoCompra_idTB_PedidoCompra,
					   ConfirmaEntregaCompra_Status=true,
                       ConfirmaEntregaCompra_Hora=CC_ConfirmaEntregaCompra_Hora,
                       ConfirmaEntregaCompra_Data=CC_ConfirmaEntregaCompra_Data
                       where TB_PedidoCompra_idTB_PedidoCompra=CC_TB_PedidoCompra_idTB_PedidoCompra;  
                       set msg='Compra confirmada com sucesso!';
end $$
Delimiter ;

-- -----------------------------FIM PROCEDURES DO CONFIRMACOMPRA-----------------------------------


-- -----------------------------PROCEDURES DO ITENSPEDIDOCOMPRA-----------------------------------

 -- Procedure Inserir ItensPedidoCompra

DELIMITER $$
drop procedure if exists `alpha_parnaiba`.`inserirItensPedidoCompra` $$
create procedure `alpha_parnaiba`.`inserirItensPedidoCompra` (
    
    in IPC_TB_Produto_idTB_Produto int,
    in IPC_ItensPedidoCompra_Quantidade int,
	in IPC_ItensPedidoCompra_ValorCusto double(12,2),
    in IPC_ItensPedidoCompra_ValorUnitario double(12,2),
    in IPC_ItensPedidoCompra_ValorTotal double(12,2),
    out msg varchar(64)
)

begin
declare E_idPedidoCompra int;
set E_idPedidoCompra=(select IdTB_PedidoCompra FROM TB_PedidoCompra ORDER BY IdTB_PedidoCompra DESC LIMIT 1);

insert into TB_ItensPedidoCompra (TB_Pedido_idTB_PedidoCompra, TB_Produto_idTB_Produto, ItensPedidoCompra_Quantidade, ItensPedidoCompra_ValorCusto, ItensPedidoCompra_ValorUnitario, ItensPedidoCompra_ValorTotal) 
						  values (E_idPedidoCompra, IPC_TB_Produto_idTB_Produto, IPC_ItensPedidoCompra_Quantidade, IPC_ItensPedidoCompra_ValorCusto, IPC_ItensPedidoCompra_ValorUnitario, IPC_ItensPedidoCompra_ValorTotal);

end $$
Delimiter ;

 -- Procedure Listar Todos Itens Pedido Compra

DELIMITER $$
drop procedure if exists `alpha_parnaiba`.`ListarItensPedidoCompra` $$
create procedure `alpha_parnaiba`.`ListarItensPedidoCompra` (
in IdPedidoCompra int
)
begin
select p.IdTB_Produto as ID,
       p.Produto_Descricao as Descricao,
       m.Marca_Descricao as Marca,
       tb_ipc.ItensPedidoCompra_Quantidade as Quantidade,
       tb_ipc.ItensPedidoCompra_ValorTotal as SubTotal,
       tb_ipc.ItensPedidoCompra_ValorCusto as ValorCusto,
       tb_ipc.ItensPedidoCompra_ValorUnitario as ValorUnit
 from tb_itensPedidoCompra as tb_ipc
 left join tb_produto as p
 on tb_ipc.TB_Produto_idTB_Produto=p.IdTB_Produto
 left join tb_marca as m
 on p.TB_Marca_idTB_Marca=m.IdTB_Marca
 where TB_Pedido_idTB_PedidoCompra=IdPedidoCompra;
end $$
Delimiter ;

 -- Procedure Excluir ItensPedidoCompra

DELIMITER $$
drop procedure if exists `alpha_parnaiba`.`excluirItensPedidoCompra` $$
create procedure `alpha_parnaiba`.`excluirItensPedidoCompra` (

 in IPC_IdTB_PedidoCompra int

)
begin
delete from tb_itenspedidocompra  where TB_Pedido_idTB_PedidoCompra = IPC_IdTB_PedidoCompra;
end $$
Delimiter ;
-- --------------------------------------------------------------------

-- -----------------------------FIM PROCEDURES DO ITENSPedidoCompra---------------------------------


-- ----------------------------- PROCEDURES DO PedidoCompra-----------------------------------------

 -- Procedure Inserir PedidoCompra

DELIMITER $$
drop procedure if exists `alpha_parnaiba`.`inserirPedidoCompra` $$
create procedure `alpha_parnaiba`.`inserirPedidoCompra` (
  
    in PC_TB_Fornecedor_idTB_Fornecedor int,
    in PC_PedidoCompra_Frete double(12,2),
	in PC_PedidoCompra_PorcentagemDesconto double(5,2),
    in PC_PedidoCompra_ValorDesconto double(12,2),
    in PC_PedidoCompra_Total double(12,2),
    in PC_PedidoCompra_Hora time,
	in PC_PedidoCompra_Data date,
  out msg varchar(40)
  )
begin
declare IdPedido int;

insert into TB_PedidoCompra (TB_Fornecedor_idTB_Fornecedor, PedidoCompra_frete, PedidoCompra_PorcentagemDesconto, PedidoCompra_ValorDesconto, PedidoCompra_Total, PedidoCompra_Hora, PedidoCompra_Data) 
values (PC_TB_Fornecedor_idTB_Fornecedor, PC_PedidoCompra_frete, PC_PedidoCompra_PorcentagemDesconto, PC_PedidoCompra_ValorDesconto, PC_PedidoCompra_Total, PC_PedidoCompra_Hora, PC_PedidoCompra_Data);

set IdPedido=(select IdTB_PedidoCompra FROM TB_PedidoCompra ORDER BY IdTB_PedidoCompra DESC LIMIT 1);
insert into TB_ConfirmaEntregaCompra (TB_PedidoCompra_idTB_PedidoCompra,ConfirmaEntregaCompra_Status) 
							  values (IdPedido,false);

set msg='Pedido de compra cadastrado com sucesso!';

end $$
Delimiter ;
-- --------------------------------------------------------------------

-- Procedure Inserir PedidoCompra

DELIMITER $$
drop procedure if exists `alpha_parnaiba`.`alterarPedidoCompra` $$
create procedure `alpha_parnaiba`.`alterarPedidoCompra` (
    in PC_IdPedidoCompra int,
    in PC_TB_Fornecedor_idTB_Fornecedor int,
    in PC_PedidoCompra_Frete double(12,2),
	in PC_PedidoCompra_PorcentagemDesconto double(5,2),
    in PC_PedidoCompra_ValorDesconto double(12,2),
    in PC_PedidoCompra_Total double(12,2),
    in PC_PedidoCompra_Hora time,
	in PC_PedidoCompra_Data date,
  out msg varchar(40)
  )
begin

update TB_PedidoCompra set TB_Fornecedor_idTB_Fornecedor=PC_TB_Fornecedor_idTB_Fornecedor,
					  PedidoCompra_frete=PC_PedidoCompra_frete,
					  PedidoCompra_PorcentagemDesconto=PC_PedidoCompra_PorcentagemDesconto,
					  PedidoCompra_ValorDesconto=PC_PedidoCompra_ValorDesconto,
                      PedidoCompra_Total=PC_PedidoCompra_Total,
                      PedidoCompra_Hora=PC_PedidoCompra_Hora,
                      PedidoCompra_Data=PC_PedidoCompra_Data
                      where IdTB_PedidoCompra=PC_IdPedidoCompra;

set msg='Pedido de compra alterado com sucesso!';

end $$
Delimiter ;
-- --------------------------------------------------------------------

 -- Procedure Excluir PedidoCompra

DELIMITER $$
drop procedure if exists `alpha_parnaiba`.`excluirPedidoCompra` $$
create procedure `alpha_parnaiba`.`excluirPedidoCompra` (

 in PC_IdTB_PedidoCompra int,
out msg varchar(40)

)
begin

delete from TB_PedidoCompra  where IdTB_PedidoCompra = PC_IdTB_PedidoCompra;
set msg='Pedido de compra excluido com sucesso!';
end $$
Delimiter ;
-- --------------------------------------------------------------------


 -- Procedure Listar Todos PedidoCompras

DELIMITER $$
drop procedure if exists `alpha_parnaiba`.`listarTodosPedidoCompra` $$
create procedure `alpha_parnaiba`.`listarTodosPedidoCompra` ()
begin

select pc.IdTB_PedidoCompra as IdPedidoCompra,
       f.IdTB_Fornecedor as IdFornecedor,
       f.Fornecedor_Nome as Fornecedor,
       pc.PedidoCompra_frete as Frete,
       pc.PedidoCompra_PorcentagemDesconto as DescontoPorcentagem,
       pc.PedidoCompra_ValorDesconto as Desconto,
       pc.PedidoCompra_Total as Total,
       conf.ConfirmaEntregaCompra_Status as 'Status',
       pc.PedidoCompra_Hora as Hora,
       pc.PedidoCompra_Data as 'Data'
       
 from TB_PedidoCompra as pc
 left join tb_confirmaentregacompra as conf
 on conf.TB_PedidoCompra_idTB_PedidoCompra=pc.IdTB_PedidoCompra
 left join TB_Fornecedor as f
 on pc.TB_Fornecedor_idTB_Fornecedor=f.IdTB_Fornecedor;
 
end $$
Delimiter ;

 -- Procedure Listar Todos Pedido Compra Por Id

DELIMITER $$
drop procedure if exists `alpha_parnaiba`.`listarTodosPedidoCompraPorID` $$
create procedure `alpha_parnaiba`.`listarTodosPedidoCompraPorID` (
in idPedidoCompra int
)
begin

select pc.IdTB_PedidoCompra as 'IdPedidoCompra',
	   f.IdTB_Fornecedor as 'IdFornecedor',
       f.Fornecedor_Nome as 'Fornecedor',
       pc.PedidoCompra_frete as 'Frete',
       pc.PedidoCompra_PorcentagemDesconto as 'DescontoPorcentagem',
       pc.PedidoCompra_ValorDesconto as 'Desconto',
       pc.PedidoCompra_Total as 'Total',
       conf.ConfirmaEntregaCompra_Status as 'Status',
       pc.PedidoCompra_Hora as 'Hora',
       pc.PedidoCompra_Data as 'Data'
 from tb_PedidoCompra as pc
 left join tb_confirmaentregacompra as conf
 on conf.TB_PedidoCompra_idTB_PedidoCompra=pc.IdTB_PedidoCompra
 left join tb_fornecedor as f
 on pc.TB_Fornecedor_idTB_Fornecedor=f.IdTB_Fornecedor
 where pc.IdTB_PedidoCompra=idPedidoCompra;
end $$
Delimiter ;

 -- Procedure Consultar PedidoCompra

DELIMITER $$
drop procedure if exists `alpha_parnaiba`.`BuscarPedidoCompra` $$
create procedure `alpha_parnaiba`.`BuscarPedidoCompra` (
	in PC_PedidoCompra_Campo varchar(20),
    in PC_PedidoCompra_Consulta varchar(20)
)
begin
select * from tb_cliente where PC_PedidoCompra_Campo like PC_PedidoCompra_Consulta;

end $$
Delimiter ;
-- ----------------------------FIM PROCEDURES DO PedidoCompra--------------------------------

-- ----------------------------PROCEDURES DE CONFIRMACOES DE VENDA--------------------------------

-- Procedure Confirma Pagamento de Venda

DELIMITER $$
drop procedure if exists `alpha_parnaiba`.`ConfirmaPagamentoVenda` $$
create procedure `alpha_parnaiba`.`ConfirmaPagamentoVenda` (
    in CPV_IdTB_PedidoVenda int,
    in CPV_TB_TipoPagamento_idTB_TipoPagamento varchar(64),
    in CPV_Pagamento_ValorRecebido double(12,2),
    in CPV_Pagamento_Troco double(12,2),
    in CPV_Pagamento_Hora time,
	in CPV_Pagamento_Data date
    )
begin
declare tipopag int;
set tipopag=(select (IdTB_TipoPagamento) from tb_tipopagamento where TipoPagamento_Tipo=CPV_TB_TipoPagamento_idTB_TipoPagamento);
update tb_pagamento set TB_TipoPagamento_idTB_TipoPagamento = tipopag,
					Pagamento_ValorRecebido = CPV_Pagamento_ValorRecebido,
                    Pagamento_Troco = CPV_Pagamento_Troco,
                    Pagamento_Status = true,
                    Pagamento_Hora  = CPV_Pagamento_Hora,
                    Pagamento_Data = CPV_Pagamento_Data
                   where TB_PedidoVenda_IdTB_PedidoVenda=CPV_IdTB_PedidoVenda;
end $$
Delimiter ;

-- Procedure Confirma Entrega de Venda

DELIMITER $$
drop procedure if exists `alpha_parnaiba`.`ConfirmaEntregaVenda`  $$
create procedure `alpha_parnaiba`.`ConfirmaEntregaVenda` (
    in CEV_IdTB_PedidoVenda int,
    in CEV_IdFuncionario varchar(32),
    in CEV_Entrega_Hora time,
	in CEV_Entrega_Data date,
    out msg varchar(64)
    )
begin
update tb_entrega set TB_Funcionario_IdTB_Funcionario=CEV_IdFuncionario,
                    Entrega_Status= true,
                    Entrega_Hora= CEV_Entrega_Hora,
                    Entrega_Data= CEV_Entrega_Data
                   where TB_PedidoVenda_IdTB_PedidoVenda=CEV_IdTB_PedidoVenda;
end $$
Delimiter ;
-- ----------------------------FIM PROCEDURES DE CONFIRMACOES DE VENDA--------------------------------

-- ----------------------------- PROCEDURES DO PEDIDOVENDA-----------------------------------------

 -- Procedure Inserir PedidoVenda

DELIMITER $$
drop procedure if exists `alpha_parnaiba`.`inserirPedidoVenda` $$
create procedure `alpha_parnaiba`.`inserirPedidoVenda` (
    in PV_IdTB_Cliente int,
    in PV_IdTB_Funcionario int,
    in PV_PedidoVenda_Frete double(12,2),
	in PV_PedidoVenda_PorcentagemDesconto double(5,2),
    in PV_PedidoVenda_ValorDesconto double(12,2),
    in PV_PedidoVenda_Total double(12,2),
    in PV_PedidoVenda_TipoDeVenda varchar(16),
    in PV_PedidoVenda_Hora time,
	in PV_PedidoVenda_Data date,
  out msg varchar(40)
  )
begin
declare IdPedido int;
declare tipovenda int;

set tipovenda=(select IdTB_TipoVenda FROM TB_TipoVenda where TipoVenda_Tipo=PV_PedidoVenda_TipoDeVenda);

insert into TB_PedidoVenda (TB_Cliente_IdTB_Cliente, PedidoVenda_frete, PedidoVenda_PorcentagemDesconto, PedidoVenda_ValorDesconto, PedidoVenda_Total, TB_TipoVenda_idTB_TipoVenda,PedidoVenda_Hora, PedidoVenda_Data) 
values (PV_IdTB_Cliente, PV_PedidoVenda_Frete,PV_PedidoVenda_PorcentagemDesconto, PV_PedidoVenda_ValorDesconto, PV_PedidoVenda_Total, tipovenda,PV_PedidoVenda_Hora, PV_PedidoVenda_Data);
set IdPedido=(select IdTB_PedidoVenda FROM TB_PedidoVenda ORDER BY IdTB_PedidoVenda DESC LIMIT 1);

insert into tb_pagamento(TB_PedidoVenda_IdTB_PedidoVenda, Pagamento_Status) values (IdPedido, false);

insert into tb_entrega(TB_PedidoVenda_IdTB_PedidoVenda,TB_Funcionario_IdTB_Funcionario, Entrega_Status) values (IdPedido, PV_IdTB_Funcionario, false);
set msg='Pedido de venda cadastrado com sucesso!';
end $$
Delimiter ;
-- --------------------------------------------------------------------

-- Procedure Alterar PedidoVenda

DELIMITER $$
drop procedure if exists `alpha_parnaiba`.`alterarPedidoVenda` $$
create procedure `alpha_parnaiba`.`alterarPedidoVenda` (
    in PV_IdVenda int,
    in PV_IdTB_Cliente int,
    in PV_IdTB_Funcionario int,
    in PV_PedidoVenda_Frete double(12,2),
	in PV_PedidoVenda_PorcentagemDesconto double(5,2),
    in PV_PedidoVenda_ValorDesconto double(12,2),
    in PV_PedidoVenda_Total double(12,2),
    in PV_PedidoVenda_TipoDeVenda varchar(16),
    in PV_PedidoVenda_Hora time,
	in PV_PedidoVenda_Data date,
  out msg varchar(40)
  )
begin
declare IdPedido int;
declare tipovenda int;

set tipovenda=(select IdTB_TipoVenda FROM TB_TipoVenda where TipoVenda_Tipo=PV_PedidoVenda_TipoDeVenda);

update TB_PedidoVenda set TB_Cliente_IdTB_Cliente=PV_IdTB_Cliente,
					  PedidoVenda_frete=PV_PedidoVenda_Frete,
                      PV_PedidoVenda_PorcentagemDesconto=PV_PedidoVenda_PorcentagemDesconto,
                      PedidoVenda_ValorDesconto=PV_PedidoVenda_ValorDesconto,
                      PedidoVenda_Total=PV_PedidoVenda_Total,
                      TB_TipoVenda_idTB_TipoVenda=tipovenda,
                      PedidoVenda_Hora=PV_PedidoVenda_Hora,
                      PedidoVenda_Data=PV_PedidoVenda_Data
                      where TB_PedidoVenda_IdTB_PedidoVenda=PV_IdVenda;

update tb_entrega set TB_Funcionario_IdTB_Funcionario=PV_IdTB_Funcionario
                      where TB_PedidoVenda_IdTB_PedidoVenda=PV_IdVenda;
                      set msg='Pedido de venda cadastrado com sucesso!';
end $$
Delimiter ;
-- --------------------------------------------------------------------

 -- Procedure Excluir PedidoVenda

DELIMITER $$
drop procedure if exists `alpha_parnaiba`.`excluirPedidoVenda` $$
create procedure `alpha_parnaiba`.`excluirPedidoVenda` (

 in PV_IdTB_PedidoVenda int,
out msg varchar(40)

)
begin

delete from TB_PedidoVenda  where IdTB_PedidoVenda = PV_IdTB_PedidoVenda;
set msg='PedidoVenda excluido com sucesso!';
end $$
Delimiter ;
-- --------------------------------------------------------------------


 -- Procedure Listar Todos PedidoVendas

DELIMITER $$
drop procedure if exists `alpha_parnaiba`.`listarTodosPedidoVenda` $$
create procedure `alpha_parnaiba`.`listarTodosPedidoVenda` ()
begin

select pv.IdTB_PedidoVenda as IdPedidoVenda,
	   c.IdTB_Cliente as 'IdCliente',
       c.Cliente_Nome as 'Cliente',
       f.IdTB_Funcionario as 'IdFuncionario',
       f.Funcionario_Nome as 'Funcionario',
       pv.PedidoVenda_frete as 'Frete',
       pv.PedidoVenda_PorcentagemDesconto as 'DescontoPorcentagem',
       pv.PedidoVenda_ValorDesconto as 'Desconto',
       pv.PedidoVenda_Total as 'Total',
       tv.TipoVenda_Tipo as 'TipoDeVenda',
       ent.Entrega_Status as 'StatusEntrega',
       pag.Pagamento_Status as 'StatusPagamento',
       pv.PedidoVenda_Hora as 'Hora',
       pv.PedidoVenda_Data as 'Data'
 from TB_PedidoVenda as pv
 left join TB_Cliente as c
 on pv.TB_Cliente_IdTB_Cliente=c.IdTB_Cliente
 left join tb_entrega as ent
 on ent.TB_PedidoVenda_IdTB_PedidoVenda=pv.IdTB_PedidoVenda
 left join TB_Funcionario as f
 on ent.TB_Funcionario_IdTB_Funcionario=f.IdTB_Funcionario
 left join TB_TipoVenda as tv
 on pv.TB_TipoVenda_idTB_TipoVenda=tv.IdTB_TipoVenda
 left join tb_pagamento as pag
 on pag.TB_PedidoVenda_IdTB_PedidoVenda=pv.IdTB_PedidoVenda;
end $$
Delimiter ;
-- --------------------------------------------------------------------

 -- Procedure Listar Todos PedidoVendas

DELIMITER $$
drop procedure if exists `alpha_parnaiba`.`listarTodosPedidoVendaPorID` $$
create procedure `alpha_parnaiba`.`listarTodosPedidoVendaPorID` (
in idPedidoVenda int
)
begin

select pv.IdTB_PedidoVenda as IdPedidoVenda,
	   c.IdTB_Cliente as 'IdCliente',
       c.Cliente_Nome as 'Cliente',
       f.IdTB_Funcionario as 'IdFuncionario',
       f.Funcionario_Nome as 'Funcionario',
       pv.PedidoVenda_frete as 'Frete',
       pv.PedidoVenda_PorcentagemDesconto as 'DescontoPorcentagem',
       pv.PedidoVenda_ValorDesconto as 'Desconto',
       pv.PedidoVenda_Total as 'Total',
       pv.TB_TipoVenda_idTB_TipoVenda as 'TipoDeVenda',
       ent.Entrega_Status as 'StatusEntrega',
       pag.Pagamento_Status as 'StatusPagamento',
       pv.PedidoVenda_Hora as 'Hora',
       pv.PedidoVenda_Data as 'Data'
 from TB_PedidoVenda as pv
 left join TB_Cliente as c
 on pv.TB_Cliente_IdTB_Cliente=c.IdTB_Cliente
 left join tb_entrega as ent
 on ent.TB_PedidoVenda_IdTB_PedidoVenda=pv.IdTB_PedidoVenda
 left join TB_Funcionario as f
 on ent.TB_Funcionario_IdTB_Funcionario=f.IdTB_Funcionario
 left join tb_pagamento as pag
 on pag.TB_PedidoVenda_IdTB_PedidoVenda=pv.IdTB_PedidoVenda
 where pv.IdTB_PedidoVenda=idPedidoVenda;
end $$
Delimiter ;
-- ----------------------------FIM PROCEDURES DO PEDIDOVenda--------------------------------

-- -----------------------------PROCEDURES DO ITENSPEDIDOVenda-----------------------------------

 -- Procedure Inserir ItensPedidoVenda

DELIMITER $$
drop procedure if exists `alpha_parnaiba`.`inserirItensPedidoVenda` $$
create procedure `alpha_parnaiba`.`inserirItensPedidoVenda` (
    
    in IPV_TB_Produto_idTB_Produto int,
    in IPV_ItensPedidoVenda_Quantidade int,
    in IPV_ItensPedidoVenda_ValorUnitario double(12,2),
    in IPV_ItensPedidoVenda_ValorTotal double(12,2),
 out msg varchar(40)
)

begin
declare E_idPedidoVenda int;
declare idprodutoestoque int;
declare qtd int;

set E_idPedidoVenda=(select IdTB_PedidoVenda FROM TB_PedidoVenda ORDER BY IdTB_PedidoVenda DESC LIMIT 1);

insert into TB_ItensPedidoVenda (TB_Pedido_idTB_PedidoVenda, TB_Produto_idTB_Produto, ItensPedidoVenda_Quantidade, ItensPedidoVenda_ValorUnitario, ItensPedidoVenda_ValorTotal) 
 values (E_idPedidoVenda, IPV_TB_Produto_idTB_Produto, IPV_ItensPedidoVenda_Quantidade, IPV_ItensPedidoVenda_ValorUnitario, IPV_ItensPedidoVenda_ValorTotal);

end $$
Delimiter ;

 -- Procedure Listar Todos Itens Pedido Venda

DELIMITER $$
drop procedure if exists `alpha_parnaiba`.`ListarItensPedidoVenda` $$
create procedure `alpha_parnaiba`.`ListarItensPedidoVenda` (
in IdPedidoVenda int
)
begin
select p.IdTB_Produto as 'ID',
       p.Produto_Descricao as 'Descricao',
       m.Marca_Descricao as Marca,
       ipv.ItensPedidoVenda_Quantidade as Quantidade,
       ipv.ItensPedidoVenda_ValorTotal as SubTotal,
       ipv.ItensPedidoVenda_ValorUnitario as ValorUnit
 from tb_itenspedidoVenda as ipv
 left join tb_produto as p
 on ipv.TB_Produto_idTB_Produto=p.IdTB_Produto
 left join tb_marca as m
 on p.TB_Marca_idTB_Marca=m.IdTB_Marca
 where TB_Pedido_idTB_PedidoVenda=IdPedidoVenda;
end $$
Delimiter ;

 -- Procedure Excluir Produto

DELIMITER $$
drop procedure if exists `alpha_parnaiba`.`excluirItensPedidoVenda` $$
create procedure `alpha_parnaiba`.`excluirItensPedidoVenda` (

 in IPC_IdTB_PedidoVenda int

)
begin
delete from tb_itenspedidovenda  where TB_Pedido_idTB_PedidoVenda = IPC_IdTB_PedidoVenda;
end $$
Delimiter ;
-- --------------------------------------------------------------------
-- -----------------------------FIM PROCEDURES DO ITENSPEDIDOVenda---------------------------------

-- ----------------------------- PROCEDURES DO FUNCIONARIO----------------------------

 -- Procedure Inserir Usuario


DELIMITER $$
drop procedure if exists `alpha_parnaiba`.`inserirUsuario` $$
create procedure `alpha_parnaiba`.`inserirUsuario` (
  in U_Usuario_Nome varchar(64),
  in U_Usuario_Email varchar(32),
  in U_Usuario_Tipo varchar(32),
  in U_Usuario_Senha varchar(32),
  
  out msg varchar(40)
  )
begin
declare verificanome int;
declare tipo int;
set verificanome=(select IdTB_Usuario from tb_usuario where Usuario_Nome=U_Usuario_Nome);
set tipo=(select IdTB_TipoConta from tb_tipoconta where TipoConta_Tipo=U_Usuario_Tipo);
if(verificanome >=1) then     
     set msg='Este nome de usuário já existe !';
else
insert into TB_Usuario ( TB_TipoConta_idTB_TipoConta,Usuario_Nome, Usuario_Senha, Usuario_Email) 
 values (tipo,U_Usuario_Nome, U_Usuario_Senha, U_Usuario_Email);
set msg='Usuário cadastrado com sucesso!';
end if;
end $$
Delimiter ;
-- --------------------------------------------------------------------

 -- Procedure Alterar Usuario

DELIMITER $$
drop procedure if exists `alpha_parnaiba`.`alterarUsuario` $$
create procedure `alpha_parnaiba`.`alterarUsuario` (
  in U_IdTB_Usuario int,
  in U_Usuario_Nome varchar(64),
  in U_Usuario_Email varchar(64),
  in U_Usuario_Senha varchar(32),
  in U_Usuario_SenhaAntiga varchar(32),
  in U_Usuario_Tipo varchar(32),
  out msg varchar(40)
  )
begin
declare senhateste varchar (32);
declare tipo int;
set tipo=(select IdTB_TipoConta from tb_tipoconta where TipoConta_Tipo=U_Usuario_Tipo);
set senhateste=(select Usuario_Senha from TB_Usuario where IdTB_Usuario=U_IdTB_Usuario);
if(senhateste = U_Usuario_SenhaAntiga) then

update TB_Usuario set TB_TipoConta_idTB_TipoConta=tipo,
					  Usuario_Nome=U_Usuario_Nome,
					  Usuario_Email=U_Usuario_Email,
					  Usuario_Senha=U_Usuario_Senha
                      where IdTB_Usuario=U_IdTB_Usuario;
                      set msg='Usuário Atualizado com sucesso!';
else
set msg='Senhas antigas não se coincidem';
end if;
end $$
Delimiter;
-- --------------------------------------------------------------------

 -- Procedure Excluir Usuario

DELIMITER $$
drop procedure if exists `alpha_parnaiba`.`excluirUsuario` $$
create procedure `alpha_parnaiba`.`excluirUsuario` (
 in U_IdTB_Usuario int,
 out msg varchar(40)
)
begin
delete from TB_Usuario  where IdTB_Usuario = U_IdTB_Usuario;
set msg='Usuário excluido com sucesso!';
end $$
Delimiter ;
-- --------------------------------------------------------------------


 -- Procedure Listar Todos Usuarios

DELIMITER $$
drop procedure if exists `alpha_parnaiba`.`listarTodosUsuarios` $$
create procedure `alpha_parnaiba`.`listarTodosUsuarios` ()
begin

select u.IdTB_Usuario as ID,
       u.Usuario_Nome as Nome,
	   u.Usuario_Email as Email,
	   t.TipoConta_Tipo as TipoConta,
	   u.Usuario_Senha as Senha
from TB_Usuario as u 
inner join tb_TipoConta as t on t.IdTB_TipoConta = u.TB_TipoConta_idTB_TipoConta;
end $$
Delimiter ;

 -- Procedure listar Usuario Id

DELIMITER $$
drop procedure if exists `alpha_parnaiba`.`listarUsuarioId` $$
create procedure `alpha_parnaiba`.`listarUsuarioId` (
in U_Id int
)
begin

select u.IdTB_Usuario as ID,
       u.Usuario_Nome as Nome,
	   u.Usuario_Email as Email,
	   t.TipoConta_Tipo as TipoConta,
	   u.Usuario_Senha as Senha
from TB_Usuario as u 
inner join tb_TipoConta as t on t.IdTB_TipoConta = u.TB_TipoConta_idTB_TipoConta where IdTB_Usuario=U_Id;
end $$
Delimiter ;
 -- Procedure Trocar Senha Usuario
 
DELIMITER $$
drop procedure if exists `alpha_parnaiba`.`TrocarSenhaUsuario` $$
create procedure `alpha_parnaiba`.`TrocarSenhaUsuario` (
in U_IdTB_Usuario int,
in U_UsuarioSenha varchar(64),
 out msg varchar(40)
)
begin

update tb_usuario set Usuario_Senha = U_UsuarioSenha where IdTB_Usuario =U_IdTB_Usuario;
end $$
Delimiter ;
-- ----------------------------FIM PROCEDURES DO FUNCIONARIO--------------------------------

-- ----------------------------PROCEDURES DOS DADOS DA EMPRESA--------------------------------
-- Procedure Criar Tabela Dados Empresa

DELIMITER $$
drop procedure if exists `alpha_parnaiba`.`CriarTabelaDadosEmpresa` $$
create procedure `alpha_parnaiba`.`CriarTabelaDadosEmpresa` ()
begin
drop table if exists tb_dadosempresa;
create table TB_DadosEmpresa (
IdTB_DadosEmpresa int(11) NOT NULL AUTO_INCREMENT,
  DadosEmpresa_Nome varchar(16) DEFAULT NULL,
  DadosEmpresa_Endereco varchar(256) DEFAULT NULL,
  DadosEmpresa_Numero int(11) DEFAULT NULL,
  DadosEmpresa_Bairro varchar(64) DEFAULT NULL,
  DadosEmpresa_Cidade varchar(64) DEFAULT NULL,
  DadosEmpresa_Estado char(2) DEFAULT NULL,
  DadosEmpresa_CEP varchar(10) DEFAULT NULL,
  DadosEmpresa_Email varchar(64) DEFAULT NULL,
  DadosEmpresa_Telefone1 varchar(15) DEFAULT NULL,
  DadosEmpresa_Telefone2 varchar(15) DEFAULT NULL,
  PRIMARY KEY (IdTB_DadosEmpresa)
);
INSERT INTO `tb_dadosempresa` VALUES (1,'J.C Tramontina','Rua Alberto Frediani',219,'Centro','Santana de Parnaíba','SP','06.502-155','emailexemplo@hotmail.com.br','(11) 4152-6500','(11) 4152-6500');
end $$
Delimiter ;

DELIMITER $$
drop procedure if exists `alpha_parnaiba`.`alterarDados` $$
create procedure `alpha_parnaiba`.`alterarDados` (
in E_DadosEmpresa_Nome varchar(16),
in E_DadosEmpresa_Endereco varchar(256),
in E_DadosEmpresa_Numero int(11),
in E_DadosEmpresa_Bairro varchar(64),
in E_DadosEmpresa_Cidade varchar(64),
in E_DadosEmpresa_Estado char(2),
in E_DadosEmpresa_CEP varchar(10),
in E_DadosEmpresa_Email varchar(64),
in E_DadosEmpresa_Telefone1 varchar(15),
in E_DadosEmpresa_Telefone2 varchar(15),
out msg varchar(64)
)
begin
update TB_DadosEmpresa set DadosEmpresa_Nome=E_DadosEmpresa_Nome,
					  DadosEmpresa_Endereco=E_DadosEmpresa_Endereco,
					  DadosEmpresa_Numero=E_DadosEmpresa_Numero,
                      DadosEmpresa_Bairro=E_DadosEmpresa_Bairro,
                      DadosEmpresa_Cidade=E_DadosEmpresa_Cidade,
                      DadosEmpresa_Estado=E_DadosEmpresa_Estado,
                      DadosEmpresa_CEP=E_DadosEmpresa_CEP,
                      DadosEmpresa_Email=E_DadosEmpresa_Email,
                      DadosEmpresa_Telefone1=E_DadosEmpresa_Telefone1,
                      DadosEmpresa_Telefone2=E_DadosEmpresa_Telefone2
                      where IdTB_DadosEmpresa=1;
                      set msg='Dados atualizados com sucesso!';
end $$
Delimiter ;
-- ----------------------------FIM PROCEDURES DOS DADOS DA EMPRESA--------------------------------
-- ------------------------------------------------------------------------------------
-- ------------------------------------------------------------------------------------
-- ------------------------------------------------------------------------------------
-- ------------------------------------------------------------------------------------
-- ------------------------------------------------------------------------------------
-- ------------------------------------------------------------------------------------
-- ------------------------------------------------------------------------------------

call CriarTabelaDadosEmpresa;
-- ----------------------------- PROCEDURES DO CLIENTE----------------------------
 -- Procedure Inserir Cliente

DELIMITER $$
drop procedure if exists `inserirCliente` $$
create procedure `inserirCliente` (
  
  in C_Cliente_Nome varchar(64),
  in C_Cliente_Telefone varchar(15),
  in C_Cliente_Endereco varchar(64),
  in C_Cliente_Numero int,
  in C_Cliente_Complemento varchar(32),
  in C_Cliente_Bairro varchar(64),
  in C_Cliente_Cidade varchar(64),
  in C_Cliente_Estado varchar(2),
  in C_Cliente_CEP varchar(10),
  in C_Cliente_Sexo varchar(10),
  in C_Cliente_Pessoa_F_J varchar(8),
  in C_Cliente_CPF_CNPJ varchar(20),
  in C_Cliente_Nascimento date,
  out msg varchar(40)
  )
begin

insert into TB_Cliente (Cliente_Nome, Cliente_Telefone, Cliente_Endereco, Cliente_Numero, Cliente_Complemento, Cliente_Bairro, Cliente_Cidade, Cliente_Estado, Cliente_CEP, Cliente_Sexo, Cliente_Pessoa_F_J, Cliente_CPF_CNPJ, Cliente_Nascimento) 
 values (C_Cliente_Nome, C_Cliente_Telefone, C_Cliente_Endereco, C_Cliente_Numero, C_Cliente_Complemento, C_Cliente_Bairro, C_Cliente_Cidade, C_Cliente_Estado, C_Cliente_CEP, C_Cliente_Sexo, C_Cliente_Pessoa_F_J, C_Cliente_CPF_CNPJ, C_Cliente_Nascimento);
set msg='Cliente cadastrado com sucesso!';

end $$
Delimiter ;
-- --------------------------------------------------------------------
 -- Procedure Alterar Cliente
DELIMITER $$
drop procedure if exists `alterarCliente` $$
create procedure `alterarCliente` (
  in C_IdTB_Cliente int,
  in C_Cliente_Nome varchar(64),
  in C_Cliente_Telefone varchar(15),
  in C_Cliente_Endereco varchar(64),
  in C_Cliente_Numero int,
  in C_Cliente_Complemento varchar(32),
  in C_Cliente_Bairro varchar(64),
  in C_Cliente_Cidade varchar(64),
  in C_Cliente_Estado varchar(2),
  in C_Cliente_CEP varchar(10),
  in C_Cliente_Sexo varchar(10),
  in C_Cliente_Pessoa_F_J varchar(8),
  in C_Cliente_CPF_CNPJ varchar(20),
  in C_Cliente_Nascimento date,
  out msg varchar(40)
  )
begin

update TB_Cliente set  Cliente_Nome=C_Cliente_Nome,
					   Cliente_Telefone=C_Cliente_Telefone,
					   Cliente_Endereco=C_Cliente_Endereco,
                       Cliente_Numero=C_Cliente_Numero,
                       Cliente_Complemento=C_Cliente_Complemento,
					   Cliente_Bairro=C_Cliente_Bairro,
					   Cliente_Cidade=C_Cliente_Cidade,
                       Cliente_Estado=C_Cliente_Estado,
					   Cliente_CEP=C_Cliente_CEP,
					   Cliente_Sexo=C_Cliente_Sexo,
                       Cliente_Pessoa_F_J=C_Cliente_Pessoa_F_J,
					   Cliente_CPF_CNPJ=C_Cliente_CPF_CNPJ,
					   Cliente_Nascimento=C_Cliente_Nascimento									  
                       where IdTB_Cliente=C_IdTB_Cliente;  
                       set msg='Cliente alterado com sucesso!';
end $$
Delimiter ;
-- --------------------------------------------------------------------


 -- Procedure Excluir Cliente

DELIMITER $$
drop procedure if exists `excluirCliente` $$
create procedure `excluirCliente` (

in C_IdTB_Cliente int,
out msg varchar(40)

)
begin

delete from TB_Cliente  where IdTB_Cliente = C_IdTB_Cliente;
set msg='Cliente excluido com sucesso!';
end $$
Delimiter ;
-- --------------------------------------------------------------------

-- ----------------------------FIM PROCEDURES DO CLIENTE--------------------------------
            
-- ----------------------------- PROCEDURES ITENS CLIENTE----------------------------

 -- Procedure Inserir ItensCliente

DELIMITER $$
drop procedure if exists `inserirItensCliente` $$
create procedure `inserirItensCliente` (
  in IC_Cliente_Id int,
  in IC_Produto_Id int,
  in IC_ValorUnitario double(12,2)
  )
begin
insert into TB_ItensCliente (TB_Cliente_idTB_Cliente,TB_Produto_idTB_Produto,ItensCliente_ValorUnitario) 
values (IC_Cliente_Id,IC_Produto_Id,IC_ValorUnitario);
end $$
Delimiter ;
-- --------------------------------------------------------------------

 -- Procedure Excluir ItensCliente

DELIMITER $$
drop procedure if exists `excluirItensCliente` $$
create procedure `excluirItensCliente` (
 in IC_Cliente_Id int
)
begin

delete from TB_ItensCliente  where TB_Cliente_idTB_Cliente = IC_Cliente_Id;
end $$
Delimiter ;
-- --------------------------------------------------------------------


 -- Procedure Listar Todos ItensCliente por ID

DELIMITER $$
drop procedure if exists `listarTodosItensClienteId` $$
create procedure `listarTodosItensClienteId` (
in IC_Cliente_Id int
)
begin
select p.IdTB_Produto as 'IdTB_Produto',
       p.Produto_Descricao as 'Produto_Descricao',
       ic.ItensCliente_ValorUnitario as 'ValorUnitario'

 from TB_ItensCliente as ic
 inner join TB_Produto as p
 on ic.TB_Produto_idTB_Produto=p.IdTB_Produto 
 where ic.TB_Cliente_idTB_Cliente=IC_Cliente_Id;
 
end $$
Delimiter ;
-- --------------------------------------------------------------------

-- ----------------------------FIM PROCEDURES ITENS CLIENTE--------------------------------
            
	
-- -----------------------------PROCEDURES DO ESTOQUE-----------------------------------

 -- Procedure Listar Todos Estoque

DELIMITER $$
drop procedure if exists `listarTodosEstoque` $$
create procedure `listarTodosEstoque` ()
begin

select E.TB_Produto_idTB_Produto as IdProduto,
       P.Produto_Descricao as ProdutoNome,
       m.Marca_Descricao as Marca,
       E.Estoque_QuantidadeAtual as QuantidadeAtual,
       P.Produto_EstoqueMinimo as EstoqueMin,
       E.Estoque_ValorUnitario as ValorUnit
from TB_Estoque as E 
inner join TB_Produto as P on P.IdTB_Produto = E.TB_Produto_IdTB_Produto
left join TB_Marca as m on m.IdTB_Marca = P.TB_Marca_idTB_Marca;

end $$
Delimiter ;

DELIMITER $$
drop procedure if exists `cadastroAlteracaoEstoqueCompra` $$
create procedure `cadastroAlteracaoEstoqueCompra` (
in E_idProduto int,
in E_Quantidade int,
in E_ValorUnit double(12,2)
)
begin
declare idprodutoestoque int;
declare qtd int;

set idprodutoestoque=(select TB_Produto_idTB_Produto from TB_Estoque where TB_Produto_idTB_Produto=E_idProduto);
set qtd=(SELECT SUM(Estoque_QuantidadeAtual) FROM TB_Estoque where TB_Produto_idTB_Produto =E_idProduto);

if(idprodutoestoque = E_idProduto) then
     update TB_Estoque set  Estoque_QuantidadeAtual=qtd+E_Quantidade,
							Estoque_ValorUnitario=E_ValorUnit
							where TB_Produto_idTB_Produto = E_idProduto;                    
else
     insert into TB_Estoque (TB_Produto_idTB_Produto, Estoque_QuantidadeAtual,Estoque_ValorUnitario)values(E_idProduto,E_Quantidade,E_ValorUnit);
end if;
end $$
Delimiter ;

DELIMITER $$
drop procedure if exists `AlteracaoEstoqueVenda` $$
create procedure `AlteracaoEstoqueVenda` (
in E_idProduto int,
in E_Quantidade int
)
begin
declare qtd int;
set qtd=(SELECT SUM(Estoque_QuantidadeAtual) FROM TB_Estoque WHERE TB_Produto_idTB_Produto =E_idProduto);
     
     update TB_Estoque set  Estoque_QuantidadeAtual=qtd-E_Quantidade 
							where TB_Produto_idTB_Produto = E_idProduto;
end $$
Delimiter ;

-- -----------------------------FIM PROCEDURES DO ESTOQUE---------------------------------

-- -----------------------------PROCEDURES DO FORNECEDOR-----------------------------------

 -- Procedure Inserir Fornecedor

DELIMITER $$
drop procedure if exists `inserirFornecedor` $$
create procedure `inserirFornecedor` (

 
 in F_Fornecedor_Nome varchar(64),
 in F_Fornecedor_Telefone varchar(16),
 in F_Fornecedor_Email varchar(64),
 in F_Fornecedor_CNPJ varchar(20),
 in F_Fornecedor_CEP varchar(10),
 in F_Fornecedor_Endereco varchar(64),
 in F_Fornecedor_Bairro varchar(64),
 in F_Fornecedor_Cidade varchar(64),
 in F_Fornecedor_Estado varchar(2),
 out msg varchar(40)
)
begin

insert into TB_Fornecedor (Fornecedor_Nome, Fornecedor_Telefone, Fornecedor_Email, Fornecedor_CNPJ, Fornecedor_CEP, Fornecedor_Endereco, Fornecedor_Bairro, Fornecedor_Cidade, Fornecedor_Estado) 
 values (F_Fornecedor_Nome, F_Fornecedor_Telefone, F_Fornecedor_Email, F_Fornecedor_CNPJ, F_Fornecedor_CEP, F_Fornecedor_Endereco, F_Fornecedor_Bairro, F_Fornecedor_Cidade, F_Fornecedor_Estado);
set msg='Fornecedor cadastrado com sucesso!';
end $$
Delimiter ;
-- --------------------------------------------------------------------

 -- Procedure Alterar Fornecedor

DELIMITER $$
drop procedure if exists `alterarFornecedor` $$
create procedure `alterarFornecedor` (

 in F_IdTB_Fornecedor int,
 in F_Fornecedor_Nome varchar(64),
 in F_Fornecedor_Telefone varchar(16),
 in F_Fornecedor_Email varchar(64),
 in F_Fornecedor_CNPJ varchar(20),
 in F_Fornecedor_CEP varchar(10),
 in F_Fornecedor_Endereco varchar(64),
 in F_Fornecedor_Bairro varchar(64),
 in F_Fornecedor_Cidade varchar(64),
 in F_Fornecedor_Estado varchar(64),
 out msg varchar(40)
 
)
begin
update TB_Fornecedor set    Fornecedor_Nome=F_Fornecedor_Nome,
							Fornecedor_Telefone=F_Fornecedor_Telefone,
							Fornecedor_Email=F_Fornecedor_Email,
							Fornecedor_CNPJ=F_Fornecedor_CNPJ,
							Fornecedor_CEP=F_Fornecedor_CEP,
							Fornecedor_Endereco=F_Fornecedor_Endereco,
							Fornecedor_Bairro=F_Fornecedor_Bairro,
							Fornecedor_Cidade=F_Fornecedor_Cidade,
							Fornecedor_Estado=F_Fornecedor_Estado                            
							where F_IdTB_Fornecedor = idTB_Fornecedor;
							set msg='Fornecedor alterado com sucesso!';
end $$
Delimiter ;
-- --------------------------------------------------------------------


 -- Procedure Excluir Fornecedor

DELIMITER $$
drop procedure if exists `excluirFornecedor` $$
create procedure `excluirFornecedor` (

 in F_IdTB_Fornecedor int,
out msg varchar(40)
)
begin

delete from TB_Fornecedor  where IdTB_Fornecedor = F_IdTB_Fornecedor;
set msg='Fornecedor excluido com sucesso!';
end $$
Delimiter ;
-- --------------------------------------------------------------------


 -- Procedure Listar Todos Fornecedor

DELIMITER $$
drop procedure if exists `listarTodosFornecedor` $$
create procedure `listarTodosFornecedor` ()
begin

select * from TB_Fornecedor;
        
end $$
Delimiter ;
-- --------------------------------------------------------------------

 -- Procedure Consultar Fornecedor

DELIMITER $$
drop procedure if exists `BuscarFornecedor` $$
create procedure `BuscarFornecedor` (

	in F_Fornecedor_Consulta varchar(100), 
    in F_Fornecedor_Campo varchar(100)

)
begin

select * from TB_Estoque where F_Fornecedor_Campo like F_Fornecedor_Consulta;

end $$
Delimiter ;

-- Procedure Consultar FornecedorPorNome

DELIMITER $$
drop procedure if exists `BuscarFornecedorPorNome` $$
create procedure `BuscarFornecedorPorNome` (

	in F_Fornecedor_Consulta varchar(100)

)
begin

select * from TB_Fornecedor where Fornecedor_Nome like F_Fornecedor_Consulta;

end $$
Delimiter ;

-- -----------------------------FIM PROCEDURES DO FORNECEDOR---------------------------------

-- ----------------------------- PROCEDURES DO CARGO----------------------------

-- Procedure inserir Cargo
DELIMITER $$
drop procedure if exists `inserirCargo` $$
create procedure `inserirCargo` (
  in C_Cargo_Descricao varchar(64),
  out msg varchar(100)
  )
begin
declare descteste int;
set descteste=(select IdTB_Cargo from TB_Cargo where Cargo_Descricao=C_Cargo_Descricao);
if(descteste>=1) then 
set msg='Este cargo ja foi cadastrado!';
else
insert into TB_Cargo (Cargo_Descricao) 
 values (C_Cargo_Descricao);
 set msg='Cargo cadastrado com sucesso!';
end if;

end $$
Delimiter ;

-- Procedure Excluir Cargo

DELIMITER $$
drop procedure if exists `excluirCargo` $$
create procedure `excluirCargo` (

 in P_IdTB_Cargo int,
out msg varchar(40)
)
begin
declare testecargo int;
set testecargo=(select Cargo_Descricao from TB_Cargo where Produto_Nome=P_Produto_Nome);

delete from TB_Produto  where IdTB_Produto = P_IdTB_Produto;
set msg='Produto excluido com sucesso!';
end $$
Delimiter ;
-- -----------------------------FIM PROCEDURES DO CARGO---------------------------------

-- ----------------------------- PROCEDURES DO FUNCIONARIO----------------------------

 -- Procedure Inserir Funcionario


DELIMITER $$
drop procedure if exists `inserirFuncionario` $$
create procedure `inserirFuncionario` (
  in F_Funcionario_Nome varchar(64),
  in F_Funcionario_Telefone varchar(16),
  in F_Funcionario_Cargo varchar(32),
  in F_Funcionario_Salario double(20,2),
  in F_Funcionario_Bairro varchar(32),
  in F_Funcionario_Cidade varchar(64),
  in F_Funcionario_Estado varchar(2),
  in F_Funcionario_CEP varchar(20),
  in F_Funcionario_Sexo varchar(10),
  in F_Funcionario_CPF varchar(20),
  in F_Funcionario_Nascimento date,
  out msg varchar(40)
  )
begin
declare idcargo int;
set idcargo = (Select IdTB_Cargo from TB_Cargo where Cargo_Descricao=F_Funcionario_Cargo);
insert into TB_Funcionario (Funcionario_Nome, Funcionario_Telefone, TB_Cargo_idTB_Cargo, Funcionario_Salario, Funcionario_Bairro, Funcionario_Cidade, Funcionario_Estado, Funcionario_CEP, Funcionario_Sexo, Funcionario_CPF, Funcionario_Nascimento) 
 values (F_Funcionario_Nome, F_Funcionario_Telefone, idcargo, F_Funcionario_Salario, F_Funcionario_Bairro, F_Funcionario_Cidade, F_Funcionario_Estado, F_Funcionario_CEP, F_Funcionario_Sexo, F_Funcionario_CPF, F_Funcionario_Nascimento);
set msg='Funcionário cadastrado com sucesso!';
end $$
Delimiter ;
-- --------------------------------------------------------------------

 -- Procedure Alterar Funcionario

DELIMITER $$
drop procedure if exists `alterarFuncionario` $$
create procedure `alterarFuncionario` (
  in F_IdTB_Funcionario int,
  in F_Funcionario_Nome varchar(64),
  in F_Funcionario_Telefone varchar(16),
  in F_Funcionario_Cargo varchar(255),
  in F_Funcionario_Salario double(20,2),
  in F_Funcionario_Bairro varchar(32),
  in F_Funcionario_Cidade varchar(64),
  in F_Funcionario_Estado varchar(2),
  in F_Funcionario_CEP varchar(20),
  in F_Funcionario_Sexo varchar(10),
  in F_Funcionario_CPF varchar(20),
  in F_Funcionario_Nascimento date,
  out msg varchar(40)
  )
begin

declare IdCargo int;
 set IdCargo=(select (idTB_Cargo) from TB_Cargo where Cargo_Descricao= F_Funcionario_Cargo);
 
update TB_Funcionario set Funcionario_Nome=F_Funcionario_Nome,
					Funcionario_Telefone=F_Funcionario_Telefone,
                    TB_Cargo_idTB_Cargo=IdCargo,
                    Funcionario_Salario=F_Funcionario_Salario,
					Funcionario_Bairro=F_Funcionario_Bairro,
					Funcionario_Cidade=F_Funcionario_Cidade,
                    Funcionario_Estado=F_Funcionario_Estado,
					Funcionario_CEP=F_Funcionario_CEP,
					Funcionario_Sexo=F_Funcionario_Sexo,
					Funcionario_CPF=F_Funcionario_CPF,
					Funcionario_Nascimento=F_Funcionario_Nascimento									  
                   where IdTB_Funcionario=F_IdTB_Funcionario;
                   set msg='Funcionário Atualizado com sucesso!';

end $$
Delimiter ;
-- --------------------------------------------------------------------

 -- Procedure Excluir Funcionario

DELIMITER $$
drop procedure if exists `excluirFuncionario` $$
create procedure `excluirFuncionario` (

 in F_IdTB_Funcionario int,
 out msg varchar(40)
)
begin

delete from TB_Funcionario  where IdTB_Funcionario = F_IdTB_Funcionario;
set msg='Funcionário excluido com sucesso!';
end $$
Delimiter ;
-- --------------------------------------------------------------------


 -- Procedure Listar Todos Funcionarios

DELIMITER $$
drop procedure if exists `listarTodosFuncionarios` $$
create procedure `listarTodosFuncionarios` ()
begin

select f.IdTB_Funcionario as Id,
	   f.Funcionario_Nome as Nome,
       f.Funcionario_Telefone as Telefone,
       c.Cargo_Descricao as Cargo,
       f.Funcionario_Salario as Salario,
       f.Funcionario_Bairro as Bairro,
       f.Funcionario_Cidade as Cidade,
       f.Funcionario_Estado as Uf,
       f.Funcionario_CEP as CEP,
       f.Funcionario_Sexo as Sexo,
       f.Funcionario_CPF as CPF,
       f.Funcionario_Nascimento as Nascimento

 from TB_Funcionario as f
 inner join TB_Cargo as c
 on f.TB_Cargo_idTB_Cargo=c.IdTB_Cargo;
 
end $$
Delimiter ;
-- --------------------------------------------------------------------

 -- Procedure Consultar Funcionario

DELIMITER $$
drop procedure if exists `BuscarFuncionario` $$
create procedure `BuscarFuncionario` (
    in F_Funcionario_Campo varchar(100),
	in F_Funcionario_Consulta varchar(100)
)
begin

select * from TB_Funcionario where F_Funcionario_Campo like CONCAT('%',F_Funcionario_Consulta,'%'); 

end $$
Delimiter ;
create view 

-- ----------------------------FIM PROCEDURES DO FUNCIONARIO--------------------------------



-- ----------------------------- PROCEDURES DO PEDIDOS----------------------------

 -- Procedure Inserir Pedidos


DELIMITER $$
drop procedure if exists `inserirPedidos` $$
create procedure `inserirPedidos` (

  in P_TB_Estoque_idTB_Estoque integer,
  in P_TB_Vendas_idTB_Vendas integer,
  in P_Ped_DataEntrada date,
  in P_Ped_ValorTotal double(6,2),
  in P_Ped_Quantidade int,
  out msg varchar(40)
  )
begin

insert into TB_Pedidos (TB_Estoque_idTB_Estoque, TB_Vendas_idTB_Vendas, Ped_DataEntrada, Ped_ValorTotal, Ped_Quantidade) 
				    values (P_TB_Estoque_idTB_Estoque, P_TB_Vendas_idTB_Vendas, P_Ped_DataEntrada, P_Ped_ValorTotal, P_Ped_Quantidade);
set msg='Cliente cadastrado com sucesso!';
end $$
Delimiter ;
-- --------------------------------------------------------------------

-- -----------------------------PROCEDURES DE MARCA-----------------------------------

 -- Procedure Inserir Marca

DELIMITER $$
drop procedure if exists `inserirMarca` $$
create procedure `inserirMarca` (
 in M_Marca_Descricao varchar(64),
 out msg varchar(40)
)
begin
declare verificamarca varchar(64);
 set verificamarca=(select (Marca_Descricao) from TB_Marca where Marca_Descricao=M_Marca_Descricao);
 
 if(verificamarca = M_Marca_Descricao) then  
set msg='Esta marca ja foi cadastrada!';
else
insert into TB_Marca (Marca_Descricao) 
 values (M_Marca_Descricao); 
set msg='Marca cadastrada com sucesso!';

end if;
 

end $$
Delimiter ;
-- -----------------------------FIM PROCEDURES DE MARCA---------------------------------


-- ----------------------------- PROCEDURES DO PRODUTO----------------------------
 -- Procedure Inserir Produto

DELIMITER $$
drop procedure if exists `inserirProduto` $$
create procedure `inserirProduto` (
  
  in P_Produto_Descricao varchar(64),
  in P_Marca Varchar(64),
  in P_Produto_EstoqueMinimo int,
  out msg varchar(64)  
  )
begin
declare verificaproduto varchar(64);
declare marca int;
 set verificaproduto=(select (Produto_Descricao) from TB_Produto where Produto_Descricao=P_Produto_Descricao order by IdTB_Produto desc limit 1);
 set marca=(select (idTB_Marca) from TB_Marca where Marca_Descricao=P_Marca);
  
 if(verificaproduto =P_Produto_Descricao) then 
 
set msg='Este nome de produto ja foi cadastrado!';

else 
insert into TB_Produto (Produto_Descricao,TB_Marca_idTB_Marca,Produto_EstoqueMinimo ) 
 values (P_Produto_Descricao, marca,P_Produto_EstoqueMinimo);
 
set msg='Produto cadastrado com sucesso!';

end if;
end $$
Delimiter ;
-- --------------------------------------------------------------------
 -- Procedure Alterar Produto
DELIMITER $$
drop procedure if exists `alterarProduto` $$
create procedure `alterarProduto` (
  in P_IdTB_Produto int,
  in P_Produto_Descricao varchar(64),
  in P_Marca varchar(64),
  in P_Produto_EstoqueMinimo int,
  out msg varchar(40)  
  )
begin
declare IdMarca int;
set IdMarca=(select (idTB_Marca) from TB_Marca where Marca_Descricao=P_Marca);
update TB_Produto set  Produto_Descricao=P_Produto_Descricao,
					   TB_Marca_idTB_Marca=IdMarca,
                       Produto_EstoqueMinimo=P_Produto_EstoqueMinimo					   
                       where IdTB_Produto=P_IdTB_Produto;  
                       set msg='Produto alterado com sucesso!';
end $$
Delimiter ;
-- --------------------------------------------------------------------


 -- Procedure Excluir Produto

DELIMITER $$
drop procedure if exists `excluirProduto` $$
create procedure `excluirProduto` (

 in P_IdTB_Produto int,
out msg varchar(40)

)
begin
declare verificaproduto int;
set verificaproduto=(select (TB_Pedido_idTB_PedidoVenda) from TB_ItensPedidoVenda where TB_Produto_idTB_Produto=P_IdTB_Produto);
if(verificaproduto >=1) then 
set msg='Este produto está relacionado com algum pedido';
else
delete from TB_Produto  where IdTB_Produto = P_IdTB_Produto;
set msg='Produto excluido com sucesso!';
end if;
end $$
Delimiter ;
-- --------------------------------------------------------------------


 -- Procedure Listar Todos Produtos

DELIMITER $$
drop procedure if exists `listarTodosProdutos` $$
create procedure `listarTodosProdutos` ()
begin
select p.IdTB_Produto as Id,
	   p.Produto_Descricao as Descricao,
       m.Marca_Descricao as Marca,
       p.Produto_EstoqueMinimo as EstoqueMinimo
 from TB_Produto as p
 inner join TB_Marca as m
 on p.TB_Marca_idTB_Marca=m.IdTB_Marca;
end $$
Delimiter ;
-- --------------------------------------------------------------------

 -- Procedure Consultar Produto

DELIMITER $$
drop procedure if exists `BuscarProduto` $$
create procedure `BuscarProduto` (
	in P_Produto_Campo varchar(20),
    in P_Produto_Consulta varchar(20)
)
begin
select * from TB_Produto where P_Produto_Campo like '%P_Produto_Consulta%';

end $$
Delimiter ;
-- ----------------------------FIM PROCEDURES DO PRODUTO--------------------------------


-- -----------------------------PROCEDURES DO CONFIRMAENTREGACOMPRA-----------------------------------

DELIMITER $$
drop procedure if exists `confirmaEntregaCompra` $$
create procedure `confirmaEntregaCompra` (
	in CC_TB_PedidoCompra_idTB_PedidoCompra int,
    in CC_ConfirmaEntregaCompra_Hora time,
	in CC_ConfirmaEntregaCompra_Data date
)
begin

update TB_ConfirmaEntregaCompra set  TB_PedidoCompra_idTB_PedidoCompra=CC_TB_PedidoCompra_idTB_PedidoCompra,
					   ConfirmaEntregaCompra_Status=true,
                       ConfirmaEntregaCompra_Hora=CC_ConfirmaEntregaCompra_Hora,
                       ConfirmaEntregaCompra_Data=CC_ConfirmaEntregaCompra_Data
                       where TB_PedidoCompra_idTB_PedidoCompra=CC_TB_PedidoCompra_idTB_PedidoCompra;
end $$
Delimiter ;

-- -----------------------------FIM PROCEDURES DO CONFIRMACOMPRA-----------------------------------


-- -----------------------------PROCEDURES DO ITENSPEDIDOCOMPRA-----------------------------------

 -- Procedure Inserir ItensPedidoCompra

DELIMITER $$
drop procedure if exists `inserirItensPedidoCompra` $$
create procedure `inserirItensPedidoCompra` (
    
    in IPC_TB_Produto_idTB_Produto int,
    in IPC_ItensPedidoCompra_Quantidade int,
	in IPC_ItensPedidoCompra_ValorCusto double(12,2),
    in IPC_ItensPedidoCompra_ValorUnitario double(12,2),
    in IPC_ItensPedidoCompra_ValorTotal double(12,2),
    out msg varchar(64)
)

begin
declare E_idPedidoCompra int;
set E_idPedidoCompra=(select IdTB_PedidoCompra FROM TB_PedidoCompra ORDER BY IdTB_PedidoCompra DESC LIMIT 1);

insert into TB_ItensPedidoCompra (TB_Pedido_idTB_PedidoCompra, TB_Produto_idTB_Produto, ItensPedidoCompra_Quantidade, ItensPedidoCompra_ValorCusto, ItensPedidoCompra_ValorUnitario, ItensPedidoCompra_ValorTotal) 
						  values (E_idPedidoCompra, IPC_TB_Produto_idTB_Produto, IPC_ItensPedidoCompra_Quantidade, IPC_ItensPedidoCompra_ValorCusto, IPC_ItensPedidoCompra_ValorUnitario, IPC_ItensPedidoCompra_ValorTotal);

end $$
Delimiter ;

 -- Procedure Listar Todos Itens Pedido Compra

DELIMITER $$
drop procedure if exists `ListarItensPedidoCompra` $$
create procedure `ListarItensPedidoCompra` (
in IdPedidoCompra int
)
begin
select p.IdTB_Produto as ID,
       p.Produto_Descricao as Descricao,
       m.Marca_Descricao as Marca,
       TB_ipc.ItensPedidoCompra_Quantidade as Quantidade,
       TB_ipc.ItensPedidoCompra_ValorTotal as SubTotal,
       TB_ipc.ItensPedidoCompra_ValorCusto as ValorCusto,
       TB_ipc.ItensPedidoCompra_ValorUnitario as ValorUnit
       
 from TB_ItensPedidoCompra as TB_ipc
 left join TB_Produto as p
 on TB_ipc.TB_Produto_idTB_Produto=p.IdTB_Produto
 left join TB_Marca as m
 on p.TB_Marca_idTB_Marca=m.IdTB_Marca
 where TB_Pedido_idTB_PedidoCompra=IdPedidoCompra;
end $$
Delimiter ;

 -- Procedure Excluir ItensPedidoCompra

DELIMITER $$
drop procedure if exists `excluirItensPedidoCompra` $$
create procedure `excluirItensPedidoCompra` (

 in IPC_IdTB_PedidoCompra int

)
begin
delete from TB_ItensPedidoCompra  where TB_Pedido_idTB_PedidoCompra = IPC_IdTB_PedidoCompra;
end $$
Delimiter ;
-- --------------------------------------------------------------------

-- -----------------------------FIM PROCEDURES DO ITENSPedidoCompra---------------------------------


-- ----------------------------- PROCEDURES DO PedidoCompra-----------------------------------------

 -- Procedure Inserir PedidoCompra

DELIMITER $$
drop procedure if exists `inserirPedidoCompra` $$
create procedure `inserirPedidoCompra` (
  
    in PC_TB_Fornecedor_idTB_Fornecedor int,
    in PC_PedidoCompra_Frete double(12,2),
	in PC_PedidoCompra_PorcentagemDesconto double(5,2),
    in PC_PedidoCompra_ValorDesconto double(12,2),
    in PC_PedidoCompra_Total double(12,2),
    in PC_PedidoCompra_Hora time,
	in PC_PedidoCompra_Data date,
  out msg varchar(40)
  )
begin
declare IdPedido int;

insert into TB_PedidoCompra (TB_Fornecedor_idTB_Fornecedor, PedidoCompra_frete, PedidoCompra_PorcentagemDesconto, PedidoCompra_ValorDesconto, PedidoCompra_Total, PedidoCompra_Hora, PedidoCompra_Data) 
values (PC_TB_Fornecedor_idTB_Fornecedor, PC_PedidoCompra_frete, PC_PedidoCompra_PorcentagemDesconto, PC_PedidoCompra_ValorDesconto, PC_PedidoCompra_Total, PC_PedidoCompra_Hora, PC_PedidoCompra_Data);

set IdPedido=(select IdTB_PedidoCompra FROM TB_PedidoCompra ORDER BY IdTB_PedidoCompra DESC LIMIT 1);
insert into TB_ConfirmaEntregaCompra (TB_PedidoCompra_idTB_PedidoCompra,ConfirmaEntregaCompra_Status) 
							  values (IdPedido,false);

set msg='Pedido de compra cadastrado com sucesso!';

end $$
Delimiter ;
-- --------------------------------------------------------------------

-- Procedure Inserir PedidoCompra

DELIMITER $$
drop procedure if exists `alterarPedidoCompra` $$
create procedure `alterarPedidoCompra` (
    in PC_IdPedidoCompra int,
    in PC_TB_Fornecedor_idTB_Fornecedor int,
    in PC_PedidoCompra_Frete double(12,2),
	in PC_PedidoCompra_PorcentagemDesconto double(5,2),
    in PC_PedidoCompra_ValorDesconto double(12,2),
    in PC_PedidoCompra_Total double(12,2),
    in PC_PedidoCompra_Hora time,
	in PC_PedidoCompra_Data date,
  out msg varchar(40)
  )
begin

update TB_PedidoCompra set TB_Fornecedor_idTB_Fornecedor=PC_TB_Fornecedor_idTB_Fornecedor,
					  PedidoCompra_frete=PC_PedidoCompra_frete,
					  PedidoCompra_PorcentagemDesconto=PC_PedidoCompra_PorcentagemDesconto,
					  PedidoCompra_ValorDesconto=PC_PedidoCompra_ValorDesconto,
                      PedidoCompra_Total=PC_PedidoCompra_Total,
                      PedidoCompra_Hora=PC_PedidoCompra_Hora,
                      PedidoCompra_Data=PC_PedidoCompra_Data
                      where IdTB_PedidoCompra=PC_IdPedidoCompra;

set msg='Pedido de compra alterado com sucesso!';

end $$
Delimiter ;
-- --------------------------------------------------------------------

 -- Procedure Excluir PedidoCompra

DELIMITER $$
drop procedure if exists `excluirPedidoCompra` $$
create procedure `excluirPedidoCompra` (

 in PC_IdTB_PedidoCompra int,
out msg varchar(40)

)
begin

delete from TB_PedidoCompra  where IdTB_PedidoCompra = PC_IdTB_PedidoCompra;
set msg='Pedido de compra excluido com sucesso!';
end $$
Delimiter ;
-- --------------------------------------------------------------------


 -- Procedure Listar Todos PedidoCompras

DELIMITER $$
drop procedure if exists `listarTodosPedidoCompra` $$
create procedure `listarTodosPedidoCompra` ()
begin

select pc.IdTB_PedidoCompra as IdPedidoCompra,
       f.IdTB_Fornecedor as IdFornecedor,
       f.Fornecedor_Nome as Fornecedor,
       pc.PedidoCompra_frete as Frete,
       pc.PedidoCompra_PorcentagemDesconto as DescontoPorcentagem,
       pc.PedidoCompra_ValorDesconto as Desconto,
       pc.PedidoCompra_Total as Total,
       conf.ConfirmaEntregaCompra_Status as 'Status',
       pc.PedidoCompra_Hora as Hora,
       pc.PedidoCompra_Data as 'Data'
       
 from TB_PedidoCompra as pc
 left join TB_ConfirmaEntregaCompra as conf
 on conf.TB_PedidoCompra_idTB_PedidoCompra=pc.IdTB_PedidoCompra
 left join TB_Fornecedor as f
 on pc.TB_Fornecedor_idTB_Fornecedor=f.IdTB_Fornecedor;
 
end $$
Delimiter ;

 -- Procedure Listar Todos Pedido Compra Por Id

DELIMITER $$
drop procedure if exists `listarTodosPedidoCompraPorID` $$
create procedure `listarTodosPedidoCompraPorID` (
in idPedidoCompra int
)
begin

select pc.IdTB_PedidoCompra as 'IdPedidoCompra',
	   f.IdTB_Fornecedor as 'IdFornecedor',
       f.Fornecedor_Nome as 'Fornecedor',
       pc.PedidoCompra_frete as 'Frete',
       pc.PedidoCompra_PorcentagemDesconto as 'DescontoPorcentagem',
       pc.PedidoCompra_ValorDesconto as 'Desconto',
       pc.PedidoCompra_Total as 'Total',
       conf.ConfirmaEntregaCompra_Status as 'Status',
       pc.PedidoCompra_Hora as 'Hora',
       pc.PedidoCompra_Data as 'Data'
 from TB_PedidoCompra as pc
 left join TB_ConfirmaEntregaCompra as conf
 on conf.TB_PedidoCompra_idTB_PedidoCompra=pc.IdTB_PedidoCompra
 left join TB_Fornecedor as f
 on pc.TB_Fornecedor_idTB_Fornecedor=f.IdTB_Fornecedor
 where pc.IdTB_PedidoCompra=idPedidoCompra;
end $$
Delimiter ;

 -- Procedure Consultar PedidoCompra

DELIMITER $$
drop procedure if exists `BuscarPedidoCompra` $$
create procedure `BuscarPedidoCompra` (
	in PC_PedidoCompra_Campo varchar(20),
    in PC_PedidoCompra_Consulta varchar(20)
)
begin
select * from TB_Cliente where PC_PedidoCompra_Campo like PC_PedidoCompra_Consulta;

end $$
Delimiter ;
-- ----------------------------FIM PROCEDURES DO PedidoCompra--------------------------------

-- ----------------------------PROCEDURES DE CONFIRMACOES DE VENDA--------------------------------

-- Procedure Confirma Pagamento de Venda

DELIMITER $$
drop procedure if exists `ConfirmaPagamentoVenda` $$
create procedure `ConfirmaPagamentoVenda` (
    in CPV_IdTB_PedidoVenda int,
    in CPV_TB_TipoPagamento_idTB_TipoPagamento varchar(64),
    in CPV_Pagamento_ValorRecebido double(12,2),
    in CPV_Pagamento_Troco double(12,2),
    in CPV_Pagamento_Hora time,
	in CPV_Pagamento_Data date
    )
begin
declare tipopag int;
set tipopag=(select (IdTB_TipoPagamento) from TB_TipoPagamento where TipoPagamento_Tipo=CPV_TB_TipoPagamento_idTB_TipoPagamento);
update TB_Pagamento set TB_TipoPagamento_idTB_TipoPagamento = tipopag,
					Pagamento_ValorRecebido = CPV_Pagamento_ValorRecebido,
                    Pagamento_Troco = CPV_Pagamento_Troco,
                    Pagamento_Status = true,
                    Pagamento_Hora  = CPV_Pagamento_Hora,
                    Pagamento_Data = CPV_Pagamento_Data
                   where TB_PedidoVenda_IdTB_PedidoVenda=CPV_IdTB_PedidoVenda;
end $$
Delimiter ;

-- Procedure Confirma Entrega de Venda

DELIMITER $$
drop procedure if exists `ConfirmaEntregaVenda`  $$
create procedure `ConfirmaEntregaVenda` (
    in CEV_IdTB_PedidoVenda int,
    in CEV_IdFuncionario varchar(32),
    in CEV_Entrega_Hora time,
	in CEV_Entrega_Data date,
    out msg varchar(64)
    )
begin
update TB_Entrega set TB_Funcionario_IdTB_Funcionario=CEV_IdFuncionario,
                    Entrega_Status= true,
                    Entrega_Hora= CEV_Entrega_Hora,
                    Entrega_Data= CEV_Entrega_Data
                   where TB_PedidoVenda_IdTB_PedidoVenda=CEV_IdTB_PedidoVenda;
end $$
Delimiter ;
-- ----------------------------FIM PROCEDURES DE CONFIRMACOES DE VENDA--------------------------------

-- ----------------------------- PROCEDURES DO PEDIDOVENDA-----------------------------------------

 -- Procedure Inserir PedidoVenda

DELIMITER $$
drop procedure if exists `inserirPedidoVenda` $$
create procedure `inserirPedidoVenda` (
    in PV_IdTB_Cliente int,
    in PV_IdTB_Funcionario int,
    in PV_PedidoVenda_Frete double(12,2),
	in PV_PedidoVenda_PorcentagemDesconto double(5,2),
    in PV_PedidoVenda_ValorDesconto double(12,2),
    in PV_PedidoVenda_Total double(12,2),
    in PV_PedidoVenda_TipoDeVenda varchar(16),
    in PV_PedidoVenda_Hora time,
	in PV_PedidoVenda_Data date,
  out msg varchar(40)
  )
begin
declare IdPedido int;
declare tipovenda int;

set tipovenda=(select IdTB_TipoVenda FROM TB_TipoVenda where TipoVenda_Tipo=PV_PedidoVenda_TipoDeVenda);

insert into TB_PedidoVenda (TB_Cliente_IdTB_Cliente, PedidoVenda_frete, PedidoVenda_PorcentagemDesconto, PedidoVenda_ValorDesconto, PedidoVenda_Total, TB_TipoVenda_idTB_TipoVenda,PedidoVenda_Hora, PedidoVenda_Data) 
values (PV_IdTB_Cliente, PV_PedidoVenda_Frete,PV_PedidoVenda_PorcentagemDesconto, PV_PedidoVenda_ValorDesconto, PV_PedidoVenda_Total, tipovenda,PV_PedidoVenda_Hora, PV_PedidoVenda_Data);
set IdPedido=(select IdTB_PedidoVenda FROM TB_PedidoVenda ORDER BY IdTB_PedidoVenda DESC LIMIT 1);

insert into TB_Pagamento(TB_PedidoVenda_IdTB_PedidoVenda, Pagamento_Status) values (IdPedido, false);

insert into TB_Entrega(TB_PedidoVenda_IdTB_PedidoVenda,TB_Funcsionario_IdTB_Funcionario, Entrega_Status) values (IdPedido, PV_IdTB_Funcionario, false);
set msg='Pedido de venda cadastrado com sucesso!';
end $$
Delimiter ;
-- --------------------------------------------------------------------

-- Procedure Alterar PedidoVenda

DELIMITER $$
drop procedure if exists `alterarPedidoVenda` $$
create procedure `alterarPedidoVenda` (
    in PV_IdVenda int,
    in PV_IdTB_Cliente int,
    in PV_IdTB_Funcionario int,
    in PV_PedidoVenda_Frete double(12,2),
	in PV_PedidoVenda_PorcentagemDesconto double(5,2),
    in PV_PedidoVenda_ValorDesconto double(12,2),
    in PV_PedidoVenda_Total double(12,2),
    in PV_PedidoVenda_TipoDeVenda varchar(16),
    in PV_PedidoVenda_Hora time,
	in PV_PedidoVenda_Data date,
  out msg varchar(40)
  )
begin
declare IdPedido int;
declare tipovenda int;

set tipovenda=(select IdTB_TipoVenda FROM TB_TipoVenda where TipoVenda_Tipo=PV_PedidoVenda_TipoDeVenda);

update TB_PedidoVenda set TB_Cliente_IdTB_Cliente=PV_IdTB_Cliente,
					  PedidoVenda_frete=PV_PedidoVenda_Frete,
                      PV_PedidoVenda_PorcentagemDesconto=PV_PedidoVenda_PorcentagemDesconto,
                      PedidoVenda_ValorDesconto=PV_PedidoVenda_ValorDesconto,
                      PedidoVenda_Total=PV_PedidoVenda_Total,
                      TB_TipoVenda_idTB_TipoVenda=tipovenda,
                      PedidoVenda_Hora=PV_PedidoVenda_Hora,
                      PedidoVenda_Data=PV_PedidoVenda_Data
                      where TB_PedidoVenda_IdTB_PedidoVenda=PV_IdVenda;

update TB_Entrega set TB_Funcionario_IdTB_Funcionario=PV_IdTB_Funcionario
                      where TB_PedidoVenda_IdTB_PedidoVenda=PV_IdVenda;
                      set msg='Pedido de venda cadastrado com sucesso!';
end $$
Delimiter ;
-- --------------------------------------------------------------------

 -- Procedure Excluir PedidoVenda

DELIMITER $$
drop procedure if exists `excluirPedidoVenda` $$
create procedure `excluirPedidoVenda` (

 in PV_IdTB_PedidoVenda int,
out msg varchar(40)

)
begin

delete from TB_PedidoVenda  where IdTB_PedidoVenda = PV_IdTB_PedidoVenda;
set msg='PedidoVenda excluido com sucesso!';
end $$
Delimiter ;
-- --------------------------------------------------------------------


 -- Procedure Listar Todos PedidoVendas

DELIMITER $$
drop procedure if exists `listarTodosPedidoVenda` $$
create procedure `listarTodosPedidoVenda` ()
begin

select pv.IdTB_PedidoVenda as IdPedidoVenda,
	   c.IdTB_Cliente as 'IdCliente',
       c.Cliente_Nome as 'Cliente',
       f.IdTB_Funcionario as 'IdFuncionario',
       f.Funcionario_Nome as 'Funcionario',
       pv.PedidoVenda_frete as 'Frete',
       pv.PedidoVenda_PorcentagemDesconto as 'DescontoPorcentagem',
       pv.PedidoVenda_ValorDesconto as 'Desconto',
       pv.PedidoVenda_Total as 'Total',
       tv.TipoVenda_Tipo as 'TipoDeVenda',
       ent.Entrega_Status as 'StatusEntrega',
       pag.Pagamento_Status as 'StatusPagamento',
       pv.PedidoVenda_Hora as 'Hora',
       pv.PedidoVenda_Data as 'Data'
 from TB_PedidoVenda as pv
 left join TB_Cliente as c
 on pv.TB_Cliente_IdTB_Cliente=c.IdTB_Cliente
 left join TB_Entrega as ent
 on ent.TB_PedidoVenda_IdTB_PedidoVenda=pv.IdTB_PedidoVenda
 left join TB_Funcionario as f
 on ent.TB_Funcionario_IdTB_Funcionario=f.IdTB_Funcionario
 left join TB_TipoVenda as tv
 on pv.TB_TipoVenda_idTB_TipoVenda=tv.IdTB_TipoVenda
 left join TB_Pagamento as pag
 on pag.TB_PedidoVenda_IdTB_PedidoVenda=pv.IdTB_PedidoVenda;
end $$
Delimiter ;
-- --------------------------------------------------------------------

 -- Procedure Listar Todos PedidoVendas

DELIMITER $$
drop procedure if exists `listarTodosPedidoVendaPorID` $$
create procedure `listarTodosPedidoVendaPorID` (
in idPedidoVenda int
)
begin

select pv.IdTB_PedidoVenda as IdPedidoVenda,
	   c.IdTB_Cliente as 'IdCliente',
       c.Cliente_Nome as 'Cliente',
       f.IdTB_Funcionario as 'IdFuncionario',
       f.Funcionario_Nome as 'Funcionario',
       pv.PedidoVenda_frete as 'Frete',
       pv.PedidoVenda_PorcentagemDesconto as 'DescontoPorcentagem',
       pv.PedidoVenda_ValorDesconto as 'Desconto',
       pv.PedidoVenda_Total as 'Total',
       pv.TB_TipoVenda_idTB_TipoVenda as 'TipoDeVenda',
       ent.Entrega_Status as 'StatusEntrega',
       pag.Pagamento_Status as 'StatusPagamento',
       pv.PedidoVenda_Hora as 'Hora',
       pv.PedidoVenda_Data as 'Data'
 from TB_PedidoVenda as pv
 left join TB_Cliente as c
 on pv.TB_Cliente_IdTB_Cliente=c.IdTB_Cliente
 left join TB_Entrega as ent
 on ent.TB_PedidoVenda_IdTB_PedidoVenda=pv.IdTB_PedidoVenda
 left join TB_Funcionario as f
 on ent.TB_Funcionario_IdTB_Funcionario=f.IdTB_Funcionario
 left join TB_Pagamento as pag
 on pag.TB_PedidoVenda_IdTB_PedidoVenda=pv.IdTB_PedidoVenda
 where pv.IdTB_PedidoVenda=idPedidoVenda;
end $$
Delimiter ;
-- ----------------------------FIM PROCEDURES DO PEDIDOVenda--------------------------------

-- -----------------------------PROCEDURES DO ITENSPEDIDOVenda-----------------------------------

 -- Procedure Inserir ItensPedidoVenda

DELIMITER $$
drop procedure if exists `inserirItensPedidoVenda` $$
create procedure `inserirItensPedidoVenda` (
    
    in IPV_TB_Produto_idTB_Produto int,
    in IPV_ItensPedidoVenda_Quantidade int,
    in IPV_ItensPedidoVenda_ValorUnitario double(12,2),
    in IPV_ItensPedidoVenda_ValorTotal double(12,2),
 out msg varchar(40)
)

begin
declare E_idPedidoVenda int;
declare idprodutoestoque int;
declare qtd int;

set E_idPedidoVenda=(select IdTB_PedidoVenda FROM TB_PedidoVenda ORDER BY IdTB_PedidoVenda DESC LIMIT 1);

insert into TB_ItensPedidoVenda (TB_Pedido_idTB_PedidoVenda, TB_Produto_idTB_Produto, ItensPedidoVenda_Quantidade, ItensPedidoVenda_ValorUnitario, ItensPedidoVenda_ValorTotal) 
 values (E_idPedidoVenda, IPV_TB_Produto_idTB_Produto, IPV_ItensPedidoVenda_Quantidade, IPV_ItensPedidoVenda_ValorUnitario, IPV_ItensPedidoVenda_ValorTotal);

end $$
Delimiter ;

 -- Procedure Listar Todos Itens Pedido Venda

DELIMITER $$
drop procedure if exists `ListarItensPedidoVenda` $$
create procedure `ListarItensPedidoVenda` (
in IdPedidoVenda int
)
begin
select p.IdTB_Produto as 'ID',
       p.Produto_Descricao as 'Descricao',
       m.Marca_Descricao as Marca,
       ipv.ItensPedidoVenda_Quantidade as Quantidade,
       ipv.ItensPedidoVenda_ValorTotal as SubTotal,
       ipv.ItensPedidoVenda_ValorUnitario as ValorUnit
 from TB_ItensPedidoVenda as ipv
 left join TB_Produto as p
 on ipv.TB_Produto_idTB_Produto=p.IdTB_Produto
 left join TB_Marca as m
 on p.TB_Marca_idTB_Marca=m.IdTB_Marca
 where TB_Pedido_idTB_PedidoVenda=IdPedidoVenda;
end $$
Delimiter ;

 -- Procedure Excluir Produto

DELIMITER $$
drop procedure if exists `excluirItensPedidoVenda` $$
create procedure `excluirItensPedidoVenda` (

 in IPC_IdTB_PedidoVenda int

)
begin
delete from TB_ItensPedidoVenda  where TB_Pedido_idTB_PedidoVenda = IPC_IdTB_PedidoVenda;
end $$
Delimiter ;
-- --------------------------------------------------------------------
-- -----------------------------FIM PROCEDURES DO ITENSPEDIDOVenda---------------------------------

-- ----------------------------- PROCEDURES DO FUNCIONARIO----------------------------

 -- Procedure Inserir Usuario


DELIMITER $$
drop procedure if exists `inserirUsuario` $$
create procedure `inserirUsuario` (
  in U_Usuario_Nome varchar(64),
  in U_Usuario_Email varchar(32),
  in U_Usuario_Tipo varchar(32),
  in U_Usuario_Senha varchar(32),
  
  out msg varchar(40)
  )
begin
declare verificanome int;
declare tipo int;
set verificanome=(select IdTB_Usuario from TB_Usuario where Usuario_Nome=U_Usuario_Nome);
set tipo=(select IdTB_TipoConta from TB_TipoConta where TipoConta_Tipo=U_Usuario_Tipo);
if(verificanome >=1) then     
     set msg='Este nome de usuário já existe !';
else
insert into TB_Usuario ( TB_TipoConta_idTB_TipoConta,Usuario_Nome, Usuario_Senha, Usuario_Email) 
 values (tipo,U_Usuario_Nome, U_Usuario_Senha, U_Usuario_Email);
set msg='Usuário cadastrado com sucesso!';
end if;
end $$
Delimiter ;
-- --------------------------------------------------------------------

 -- Procedure Alterar Usuario

DELIMITER $$
drop procedure if exists `alterarUsuario` $$
create procedure `alterarUsuario` (
  in U_IdTB_Usuario int,
  in U_Usuario_Nome varchar(64),
  in U_Usuario_Email varchar(64),
  in U_Usuario_Senha varchar(32),
  in U_Usuario_SenhaAntiga varchar(32),
  in U_Usuario_Tipo varchar(32),
  out msg varchar(40)
  )
begin
declare senhateste varchar (32);
declare tipo int;
set tipo=(select IdTB_TipoConta from TB_TipoConta where TipoConta_Tipo=U_Usuario_Tipo);
set senhateste=(select Usuario_Senha from TB_Usuario where IdTB_Usuario=U_IdTB_Usuario);
if(senhateste = U_Usuario_SenhaAntiga) then

update TB_Usuario set TB_TipoConta_idTB_TipoConta=tipo,
					  Usuario_Nome=U_Usuario_Nome,
					  Usuario_Email=U_Usuario_Email,
					  Usuario_Senha=U_Usuario_Senha
                      where IdTB_Usuario=U_IdTB_Usuario;
                      set msg='Usuário Atualizado com sucesso!';
else
set msg='Senhas antigas não se coincidem';
end if;
end $$
Delimiter;
-- --------------------------------------------------------------------

 -- Procedure Excluir Usuario

DELIMITER $$
drop procedure if exists `excluirUsuario` $$
create procedure `excluirUsuario` (
 in U_IdTB_Usuario int,
 out msg varchar(40)
)
begin
delete from TB_Usuario  where IdTB_Usuario = U_IdTB_Usuario;
set msg='Usuário excluido com sucesso!';
end $$
Delimiter ;
-- --------------------------------------------------------------------


 -- Procedure Listar Todos Usuarios

DELIMITER $$
drop procedure if exists `listarTodosUsuarios` $$
create procedure `listarTodosUsuarios` ()
begin

select u.IdTB_Usuario as ID,
       u.Usuario_Nome as Nome,
	   u.Usuario_Email as Email,
	   t.TipoConta_Tipo as TipoConta,
	   u.Usuario_Senha as Senha
from TB_Usuario as u 
inner join TB_TipoConta as t on t.IdTB_TipoConta = u.TB_TipoConta_idTB_TipoConta;
end $$
Delimiter ;

 -- Procedure listar Usuario Id

DELIMITER $$
drop procedure if exists `listarUsuarioId` $$
create procedure `listarUsuarioId` (
in U_Id int
)
begin

select u.IdTB_Usuario as ID,
       u.Usuario_Nome as Nome,
	   u.Usuario_Email as Email,
	   t.TipoConta_Tipo as TipoConta,
	   u.Usuario_Senha as Senha
from TB_Usuario as u 
inner join TB_TipoConta as t on t.IdTB_TipoConta = u.TB_TipoConta_idTB_TipoConta where IdTB_Usuario=U_Id;
end $$
Delimiter ;
 -- Procedure Trocar Senha Usuario
 
DELIMITER $$
drop procedure if exists `TrocarSenhaUsuario` $$
create procedure `TrocarSenhaUsuario` (
in U_IdTB_Usuario int,
in U_UsuarioSenha varchar(64),
 out msg varchar(40)
)
begin

update TB_Usuario set Usuario_Senha = U_UsuarioSenha where IdTB_Usuario =U_IdTB_Usuario;
end $$
Delimiter ;
-- ----------------------------FIM PROCEDURES DO FUNCIONARIO--------------------------------

-- ----------------------------PROCEDURES DOS DADOS DA EMPRESA--------------------------------
-- Procedure Criar Tabela Dados Empresa

DELIMITER $$
drop procedure if exists `CriarTabelaDadosEmpresa` $$
create procedure `CriarTabelaDadosEmpresa` ()
begin
drop table if exists TB_DadosEmpresa;
create table TB_DadosEmpresa (
IdTB_DadosEmpresa int(11) NOT NULL AUTO_INCREMENT,
  DadosEmpresa_Nome varchar(16) DEFAULT NULL,
  DadosEmpresa_Endereco varchar(256) DEFAULT NULL,
  DadosEmpresa_Numero int(11) DEFAULT NULL,
  DadosEmpresa_Bairro varchar(64) DEFAULT NULL,
  DadosEmpresa_Cidade varchar(64) DEFAULT NULL,
  DadosEmpresa_Estado char(2) DEFAULT NULL,
  DadosEmpresa_CEP varchar(10) DEFAULT NULL,
  DadosEmpresa_Email varchar(64) DEFAULT NULL,
  DadosEmpresa_Telefone1 varchar(15) DEFAULT NULL,
  DadosEmpresa_Telefone2 varchar(15) DEFAULT NULL,
  PRIMARY KEY (IdTB_DadosEmpresa)
);
INSERT INTO `TB_DadosEmpresa` VALUES (1,'J.C Tramontina','Rua Alberto Frediani',219,'Centro','Santana de Parnaíba','SP','06.502-155','emailexemplo@hotmail.com.br','(11) 4152-6500','(11) 4152-6500');
end $$
Delimiter ;

DELIMITER $$
drop procedure if exists `alterarDados` $$
create procedure `alterarDados` (
in E_DadosEmpresa_Nome varchar(16),
in E_DadosEmpresa_Endereco varchar(256),
in E_DadosEmpresa_Numero int(11),
in E_DadosEmpresa_Bairro varchar(64),
in E_DadosEmpresa_Cidade varchar(64),
in E_DadosEmpresa_Estado char(2),
in E_DadosEmpresa_CEP varchar(10),
in E_DadosEmpresa_Email varchar(64),
in E_DadosEmpresa_Telefone1 varchar(15),
in E_DadosEmpresa_Telefone2 varchar(15),
out msg varchar(64)
)
begin
update TB_DadosEmpresa set DadosEmpresa_Nome=E_DadosEmpresa_Nome,
					  DadosEmpresa_Endereco=E_DadosEmpresa_Endereco,
					  DadosEmpresa_Numero=E_DadosEmpresa_Numero,
                      DadosEmpresa_Bairro=E_DadosEmpresa_Bairro,
                      DadosEmpresa_Cidade=E_DadosEmpresa_Cidade,
                      DadosEmpresa_Estado=E_DadosEmpresa_Estado,
                      DadosEmpresa_CEP=E_DadosEmpresa_CEP,
                      DadosEmpresa_Email=E_DadosEmpresa_Email,
                      DadosEmpresa_Telefone1=E_DadosEmpresa_Telefone1,
                      DadosEmpresa_Telefone2=E_DadosEmpresa_Telefone2
                      where IdTB_DadosEmpresa=1;
                      set msg='Dados atualizados com sucesso!';
end $$
Delimiter ;
-- ----------------------------FIM PROCEDURES DOS DADOS DA EMPRESA--------------------------------
-- ------------------------------------------------------------------------------------
-- ------------------------------------------------------------------------------------
-- ------------------------------------------------------------------------------------
-- ------------------------------------------------------------------------------------
-- ------------------------------------------------------------------------------------
-- ------------------------------------------------------------------------------------
-- ------------------------------------------------------------------------------------

call CriarTabelaDadosEmpresa;
-- ---------------------------- INSERÇÃO DE DADOS PRIMARIOS ----------------------------

insert into TB_TipoConta (TipoConta_Tipo) 
values ('Administrador'); 
insert into TB_TipoConta (TipoConta_Tipo) 
values ('Comum');

insert into TB_TipoVenda (TipoVenda_Tipo) 
values ('Local'); 
insert into TB_TipoVenda (TipoVenda_Tipo) 
values ('Entrega');

insert into TB_TipoPagamento (TipoPagamento_Tipo)
values ('Dinheiro'); 
insert into TB_TipoPagamento (TipoPagamento_Tipo) 
values ('Cartão de Crédito');
insert into TB_TipoPagamento (TipoPagamento_Tipo) 
values ('Cartão de Débito');
 
insert into TB_Usuario (Usuario_Nome, Usuario_Email, TB_TipoConta_IdTB_TipoConta, Usuario_Senha) 
 values ('admin', '', 1, '827ccb0eea8a706c4c34a16891f84e7b');