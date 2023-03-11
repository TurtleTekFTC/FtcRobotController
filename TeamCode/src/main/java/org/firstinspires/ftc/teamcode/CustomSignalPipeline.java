package org.firstinspires.ftc.teamcode;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfPoint;
import org.opencv.core.Scalar;
import org.opencv.imgproc.Imgproc;
import org.openftc.easyopencv.OpenCvPipeline;

import java.util.ArrayList;
import java.util.List;

public class CustomSignalPipeline extends OpenCvPipeline
{
    private Mat rgbThreshold0Output = new Mat();
    private ArrayList<MatOfPoint> findContours0Output = new ArrayList<MatOfPoint>();
    private Mat rgbThreshold1Output = new Mat();
    private ArrayList<MatOfPoint> findContours1Output = new ArrayList<MatOfPoint>();
    private Mat rgbThreshold2Output = new Mat();
    private ArrayList<MatOfPoint> findContours2Output = new ArrayList<MatOfPoint>();
    PossibilitiesForTheSignalSleeveToBe lastResult = PossibilitiesForTheSignalSleeveToBe.ZILCH;
    public enum PossibilitiesForTheSignalSleeveToBe {ONE, TWO, THREE, ZILCH}
    @Override
    public Mat processFrame(Mat source0)
    {
        // Step RGB_Threshold0:
        Mat rgbThreshold0Input = source0;
        double[] rgbThreshold0Red = {134.46327683615814, 196.22340425531914};
        double[] rgbThreshold0Green = {163.27683615819208, 218.82978723404256};
        double[] rgbThreshold0Blue = {45.62146892655366, 126.14361702127661};
        rgbThreshold(rgbThreshold0Input, rgbThreshold0Red, rgbThreshold0Green, rgbThreshold0Blue, rgbThreshold0Output);

        // Step Find_Contours0:
        Mat findContours0Input = rgbThreshold0Output;
        boolean findContours0ExternalOnly = true;
        findContours(findContours0Input, findContours0ExternalOnly, findContours0Output);

        // Step RGB_Threshold1:
        Mat rgbThreshold1Input = source0;
        double[] rgbThreshold1Red = {213.70056497175142, 255.0};
        double[] rgbThreshold1Green = {146.4689265536723, 209.7872340425532};
        double[] rgbThreshold1Blue = {83.84953054505547, 123.62582631940181};
        rgbThreshold(rgbThreshold1Input, rgbThreshold1Red, rgbThreshold1Green, rgbThreshold1Blue, rgbThreshold1Output);

        // Step Find_Contours1:
        Mat findContours1Input = rgbThreshold1Output;
        boolean findContours1ExternalOnly = false;
        findContours(findContours1Input, findContours1ExternalOnly, findContours1Output);

        // Step RGB_Threshold2:
        Mat rgbThreshold2Input = source0;
        double[] rgbThreshold2Red = {156.0734463276836, 255.0};
        double[] rgbThreshold2Green = {0.0, 148.74999999999997};
        double[] rgbThreshold2Blue = {120.05649717514125, 209.7872340425532};
        rgbThreshold(rgbThreshold2Input, rgbThreshold2Red, rgbThreshold2Green, rgbThreshold2Blue, rgbThreshold2Output);

        // Step Find_Contours2:
        Mat findContours2Input = rgbThreshold2Output;
        boolean findContours2ExternalOnly = false;
        findContours(findContours2Input, findContours2ExternalOnly, findContours2Output);



        if(findContours0Output.size() > 0)
        {
            lastResult = PossibilitiesForTheSignalSleeveToBe.ONE;
        }
        else if(findContours1Output.size() > 0)
        {
            lastResult = PossibilitiesForTheSignalSleeveToBe.TWO;
        }
        else if(findContours2Output.size() > 0)
        {
            lastResult = PossibilitiesForTheSignalSleeveToBe.THREE;
        }
        else {
            lastResult = PossibilitiesForTheSignalSleeveToBe.ZILCH;
        }
        return source0;
    }

    public PossibilitiesForTheSignalSleeveToBe getLatestResults()
    {
        return lastResult;
    }

    /**
     * This method is a generated getter for the output of a RGB_Threshold.
     * @return Mat output from RGB_Threshold.
     */
    public Mat rgbThreshold0Output() {
        return rgbThreshold0Output;
    }

    /**
     * This method is a generated getter for the output of a Find_Contours.
     * @return ArrayList<MatOfPoint> output from Find_Contours.
     */
    public ArrayList<MatOfPoint> findContours0Output() {
        return findContours0Output;
    }

    /**
     * This method is a generated getter for the output of a RGB_Threshold.
     * @return Mat output from RGB_Threshold.
     */
    public Mat rgbThreshold1Output() {
        return rgbThreshold1Output;
    }

    /**
     * This method is a generated getter for the output of a Find_Contours.
     * @return ArrayList<MatOfPoint> output from Find_Contours.
     */
    public ArrayList<MatOfPoint> findContours1Output() {
        return findContours1Output;
    }

    /**
     * This method is a generated getter for the output of a RGB_Threshold.
     * @return Mat output from RGB_Threshold.
     */
    public Mat rgbThreshold2Output() {
        return rgbThreshold2Output;
    }

    /**
     * This method is a generated getter for the output of a Find_Contours.
     * @return ArrayList<MatOfPoint> output from Find_Contours.
     */
    public ArrayList<MatOfPoint> findContours2Output() {
        return findContours2Output;
    }


    /**
     * Segment an image based on color ranges.
     * @param input The image on which to perform the RGB threshold.
     * @param red The min and max red.
     * @param green The min and max green.
     * @param blue The min and max blue.
     * @param output The image in which to store the output.
     */
    private void rgbThreshold(Mat input, double[] red, double[] green, double[] blue,
                              Mat out) {
        Imgproc.cvtColor(input, out, Imgproc.COLOR_BGR2RGB);
        Core.inRange(out, new Scalar(red[0], green[0], blue[0]),
                new Scalar(red[1], green[1], blue[1]), out);
    }
    private void findContours(Mat input, boolean externalOnly,
                              List<MatOfPoint> contours) {
        Mat hierarchy = new Mat();
        contours.clear();
        int mode;
        if (externalOnly) {
            mode = Imgproc.RETR_EXTERNAL;
        }
        else {
            mode = Imgproc.RETR_LIST;
        }
        int method = Imgproc.CHAIN_APPROX_SIMPLE;
        Imgproc.findContours(input, contours, hierarchy, mode, method);
    }
}

