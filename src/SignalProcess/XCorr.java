package SignalProcess;

public class XCorr {
    public static void main(String[] args) {
        double[] s1 = new double[]{1,2,2,1,2,3,1,2,3,1,0,-1,2,5,2};
        double[] s2 = new double[]{1,2,3,1};
        double[] res = xcorr(s1,s2);
        for (double d : res){
            System.out.println(d);
        }

        System.out.println("test:" + Float.parseFloat("0.023"));
        //int res = xcorr(s1,s2);
        //System.out.println(res);
    }

    private static double[] xcorr(double[] s1,double[] s2){
        int len1 = s1.length;//max
        int len2 = s2.length;//min
        double[] ret = new double[len1+len2-1];

        double max;
        int maxIndex;

        int delay,i,j;
        float sxy;
        delay = -len1 + 1;
        sxy = 0;
        for (i = 0;i<len1;i++){
            j = i+ delay;
            if ((j<0) || (j >= len2)){
                continue;
            }else {
                sxy += (s1[i]*s2[j]);
            }
        }
        ret[delay + len1 - 1] = sxy;
        max = sxy;
        maxIndex = delay + len1 - 1;

        for (delay = -len1+2;delay < len2;delay++){
            sxy = 0;
            for (i = 0;i<len1;i++){
                j = i + delay;
                if ((j<0) || (j >= len2)){
                    continue;
                }else {
                    sxy += (s1[i]*s2[j]);
                }
            }
            ret[delay + len1 - 1] = sxy;
            if(ret[delay + len1 - 1] > max){
                max = ret[delay + len1 - 1];
                maxIndex = delay + len1 - 1;
            }
        }
        System.out.println("index:" + maxIndex);
        return ret;

    }

    private static double[] xcorr2(double[] s1,double[] s2){
        int len1 = s1.length;//max
        int len2 = s2.length;//min
        int N = len1;
        double[] ret = new double[2*N-1];

        double max;
        int maxIndex;

        int delay,i,j;
        float sxy;
        delay = -N + 1;
        sxy = 0;
        for (i = 0;i<N;i++){
            j = i+ delay;
            if ((j<0) || (j >= N)){
                continue;
            }else {
                sxy += (s1[i]*s2[j]);
            }
        }
        ret[delay + N - 1] = sxy;
        max = sxy;
        maxIndex = delay + N - 1;

        for (delay = -N+2;delay < N;delay++){
            sxy = 0;
            for (i = 0;i<N;i++){
                j = i + delay;
                if ((j<0) || (j >= N)){
                    continue;
                }else {
                    sxy += (s1[i]*s2[j]);
                }
            }
            ret[delay + N - 1] = sxy;
            if(ret[delay + N - 1] > max){
                max = ret[delay + N - 1];
                maxIndex = delay + N - 1;
            }
        }
        System.out.println("index:" + maxIndex);
        return ret;

    }
}
