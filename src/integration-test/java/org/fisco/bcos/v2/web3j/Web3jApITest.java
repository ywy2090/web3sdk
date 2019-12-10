package org.fisco.bcos.v2.web3j;

import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.math.BigInteger;
import java.util.concurrent.ExecutionException;
import org.fisco.bcos.v2.TestBase;
import org.fisco.bcos.v2.rpc.methods.response.BcosBlock;
import org.fisco.bcos.v2.rpc.methods.response.BcosTransaction;
import org.fisco.bcos.v2.rpc.methods.response.BcosTransactionReceipt;
import org.fisco.bcos.v2.rpc.methods.response.BlockHash;
import org.fisco.bcos.v2.rpc.methods.response.BlockNumber;
import org.fisco.bcos.v2.rpc.methods.response.Code;
import org.fisco.bcos.v2.rpc.methods.response.GroupList;
import org.fisco.bcos.v2.rpc.methods.response.GroupPeers;
import org.fisco.bcos.v2.rpc.methods.response.NodeIDList;
import org.fisco.bcos.v2.rpc.methods.response.NodeVersion;
import org.fisco.bcos.v2.rpc.methods.response.ObserverList;
import org.fisco.bcos.v2.rpc.methods.response.PbftView;
import org.fisco.bcos.v2.rpc.methods.response.Peers;
import org.fisco.bcos.v2.rpc.methods.response.PendingTransactions;
import org.fisco.bcos.v2.rpc.methods.response.PendingTxSize;
import org.fisco.bcos.v2.rpc.methods.response.SealerList;
import org.fisco.bcos.v2.rpc.methods.response.SystemConfig;
import org.fisco.bcos.v2.rpc.methods.response.TotalTransactionCount;
import org.fisco.bcos.v2.rpc.methods.response.Transaction;
import org.fisco.bcos.v2.rpc.methods.response.TransactionReceipt;
import org.junit.Test;

public class Web3jApITest extends TestBase {

  @Test
  public void getNodeVersion() throws IOException {
    NodeVersion nodeVersion = web3j.getNodeVersion().send();
    assertNotNull(nodeVersion.getNodeVersion().getBuildTime());
    assertNotNull(nodeVersion.getNodeVersion().getBuildType());
    assertNotNull(nodeVersion.getNodeVersion().getGitBranch());
    assertNotNull(nodeVersion.getNodeVersion().getGitCommit());
    assertNotNull(nodeVersion.getNodeVersion().getVersion());
  }

  @Test
  public void getBlockNumber() throws IOException, InterruptedException, ExecutionException {
    BlockNumber blockNumber = web3j.getBlockNumber().send();
    assertNotNull(blockNumber.getBlockNumber());
    blockNumber = web3j.getBlockNumber().sendAsync().get();
    assertNotNull(blockNumber.getBlockNumber());
  }

  @Test
  public void pbftView() throws Exception {
    PbftView pbftView = web3j.getPbftView().send();
    assertNotNull(pbftView.getPbftView());
  }

  @Test
  public void getConsensusStatus() throws Exception {
    String consensusStatus = web3j.getConsensusStatus().sendForReturnString();
    assertNotNull(consensusStatus);
  }

  @Test
  public void getSyncStatus() throws Exception {
    String syncStatus = web3j.getSyncStatus().sendForReturnString();
    assertNotNull(syncStatus);
  }

  @Test
  public void peers() throws Exception {
    Peers peers = web3j.getPeers().send();
    assertNotNull(peers.getPeers());
  }

  @Test
  public void groupPeers() throws Exception {
    GroupPeers groupPeers = web3j.getGroupPeers().send();
    assertNotNull(groupPeers.getGroupPeers());
  }

  @Test
  public void groupList() throws Exception {
    GroupList groupList = web3j.getGroupList().send();
    assertNotNull(groupList.getGroupList());
  }

  @Test
  public void getSealerList() throws Exception {
    SealerList sealerList = web3j.getSealerList().send();
    assertNotNull(sealerList.getSealerList());
  }

  @Test
  public void getObserverList() throws Exception {
    ObserverList observerList = web3j.getObserverList().send();
    assertNotNull(observerList.getObserverList());
  }

  @Test
  public void getNodeIDList() throws Exception {
    NodeIDList nodeIDList = web3j.getNodeIDList().send();
    assertNotNull(nodeIDList.getNodeIDList());
  }

  @Test
  public void getSystemConfigByKey() throws Exception {
    SystemConfig txCountLimit = web3j.getSystemConfigByKey("tx_count_limit").send();
    SystemConfig txGasLimit = web3j.getSystemConfigByKey("tx_gas_limit").send();
    assertNotNull(txCountLimit.getSystemConfigByKey());
    assertNotNull(txGasLimit.getSystemConfigByKey());
  }

  @Test
  public void getCode() throws Exception {
    Code code = web3j.getCode(address).send();
    assertNotNull(code.getCode());
  }

  @Test
  public void getTotalTransactionCount() throws Exception {
    TotalTransactionCount count = web3j.getTotalTransactionCount().send();
    assertNotNull(count.getTotalTransactionCount());
  }

  @Test
  public void getBlockByHash() throws Exception {
    BcosBlock bcosBlock = web3j.getBlockByHash(blockHash, true).send();
    assertNotNull(bcosBlock.getBlock());
  }

  @Test
  public void getBlockByNumber() throws Exception {
    BcosBlock bcosBlock =
        web3j.getBlockByNumber(blockNumber, true).send();
    assertNotNull(bcosBlock.getBlock());
  }

  @Test
  public void getBlockHashByNumber() throws Exception {
    BlockHash blockHash =
        web3j.getBlockHashByNumber(blockNumber).send();
    assertNotNull(blockHash.getBlockHashByNumber());
  }

  @Test
  public void getTransactionByHash() throws Exception {
    BcosTransaction bcosTransaction = web3j.getTransactionByHash(blockHash).send();
    assertNotNull(bcosTransaction.getTransaction());
  }

  //  @Test
  //  public void getTransactionByHashWithProof() throws IOException {
  //    TransactionWithProof transactionWithProof =
  // web3j.getTransactionByHashWithProof(txHash).send();
  //    Transaction transaction = transactionWithProof.getTransactionWithProof().getTransaction();
  //    assertNotNull(transaction);
  //    List<MerkleProofUnit> merkleProofUnits =
  //        transactionWithProof.getTransactionWithProof().getTxProof();
  //    assertNotNull(merkleProofUnits);
  //  }

  @Test
  public void getTransactionByBlockNumberAndIndex() throws IOException {
    BcosTransaction bcosTransaction =
        web3j
            .getTransactionByBlockNumberAndIndex(
                    blockNumber, new BigInteger("0"))
            .send();
    Transaction transaction = bcosTransaction.getTransaction().get();
    assertNotNull(transaction);
  }

  @Test
  public void getTransactionByBlockHashAndIndex() throws IOException {
    BcosTransaction bcosTransaction =
        web3j.getTransactionByBlockHashAndIndex(blockHash, new BigInteger("0")).send();
    Transaction transaction = bcosTransaction.getTransaction().get();
    assertNotNull(transaction);
  }

  @Test
  public void getTransactionReceipt() throws IOException {
    BcosTransactionReceipt bcosTransactionReceipt = web3j.getTransactionReceipt(txHash).send();
    TransactionReceipt transactionReceipt = bcosTransactionReceipt.getTransactionReceipt().get();
    assertNotNull(transactionReceipt);
  }

  //  @Test
  //  public void getTransactionReceiptByHashWithProof() throws IOException {
  //    TransactionReceiptWithProof transactionReceiptWithProof =
  //        web3j.getTransactionReceiptByHashWithProof(txHash).send();
  //    TransactionReceipt transactionReceipt =
  //        transactionReceiptWithProof.getTransactionReceiptWithProof().getTransactionReceipt();
  //    assertNotNull(transactionReceipt);
  //    List<MerkleProofUnit> merkleProofUnits =
  //        transactionReceiptWithProof.getTransactionReceiptWithProof().getReceiptProof();
  //    assertNotNull(merkleProofUnits);
  //  }

  @Test
  public void getPendingTransaction() throws IOException {
    PendingTransactions pendingTransactions = web3j.getPendingTransaction().send();
    assertNotNull(pendingTransactions.getPendingTransactions());
  }

  @Test
  public void getPendingTxSize() throws IOException {
    PendingTxSize pendingTxSize = web3j.getPendingTxSize().send();
    assertNotNull(pendingTxSize.getPendingTxSize());
  }
}
