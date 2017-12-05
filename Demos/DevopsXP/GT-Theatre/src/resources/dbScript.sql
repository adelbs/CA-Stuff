-- EVEN_CD_TIPO:
-- 1 - FUTEBOL
-- 2 - SHOW
-- 3 - TEATRO
-- 4 - CINEMA
-- 5 - LUTA


-- FUTEBOL ###########################################################################

INSERT INTO FI_CD_EVENTO_EVEN 
(ID_EVEN_CD_EVENTO, EVEN_CD_TIPO, EVEN_DH_EVENTO, EVEN_DS_DESCRICAO, EVEN_DS_LOCAL, EVEN_DS_TITULO) 
values (1, '1', '01/12/2016', 
'Jogo novo. Descricao 123 123 123.',
'Alianz Park', '15 de Piri Piri x Jau');

INSERT INTO FI_CD_TICKET_TICK
(ID_TICK_CD_TICKET, TICK_DS_DESCRICAO, TICK_NR_DISPONIVEL, TICK_NR_VALOR, ID_EVEN_CD_EVENTO)
values (1, 'Setor 1', 3, 100.0,
(SELECT MAX(ID_EVEN_CD_EVENTO) FROM FI_CD_EVENTO_EVEN) );

INSERT INTO FI_CD_TICKET_TICK
(ID_TICK_CD_TICKET, TICK_DS_DESCRICAO, TICK_NR_DISPONIVEL, TICK_NR_VALOR, ID_EVEN_CD_EVENTO)
SELECT MAX(ID_TICK_CD_TICKET) + 1, 'Setor 2', 3, 70.0,
(SELECT MAX(ID_EVEN_CD_EVENTO) FROM FI_CD_EVENTO_EVEN) FROM FI_CD_TICKET_TICK;

INSERT INTO FI_CD_TICKET_TICK
(ID_TICK_CD_TICKET, TICK_DS_DESCRICAO, TICK_NR_DISPONIVEL, TICK_NR_VALOR, ID_EVEN_CD_EVENTO)
SELECT MAX(ID_TICK_CD_TICKET) + 1, 'Setor 3', 3, 40.0,
(SELECT MAX(ID_EVEN_CD_EVENTO) FROM FI_CD_EVENTO_EVEN) FROM FI_CD_TICKET_TICK;


INSERT INTO FI_CD_EVENTO_EVEN 
(ID_EVEN_CD_EVENTO, EVEN_CD_TIPO, EVEN_DH_EVENTO, EVEN_DS_DESCRICAO, EVEN_DS_LOCAL, EVEN_DS_TITULO) 
SELECT MAX(ID_EVEN_CD_EVENTO) + 1, '1', '01/02/2016', 
'Classico do brasileirao! Voce nao pode perder!',
'Beira Rio', 'Santos x Gremio'
FROM FI_CD_EVENTO_EVEN;

INSERT INTO FI_CD_TICKET_TICK
(ID_TICK_CD_TICKET, TICK_DS_DESCRICAO, TICK_NR_DISPONIVEL, TICK_NR_VALOR, ID_EVEN_CD_EVENTO)
SELECT MAX(ID_TICK_CD_TICKET) + 1, 'Setor 1', 3, 100.0,
(SELECT MAX(ID_EVEN_CD_EVENTO) FROM FI_CD_EVENTO_EVEN) FROM FI_CD_TICKET_TICK;

INSERT INTO FI_CD_TICKET_TICK
(ID_TICK_CD_TICKET, TICK_DS_DESCRICAO, TICK_NR_DISPONIVEL, TICK_NR_VALOR, ID_EVEN_CD_EVENTO)
SELECT MAX(ID_TICK_CD_TICKET) + 1, 'Setor 2', 3, 70.0,
(SELECT MAX(ID_EVEN_CD_EVENTO) FROM FI_CD_EVENTO_EVEN) FROM FI_CD_TICKET_TICK;

INSERT INTO FI_CD_TICKET_TICK
(ID_TICK_CD_TICKET, TICK_DS_DESCRICAO, TICK_NR_DISPONIVEL, TICK_NR_VALOR, ID_EVEN_CD_EVENTO)
SELECT MAX(ID_TICK_CD_TICKET) + 1, 'Setor 3', 3, 40.0,
(SELECT MAX(ID_EVEN_CD_EVENTO) FROM FI_CD_EVENTO_EVEN) FROM FI_CD_TICKET_TICK;

INSERT INTO FI_CD_EVENTO_EVEN 
(ID_EVEN_CD_EVENTO, EVEN_CD_TIPO, EVEN_DH_EVENTO, EVEN_DS_DESCRICAO, EVEN_DS_LOCAL, EVEN_DS_TITULO) 
SELECT MAX(ID_EVEN_CD_EVENTO) + 1, '1', '20/03/2016', 
'Campeonato Paulista. Pela primeira vez na historia o Palmeiras enfrenta o 15 de Jau. Partida imperdivel.',
'Alianz Park', '15 de Jau x Palmeiras'
FROM FI_CD_EVENTO_EVEN;

INSERT INTO FI_CD_TICKET_TICK
(ID_TICK_CD_TICKET, TICK_DS_DESCRICAO, TICK_NR_DISPONIVEL, TICK_NR_VALOR, ID_EVEN_CD_EVENTO)
SELECT MAX(ID_TICK_CD_TICKET) + 1, 'Setor 1', 3, 100.0,
(SELECT MAX(ID_EVEN_CD_EVENTO) FROM FI_CD_EVENTO_EVEN) FROM FI_CD_TICKET_TICK;

INSERT INTO FI_CD_TICKET_TICK
(ID_TICK_CD_TICKET, TICK_DS_DESCRICAO, TICK_NR_DISPONIVEL, TICK_NR_VALOR, ID_EVEN_CD_EVENTO)
SELECT MAX(ID_TICK_CD_TICKET) + 1, 'Setor 2', 3, 70.0,
(SELECT MAX(ID_EVEN_CD_EVENTO) FROM FI_CD_EVENTO_EVEN) FROM FI_CD_TICKET_TICK;

INSERT INTO FI_CD_TICKET_TICK
(ID_TICK_CD_TICKET, TICK_DS_DESCRICAO, TICK_NR_DISPONIVEL, TICK_NR_VALOR, ID_EVEN_CD_EVENTO)
SELECT MAX(ID_TICK_CD_TICKET) + 1, 'Setor 3', 3, 40.0,
(SELECT MAX(ID_EVEN_CD_EVENTO) FROM FI_CD_EVENTO_EVEN) FROM FI_CD_TICKET_TICK;

INSERT INTO FI_CD_EVENTO_EVEN 
(ID_EVEN_CD_EVENTO, EVEN_CD_TIPO, EVEN_DH_EVENTO, EVEN_DS_DESCRICAO, EVEN_DS_LOCAL, EVEN_DS_TITULO) 
SELECT MAX(ID_EVEN_CD_EVENTO) + 1, '1', '18/09/2016', 
'Campeonato Brasileiro. Segunda rodada do campeonato com replay de jogos classicos.',
'Morumbi', 'Cruzeiro x Juventus'
FROM FI_CD_EVENTO_EVEN;

INSERT INTO FI_CD_TICKET_TICK
(ID_TICK_CD_TICKET, TICK_DS_DESCRICAO, TICK_NR_DISPONIVEL, TICK_NR_VALOR, ID_EVEN_CD_EVENTO)
SELECT MAX(ID_TICK_CD_TICKET) + 1, 'Setor 1', 3, 100.0,
(SELECT MAX(ID_EVEN_CD_EVENTO) FROM FI_CD_EVENTO_EVEN) FROM FI_CD_TICKET_TICK;

INSERT INTO FI_CD_TICKET_TICK
(ID_TICK_CD_TICKET, TICK_DS_DESCRICAO, TICK_NR_DISPONIVEL, TICK_NR_VALOR, ID_EVEN_CD_EVENTO)
SELECT MAX(ID_TICK_CD_TICKET) + 1, 'Setor 2', 3, 70.0,
(SELECT MAX(ID_EVEN_CD_EVENTO) FROM FI_CD_EVENTO_EVEN) FROM FI_CD_TICKET_TICK;

INSERT INTO FI_CD_TICKET_TICK
(ID_TICK_CD_TICKET, TICK_DS_DESCRICAO, TICK_NR_DISPONIVEL, TICK_NR_VALOR, ID_EVEN_CD_EVENTO)
SELECT MAX(ID_TICK_CD_TICKET) + 1, 'Setor 3', 3, 40.0,
(SELECT MAX(ID_EVEN_CD_EVENTO) FROM FI_CD_EVENTO_EVEN) FROM FI_CD_TICKET_TICK;


-- SHOWS ####################################################################################

INSERT INTO FI_CD_EVENTO_EVEN 
(ID_EVEN_CD_EVENTO, EVEN_CD_TIPO, EVEN_DH_EVENTO, EVEN_DS_DESCRICAO, EVEN_DS_LOCAL, EVEN_DS_TITULO) 
SELECT MAX(ID_EVEN_CD_EVENTO) + 1, '2', '14/11/2016', 
'Show novo. Descricao 123 123',
'Ibirapuera', 'Metallica'
FROM FI_CD_EVENTO_EVEN;

INSERT INTO FI_CD_TICKET_TICK
(ID_TICK_CD_TICKET, TICK_DS_DESCRICAO, TICK_NR_DISPONIVEL, TICK_NR_VALOR, ID_EVEN_CD_EVENTO)
SELECT MAX(ID_TICK_CD_TICKET) + 1, 'Premium', 3, 900.0,
(SELECT MAX(ID_EVEN_CD_EVENTO) FROM FI_CD_EVENTO_EVEN) FROM FI_CD_TICKET_TICK;

INSERT INTO FI_CD_TICKET_TICK
(ID_TICK_CD_TICKET, TICK_DS_DESCRICAO, TICK_NR_DISPONIVEL, TICK_NR_VALOR, ID_EVEN_CD_EVENTO)
SELECT MAX(ID_TICK_CD_TICKET) + 1, 'Cadeira Azul', 3, 300.0,
(SELECT MAX(ID_EVEN_CD_EVENTO) FROM FI_CD_EVENTO_EVEN) FROM FI_CD_TICKET_TICK;

INSERT INTO FI_CD_TICKET_TICK
(ID_TICK_CD_TICKET, TICK_DS_DESCRICAO, TICK_NR_DISPONIVEL, TICK_NR_VALOR, ID_EVEN_CD_EVENTO)
SELECT MAX(ID_TICK_CD_TICKET) + 1, 'Camarote', 3, 250.0,
(SELECT MAX(ID_EVEN_CD_EVENTO) FROM FI_CD_EVENTO_EVEN) FROM FI_CD_TICKET_TICK;

INSERT INTO FI_CD_TICKET_TICK
(ID_TICK_CD_TICKET, TICK_DS_DESCRICAO, TICK_NR_DISPONIVEL, TICK_NR_VALOR, ID_EVEN_CD_EVENTO)
SELECT MAX(ID_TICK_CD_TICKET) + 1, 'Pista', 3, 150.0,
(SELECT MAX(ID_EVEN_CD_EVENTO) FROM FI_CD_EVENTO_EVEN) FROM FI_CD_TICKET_TICK;

INSERT INTO FI_CD_EVENTO_EVEN 
(ID_EVEN_CD_EVENTO, EVEN_CD_TIPO, EVEN_DH_EVENTO, EVEN_DS_DESCRICAO, EVEN_DS_LOCAL, EVEN_DS_TITULO) 
SELECT MAX(ID_EVEN_CD_EVENTO) + 1, '2', '10/01/2016', 
'Uma das melhores bandas de Hard Rock de todos os tempos em apresentacao unica em Sao Paulo!',
'Carioca Club', 'Uriah Heep'
FROM FI_CD_EVENTO_EVEN;

INSERT INTO FI_CD_TICKET_TICK
(ID_TICK_CD_TICKET, TICK_DS_DESCRICAO, TICK_NR_DISPONIVEL, TICK_NR_VALOR, ID_EVEN_CD_EVENTO)
SELECT MAX(ID_TICK_CD_TICKET) + 1, 'Premium', 3, 900.0,
(SELECT MAX(ID_EVEN_CD_EVENTO) FROM FI_CD_EVENTO_EVEN) FROM FI_CD_TICKET_TICK;

INSERT INTO FI_CD_TICKET_TICK
(ID_TICK_CD_TICKET, TICK_DS_DESCRICAO, TICK_NR_DISPONIVEL, TICK_NR_VALOR, ID_EVEN_CD_EVENTO)
SELECT MAX(ID_TICK_CD_TICKET) + 1, 'Cadeira Azul', 3, 300.0,
(SELECT MAX(ID_EVEN_CD_EVENTO) FROM FI_CD_EVENTO_EVEN) FROM FI_CD_TICKET_TICK;

INSERT INTO FI_CD_TICKET_TICK
(ID_TICK_CD_TICKET, TICK_DS_DESCRICAO, TICK_NR_DISPONIVEL, TICK_NR_VALOR, ID_EVEN_CD_EVENTO)
SELECT MAX(ID_TICK_CD_TICKET) + 1, 'Camarote', 3, 250.0,
(SELECT MAX(ID_EVEN_CD_EVENTO) FROM FI_CD_EVENTO_EVEN) FROM FI_CD_TICKET_TICK;

INSERT INTO FI_CD_TICKET_TICK
(ID_TICK_CD_TICKET, TICK_DS_DESCRICAO, TICK_NR_DISPONIVEL, TICK_NR_VALOR, ID_EVEN_CD_EVENTO)
SELECT MAX(ID_TICK_CD_TICKET) + 1, 'Pista', 3, 150.0,
(SELECT MAX(ID_EVEN_CD_EVENTO) FROM FI_CD_EVENTO_EVEN) FROM FI_CD_TICKET_TICK;




INSERT INTO FI_CD_EVENTO_EVEN 
(ID_EVEN_CD_EVENTO, EVEN_CD_TIPO, EVEN_DH_EVENTO, EVEN_DS_DESCRICAO, EVEN_DS_LOCAL, EVEN_DS_TITULO) 
SELECT MAX(ID_EVEN_CD_EVENTO) + 1, '2', '11/01/2016', 
'Eles ja vieram diversas vezes para o Brasil, mas esse show sera cheio de surpresas!',
'Alianz Park', 'Iron Maiden'
FROM FI_CD_EVENTO_EVEN;

INSERT INTO FI_CD_TICKET_TICK
(ID_TICK_CD_TICKET, TICK_DS_DESCRICAO, TICK_NR_DISPONIVEL, TICK_NR_VALOR, ID_EVEN_CD_EVENTO)
SELECT MAX(ID_TICK_CD_TICKET) + 1, 'Premium', 3, 900.0,
(SELECT MAX(ID_EVEN_CD_EVENTO) FROM FI_CD_EVENTO_EVEN) FROM FI_CD_TICKET_TICK;

INSERT INTO FI_CD_TICKET_TICK
(ID_TICK_CD_TICKET, TICK_DS_DESCRICAO, TICK_NR_DISPONIVEL, TICK_NR_VALOR, ID_EVEN_CD_EVENTO)
SELECT MAX(ID_TICK_CD_TICKET) + 1, 'Cadeira Azul', 3, 300.0,
(SELECT MAX(ID_EVEN_CD_EVENTO) FROM FI_CD_EVENTO_EVEN) FROM FI_CD_TICKET_TICK;

INSERT INTO FI_CD_TICKET_TICK
(ID_TICK_CD_TICKET, TICK_DS_DESCRICAO, TICK_NR_DISPONIVEL, TICK_NR_VALOR, ID_EVEN_CD_EVENTO)
SELECT MAX(ID_TICK_CD_TICKET) + 1, 'Camarote', 3, 250.0,
(SELECT MAX(ID_EVEN_CD_EVENTO) FROM FI_CD_EVENTO_EVEN) FROM FI_CD_TICKET_TICK;

INSERT INTO FI_CD_TICKET_TICK
(ID_TICK_CD_TICKET, TICK_DS_DESCRICAO, TICK_NR_DISPONIVEL, TICK_NR_VALOR, ID_EVEN_CD_EVENTO)
SELECT MAX(ID_TICK_CD_TICKET) + 1, 'Pista', 3, 150.0,
(SELECT MAX(ID_EVEN_CD_EVENTO) FROM FI_CD_EVENTO_EVEN) FROM FI_CD_TICKET_TICK;






INSERT INTO FI_CD_EVENTO_EVEN 
(ID_EVEN_CD_EVENTO, EVEN_CD_TIPO, EVEN_DH_EVENTO, EVEN_DS_DESCRICAO, EVEN_DS_LOCAL, EVEN_DS_TITULO) 
SELECT MAX(ID_EVEN_CD_EVENTO) + 1, '2', '18/01/2016', 
'Compre aqui com exclusividade e ganhe uma camiseta oficial do fa clube e ainda concorra a premios!',
'Bar do Samba', 'Arlindo Cruz'
FROM FI_CD_EVENTO_EVEN;

INSERT INTO FI_CD_TICKET_TICK
(ID_TICK_CD_TICKET, TICK_DS_DESCRICAO, TICK_NR_DISPONIVEL, TICK_NR_VALOR, ID_EVEN_CD_EVENTO)
SELECT MAX(ID_TICK_CD_TICKET) + 1, 'Premium', 3, 900.0,
(SELECT MAX(ID_EVEN_CD_EVENTO) FROM FI_CD_EVENTO_EVEN) FROM FI_CD_TICKET_TICK;

INSERT INTO FI_CD_TICKET_TICK
(ID_TICK_CD_TICKET, TICK_DS_DESCRICAO, TICK_NR_DISPONIVEL, TICK_NR_VALOR, ID_EVEN_CD_EVENTO)
SELECT MAX(ID_TICK_CD_TICKET) + 1, 'Cadeira Azul', 3, 300.0,
(SELECT MAX(ID_EVEN_CD_EVENTO) FROM FI_CD_EVENTO_EVEN) FROM FI_CD_TICKET_TICK;

INSERT INTO FI_CD_TICKET_TICK
(ID_TICK_CD_TICKET, TICK_DS_DESCRICAO, TICK_NR_DISPONIVEL, TICK_NR_VALOR, ID_EVEN_CD_EVENTO)
SELECT MAX(ID_TICK_CD_TICKET) + 1, 'Camarote', 3, 250.0,
(SELECT MAX(ID_EVEN_CD_EVENTO) FROM FI_CD_EVENTO_EVEN) FROM FI_CD_TICKET_TICK;

INSERT INTO FI_CD_TICKET_TICK
(ID_TICK_CD_TICKET, TICK_DS_DESCRICAO, TICK_NR_DISPONIVEL, TICK_NR_VALOR, ID_EVEN_CD_EVENTO)
SELECT MAX(ID_TICK_CD_TICKET) + 1, 'Pista', 3, 150.0,
(SELECT MAX(ID_EVEN_CD_EVENTO) FROM FI_CD_EVENTO_EVEN) FROM FI_CD_TICKET_TICK;




INSERT INTO FI_CD_EVENTO_EVEN 
(ID_EVEN_CD_EVENTO, EVEN_CD_TIPO, EVEN_DH_EVENTO, EVEN_DS_DESCRICAO, EVEN_DS_LOCAL, EVEN_DS_TITULO) 
SELECT MAX(ID_EVEN_CD_EVENTO) + 1, '2', '31/12/2016', 
'Voce nao pode perder, um show inedito do Rei! Show da virada em Copacabana!!! Imperdivel!',
'Copacabana', 'Roberto Carlos'
FROM FI_CD_EVENTO_EVEN;

INSERT INTO FI_CD_TICKET_TICK
(ID_TICK_CD_TICKET, TICK_DS_DESCRICAO, TICK_NR_DISPONIVEL, TICK_NR_VALOR, ID_EVEN_CD_EVENTO)
SELECT MAX(ID_TICK_CD_TICKET) + 1, 'Premium', 3, 900.0,
(SELECT MAX(ID_EVEN_CD_EVENTO) FROM FI_CD_EVENTO_EVEN) FROM FI_CD_TICKET_TICK;

INSERT INTO FI_CD_TICKET_TICK
(ID_TICK_CD_TICKET, TICK_DS_DESCRICAO, TICK_NR_DISPONIVEL, TICK_NR_VALOR, ID_EVEN_CD_EVENTO)
SELECT MAX(ID_TICK_CD_TICKET) + 1, 'Cadeira Azul', 3, 300.0,
(SELECT MAX(ID_EVEN_CD_EVENTO) FROM FI_CD_EVENTO_EVEN) FROM FI_CD_TICKET_TICK;

INSERT INTO FI_CD_TICKET_TICK
(ID_TICK_CD_TICKET, TICK_DS_DESCRICAO, TICK_NR_DISPONIVEL, TICK_NR_VALOR, ID_EVEN_CD_EVENTO)
SELECT MAX(ID_TICK_CD_TICKET) + 1, 'Camarote', 3, 250.0,
(SELECT MAX(ID_EVEN_CD_EVENTO) FROM FI_CD_EVENTO_EVEN) FROM FI_CD_TICKET_TICK;

INSERT INTO FI_CD_TICKET_TICK
(ID_TICK_CD_TICKET, TICK_DS_DESCRICAO, TICK_NR_DISPONIVEL, TICK_NR_VALOR, ID_EVEN_CD_EVENTO)
SELECT MAX(ID_TICK_CD_TICKET) + 1, 'Pista', 3, 150.0,
(SELECT MAX(ID_EVEN_CD_EVENTO) FROM FI_CD_EVENTO_EVEN) FROM FI_CD_TICKET_TICK;





INSERT INTO FI_CD_EVENTO_EVEN 
(ID_EVEN_CD_EVENTO, EVEN_CD_TIPO, EVEN_DH_EVENTO, EVEN_DS_DESCRICAO, EVEN_DS_LOCAL, EVEN_DS_TITULO) 
SELECT MAX(ID_EVEN_CD_EVENTO) + 1, '2', '15/07/2016', 
'Em apresentacao intimista, inaugurando sua carreira solo.',
'Sesc Pompeia', 'Chimbinha'
FROM FI_CD_EVENTO_EVEN;

INSERT INTO FI_CD_TICKET_TICK
(ID_TICK_CD_TICKET, TICK_DS_DESCRICAO, TICK_NR_DISPONIVEL, TICK_NR_VALOR, ID_EVEN_CD_EVENTO)
SELECT MAX(ID_TICK_CD_TICKET) + 1, 'Premium', 3, 900.0,
(SELECT MAX(ID_EVEN_CD_EVENTO) FROM FI_CD_EVENTO_EVEN) FROM FI_CD_TICKET_TICK;

INSERT INTO FI_CD_TICKET_TICK
(ID_TICK_CD_TICKET, TICK_DS_DESCRICAO, TICK_NR_DISPONIVEL, TICK_NR_VALOR, ID_EVEN_CD_EVENTO)
SELECT MAX(ID_TICK_CD_TICKET) + 1, 'Cadeira Azul', 3, 300.0,
(SELECT MAX(ID_EVEN_CD_EVENTO) FROM FI_CD_EVENTO_EVEN) FROM FI_CD_TICKET_TICK;

INSERT INTO FI_CD_TICKET_TICK
(ID_TICK_CD_TICKET, TICK_DS_DESCRICAO, TICK_NR_DISPONIVEL, TICK_NR_VALOR, ID_EVEN_CD_EVENTO)
SELECT MAX(ID_TICK_CD_TICKET) + 1, 'Camarote', 3, 250.0,
(SELECT MAX(ID_EVEN_CD_EVENTO) FROM FI_CD_EVENTO_EVEN) FROM FI_CD_TICKET_TICK;

INSERT INTO FI_CD_TICKET_TICK
(ID_TICK_CD_TICKET, TICK_DS_DESCRICAO, TICK_NR_DISPONIVEL, TICK_NR_VALOR, ID_EVEN_CD_EVENTO)
SELECT MAX(ID_TICK_CD_TICKET) + 1, 'Pista', 3, 150.0,
(SELECT MAX(ID_EVEN_CD_EVENTO) FROM FI_CD_EVENTO_EVEN) FROM FI_CD_TICKET_TICK;







INSERT INTO FI_CD_EVENTO_EVEN 
(ID_EVEN_CD_EVENTO, EVEN_CD_TIPO, EVEN_DH_EVENTO, EVEN_DS_DESCRICAO, EVEN_DS_LOCAL, EVEN_DS_TITULO) 
SELECT MAX(ID_EVEN_CD_EVENTO) + 1, '2', '10/08/2016', 
'Muita festa e animacao. Simplesmente imperdivel.',
'Maracana', 'Ivete Sangalo'
FROM FI_CD_EVENTO_EVEN;

INSERT INTO FI_CD_TICKET_TICK
(ID_TICK_CD_TICKET, TICK_DS_DESCRICAO, TICK_NR_DISPONIVEL, TICK_NR_VALOR, ID_EVEN_CD_EVENTO)
SELECT MAX(ID_TICK_CD_TICKET) + 1, 'Premium', 3, 900.0,
(SELECT MAX(ID_EVEN_CD_EVENTO) FROM FI_CD_EVENTO_EVEN) FROM FI_CD_TICKET_TICK;

INSERT INTO FI_CD_TICKET_TICK
(ID_TICK_CD_TICKET, TICK_DS_DESCRICAO, TICK_NR_DISPONIVEL, TICK_NR_VALOR, ID_EVEN_CD_EVENTO)
SELECT MAX(ID_TICK_CD_TICKET) + 1, 'Cadeira Azul', 3, 300.0,
(SELECT MAX(ID_EVEN_CD_EVENTO) FROM FI_CD_EVENTO_EVEN) FROM FI_CD_TICKET_TICK;

INSERT INTO FI_CD_TICKET_TICK
(ID_TICK_CD_TICKET, TICK_DS_DESCRICAO, TICK_NR_DISPONIVEL, TICK_NR_VALOR, ID_EVEN_CD_EVENTO)
SELECT MAX(ID_TICK_CD_TICKET) + 1, 'Camarote', 3, 250.0,
(SELECT MAX(ID_EVEN_CD_EVENTO) FROM FI_CD_EVENTO_EVEN) FROM FI_CD_TICKET_TICK;

INSERT INTO FI_CD_TICKET_TICK
(ID_TICK_CD_TICKET, TICK_DS_DESCRICAO, TICK_NR_DISPONIVEL, TICK_NR_VALOR, ID_EVEN_CD_EVENTO)
SELECT MAX(ID_TICK_CD_TICKET) + 1, 'Pista', 3, 150.0,
(SELECT MAX(ID_EVEN_CD_EVENTO) FROM FI_CD_EVENTO_EVEN) FROM FI_CD_TICKET_TICK;


-- TEATROS ####################################################################################

INSERT INTO FI_CD_EVENTO_EVEN 
(ID_EVEN_CD_EVENTO, EVEN_CD_TIPO, EVEN_DH_EVENTO, EVEN_DS_DESCRICAO, EVEN_DS_LOCAL, EVEN_DS_TITULO) 
SELECT MAX(ID_EVEN_CD_EVENTO) + 1, '3', '27/03/2016', 
'Teatro novo. Descricao 123 123 123.',
'Sesc Pinheiros', 'O Coice'
FROM FI_CD_EVENTO_EVEN;

INSERT INTO FI_CD_TICKET_TICK
(ID_TICK_CD_TICKET, TICK_DS_DESCRICAO, TICK_NR_DISPONIVEL, TICK_NR_VALOR, ID_EVEN_CD_EVENTO)
SELECT MAX(ID_TICK_CD_TICKET) + 1, 'Inteira', 3, 200.0,
(SELECT MAX(ID_EVEN_CD_EVENTO) FROM FI_CD_EVENTO_EVEN) FROM FI_CD_TICKET_TICK;

INSERT INTO FI_CD_TICKET_TICK
(ID_TICK_CD_TICKET, TICK_DS_DESCRICAO, TICK_NR_DISPONIVEL, TICK_NR_VALOR, ID_EVEN_CD_EVENTO)
SELECT MAX(ID_TICK_CD_TICKET) + 1, 'Meia', 3, 100.0,
(SELECT MAX(ID_EVEN_CD_EVENTO) FROM FI_CD_EVENTO_EVEN) FROM FI_CD_TICKET_TICK;

INSERT INTO FI_CD_EVENTO_EVEN 
(ID_EVEN_CD_EVENTO, EVEN_CD_TIPO, EVEN_DH_EVENTO, EVEN_DS_DESCRICAO, EVEN_DS_LOCAL, EVEN_DS_TITULO) 
SELECT MAX(ID_EVEN_CD_EVENTO) + 1, '3', '27/03/2016', 
'Baseado na musica de mesmo nome, de gente que entra e gente que sai.',
'Sesc Pompeia', 'A Casa de Irene'
FROM FI_CD_EVENTO_EVEN;

INSERT INTO FI_CD_TICKET_TICK
(ID_TICK_CD_TICKET, TICK_DS_DESCRICAO, TICK_NR_DISPONIVEL, TICK_NR_VALOR, ID_EVEN_CD_EVENTO)
SELECT MAX(ID_TICK_CD_TICKET) + 1, 'Inteira', 3, 200.0,
(SELECT MAX(ID_EVEN_CD_EVENTO) FROM FI_CD_EVENTO_EVEN) FROM FI_CD_TICKET_TICK;

INSERT INTO FI_CD_TICKET_TICK
(ID_TICK_CD_TICKET, TICK_DS_DESCRICAO, TICK_NR_DISPONIVEL, TICK_NR_VALOR, ID_EVEN_CD_EVENTO)
SELECT MAX(ID_TICK_CD_TICKET) + 1, 'Meia', 3, 100.0,
(SELECT MAX(ID_EVEN_CD_EVENTO) FROM FI_CD_EVENTO_EVEN) FROM FI_CD_TICKET_TICK;





INSERT INTO FI_CD_EVENTO_EVEN 
(ID_EVEN_CD_EVENTO, EVEN_CD_TIPO, EVEN_DH_EVENTO, EVEN_DS_DESCRICAO, EVEN_DS_LOCAL, EVEN_DS_TITULO) 
SELECT MAX(ID_EVEN_CD_EVENTO) + 1, '3', '20/04/2016', 
'Drama grego que conta a historia da mulher que matou seus filhos e depois se matou.',
'Teatro Gazeta', 'Memorias Esquecidas'
FROM FI_CD_EVENTO_EVEN;

INSERT INTO FI_CD_TICKET_TICK
(ID_TICK_CD_TICKET, TICK_DS_DESCRICAO, TICK_NR_DISPONIVEL, TICK_NR_VALOR, ID_EVEN_CD_EVENTO)
SELECT MAX(ID_TICK_CD_TICKET) + 1, 'Inteira', 3, 200.0,
(SELECT MAX(ID_EVEN_CD_EVENTO) FROM FI_CD_EVENTO_EVEN) FROM FI_CD_TICKET_TICK;

INSERT INTO FI_CD_TICKET_TICK
(ID_TICK_CD_TICKET, TICK_DS_DESCRICAO, TICK_NR_DISPONIVEL, TICK_NR_VALOR, ID_EVEN_CD_EVENTO)
SELECT MAX(ID_TICK_CD_TICKET) + 1, 'Meia', 3, 100.0,
(SELECT MAX(ID_EVEN_CD_EVENTO) FROM FI_CD_EVENTO_EVEN) FROM FI_CD_TICKET_TICK;


-- CINEMA ####################################################################################

INSERT INTO FI_CD_EVENTO_EVEN 
(ID_EVEN_CD_EVENTO, EVEN_CD_TIPO, EVEN_DH_EVENTO, EVEN_DS_DESCRICAO, EVEN_DS_LOCAL, EVEN_DS_TITULO) 
SELECT MAX(ID_EVEN_CD_EVENTO) + 1, '4', '11/02/2016', 
'Cinema novo. Descricao 123 123 123',
'Shopping Tatuape', 'A Mosca'
FROM FI_CD_EVENTO_EVEN;

INSERT INTO FI_CD_TICKET_TICK
(ID_TICK_CD_TICKET, TICK_DS_DESCRICAO, TICK_NR_DISPONIVEL, TICK_NR_VALOR, ID_EVEN_CD_EVENTO)
SELECT MAX(ID_TICK_CD_TICKET) + 1, 'Inteira', 3, 40.0,
(SELECT MAX(ID_EVEN_CD_EVENTO) FROM FI_CD_EVENTO_EVEN) FROM FI_CD_TICKET_TICK;

INSERT INTO FI_CD_TICKET_TICK
(ID_TICK_CD_TICKET, TICK_DS_DESCRICAO, TICK_NR_DISPONIVEL, TICK_NR_VALOR, ID_EVEN_CD_EVENTO)
SELECT MAX(ID_TICK_CD_TICKET) + 1, 'Meia', 3, 20.0,
(SELECT MAX(ID_EVEN_CD_EVENTO) FROM FI_CD_EVENTO_EVEN) FROM FI_CD_TICKET_TICK;

INSERT INTO FI_CD_EVENTO_EVEN 
(ID_EVEN_CD_EVENTO, EVEN_CD_TIPO, EVEN_DH_EVENTO, EVEN_DS_DESCRICAO, EVEN_DS_LOCAL, EVEN_DS_TITULO) 
SELECT MAX(ID_EVEN_CD_EVENTO) + 1, '4', '01/12/2016', 
'Um poderoso chefe de uma tradicional familia italiana do seculo XIX.',
'Shopping Bourbon', 'Os Mafiosos'
FROM FI_CD_EVENTO_EVEN;

INSERT INTO FI_CD_TICKET_TICK
(ID_TICK_CD_TICKET, TICK_DS_DESCRICAO, TICK_NR_DISPONIVEL, TICK_NR_VALOR, ID_EVEN_CD_EVENTO)
SELECT MAX(ID_TICK_CD_TICKET) + 1, 'Inteira', 3, 40.0,
(SELECT MAX(ID_EVEN_CD_EVENTO) FROM FI_CD_EVENTO_EVEN) FROM FI_CD_TICKET_TICK;

INSERT INTO FI_CD_TICKET_TICK
(ID_TICK_CD_TICKET, TICK_DS_DESCRICAO, TICK_NR_DISPONIVEL, TICK_NR_VALOR, ID_EVEN_CD_EVENTO)
SELECT MAX(ID_TICK_CD_TICKET) + 1, 'Meia', 3, 20.0,
(SELECT MAX(ID_EVEN_CD_EVENTO) FROM FI_CD_EVENTO_EVEN) FROM FI_CD_TICKET_TICK;






INSERT INTO FI_CD_EVENTO_EVEN 
(ID_EVEN_CD_EVENTO, EVEN_CD_TIPO, EVEN_DH_EVENTO, EVEN_DS_DESCRICAO, EVEN_DS_LOCAL, EVEN_DS_TITULO) 
SELECT MAX(ID_EVEN_CD_EVENTO) + 1, '4', '27/07/2016', 
'Sequencia inedita do classico do cinema. Com cenas de tirar o folego.',
'Shopping Tatuape', 'Laranja Mecanica 2'
FROM FI_CD_EVENTO_EVEN;

INSERT INTO FI_CD_TICKET_TICK
(ID_TICK_CD_TICKET, TICK_DS_DESCRICAO, TICK_NR_DISPONIVEL, TICK_NR_VALOR, ID_EVEN_CD_EVENTO)
SELECT MAX(ID_TICK_CD_TICKET) + 1, 'Inteira', 3, 40.0,
(SELECT MAX(ID_EVEN_CD_EVENTO) FROM FI_CD_EVENTO_EVEN) FROM FI_CD_TICKET_TICK;

INSERT INTO FI_CD_TICKET_TICK
(ID_TICK_CD_TICKET, TICK_DS_DESCRICAO, TICK_NR_DISPONIVEL, TICK_NR_VALOR, ID_EVEN_CD_EVENTO)
SELECT MAX(ID_TICK_CD_TICKET) + 1, 'Meia', 3, 20.0,
(SELECT MAX(ID_EVEN_CD_EVENTO) FROM FI_CD_EVENTO_EVEN) FROM FI_CD_TICKET_TICK;




INSERT INTO FI_CD_EVENTO_EVEN 
(ID_EVEN_CD_EVENTO, EVEN_CD_TIPO, EVEN_DH_EVENTO, EVEN_DS_DESCRICAO, EVEN_DS_LOCAL, EVEN_DS_TITULO) 
SELECT MAX(ID_EVEN_CD_EVENTO) + 1, '4', '22/08/2016', 
'O filme mais esperado do ano. Com cenas extras e entrevistas exclusivas com o diretor.',
'Shopping Tatuape', 'Star Wars 3D'
FROM FI_CD_EVENTO_EVEN;

INSERT INTO FI_CD_TICKET_TICK
(ID_TICK_CD_TICKET, TICK_DS_DESCRICAO, TICK_NR_DISPONIVEL, TICK_NR_VALOR, ID_EVEN_CD_EVENTO)
SELECT MAX(ID_TICK_CD_TICKET) + 1, 'Inteira', 3, 40.0,
(SELECT MAX(ID_EVEN_CD_EVENTO) FROM FI_CD_EVENTO_EVEN) FROM FI_CD_TICKET_TICK;

INSERT INTO FI_CD_TICKET_TICK
(ID_TICK_CD_TICKET, TICK_DS_DESCRICAO, TICK_NR_DISPONIVEL, TICK_NR_VALOR, ID_EVEN_CD_EVENTO)
SELECT MAX(ID_TICK_CD_TICKET) + 1, 'Meia', 3, 20.0,
(SELECT MAX(ID_EVEN_CD_EVENTO) FROM FI_CD_EVENTO_EVEN) FROM FI_CD_TICKET_TICK;


-- LUTAS ###################################################################################

INSERT INTO FI_CD_EVENTO_EVEN 
(ID_EVEN_CD_EVENTO, EVEN_CD_TIPO, EVEN_DH_EVENTO, EVEN_DS_DESCRICAO, EVEN_DS_LOCAL, EVEN_DS_TITULO) 
SELECT MAX(ID_EVEN_CD_EVENTO) + 1, '5', '11/09/2016', 
'Luta nova. Descricao 123 123 123',
'Ibirapuera', 'UFC 555'
FROM FI_CD_EVENTO_EVEN;

INSERT INTO FI_CD_TICKET_TICK
(ID_TICK_CD_TICKET, TICK_DS_DESCRICAO, TICK_NR_DISPONIVEL, TICK_NR_VALOR, ID_EVEN_CD_EVENTO)
SELECT MAX(ID_TICK_CD_TICKET) + 1, 'VIP', 3, 4000.0,
(SELECT MAX(ID_EVEN_CD_EVENTO) FROM FI_CD_EVENTO_EVEN) FROM FI_CD_TICKET_TICK;

INSERT INTO FI_CD_TICKET_TICK
(ID_TICK_CD_TICKET, TICK_DS_DESCRICAO, TICK_NR_DISPONIVEL, TICK_NR_VALOR, ID_EVEN_CD_EVENTO)
SELECT MAX(ID_TICK_CD_TICKET) + 1, 'Premium', 3, 1000.0,
(SELECT MAX(ID_EVEN_CD_EVENTO) FROM FI_CD_EVENTO_EVEN) FROM FI_CD_TICKET_TICK;

INSERT INTO FI_CD_TICKET_TICK
(ID_TICK_CD_TICKET, TICK_DS_DESCRICAO, TICK_NR_DISPONIVEL, TICK_NR_VALOR, ID_EVEN_CD_EVENTO)
SELECT MAX(ID_TICK_CD_TICKET) + 1, 'Camarote 1', 3, 500.0,
(SELECT MAX(ID_EVEN_CD_EVENTO) FROM FI_CD_EVENTO_EVEN) FROM FI_CD_TICKET_TICK;

INSERT INTO FI_CD_TICKET_TICK
(ID_TICK_CD_TICKET, TICK_DS_DESCRICAO, TICK_NR_DISPONIVEL, TICK_NR_VALOR, ID_EVEN_CD_EVENTO)
SELECT MAX(ID_TICK_CD_TICKET) + 1, 'Camarote 2', 3, 400.0,
(SELECT MAX(ID_EVEN_CD_EVENTO) FROM FI_CD_EVENTO_EVEN) FROM FI_CD_TICKET_TICK;

INSERT INTO FI_CD_TICKET_TICK
(ID_TICK_CD_TICKET, TICK_DS_DESCRICAO, TICK_NR_DISPONIVEL, TICK_NR_VALOR, ID_EVEN_CD_EVENTO)
SELECT MAX(ID_TICK_CD_TICKET) + 1, 'Cadeira', 3, 200.0,
(SELECT MAX(ID_EVEN_CD_EVENTO) FROM FI_CD_EVENTO_EVEN) FROM FI_CD_TICKET_TICK;

INSERT INTO FI_CD_EVENTO_EVEN 
(ID_EVEN_CD_EVENTO, EVEN_CD_TIPO, EVEN_DH_EVENTO, EVEN_DS_DESCRICAO, EVEN_DS_LOCAL, EVEN_DS_TITULO) 
SELECT MAX(ID_EVEN_CD_EVENTO) + 1, '5', '11/09/2016', 
'Luta historica! Duas lendas do UFC se enfrentando!',
'Ibirapuera', 'UFC 225'
FROM FI_CD_EVENTO_EVEN;

INSERT INTO FI_CD_TICKET_TICK
(ID_TICK_CD_TICKET, TICK_DS_DESCRICAO, TICK_NR_DISPONIVEL, TICK_NR_VALOR, ID_EVEN_CD_EVENTO)
SELECT MAX(ID_TICK_CD_TICKET) + 1, 'VIP', 3, 4000.0,
(SELECT MAX(ID_EVEN_CD_EVENTO) FROM FI_CD_EVENTO_EVEN) FROM FI_CD_TICKET_TICK;

INSERT INTO FI_CD_TICKET_TICK
(ID_TICK_CD_TICKET, TICK_DS_DESCRICAO, TICK_NR_DISPONIVEL, TICK_NR_VALOR, ID_EVEN_CD_EVENTO)
SELECT MAX(ID_TICK_CD_TICKET) + 1, 'Premium', 3, 1000.0,
(SELECT MAX(ID_EVEN_CD_EVENTO) FROM FI_CD_EVENTO_EVEN) FROM FI_CD_TICKET_TICK;

INSERT INTO FI_CD_TICKET_TICK
(ID_TICK_CD_TICKET, TICK_DS_DESCRICAO, TICK_NR_DISPONIVEL, TICK_NR_VALOR, ID_EVEN_CD_EVENTO)
SELECT MAX(ID_TICK_CD_TICKET) + 1, 'Camarote 1', 3, 500.0,
(SELECT MAX(ID_EVEN_CD_EVENTO) FROM FI_CD_EVENTO_EVEN) FROM FI_CD_TICKET_TICK;

INSERT INTO FI_CD_TICKET_TICK
(ID_TICK_CD_TICKET, TICK_DS_DESCRICAO, TICK_NR_DISPONIVEL, TICK_NR_VALOR, ID_EVEN_CD_EVENTO)
SELECT MAX(ID_TICK_CD_TICKET) + 1, 'Camarote 2', 3, 400.0,
(SELECT MAX(ID_EVEN_CD_EVENTO) FROM FI_CD_EVENTO_EVEN) FROM FI_CD_TICKET_TICK;

INSERT INTO FI_CD_TICKET_TICK
(ID_TICK_CD_TICKET, TICK_DS_DESCRICAO, TICK_NR_DISPONIVEL, TICK_NR_VALOR, ID_EVEN_CD_EVENTO)
SELECT MAX(ID_TICK_CD_TICKET) + 1, 'Cadeira', 3, 200.0,
(SELECT MAX(ID_EVEN_CD_EVENTO) FROM FI_CD_EVENTO_EVEN) FROM FI_CD_TICKET_TICK;

-- NUMERADORAS

UPDATE FI_NG_NUMERADORA_NUME 
SET NUME_NR_NEXTVAL = (SELECT MAX(ID_EVEN_CD_EVENTO) + 1 FROM FI_CD_EVENTO_EVEN)
WHERE NUME_DS_ENTITY = 'FiCdEventoEven';

UPDATE FI_NG_NUMERADORA_NUME 
SET NUME_NR_NEXTVAL = (SELECT MAX(ID_EVEN_CD_EVENTO) + 1 FROM FI_CD_EVENTO_EVEN)
WHERE NUME_DS_ENTITY = 'FiCdTicketTick';