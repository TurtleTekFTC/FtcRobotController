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
    //Outputs
    private Mat hsvThreshold0Output = new Mat();
    private ArrayList<MatOfPoint> findContours0Output = new ArrayList<MatOfPoint>();
    private Mat hsvThreshold1Output = new Mat();
    private ArrayList<MatOfPoint> findContours1Output = new ArrayList<MatOfPoint>();
    private Mat hsvThreshold2Output = new Mat();
    private ArrayList<MatOfPoint> findContours2Output = new ArrayList<MatOfPoint>();
    PossibilitiesForTheSignalSleeveToBe lastResult = PossibilitiesForTheSignalSleeveToBe.ZILCH;
    public enum PossibilitiesForTheSignalSleeveToBe {ONE, TWO, THREE, ZILCH}
    @Override
    public Mat processFrame(Mat source0)
    {
        Mat hsvThreshold0Input = source0;
        double[] hsvThreshold0Hue = {28.8135593220339, 52.340425531914896};
        double[] hsvThreshold0Saturation = {93.64406779661017, 193.96276595744678};
        double[] hsvThreshold0Value = {112.85310734463278, 182.6595744680851};
        hsvThreshold(hsvThreshold0Input, hsvThreshold0Hue, hsvThreshold0Saturation, hsvThreshold0Value, hsvThreshold0Output);

        // Step Find_Contours0:
        Mat findContours0Input = hsvThreshold0Output;
        boolean findContours0ExternalOnly = true;
        findContours(findContours0Input, findContours0ExternalOnly, findContours0Output);

        // Step HSV_Threshold1:
        Mat hsvThreshold1Input = source0;
        double[] hsvThreshold1Hue = {13.559322033898312, 20.425531914893632};
        double[] hsvThreshold1Saturation = {127.25988700564972, 200.7446808510638};
        double[] hsvThreshold1Value = {120.08427777372255, 202.75211645625654};
        hsvThreshold(hsvThreshold1Input, hsvThreshold1Hue, hsvThreshold1Saturation, hsvThreshold1Value, hsvThreshold1Output);

        // Step Find_Contours1:
        Mat findContours1Input = hsvThreshold1Output;
        boolean findContours1ExternalOnly = true;
        findContours(findContours1Input, findContours1ExternalOnly, findContours1Output);

        // Step HSV_Threshold2:
        Mat hsvThreshold2Input = source0;
        double[] hsvThreshold2Hue = {142.3705261290752, 169.82815324771926};
        double[] hsvThreshold2Saturation = {64.83050847457626, 162.31382978723406};
        double[] hsvThreshold2Value = {62.429378531073446, 200.74468085106383};
        hsvThreshold(hsvThreshold2Input, hsvThreshold2Hue, hsvThreshold2Saturation, hsvThreshold2Value, hsvThreshold2Output);

        // Step Find_Contours2:
        Mat findContours2Input = hsvThreshold2Output;
        boolean findContours2ExternalOnly = true;
        findContours(findContours2Input, findContours2ExternalOnly, findContours2Output);


        if(findContours0Output.size() > 0)
        {
            lastResult = PossibilitiesForTheSignalSleeveToBe.ONE;
        }
        else if(findContours1Output.size() > 0)
        {
            lastResult = PossibilitiesForTheSignalSleeveToBe.THREE;
        }
        else if(findContours2Output.size() > 0)
        {
            lastResult = PossibilitiesForTheSignalSleeveToBe.TWO;
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
//    public Mat rgbThreshold0Output() {
//        return rgbThreshold0Output;
//    }
//
//    /**
//     * This method is a generated getter for the output of a Find_Contours.
//     * @return ArrayList<MatOfPoint> output from Find_Contours.
//     */
    public ArrayList<MatOfPoint> findContours0Output() {
        return findContours0Output;
    }

    /**
     * This method is a generated getter for the output of a RGB_Threshold.
     * @return Mat output from RGB_Threshold.
     */
//    public Mat rgbThreshold1Output() {
//        return rgbThreshold1Output;
//    }

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
//    public Mat rgbThreshold2Output() {
//        return rgbThreshold2Output;
//    }

    /**
     * This method is a generated getter for the output of a Find_Contours.
     * @return ArrayList<MatOfPoint> output from Find_Contours.
     */
    public ArrayList<MatOfPoint> findContours2Output() {
        return findContours2Output;
    }

    /**
     * Segment an image based on hue, saturation, and value ranges.
     *
     * @param input The image on which to perform the HSL threshold.
     * @param hue The min and max hue
     * @param sat The min and max saturation
//     * @param val The min and max value
//     * @param output The image in which to store the output.
     */
    private void hsvThreshold(Mat input, double[] hue, double[] sat, double[] val,
                              Mat out) {
        Imgproc.cvtColor(input, out, Imgproc.COLOR_BGR2HSV);
        Core.inRange(out, new Scalar(hue[0], sat[0], val[0]),
                new Scalar(hue[1], sat[1], val[1]), out);
    }
    /**
     * Segment an image based on color ranges.
     * @param input The image on which to perform the RGB threshold.
     * @param red The min and max red.
     * @param green The min and max green.
     * @param blue The min and max blue.
     * @param blue The image in which to store the output.
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

