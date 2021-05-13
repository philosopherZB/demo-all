package com.philosopherzb.commonutil.util;

import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * @author philosopherZB
 * @date 2021/5/13
 */
public class IPUtils {

    /**
     * 通过掩码位计算ip数
     *
     * @param maskBit 掩码位 即192.168.0.1/24中斜线后的数字(24)
     * @return ip数
     */
    public static int getIPs(int maskBit) {
        if (maskBit <= 0 || maskBit >= 32) {
            return 0;
        }
        return BigDecimal.valueOf(Math.pow(2, 32 - maskBit) - 2).setScale(0, BigDecimal.ROUND_DOWN).intValue();
    }

    /**
     * 功能：判断一个IP是不是在一个网段下的
     * 格式：isInRange("192.168.8.3", "192.168.9.10/22");
     *
     * @param ip     指定ip
     * @param ipMask 指定掩码
     * @return 是否存在
     */
    public static boolean isInRange(String ip, String ipMask) {
        String[] ips = ip.split("\\.");
        int ipAddress = (Integer.parseInt(ips[0]) << 24)
                | (Integer.parseInt(ips[1]) << 16)
                | (Integer.parseInt(ips[2]) << 8) | Integer.parseInt(ips[3]);
        int type = Integer.parseInt(ipMask.replaceAll(".*/", ""));
        int mask = 0xFFFFFFFF << (32 - type);
        String ipMaskReplace = ipMask.replaceAll("/.*", "");
        String[] ipMaskSplit = ipMaskReplace.split("\\.");
        int ipMaskAddress = (Integer.parseInt(ipMaskSplit[0]) << 24)
                | (Integer.parseInt(ipMaskSplit[1]) << 16)
                | (Integer.parseInt(ipMaskSplit[2]) << 8)
                | Integer.parseInt(ipMaskSplit[3]);

        return (ipAddress & mask) == (ipMaskAddress & mask);
    }

    /**
     * 功能：根据IP和位数返回该IP网段的所有IP
     * 格式：parseIpMaskRange("192.192.192.1.", "23")
     *
     * @param ip   ip地址
     * @param mask 掩码位数
     * @return ips
     */
    public static List<String> parseIpMaskRange(String ip, String mask) {
        List<String> list = new ArrayList<>();
        if ("32".equals(mask)) {
            list.add(ip);
        } else {
            String startIp = getBeginIpStr(ip, mask);
            String endIp = getEndIpStr(ip, mask);
            if (!"31".equals(mask)) {
                String subStart = startIp.split("\\.")[0] + "." + startIp.split("\\.")[1] + "." + startIp.split("\\.")[2] + ".";
                String subEnd = endIp.split("\\.")[0] + "." + endIp.split("\\.")[1] + "." + endIp.split("\\.")[2] + ".";
                startIp = subStart + (Integer.parseInt(startIp.split("\\.")[3]) + 1);
                endIp = subEnd + (Integer.parseInt(endIp.split("\\.")[3]) - 1);
            }
            list = parseIpRange(startIp, endIp);
        }
        return list;
    }

    /**
     * 功能：正则判断
     * 格式：isIP("192.192.192.1")
     *
     * @param str ip
     * @return 判断结果
     */
    public static boolean isIP(String str) {
        String regex = "\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}";
        Pattern pattern = Pattern.compile(regex);
        return pattern.matcher(str).matches();
    }

    /**
     * 转换两个ip之间的所有ip
     *
     * @param ipFrom 起始ip
     * @param ipTo   终止ip
     * @return ipList
     */
    public static List<String> parseIpRange(String ipFrom, String ipTo) {
        List<String> ips = new ArrayList<>();
        String[] ipFromTemp = StringUtils.split(ipFrom, "\\.");
        String[] ipToTemp = StringUtils.split(ipTo, "\\.");
        int[] int_ipf = new int[4];
        int[] int_ipt = new int[4];
        for (int i = 0; i < 4; i++) {
            int_ipf[i] = Integer.parseInt(ipFromTemp[i]);
            int_ipt[i] = Integer.parseInt(ipToTemp[i]);
        }
        for (int A = int_ipf[0]; A <= int_ipt[0]; A++) {
            for (int B = (A == int_ipf[0] ? int_ipf[1] : 0); B <= (A == int_ipt[0] ? int_ipt[1] : 255); B++) {
                for (int C = (B == int_ipf[1] ? int_ipf[2] : 0); C <= (B == int_ipt[1] ? int_ipt[2] : 255); C++) {
                    for (int D = (C == int_ipf[2] ? int_ipf[3] : 0); D <= (C == int_ipt[2] ? int_ipt[3] : 255); D++) {
                        ips.add(A + "." + B + "." + C + "." + D);
                    }
                }
            }
        }
        return ips;
    }

    /**
     * 把long类型的Ip转为一般Ip类型：xx.xx.xx.xx
     *
     * @param ip Long型IP地址
     * @return string型ip
     */
    public static String getIpFromLong(Long ip) {
        String s1 = String.valueOf((ip & 4278190080L) / 16777216L);
        String s2 = String.valueOf((ip & 16711680L) / 65536L);
        String s3 = String.valueOf((ip & 65280L) / 256L);
        String s4 = String.valueOf(ip & 255L);
        return s1 + "." + s2 + "." + s3 + "." + s4;
    }

    /**
     * 把xx.xx.xx.xx类型的转为long类型的
     *
     * @param ip string型ip
     * @return long型ip
     */
    public static Long getIpFromString(String ip) {
        long ipLong = 0L;
        String ipTemp = ip;
        ipLong = ipLong * 256
                + Long.parseLong(ipTemp.substring(0, ipTemp.indexOf('.')));
        ipTemp = ipTemp.substring(ipTemp.indexOf('.') + 1);
        ipLong = ipLong * 256
                + Long.parseLong(ipTemp.substring(0, ipTemp.indexOf('.')));
        ipTemp = ipTemp.substring(ipTemp.indexOf(".") + 1);
        ipLong = ipLong * 256
                + Long.parseLong(ipTemp.substring(0, ipTemp.indexOf('.')));
        ipTemp = ipTemp.substring(ipTemp.indexOf('.') + 1);
        ipLong = ipLong * 256 + Long.parseLong(ipTemp);
        return ipLong;
    }

    /**
     * 根据掩码位获取掩码
     *
     * @param maskBit 掩码位数，如"28"、"30"
     * @return 掩码
     */
    public static String getMaskByMaskBit(String maskBit) {
        return "".equals(maskBit) ? "error, maskBit is null !" : getMaskMap(maskBit);
    }

    /**
     * 根据 ip/掩码位 计算IP段的起始IP 如 IP串 218.240.38.69/30
     *
     * @param ip      给定的IP，如218.240.38.69
     * @param maskBit 给定的掩码位，如30
     * @return 起始IP的字符串表示
     */
    public static String getBeginIpStr(String ip, String maskBit) {
        return getIpFromLong(getBeginIpLong(ip, maskBit));
    }

    /**
     * 根据 ip/掩码位 计算IP段的起始IP 如 IP串 218.240.38.69/30
     *
     * @param ip      给定的IP，如218.240.38.69
     * @param maskBit 给定的掩码位，如30
     * @return 起始IP的长整型表示
     */
    public static Long getBeginIpLong(String ip, String maskBit) {
        return getIpFromString(ip) & getIpFromString(getMaskByMaskBit(maskBit));
    }

    /**
     * 根据 ip/掩码位 计算IP段的终止IP 如 IP串 218.240.38.69/30
     *
     * @param ip      给定的IP，如218.240.38.69
     * @param maskBit 给定的掩码位，如30
     * @return 终止IP的字符串表示
     */
    public static String getEndIpStr(String ip, String maskBit) {
        return getIpFromLong(getEndIpLong(ip, maskBit));
    }

    /**
     * 根据 ip/掩码位 计算IP段的终止IP 如 IP串 218.240.38.69/30
     *
     * @param ip      给定的IP，如218.240.38.69
     * @param maskBit 给定的掩码位，如30
     * @return 终止IP的长整型表示
     */
    public static Long getEndIpLong(String ip, String maskBit) {
        return getBeginIpLong(ip, maskBit)
                + ~getIpFromString(getMaskByMaskBit(maskBit));
    }


    /**
     * 根据子网掩码转换为掩码位 如 255.255.255.252转换为掩码位 为 30
     *
     * @param netMarks 子网掩码
     * @return 掩码位
     */
    public static int getNetMask(String netMarks) {
        StringBuilder sbf;
        String str;
        int inetmask = 0;
        int count = 0;
        String[] ipList = netMarks.split("\\.");
        for (String anIpList : ipList) {
            sbf = toBin(Integer.parseInt(anIpList));
            str = sbf.reverse().toString();
            count = 0;
            for (int i = 0; i < str.length(); i++) {
                i = str.indexOf('1', i);
                if (i == -1) {
                    break;
                }
                count++;
            }
            inetmask += count;
        }
        return inetmask;
    }

    /**
     * 计算子网大小
     *
     * @param maskBit 掩码位
     * @return 子网大小
     */
    public static int getPoolMax(int maskBit) {
        if (maskBit <= 0 || maskBit >= 32) {
            return 0;
        }
        return (int) Math.pow(2, 32 - maskBit) - 2;
    }

    private static StringBuilder toBin(int x) {
        StringBuilder result = new StringBuilder();
        result.append(x % 2);
        x /= 2;
        while (x > 0) {
            result.append(x % 2);
            x /= 2;
        }
        return result;
    }

    /**
     * 掩码map
     *
     * @param maskBit 掩码位
     * @return 子网掩码
     */
    public static String getMaskMap(String maskBit) {
        if ("1".equals(maskBit)) return "128.0.0.0";
        if ("2".equals(maskBit)) return "192.0.0.0";
        if ("3".equals(maskBit)) return "224.0.0.0";
        if ("4".equals(maskBit)) return "240.0.0.0";
        if ("5".equals(maskBit)) return "248.0.0.0";
        if ("6".equals(maskBit)) return "252.0.0.0";
        if ("7".equals(maskBit)) return "254.0.0.0";
        if ("8".equals(maskBit)) return "255.0.0.0";
        if ("9".equals(maskBit)) return "255.128.0.0";
        if ("10".equals(maskBit)) return "255.192.0.0";
        if ("11".equals(maskBit)) return "255.224.0.0";
        if ("12".equals(maskBit)) return "255.240.0.0";
        if ("13".equals(maskBit)) return "255.248.0.0";
        if ("14".equals(maskBit)) return "255.252.0.0";
        if ("15".equals(maskBit)) return "255.254.0.0";
        if ("16".equals(maskBit)) return "255.255.0.0";
        if ("17".equals(maskBit)) return "255.255.128.0";
        if ("18".equals(maskBit)) return "255.255.192.0";
        if ("19".equals(maskBit)) return "255.255.224.0";
        if ("20".equals(maskBit)) return "255.255.240.0";
        if ("21".equals(maskBit)) return "255.255.248.0";
        if ("22".equals(maskBit)) return "255.255.252.0";
        if ("23".equals(maskBit)) return "255.255.254.0";
        if ("24".equals(maskBit)) return "255.255.255.0";
        if ("25".equals(maskBit)) return "255.255.255.128";
        if ("26".equals(maskBit)) return "255.255.255.192";
        if ("27".equals(maskBit)) return "255.255.255.224";
        if ("28".equals(maskBit)) return "255.255.255.240";
        if ("29".equals(maskBit)) return "255.255.255.248";
        if ("30".equals(maskBit)) return "255.255.255.252";
        if ("31".equals(maskBit)) return "255.255.255.254";
        if ("32".equals(maskBit)) return "255.255.255.255";
        return "-1";
    }

    /**
     * ip to double
     *
     * @param ip ip 地址
     * @return double
     */
    public static double ipToDouble(String ip) {
        String[] arr = ip.split("\\.");
        double d1 = Double.parseDouble(arr[0]);
        double d2 = Double.parseDouble(arr[1]);
        double d3 = Double.parseDouble(arr[2]);
        double d4 = Double.parseDouble(arr[3]);
        return d1 * Math.pow(256, 3) + d2 * Math.pow(256, 2) + d3 * 256 + d4;
    }

}
