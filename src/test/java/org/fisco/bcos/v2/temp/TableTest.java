package org.fisco.bcos.v2.temp;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import org.fisco.bcos.v2.abi.EventEncoder;
import org.fisco.bcos.v2.abi.FunctionReturnDecoder;
import org.fisco.bcos.v2.abi.TypeReference;
import org.fisco.bcos.v2.abi.datatypes.DynamicArray;
import org.fisco.bcos.v2.abi.datatypes.Event;
import org.fisco.bcos.v2.abi.datatypes.Function;
import org.fisco.bcos.v2.abi.datatypes.Type;
import org.fisco.bcos.v2.abi.datatypes.Utf8String;
import org.fisco.bcos.v2.abi.datatypes.generated.Bytes32;
import org.fisco.bcos.v2.abi.datatypes.generated.Int256;
import org.fisco.bcos.v2.channel.client.TransactionSucCallback;
import org.fisco.bcos.v2.common.tuples.Tuple1;
import org.fisco.bcos.v2.common.tuples.Tuple2;
import org.fisco.bcos.v2.common.tuples.Tuple3;
import org.fisco.bcos.v2.crypto.Credentials;
import org.fisco.bcos.v2.web3j.Web3j;
import org.fisco.bcos.v2.filter.EventLogPushWithDecodeCallback;
import org.fisco.bcos.v2.common.RemoteCall;
import org.fisco.bcos.v2.rpc.methods.response.Log;
import org.fisco.bcos.v2.rpc.methods.response.TransactionReceipt;
import org.fisco.bcos.v2.web3j.tx.Contract;
import org.fisco.bcos.v2.web3j.tx.manager.TransactionManager;
import org.fisco.bcos.v2.txdecode.TransactionDecoder;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.fisco.bcos.v2.codegen.SolidityFunctionWrapperGenerator in the
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version none.
 */
@SuppressWarnings("unchecked")
public class TableTest extends Contract {
    public static String BINARY = "608060405234801561001057600080fd5b5061221f806100206000396000f30060806040526004361061006d576000357c0100000000000000000000000000000000000000000000000000000000900463ffffffff168063487a5a1014610072578063c4f41ab31461013f578063ebf3b24f146101c6578063efc81a8c14610293578063fcd7e3c1146102aa575b600080fd5b34801561007e57600080fd5b50610129600480360381019080803590602001908201803590602001908080601f016020809104026020016040519081016040528093929190818152602001838380828437820191505050505050919291929080359060200190929190803590602001908201803590602001908080601f01602080910402602001604051908101604052809392919081815260200183838082843782019150505050505091929192905050506103f8565b6040518082815260200191505060405180910390f35b34801561014b57600080fd5b506101b0600480360381019080803590602001908201803590602001908080601f016020809104026020016040519081016040528093929190818152602001838380828437820191505050505050919291929080359060200190929190505050610aee565b6040518082815260200191505060405180910390f35b3480156101d257600080fd5b5061027d600480360381019080803590602001908201803590602001908080601f016020809104026020016040519081016040528093929190818152602001838380828437820191505050505050919291929080359060200190929190803590602001908201803590602001908080601f0160208091040260200160405190810160405280939291908181526020018383808284378201915050505050509192919290505050610fe7565b6040518082815260200191505060405180910390f35b34801561029f57600080fd5b506102a8611606565b005b3480156102b657600080fd5b50610311600480360381019080803590602001908201803590602001908080601f0160208091040260200160405190810160405280939291908181526020018383808284378201915050505050509192919290505050611798565b60405180806020018060200180602001848103845287818151815260200191508051906020019060200280838360005b8381101561035c578082015181840152602081019050610341565b50505050905001848103835286818151815260200191508051906020019060200280838360005b8381101561039e578082015181840152602081019050610383565b50505050905001848103825285818151815260200191508051906020019060200280838360005b838110156103e05780820151818401526020810190506103c5565b50505050905001965050505050505060405180910390f35b60008060008060008061100194508473ffffffffffffffffffffffffffffffffffffffff1663f23f63c96040518163ffffffff167c01000000000000000000000000000000000000000000000000000000000281526004018080602001828103825260068152602001807f745f746573740000000000000000000000000000000000000000000000000000815250602001915050602060405180830381600087803b1580156104a657600080fd5b505af11580156104ba573d6000803e3d6000fd5b505050506040513d60208110156104d057600080fd5b810190808051906020019092919050505093508373ffffffffffffffffffffffffffffffffffffffff166313db93466040518163ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401602060405180830381600087803b15801561054757600080fd5b505af115801561055b573d6000803e3d6000fd5b505050506040513d602081101561057157600080fd5b810190808051906020019092919050505092508273ffffffffffffffffffffffffffffffffffffffff1663e942b516886040518263ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808060200180602001838103835260098152602001807f6974656d5f6e616d650000000000000000000000000000000000000000000000815250602001838103825284818151815260200191508051906020019080838360005b83811015610644578082015181840152602081019050610629565b50505050905090810190601f1680156106715780820380516001836020036101000a031916815260200191505b509350505050600060405180830381600087803b15801561069157600080fd5b505af11580156106a5573d6000803e3d6000fd5b505050508373ffffffffffffffffffffffffffffffffffffffff16637857d7c96040518163ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401602060405180830381600087803b15801561070d57600080fd5b505af1158015610721573d6000803e3d6000fd5b505050506040513d602081101561073757600080fd5b810190808051906020019092919050505091508173ffffffffffffffffffffffffffffffffffffffff1663cd30a1d18a6040518263ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808060200180602001838103835260048152602001807f6e616d6500000000000000000000000000000000000000000000000000000000815250602001838103825284818151815260200191508051906020019080838360005b8381101561080a5780820151818401526020810190506107ef565b50505050905090810190601f1680156108375780820380516001836020036101000a031916815260200191505b509350505050600060405180830381600087803b15801561085757600080fd5b505af115801561086b573d6000803e3d6000fd5b505050508173ffffffffffffffffffffffffffffffffffffffff1663e44594b9896040518263ffffffff167c01000000000000000000000000000000000000000000000000000000000281526004018080602001838152602001828103825260078152602001807f6974656d5f69640000000000000000000000000000000000000000000000000081525060200192505050600060405180830381600087803b15801561091757600080fd5b505af115801561092b573d6000803e3d6000fd5b505050508373ffffffffffffffffffffffffffffffffffffffff1663bf2b70a18a85856040518463ffffffff167c010000000000000000000000000000000000000000000000000000000002815260040180806020018473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001828103825285818151815260200191508051906020019080838360005b83811015610a1d578082015181840152602081019050610a02565b50505050905090810190601f168015610a4a5780820380516001836020036101000a031916815260200191505b50945050505050602060405180830381600087803b158015610a6b57600080fd5b505af1158015610a7f573d6000803e3d6000fd5b505050506040513d6020811015610a9557600080fd5b810190808051906020019092919050505090507f0bdcb3b747cf033ae78b4b6e1576d2725709d03f68ad3d641b12cb72de614354816040518082815260200191505060405180910390a180955050505050509392505050565b600080600080600061100193508373ffffffffffffffffffffffffffffffffffffffff1663f23f63c96040518163ffffffff167c01000000000000000000000000000000000000000000000000000000000281526004018080602001828103825260068152602001807f745f746573740000000000000000000000000000000000000000000000000000815250602001915050602060405180830381600087803b158015610b9b57600080fd5b505af1158015610baf573d6000803e3d6000fd5b505050506040513d6020811015610bc557600080fd5b810190808051906020019092919050505092508273ffffffffffffffffffffffffffffffffffffffff16637857d7c96040518163ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401602060405180830381600087803b158015610c3c57600080fd5b505af1158015610c50573d6000803e3d6000fd5b505050506040513d6020811015610c6657600080fd5b810190808051906020019092919050505091508173ffffffffffffffffffffffffffffffffffffffff1663cd30a1d1886040518263ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808060200180602001838103835260048152602001807f6e616d6500000000000000000000000000000000000000000000000000000000815250602001838103825284818151815260200191508051906020019080838360005b83811015610d39578082015181840152602081019050610d1e565b50505050905090810190601f168015610d665780820380516001836020036101000a031916815260200191505b509350505050600060405180830381600087803b158015610d8657600080fd5b505af1158015610d9a573d6000803e3d6000fd5b505050508173ffffffffffffffffffffffffffffffffffffffff1663e44594b9876040518263ffffffff167c01000000000000000000000000000000000000000000000000000000000281526004018080602001838152602001828103825260078152602001807f6974656d5f69640000000000000000000000000000000000000000000000000081525060200192505050600060405180830381600087803b158015610e4657600080fd5b505af1158015610e5a573d6000803e3d6000fd5b505050508273ffffffffffffffffffffffffffffffffffffffff166328bb211788846040518363ffffffff167c010000000000000000000000000000000000000000000000000000000002815260040180806020018373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001828103825284818151815260200191508051906020019080838360005b83811015610f19578082015181840152602081019050610efe565b50505050905090810190601f168015610f465780820380516001836020036101000a031916815260200191505b509350505050602060405180830381600087803b158015610f6657600080fd5b505af1158015610f7a573d6000803e3d6000fd5b505050506040513d6020811015610f9057600080fd5b810190808051906020019092919050505090507f896358cb98e9e8e891ae04efd1bc177efbe5cffd7eca2e784b16ed7468553e08816040518082815260200191505060405180910390a18094505050505092915050565b600080600080600061100193508373ffffffffffffffffffffffffffffffffffffffff1663f23f63c96040518163ffffffff167c01000000000000000000000000000000000000000000000000000000000281526004018080602001828103825260068152602001807f745f746573740000000000000000000000000000000000000000000000000000815250602001915050602060405180830381600087803b15801561109457600080fd5b505af11580156110a8573d6000803e3d6000fd5b505050506040513d60208110156110be57600080fd5b810190808051906020019092919050505092508273ffffffffffffffffffffffffffffffffffffffff166313db93466040518163ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401602060405180830381600087803b15801561113557600080fd5b505af1158015611149573d6000803e3d6000fd5b505050506040513d602081101561115f57600080fd5b810190808051906020019092919050505091508173ffffffffffffffffffffffffffffffffffffffff1663e942b516896040518263ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808060200180602001838103835260048152602001807f6e616d6500000000000000000000000000000000000000000000000000000000815250602001838103825284818151815260200191508051906020019080838360005b83811015611232578082015181840152602081019050611217565b50505050905090810190601f16801561125f5780820380516001836020036101000a031916815260200191505b509350505050600060405180830381600087803b15801561127f57600080fd5b505af1158015611293573d6000803e3d6000fd5b505050508173ffffffffffffffffffffffffffffffffffffffff16632ef8ba74886040518263ffffffff167c01000000000000000000000000000000000000000000000000000000000281526004018080602001838152602001828103825260078152602001807f6974656d5f69640000000000000000000000000000000000000000000000000081525060200192505050600060405180830381600087803b15801561133f57600080fd5b505af1158015611353573d6000803e3d6000fd5b505050508173ffffffffffffffffffffffffffffffffffffffff1663e942b516876040518263ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808060200180602001838103835260098152602001807f6974656d5f6e616d650000000000000000000000000000000000000000000000815250602001838103825284818151815260200191508051906020019080838360005b838110156114175780820151818401526020810190506113fc565b50505050905090810190601f1680156114445780820380516001836020036101000a031916815260200191505b509350505050600060405180830381600087803b15801561146457600080fd5b505af1158015611478573d6000803e3d6000fd5b505050508273ffffffffffffffffffffffffffffffffffffffff166331afac3689846040518363ffffffff167c010000000000000000000000000000000000000000000000000000000002815260040180806020018373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001828103825284818151815260200191508051906020019080838360005b8381101561153757808201518184015260208101905061151c565b50505050905090810190601f1680156115645780820380516001836020036101000a031916815260200191505b509350505050602060405180830381600087803b15801561158457600080fd5b505af1158015611598573d6000803e3d6000fd5b505050506040513d60208110156115ae57600080fd5b810190808051906020019092919050505090507f66f7705280112a4d1145399e0414adc43a2d6974b487710f417edcf7d4a39d71816040518082815260200191505060405180910390a1809450505050509392505050565b60008061100191508173ffffffffffffffffffffffffffffffffffffffff166356004b6a6040518163ffffffff167c010000000000000000000000000000000000000000000000000000000002815260040180806020018060200180602001848103845260068152602001807f745f746573740000000000000000000000000000000000000000000000000000815250602001848103835260048152602001807f6e616d6500000000000000000000000000000000000000000000000000000000815250602001848103825260118152602001807f6974656d5f69642c6974656d5f6e616d650000000000000000000000000000008152506020019350505050602060405180830381600087803b15801561172057600080fd5b505af1158015611734573d6000803e3d6000fd5b505050506040513d602081101561174a57600080fd5b810190808051906020019092919050505090507fcd4779437d9d027acc605a96427bfbd3787a1402cb53a5e64cd813d5391fbc2b816040518082815260200191505060405180910390a15050565b6060806060600080600080606080606060008061100198508873ffffffffffffffffffffffffffffffffffffffff1663f23f63c96040518163ffffffff167c01000000000000000000000000000000000000000000000000000000000281526004018080602001828103825260068152602001807f745f746573740000000000000000000000000000000000000000000000000000815250602001915050602060405180830381600087803b15801561185057600080fd5b505af1158015611864573d6000803e3d6000fd5b505050506040513d602081101561187a57600080fd5b810190808051906020019092919050505097508773ffffffffffffffffffffffffffffffffffffffff16637857d7c96040518163ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401602060405180830381600087803b1580156118f157600080fd5b505af1158015611905573d6000803e3d6000fd5b505050506040513d602081101561191b57600080fd5b810190808051906020019092919050505096508773ffffffffffffffffffffffffffffffffffffffff1663e8434e398e896040518363ffffffff167c010000000000000000000000000000000000000000000000000000000002815260040180806020018373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001828103825284818151815260200191508051906020019080838360005b838110156119e95780820151818401526020810190506119ce565b50505050905090810190601f168015611a165780820380516001836020036101000a031916815260200191505b509350505050602060405180830381600087803b158015611a3657600080fd5b505af1158015611a4a573d6000803e3d6000fd5b505050506040513d6020811015611a6057600080fd5b810190808051906020019092919050505095508573ffffffffffffffffffffffffffffffffffffffff1663949d225d6040518163ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401602060405180830381600087803b158015611ad757600080fd5b505af1158015611aeb573d6000803e3d6000fd5b505050506040513d6020811015611b0157600080fd5b8101908080519060200190929190505050604051908082528060200260200182016040528015611b405781602001602082028038833980820191505090505b5094508573ffffffffffffffffffffffffffffffffffffffff1663949d225d6040518163ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401602060405180830381600087803b158015611ba757600080fd5b505af1158015611bbb573d6000803e3d6000fd5b505050506040513d6020811015611bd157600080fd5b8101908080519060200190929190505050604051908082528060200260200182016040528015611c105781602001602082028038833980820191505090505b5093508573ffffffffffffffffffffffffffffffffffffffff1663949d225d6040518163ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401602060405180830381600087803b158015611c7757600080fd5b505af1158015611c8b573d6000803e3d6000fd5b505050506040513d6020811015611ca157600080fd5b8101908080519060200190929190505050604051908082528060200260200182016040528015611ce05781602001602082028038833980820191505090505b509250600091505b8573ffffffffffffffffffffffffffffffffffffffff1663949d225d6040518163ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401602060405180830381600087803b158015611d4c57600080fd5b505af1158015611d60573d6000803e3d6000fd5b505050506040513d6020811015611d7657600080fd5b81019080805190602001909291905050508212156121da578573ffffffffffffffffffffffffffffffffffffffff1663846719e0836040518263ffffffff167c010000000000000000000000000000000000000000000000000000000002815260040180828152602001915050602060405180830381600087803b158015611dfd57600080fd5b505af1158015611e11573d6000803e3d6000fd5b505050506040513d6020811015611e2757600080fd5b810190808051906020019092919050505090508073ffffffffffffffffffffffffffffffffffffffff166327314f796040518163ffffffff167c01000000000000000000000000000000000000000000000000000000000281526004018080602001828103825260048152602001807f6e616d6500000000000000000000000000000000000000000000000000000000815250602001915050602060405180830381600087803b158015611eda57600080fd5b505af1158015611eee573d6000803e3d6000fd5b505050506040513d6020811015611f0457600080fd5b81019080805190602001909291905050508583815181101515611f2357fe5b9060200190602002019060001916908160001916815250508073ffffffffffffffffffffffffffffffffffffffff1663fda69fae6040518163ffffffff167c01000000000000000000000000000000000000000000000000000000000281526004018080602001828103825260078152602001807f6974656d5f696400000000000000000000000000000000000000000000000000815250602001915050602060405180830381600087803b158015611fdb57600080fd5b505af1158015611fef573d6000803e3d6000fd5b505050506040513d602081101561200557600080fd5b8101908080519060200190929190505050848381518110151561202457fe5b90602001906020020181815250508073ffffffffffffffffffffffffffffffffffffffff166327314f796040518163ffffffff167c01000000000000000000000000000000000000000000000000000000000281526004018080602001828103825260098152602001807f6974656d5f6e616d650000000000000000000000000000000000000000000000815250602001915050602060405180830381600087803b1580156120d257600080fd5b505af11580156120e6573d6000803e3d6000fd5b505050506040513d60208110156120fc57600080fd5b8101908080519060200190929190505050838381518110151561211b57fe5b9060200190602002019060001916908160001916815250507fc65cd2adf133adee2ddcfab8b165c2f1f7b185c4389b0789a11112483efb1c84858381518110151561216257fe5b90602001906020020151858481518110151561217a57fe5b90602001906020020151858581518110151561219257fe5b906020019060200201516040518084600019166000191681526020018381526020018260001916600019168152602001935050505060405180910390a1816001019150611ce8565b8484849b509b509b5050505050505050505091939092505600a165627a7a723058207efa4765cad748397d764e3ed05f8798eba6e27efc6561d57e5a1d7e7774af110029";

    public static final String ABI = "[{\"constant\":false,\"inputs\":[{\"name\":\"name\",\"type\":\"string\"},{\"name\":\"item_id\",\"type\":\"int256\"},{\"name\":\"item_name\",\"type\":\"string\"}],\"name\":\"update\",\"outputs\":[{\"name\":\"\",\"type\":\"int256\"}],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"name\",\"type\":\"string\"},{\"name\":\"item_id\",\"type\":\"int256\"}],\"name\":\"remove\",\"outputs\":[{\"name\":\"\",\"type\":\"int256\"}],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"name\",\"type\":\"string\"},{\"name\":\"item_id\",\"type\":\"int256\"},{\"name\":\"item_name\",\"type\":\"string\"}],\"name\":\"insert\",\"outputs\":[{\"name\":\"\",\"type\":\"int256\"}],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[],\"name\":\"create\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[{\"name\":\"name\",\"type\":\"string\"}],\"name\":\"select\",\"outputs\":[{\"name\":\"\",\"type\":\"bytes32[]\"},{\"name\":\"\",\"type\":\"int256[]\"},{\"name\":\"\",\"type\":\"bytes32[]\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"anonymous\":false,\"inputs\":[{\"indexed\":false,\"name\":\"count\",\"type\":\"int256\"}],\"name\":\"createResult\",\"type\":\"event\"},{\"anonymous\":false,\"inputs\":[{\"indexed\":false,\"name\":\"name\",\"type\":\"bytes32\"},{\"indexed\":false,\"name\":\"item_id\",\"type\":\"int256\"},{\"indexed\":false,\"name\":\"item_name\",\"type\":\"bytes32\"}],\"name\":\"selectResult\",\"type\":\"event\"},{\"anonymous\":false,\"inputs\":[{\"indexed\":false,\"name\":\"count\",\"type\":\"int256\"}],\"name\":\"insertResult\",\"type\":\"event\"},{\"anonymous\":false,\"inputs\":[{\"indexed\":false,\"name\":\"count\",\"type\":\"int256\"}],\"name\":\"updateResult\",\"type\":\"event\"},{\"anonymous\":false,\"inputs\":[{\"indexed\":false,\"name\":\"count\",\"type\":\"int256\"}],\"name\":\"removeResult\",\"type\":\"event\"}]";

    public static final TransactionDecoder transactionDecoder = new TransactionDecoder(ABI, BINARY);

    public static final String FUNC_UPDATE = "update";

    public static final String FUNC_REMOVE = "remove";

    public static final String FUNC_INSERT = "insert";

    public static final String FUNC_CREATE = "create";

    public static final String FUNC_SELECT = "select";

    public static final Event CREATERESULT_EVENT = new Event("createResult", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Int256>() {}));
    ;

    public static final Event SELECTRESULT_EVENT = new Event("selectResult", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}, new TypeReference<Int256>() {}, new TypeReference<Bytes32>() {}));
    ;

    public static final Event INSERTRESULT_EVENT = new Event("insertResult", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Int256>() {}));
    ;

    public static final Event UPDATERESULT_EVENT = new Event("updateResult", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Int256>() {}));
    ;

    public static final Event REMOVERESULT_EVENT = new Event("removeResult", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Int256>() {}));
    ;

    @Deprecated
    protected TableTest(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected TableTest(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected TableTest(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected TableTest(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static TransactionDecoder getTransactionDecoder() {
        return transactionDecoder;
    }

    public RemoteCall<TransactionReceipt> update(String name, BigInteger item_id, String item_name) {
        final Function function = new Function(
                FUNC_UPDATE, 
                Arrays.<Type>asList(new org.fisco.bcos.v2.abi.datatypes.Utf8String(name),
                new org.fisco.bcos.v2.abi.datatypes.generated.Int256(item_id),
                new org.fisco.bcos.v2.abi.datatypes.Utf8String(item_name)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void update(String name, BigInteger item_id, String item_name, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_UPDATE, 
                Arrays.<Type>asList(new org.fisco.bcos.v2.abi.datatypes.Utf8String(name),
                new org.fisco.bcos.v2.abi.datatypes.generated.Int256(item_id),
                new org.fisco.bcos.v2.abi.datatypes.Utf8String(item_name)),
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public String updateSeq(String name, BigInteger item_id, String item_name) {
        final Function function = new Function(
                FUNC_UPDATE, 
                Arrays.<Type>asList(new org.fisco.bcos.v2.abi.datatypes.Utf8String(name),
                new org.fisco.bcos.v2.abi.datatypes.generated.Int256(item_id),
                new org.fisco.bcos.v2.abi.datatypes.Utf8String(item_name)),
                Collections.<TypeReference<?>>emptyList());
        return createTransactionSeq(function);
    }

    public Tuple3<String, BigInteger, String> getUpdateInput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getInput().substring(10);
        final Function function = new Function(FUNC_UPDATE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}, new TypeReference<Int256>() {}, new TypeReference<Utf8String>() {}));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());;
        return new Tuple3<String, BigInteger, String>(

                (String) results.get(0).getValue(), 
                (BigInteger) results.get(1).getValue(), 
                (String) results.get(2).getValue()
                );
    }

    public Tuple1<BigInteger> getUpdateOutput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getOutput();
        final Function function = new Function(FUNC_UPDATE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Int256>() {}));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());;
        return new Tuple1<BigInteger>(

                (BigInteger) results.get(0).getValue()
                );
    }

    public RemoteCall<TransactionReceipt> remove(String name, BigInteger item_id) {
        final Function function = new Function(
                FUNC_REMOVE, 
                Arrays.<Type>asList(new org.fisco.bcos.v2.abi.datatypes.Utf8String(name),
                new org.fisco.bcos.v2.abi.datatypes.generated.Int256(item_id)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void remove(String name, BigInteger item_id, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_REMOVE, 
                Arrays.<Type>asList(new org.fisco.bcos.v2.abi.datatypes.Utf8String(name),
                new org.fisco.bcos.v2.abi.datatypes.generated.Int256(item_id)),
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public String removeSeq(String name, BigInteger item_id) {
        final Function function = new Function(
                FUNC_REMOVE, 
                Arrays.<Type>asList(new org.fisco.bcos.v2.abi.datatypes.Utf8String(name),
                new org.fisco.bcos.v2.abi.datatypes.generated.Int256(item_id)),
                Collections.<TypeReference<?>>emptyList());
        return createTransactionSeq(function);
    }

    public Tuple2<String, BigInteger> getRemoveInput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getInput().substring(10);
        final Function function = new Function(FUNC_REMOVE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}, new TypeReference<Int256>() {}));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());;
        return new Tuple2<String, BigInteger>(

                (String) results.get(0).getValue(), 
                (BigInteger) results.get(1).getValue()
                );
    }

    public Tuple1<BigInteger> getRemoveOutput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getOutput();
        final Function function = new Function(FUNC_REMOVE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Int256>() {}));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());;
        return new Tuple1<BigInteger>(

                (BigInteger) results.get(0).getValue()
                );
    }

    public RemoteCall<TransactionReceipt> insert(String name, BigInteger item_id, String item_name) {
        final Function function = new Function(
                FUNC_INSERT, 
                Arrays.<Type>asList(new org.fisco.bcos.v2.abi.datatypes.Utf8String(name),
                new org.fisco.bcos.v2.abi.datatypes.generated.Int256(item_id),
                new org.fisco.bcos.v2.abi.datatypes.Utf8String(item_name)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void insert(String name, BigInteger item_id, String item_name, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_INSERT, 
                Arrays.<Type>asList(new org.fisco.bcos.v2.abi.datatypes.Utf8String(name),
                new org.fisco.bcos.v2.abi.datatypes.generated.Int256(item_id),
                new org.fisco.bcos.v2.abi.datatypes.Utf8String(item_name)),
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public String insertSeq(String name, BigInteger item_id, String item_name) {
        final Function function = new Function(
                FUNC_INSERT, 
                Arrays.<Type>asList(new org.fisco.bcos.v2.abi.datatypes.Utf8String(name),
                new org.fisco.bcos.v2.abi.datatypes.generated.Int256(item_id),
                new org.fisco.bcos.v2.abi.datatypes.Utf8String(item_name)),
                Collections.<TypeReference<?>>emptyList());
        return createTransactionSeq(function);
    }

    public Tuple3<String, BigInteger, String> getInsertInput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getInput().substring(10);
        final Function function = new Function(FUNC_INSERT, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}, new TypeReference<Int256>() {}, new TypeReference<Utf8String>() {}));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());;
        return new Tuple3<String, BigInteger, String>(

                (String) results.get(0).getValue(), 
                (BigInteger) results.get(1).getValue(), 
                (String) results.get(2).getValue()
                );
    }

    public Tuple1<BigInteger> getInsertOutput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getOutput();
        final Function function = new Function(FUNC_INSERT, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Int256>() {}));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());;
        return new Tuple1<BigInteger>(

                (BigInteger) results.get(0).getValue()
                );
    }

    public RemoteCall<TransactionReceipt> create() {
        final Function function = new Function(
                FUNC_CREATE, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void create(TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_CREATE, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public String createSeq() {
        final Function function = new Function(
                FUNC_CREATE, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return createTransactionSeq(function);
    }

    public RemoteCall<Tuple3<List<byte[]>, List<BigInteger>, List<byte[]>>> select(String name) {
        final Function function = new Function(FUNC_SELECT, 
                Arrays.<Type>asList(new org.fisco.bcos.v2.abi.datatypes.Utf8String(name)),
                Arrays.<TypeReference<?>>asList(new TypeReference<DynamicArray<Bytes32>>() {}, new TypeReference<DynamicArray<Int256>>() {}, new TypeReference<DynamicArray<Bytes32>>() {}));
        return new RemoteCall<Tuple3<List<byte[]>, List<BigInteger>, List<byte[]>>>(
                new Callable<Tuple3<List<byte[]>, List<BigInteger>, List<byte[]>>>() {
                    @Override
                    public Tuple3<List<byte[]>, List<BigInteger>, List<byte[]>> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple3<List<byte[]>, List<BigInteger>, List<byte[]>>(
                                convertToNative((List<Bytes32>) results.get(0).getValue()), 
                                convertToNative((List<Int256>) results.get(1).getValue()), 
                                convertToNative((List<Bytes32>) results.get(2).getValue()));
                    }
                });
    }

    public List<CreateResultEventResponse> getCreateResultEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(CREATERESULT_EVENT, transactionReceipt);
        ArrayList<CreateResultEventResponse> responses = new ArrayList<CreateResultEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            CreateResultEventResponse typedResponse = new CreateResultEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.count = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public void registercreateResultEventLogFilter(String fromBlock, String toBlock, List<String> otherTopcs, EventLogPushWithDecodeCallback callback) {
        String topic0 = EventEncoder.encode(CREATERESULT_EVENT);
        registerEventLogPushFilter(ABI,BINARY,topic0,fromBlock,toBlock,otherTopcs,callback);
    }

    public void registercreateResultEventLogFilter(EventLogPushWithDecodeCallback callback) {
        String topic0 = EventEncoder.encode(CREATERESULT_EVENT);
        registerEventLogPushFilter(ABI,BINARY,topic0,callback);
    }

    public List<SelectResultEventResponse> getSelectResultEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(SELECTRESULT_EVENT, transactionReceipt);
        ArrayList<SelectResultEventResponse> responses = new ArrayList<SelectResultEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            SelectResultEventResponse typedResponse = new SelectResultEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.name = (byte[]) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.item_id = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse.item_name = (byte[]) eventValues.getNonIndexedValues().get(2).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public void registerselectResultEventLogFilter(String fromBlock, String toBlock, List<String> otherTopcs, EventLogPushWithDecodeCallback callback) {
        String topic0 = EventEncoder.encode(SELECTRESULT_EVENT);
        registerEventLogPushFilter(ABI,BINARY,topic0,fromBlock,toBlock,otherTopcs,callback);
    }

    public void registerselectResultEventLogFilter(EventLogPushWithDecodeCallback callback) {
        String topic0 = EventEncoder.encode(SELECTRESULT_EVENT);
        registerEventLogPushFilter(ABI,BINARY,topic0,callback);
    }

    public List<InsertResultEventResponse> getInsertResultEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(INSERTRESULT_EVENT, transactionReceipt);
        ArrayList<InsertResultEventResponse> responses = new ArrayList<InsertResultEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            InsertResultEventResponse typedResponse = new InsertResultEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.count = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public void registerinsertResultEventLogFilter(String fromBlock, String toBlock, List<String> otherTopcs, EventLogPushWithDecodeCallback callback) {
        String topic0 = EventEncoder.encode(INSERTRESULT_EVENT);
        registerEventLogPushFilter(ABI,BINARY,topic0,fromBlock,toBlock,otherTopcs,callback);
    }

    public void registerinsertResultEventLogFilter(EventLogPushWithDecodeCallback callback) {
        String topic0 = EventEncoder.encode(INSERTRESULT_EVENT);
        registerEventLogPushFilter(ABI,BINARY,topic0,callback);
    }

    public List<UpdateResultEventResponse> getUpdateResultEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(UPDATERESULT_EVENT, transactionReceipt);
        ArrayList<UpdateResultEventResponse> responses = new ArrayList<UpdateResultEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            UpdateResultEventResponse typedResponse = new UpdateResultEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.count = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public void registerupdateResultEventLogFilter(String fromBlock, String toBlock, List<String> otherTopcs, EventLogPushWithDecodeCallback callback) {
        String topic0 = EventEncoder.encode(UPDATERESULT_EVENT);
        registerEventLogPushFilter(ABI,BINARY,topic0,fromBlock,toBlock,otherTopcs,callback);
    }

    public void registerupdateResultEventLogFilter(EventLogPushWithDecodeCallback callback) {
        String topic0 = EventEncoder.encode(UPDATERESULT_EVENT);
        registerEventLogPushFilter(ABI,BINARY,topic0,callback);
    }

    public List<RemoveResultEventResponse> getRemoveResultEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(REMOVERESULT_EVENT, transactionReceipt);
        ArrayList<RemoveResultEventResponse> responses = new ArrayList<RemoveResultEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            RemoveResultEventResponse typedResponse = new RemoveResultEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.count = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public void registerremoveResultEventLogFilter(String fromBlock, String toBlock, List<String> otherTopcs, EventLogPushWithDecodeCallback callback) {
        String topic0 = EventEncoder.encode(REMOVERESULT_EVENT);
        registerEventLogPushFilter(ABI,BINARY,topic0,fromBlock,toBlock,otherTopcs,callback);
    }

    public void registerremoveResultEventLogFilter(EventLogPushWithDecodeCallback callback) {
        String topic0 = EventEncoder.encode(REMOVERESULT_EVENT);
        registerEventLogPushFilter(ABI,BINARY,topic0,callback);
    }

    @Deprecated
    public static TableTest load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new TableTest(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static TableTest load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new TableTest(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static TableTest load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new TableTest(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static TableTest load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new TableTest(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<TableTest> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(TableTest.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<TableTest> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(TableTest.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<TableTest> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(TableTest.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<TableTest> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(TableTest.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    public static class CreateResultEventResponse {
        public Log log;

        public BigInteger count;
    }

    public static class SelectResultEventResponse {
        public Log log;

        public byte[] name;

        public BigInteger item_id;

        public byte[] item_name;
    }

    public static class InsertResultEventResponse {
        public Log log;

        public BigInteger count;
    }

    public static class UpdateResultEventResponse {
        public Log log;

        public BigInteger count;
    }

    public static class RemoveResultEventResponse {
        public Log log;

        public BigInteger count;
    }
}
