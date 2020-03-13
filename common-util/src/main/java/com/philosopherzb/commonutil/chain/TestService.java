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
                    addBaseCase(new TwoChain());
            TestDBDTO result = handleChain.doSomething(input, testDBDTOList, handleChain);
            if (result != null && StringUtils.isNotEmpty(result.getName())) {
                System.out.println("chain result: " + result.getName());
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
        testDTO.setId("002");
        return testDTO;
    }


    private static List<TestDBDTO> setTestDBDTO(){
        List<TestDBDTO> testDBDTOList = new ArrayList<>();

        TestDBDTO testDBDTO1 = new TestDBDTO();
        testDBDTO1.setAge("20");
        testDBDTO1.setId("002");
        testDBDTO1.setName("name002");

        TestDBDTO testDBDTO2 = new TestDBDTO();
        testDBDTO2.setAge("20");
        testDBDTO2.setId("001");
        testDBDTO2.setName("name001");

        TestDBDTO testDBDTO3 = new TestDBDTO();
        testDBDTO3.setAge("20");
        testDBDTO3.setId("001");
        testDBDTO3.setName("name001");

        TestDBDTO testDBDTO4 = new TestDBDTO();
        testDBDTO4.setAge("30");
        testDBDTO4.setId("003");
        testDBDTO4.setName("name003");

        testDBDTOList.add(testDBDTO1);
        testDBDTOList.add(testDBDTO2);
        testDBDTOList.add(testDBDTO3);
        testDBDTOList.add(testDBDTO4);

        return testDBDTOList;
    }
}
