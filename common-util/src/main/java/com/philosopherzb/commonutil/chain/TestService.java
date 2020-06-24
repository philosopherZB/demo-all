package com.philosopherzb.commonutil.chain;

import com.philosopherzb.commonutil.chain.dto.TestDBDTO;
import com.philosopherzb.commonutil.chain.dto.TestDTO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * author: philosopherZB
 * date: 2020/3/13
 */
@Service
public class TestService {


    public static void main(String[] args){
        try {
            TestDTO input = getTestDto();
            List<TestDBDTO> testDBDTOList = setTestDBDTO();

            HandleChain handleChain = new HandleChain();
            handleChain.addBaseCase(new OneChain()).
                    addBaseCase(new TwoChain()).
                    addBaseCase(new ThreeChain()).
                    addBaseCase(new FourChain());
            TestDBDTO result = handleChain.doSomething(input, testDBDTOList, handleChain);
            if (result != null && StringUtils.isNotEmpty(result.getName())) {
                System.out.println("chain result: " + result.getName() + "====" + result.getCardNo());
            } else{
                System.out.println("chain no result: ");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    private static TestDTO getTestDto(){
        TestDTO testDTO = new TestDTO();
        testDTO.setAge("30");
        testDTO.setId("4");
        testDTO.setSex("男");
//        testDTO.setCardNo("C001");
        return testDTO;
    }


    private static List<TestDBDTO> setTestDBDTO(){
        List<TestDBDTO> testDBDTOList = new ArrayList<>();

        TestDBDTO testDBDTO1 = new TestDBDTO();
        testDBDTO1.setAge("20");
        testDBDTO1.setId("2");
        testDBDTO1.setName("name002");
        testDBDTO1.setSex("男");
        testDBDTO1.setCardNo("C002");

        TestDBDTO testDBDTO2 = new TestDBDTO();
        testDBDTO2.setAge("20");
        testDBDTO2.setId("1");
        testDBDTO2.setName("name001");
        testDBDTO2.setSex("男");
        testDBDTO2.setCardNo("C001");

        TestDBDTO testDBDTO3 = new TestDBDTO();
        testDBDTO3.setAge("20");
        testDBDTO3.setId("1");
        testDBDTO3.setName("name001");
        testDBDTO3.setSex("女");
        testDBDTO3.setCardNo("C001");

        TestDBDTO testDBDTO4 = new TestDBDTO();
        testDBDTO4.setAge("30");
        testDBDTO4.setId("3");
        testDBDTO4.setName("name003");
        testDBDTO4.setSex("男");
        testDBDTO4.setCardNo("C003");

        TestDBDTO testDBDTO5 = new TestDBDTO();
        testDBDTO5.setAge("30");
        testDBDTO5.setId("4");
        testDBDTO5.setName("name004");
        testDBDTO5.setSex("男");
        testDBDTO5.setCardNo("C004");

        TestDBDTO testDBDTO6 = new TestDBDTO();
        testDBDTO6.setAge("30");
        testDBDTO6.setId("4");
        testDBDTO6.setName("name005");
        testDBDTO6.setSex("男");
        testDBDTO6.setCardNo("C004");

        testDBDTOList.add(testDBDTO1);
        testDBDTOList.add(testDBDTO2);
        testDBDTOList.add(testDBDTO3);
        testDBDTOList.add(testDBDTO4);
        testDBDTOList.add(testDBDTO5);
        testDBDTOList.add(testDBDTO6);

        return testDBDTOList;
    }
}
