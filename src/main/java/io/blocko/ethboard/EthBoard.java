package io.blocko.ethboard;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.Log;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tuples.generated.Tuple5;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import rx.Observable;
import rx.functions.Func1;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 3.5.0.
 */
public class EthBoard extends Contract {
    private static final String BINARY = "608060405234801561001057600080fd5b506106cb806100206000396000f3006080604052600436106100565763ffffffff7c0100000000000000000000000000000000000000000000000000000000600035041663224ae14a811461005b57806340731c2414610132578063c697daee146102c8575b600080fd5b34801561006757600080fd5b506040805160206004803580820135601f810184900484028501840190955284845261013094369492936024939284019190819084018382808284375050604080516020601f89358b018035918201839004830284018301909452808352979a99988101979196509182019450925082915084018382808284375050604080516020601f89358b018035918201839004830284018301909452808352979a9998810197919650918201945092508291508401838280828437509497506102ef9650505050505050565b005b34801561013e57600080fd5b5061014a600435610402565b604051808681526020018060200180602001806020018573ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001848103845288818151815260200191508051906020019080838360005b838110156101c75781810151838201526020016101af565b50505050905090810190601f1680156101f45780820380516001836020036101000a031916815260200191505b50848103835287518152875160209182019189019080838360005b8381101561022757818101518382015260200161020f565b50505050905090810190601f1680156102545780820380516001836020036101000a031916815260200191505b50848103825286518152865160209182019188019080838360005b8381101561028757818101518382015260200161026f565b50505050905090810190601f1680156102b45780820380516001836020036101000a031916815260200191505b509850505050505050505060405180910390f35b3480156102d457600080fd5b506102dd610600565b60408051918252519081900360200190f35b60008054600180820183556040805160a08101825283815260208082018981528284018990526060830188905233608084015285875284825292909520815181559151805194959194929361034c93908501929190910190610607565b5060408201518051610368916002840191602090910190610607565b5060608201518051610384916003840191602090910190610607565b50608091909101516004909101805473ffffffffffffffffffffffffffffffffffffffff191673ffffffffffffffffffffffffffffffffffffffff9092169190911790556040805182815290517f162de706c5323a77af7a43e84349518a6a1eab41b6329f42476e49e18a8e7acd916020908290030190a150505050565b6000818152600160208181526040808420600481015481850180548451601f6002600019998416156101000299909901909216889004918201879004870281018701909552808552606096879687968a968c969381019460039091019373ffffffffffffffffffffffffffffffffffffffff16928691908301828280156104ca5780601f1061049f576101008083540402835291602001916104ca565b820191906000526020600020905b8154815290600101906020018083116104ad57829003601f168201915b5050865460408051602060026001851615610100026000190190941693909304601f8101849004840282018401909252818152959950889450925084019050828280156105585780601f1061052d57610100808354040283529160200191610558565b820191906000526020600020905b81548152906001019060200180831161053b57829003601f168201915b5050855460408051602060026001851615610100026000190190941693909304601f8101849004840282018401909252818152959850879450925084019050828280156105e65780601f106105bb576101008083540402835291602001916105e6565b820191906000526020600020905b8154815290600101906020018083116105c957829003601f168201915b505050505091509450945094509450945091939590929450565b6000545b90565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f1061064857805160ff1916838001178555610675565b82800160010185558215610675579182015b8281111561067557825182559160200191906001019061065a565b50610681929150610685565b5090565b61060491905b80821115610681576000815560010161068b5600a165627a7a7230582076bc5b25446e69d0b0f56dfdffa36b4c54f9569cd5ef43271a8e8a09b5a458a20029";

    public static final String FUNC_ADDPOST = "addPost";

    public static final String FUNC_GETPOST = "getPost";

    public static final String FUNC_GETNUMOFPOSTS = "getNumOfPosts";

    public static final Event ADDEDPOST_EVENT = new Event("AddedPost", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
    ;

    protected EthBoard(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected EthBoard(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public RemoteCall<TransactionReceipt> addPost(String title, String content, String ownerName) {
        final Function function = new Function(
                FUNC_ADDPOST, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(title), 
                new org.web3j.abi.datatypes.Utf8String(content), 
                new org.web3j.abi.datatypes.Utf8String(ownerName)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<Tuple5<BigInteger, String, String, String, String>> getPost(BigInteger uid) {
        final Function function = new Function(FUNC_GETPOST, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(uid)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Address>() {}));
        return new RemoteCall<Tuple5<BigInteger, String, String, String, String>>(
                new Callable<Tuple5<BigInteger, String, String, String, String>>() {
                    @Override
                    public Tuple5<BigInteger, String, String, String, String> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple5<BigInteger, String, String, String, String>(
                                (BigInteger) results.get(0).getValue(), 
                                (String) results.get(1).getValue(), 
                                (String) results.get(2).getValue(), 
                                (String) results.get(3).getValue(), 
                                (String) results.get(4).getValue());
                    }
                });
    }

    public RemoteCall<BigInteger> getNumOfPosts() {
        final Function function = new Function(FUNC_GETNUMOFPOSTS, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public List<AddedPostEventResponse> getAddedPostEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(ADDEDPOST_EVENT, transactionReceipt);
        ArrayList<AddedPostEventResponse> responses = new ArrayList<AddedPostEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            AddedPostEventResponse typedResponse = new AddedPostEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.uid = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<AddedPostEventResponse> addedPostEventObservable(EthFilter filter) {
        return web3j.ethLogObservable(filter).map(new Func1<Log, AddedPostEventResponse>() {
            @Override
            public AddedPostEventResponse call(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(ADDEDPOST_EVENT, log);
                AddedPostEventResponse typedResponse = new AddedPostEventResponse();
                typedResponse.log = log;
                typedResponse.uid = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Observable<AddedPostEventResponse> addedPostEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(ADDEDPOST_EVENT));
        return addedPostEventObservable(filter);
    }

    public static RemoteCall<EthBoard> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(EthBoard.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<EthBoard> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(EthBoard.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    public static EthBoard load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new EthBoard(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    public static EthBoard load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new EthBoard(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static class AddedPostEventResponse {
        public Log log;

        public BigInteger uid;
    }
}
