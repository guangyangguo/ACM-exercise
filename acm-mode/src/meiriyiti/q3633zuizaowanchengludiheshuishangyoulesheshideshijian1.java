package meiriyiti;

public class q3633zuizaowanchengludiheshuishangyoulesheshideshijian1 {

    public static void main(String[] args) {
        int[] landStartTime = {2,8};
        int[] landDuration = {4,1};
        int[] waterStartTime = {6};
        int[] waterDuration = {3};
        System.out.println(earliestFinishTime(landStartTime,landDuration,waterStartTime,waterDuration));
    }



    /*
    * 简单题，但是稍微有点绕
    * */
    public static int earliestFinishTime(int[] landStartTime,int[] landDuration,int[] waterStartTime,int[] waterDuration){
        int res = Integer.MAX_VALUE;
        //先陆地后水上
        for (int i = 0; i < landStartTime.length; i++) {
            //陆地项目完成时间
            int landfinishTime = landStartTime[i] + landDuration[i];
            for (int j = 0; j < waterStartTime.length; j++) {
                //如果水上项目已经开始了，最终时间就是陆地完成时间+水上项目持续时间
                if (landfinishTime >= waterStartTime[j]){
                    int waterFinishTime = landfinishTime + waterDuration[j];
                    res = Math.min(res,waterFinishTime);
                //如果水上项目还没开始，无所谓中间等待时间，最终时间就是水上项目开始时间+水上项目持续时间
                }else {
                    int waterFinishTime = waterStartTime[j] + waterDuration[j];
                    res = Math.min(res,waterFinishTime);
                }
            }
        }
        //先水上后陆地
        for (int i = 0; i < waterStartTime.length; i++) {
            int waterFinishTime = waterStartTime[i] + waterDuration[i];
            for (int j = 0; j < landStartTime.length; j++) {
                if (waterFinishTime >= landStartTime[j]){
                    int landFinishTime = waterFinishTime + landDuration[j];
                    res = Math.min(res,landFinishTime);
                }else {
                    int landFinishTime = landStartTime[j] + landDuration[j];
                    res = Math.min(res,landFinishTime);
                }
            }
        }
        return res;
    }
}
