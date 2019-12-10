package org.fisco.bcos.v2.precompile;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.fisco.bcos.v2.TestBase;
import org.fisco.bcos.v2.precompile.consensus.ConsensusService;
import org.junit.Ignore;

public class ConsensusServiceTest extends TestBase {


	private ConsensusService consensusService = new ConsensusService(web3j, credentials);

  @Ignore
  public void addSealerAndObserverTest() throws Exception {

  	List<String> sealerList1 = web3j.getSealerList().send().getSealerList();
  	String nodeId = sealerList1.get(sealerList1.size() -1);
  	
		String addObserverResult = consensusService.addObserver(nodeId);
		assertEquals(addObserverResult, Common.SUSSCESS);
		
		String removeNodeResult = consensusService.removeNode(nodeId);
		assertEquals(removeNodeResult, Common.SUSSCESS);
  	
  	String addSealerResult = consensusService.addSealer(nodeId);
  	assertEquals(addSealerResult, Common.SUSSCESS);
  	
  }
  
}
