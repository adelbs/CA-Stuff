package obi1.fi.business.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import obi1.fi.business.entity.FiCdUsuarioUSUA;
import obi1.fi.common.exception.FiException;
import obi1.fi.common.util.Constantes;

@Repository
public final class DbConnectServiceImpl extends AbstractService implements DbConnectService {
	
	@Autowired
	private GenericService gService;

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
	public void checkDefaultRecords() {
		
		try {
			if (gService.getListALLEntity(new FiCdUsuarioUSUA()).size() == 0) {
				
				//USUARIO ADMINISTRADOR
				getEM().persist(new FiCdUsuarioUSUA(Constantes.ID_USER_ADM, "Administrador", "admin", "NHGNgMJAMnLJD"));
				
				//String sql = IOUtils.toString(getClass().getClassLoader().getResourceAsStream("resources/inserts_eventos.sql"));
				getJDBC().execute("INSERT INTO fi_cd_evento_even VALUES (1,'1','01/12/2016','Jogo novo. Descricao 123 123 123.','Alianz Park','15 de Piri Piri x Jau'),(2,'1','01/02/2016','Classico do brasileirao! Voce nao pode perder!','Beira Rio','Santos x Gremio'),(3,'1','20/03/2016','Campeonato Paulista. Pela primeira vez na historia o Palmeiras enfrenta o 15 de Jau. Partida imperdivel.','Alianz Park','15 de Jau x Palmeiras'),(4,'1','18/09/2016','Campeonato Brasileiro. Segunda rodada do campeonato com replay de jogos classicos.','Morumbi','Cruzeiro x Juventus'),(5,'2','14/11/2016','Show novo. Descricao 123 123','Ibirapuera','Metallica'),(6,'2','10/01/2016','Uma das melhores bandas de Hard Rock de todos os tempos em apresentacao unica em Sao Paulo!','Carioca Club','Uriah Heep'),(7,'2','11/01/2016','Eles ja vieram diversas vezes para o Brasil, mas esse show sera cheio de surpresas!','Alianz Park','Iron Maiden'),(8,'2','18/01/2016','Compre aqui com exclusividade e ganhe uma camiseta oficial do fa clube e ainda concorra a premios!','Bar do Samba','Arlindo Cruz'),(9,'2','31/12/2016','Voce nao pode perder, um show inedito do Rei! Show da virada em Copacabana!!! Imperdivel!','Copacabana','Roberto Carlos'),(10,'2','15/07/2016','Em apresentacao intimista, inaugurando sua carreira solo.','Sesc Pompeia','Chimbinha'),(11,'2','10/08/2016','Muita festa e animacao. Simplesmente imperdivel.','Maracana','Ivete Sangalo'),(12,'3','27/03/2016','Teatro novo. Descricao 123 123 123.','Sesc Pinheiros','O Coice'),(13,'3','27/03/2016','Baseado na musica de mesmo nome, de gente que entra e gente que sai.','Sesc Pompeia','A Casa de Irene'),(14,'3','20/04/2016','Drama grego que conta a historia da mulher que matou seus filhos e depois se matou.','Teatro Gazeta','Memorias Esquecidas'),(15,'4','11/02/2016','Cinema novo. Descricao 123 123 123','Shopping Tatuape','A Mosca'),(16,'4','01/12/2016','Um poderoso chefe de uma tradicional familia italiana do seculo XIX.','Shopping Bourbon','Os Mafiosos'),(17,'4','27/07/2016','Sequencia inedita do classico do cinema. Com cenas de tirar o folego.','Shopping Tatuape','Laranja Mecanica 2'),(18,'4','22/08/2016','O filme mais esperado do ano. Com cenas extras e entrevistas exclusivas com o diretor.','Shopping Tatuape','Star Wars 3D'),(19,'5','11/09/2016','Luta nova. Descricao 123 123 123','Ibirapuera','UFC 555'),(20,'5','11/09/2016','Luta historica! Duas lendas do UFC se enfrentando!','Ibirapuera','UFC 225')");
				
				//sql = IOUtils.toString(getClass().getClassLoader().getResourceAsStream("resources/inserts_tickets.sql"));
				getJDBC().execute("INSERT INTO fi_cd_ticket_tick VALUES (1,'Setor 1',3,100,1),(2,'Setor 2',3,70,1),(3,'Setor 3',3,40,1),(4,'Setor 1',3,100,2),(5,'Setor 2',3,70,2),(6,'Setor 3',3,40,2),(7,'Setor 1',3,100,3),(8,'Setor 2',3,70,3),(9,'Setor 3',3,40,3),(10,'Setor 1',3,100,4),(11,'Setor 2',3,70,4),(12,'Setor 3',3,40,4),(13,'Premium',3,900,5),(14,'Cadeira Azul',3,300,5),(15,'Camarote',3,250,5),(16,'Pista',3,150,5),(17,'Premium',3,900,6),(18,'Cadeira Azul',3,300,6),(19,'Camarote',3,250,6),(20,'Pista',3,150,6),(21,'Premium',3,900,7),(22,'Cadeira Azul',3,300,7),(23,'Camarote',3,250,7),(24,'Pista',3,150,7),(25,'Premium',3,900,8),(26,'Cadeira Azul',3,300,8),(27,'Camarote',3,250,8),(28,'Pista',3,150,8),(29,'Premium',3,900,9),(30,'Cadeira Azul',3,300,9),(31,'Camarote',3,250,9),(32,'Pista',3,150,9),(33,'Premium',3,900,10),(34,'Cadeira Azul',3,300,10),(35,'Camarote',3,250,10),(36,'Pista',3,150,10),(37,'Premium',3,900,11),(38,'Cadeira Azul',3,300,11),(39,'Camarote',3,250,11),(40,'Pista',3,150,11),(41,'Inteira',3,200,12),(42,'Meia',3,100,12),(43,'Inteira',3,200,13),(44,'Meia',3,100,13),(45,'Inteira',3,200,14),(46,'Meia',3,100,14),(47,'Inteira',3,40,15),(48,'Meia',3,20,15),(49,'Inteira',3,40,16),(50,'Meia',3,20,16),(51,'Inteira',3,40,17),(52,'Meia',3,20,17),(53,'Inteira',3,40,18),(54,'Meia',3,20,18),(55,'VIP',3,4000,19),(56,'Premium',3,1000,19),(57,'Camarote 1',3,500,19),(58,'Camarote 2',3,400,19),(59,'Cadeira',3,200,19),(60,'VIP',3,4000,20),(61,'Premium',3,1000,20),(62,'Camarote 1',3,500,20),(63,'Camarote 2',3,400,20),(64,'Cadeira',3,200,20)");
				
			}
		}
		catch (Exception e) {
			throw new FiException(e, "Erro ao tentar criar os registros base (" + e.getMessage() + ")");
		}
	}
}
