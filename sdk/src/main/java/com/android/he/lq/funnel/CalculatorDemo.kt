package com.android.he.lq.funnel

import java.text.SimpleDateFormat
import java.util.*
import java.util.stream.Collectors
//import lombok.Data // Lombok能以简单的注解形式来简化java代码，提高开发人员的开发效率 https://www.cnblogs.com/heyonggang/p/8638374.html
import java.util.Locale.filter

// 本文 https://www.jianshu.com/p/9ca7496c97ac
// 观点 http://www.woshipm.com/data-analysis/758063.html  https://www.cnblogs.com/HuZihu/p/11357799.html 可以做论文
class CalculatorDemo {

//    public static List<FunnelDataDTO> visitList = new ArrayList<FunnelDataDTO>()
//
//    static {
//
//        visitList.add(new FunnelDataDTO("ggr", 1535624314001L, "20180830", "v2"))
//        visitList.add(new FunnelDataDTO("ggr", 1535624314002L, "20180830", "v1"))
//        visitList.add(new FunnelDataDTO("ggr", 1535624314003L, "20180830", "v1"))
//        visitList.add(new FunnelDataDTO("ggr", 1535624314004L, "20180830", "v2"))
//        visitList.add(new FunnelDataDTO("ggr", 1535624314005L, "20180830", "v1"))
//
//        visitList.add(new FunnelDataDTO("ggr", 1535710714000L, "20180831", "v1"))
//        visitList.add(new FunnelDataDTO("ggr", 1535710714001L, "20180831", "v2"))
//        visitList.add(new FunnelDataDTO("ggr", 1535710714002L, "20180831", "v1"))
//        visitList.add(new FunnelDataDTO("ggr", 1535710714003L, "20180831", "v2"))
//        visitList.add(new FunnelDataDTO("ggr", 1535710714004L, "20180831", "v2"))
//        visitList.add(new FunnelDataDTO("ggr", 1535710714005L, "20180831", "v2"))
//
//        visitList.add(new FunnelDataDTO("ggr", 1535797114000L, "20180901", "v1"))
//        visitList.add(new FunnelDataDTO("ggr", 1535797114003L, "20180901", "v3"))
//        visitList.add(new FunnelDataDTO("ggr", 1535797114003L, "20180901", "v2"))
//        visitList.add(new FunnelDataDTO("ggr", 1535797114004L, "20180901", "v1"))
//        visitList.add(new FunnelDataDTO("ggr", 1535797114004L, "20180901", "v3"))
//    }
//
//
//    public Map<String,List<Integer>> getDayTransForm(List<FunnelDataDTO> visitList, long startTime, long endTime, int cycle, String step){
//
//        int countDay = Math.ceil((endTime - startTime) / 86400000.0D) > 1.0D ? (int) Math.ceil((endTime - startTime) / 86400000.0D) : 1
//        Map<String, Integer> dayMap = new LinkedHashMap<>(countDay + 1)
//        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd")
//        String[] stepArray = step.split(",")
//        int[] stepCountArray = new int[stepArray.length]
//        while (countDay > 0) {
//            /***初始化日期列表和结果列表*/
//            dayMap.put(format.format(new java.util.Date(endTime - (86400000 * countDay))), 0)
//            countDay--
//        }
//        dayMap.put(format.format(new Date(endTime)), 0)
//        /**开始查找*/
//        for (int k = 0 k < visitList.size() k++) {
//            boolean hasFirstStep = visitList.get(k).getVid().equals(stepArray[0]) && dayMap.get(visitList.get(k).getDay()).equals(0)
//            if (hasFirstStep) {
//                stepCountArray[0] = 1
//                /*计算左右两边的边界时间,并截取合法的访问记录进行比对*/
//                long left = visitList.get(k).getTimestamp().longValue()
//                long right = visitList.get(k).getTimestamp().longValue() + (86400000 * cycle)
//                List<FunnelDataDTO> subList = visitList.subList(k, visitList.size()).stream()
//                .filter(funnelDataDTO -> funnelDataDTO.getTimestamp() > left && funnelDataDTO.getTimestamp() <= right)
//                .sorted((x, y) -> (int) (y.getTimestamp() - x.getTimestamp()))
//                .collect(Collectors.toList())
//
//                /**记录已经找到的步骤数，只有当所有步骤全部都找到了才算转化成功*/
//                int stepCount = stepArray.length - 1
//                for (int l = 0 l < subList.size() l++) {
//                    if (subList.get(l).getVid().equals(stepArray[stepCount])) {
//                        stepCount--
//                    } else {
//                        continue
//                    }
//                    /**如果已经找到了所有的步骤就更新一下endStepCount数组，并退出本次循环*/
//                    if (stepCount == 0) {
//                        dayMap.put(visitList.get(k).getDay(), 1)
//                        break
//                    }
//                }
//
//                /**计算每一步的到达人数,得到漏斗图数据*/
//                stepCount = 1
//                for (int m = subList.size() - 1 m >= 0 m--) {
//                    if (stepCount < stepArray.length && subList.get(m).getVid().equals(stepArray[stepCount])) {
//                        stepCountArray[stepCount] = 1
//                        stepCount++
//                    }
//                }
//            }
//        }
//
//        ArrayList<Integer> trendCountList = new ArrayList<>(dayMap.values())
//        List<int[]> stepCountList = Arrays.asList(stepCountArray)
//        Map map = new HashMap(2)
//        map.put("trendCountList",trendCountList)
//        map.put("stepCountList",stepCountList)
//        return map
//    }
//
//
//    public static void main(String[] args) throws Exception {
//        CalculatorDemo demo = new CalculatorDemo()
//        Map<String, List<Integer>> dayTransForm = demo.getDayTransForm(CalculatorDemo.visitList, 1535550316000L, 1535809516000L, 2, "v1,v2,v3")
//        System.out.println(dayTransForm)
//
//    }
}