package com.challenge.meli.trilateracion;

import com.challenge.meli.trilateracion.api.model.dto.CalledHelpSatellitesDTO;
import com.challenge.meli.trilateracion.api.model.dto.MainResponseDTO;
import com.challenge.meli.trilateracion.api.model.dto.SatelliteLocationsDTO;
import com.challenge.meli.trilateracion.api.operation.ComputeTrilateration;
import org.apache.commons.math3.fitting.leastsquares.LeastSquaresOptimizer.Optimum;
import org.apache.commons.math3.linear.RealVector;

import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * Test class which is initialized with different predefined test cases.
 * Test was refactored from @author scott
 *
 * @author burfi
 */
public class TrilaterationTest {

    CalledHelpSatellitesDTO calledHelpSatellitesDTO;
    SatelliteLocationsDTO satelliteLocationsDTO;
    MainResponseDTO mainResponseDTO;
    private double[] expectedPosition;
    private double acceptedDelta;
    private StringBuilder output;

    private RealVector linearCalculatedPosition;
    private Optimum nonLinearOptimum;

    public TrilaterationTest(CalledHelpSatellitesDTO calledHelpSatellitesDTO, SatelliteLocationsDTO satelliteLocationsDTO,
                             double[] expectedPosition, double acceptedDelta) {
        this.calledHelpSatellitesDTO = calledHelpSatellitesDTO;
        this.satelliteLocationsDTO = satelliteLocationsDTO;
        this.expectedPosition = expectedPosition;
        this.acceptedDelta = acceptedDelta;
        mainResponseDTO = ComputeTrilateration.computeTrilateration(calledHelpSatellitesDTO, satelliteLocationsDTO);
        outputResult();
        compareExpectedAndCalculatedResults();
    }

    private void outputResult() {
        System.out.println("Resultado esperado: " + expectedPosition[0] + ", " + expectedPosition[1]);
        System.out.println("Resultado obtenido: " + mainResponseDTO.getLocationDTO().getPositionX()
                + ", " + mainResponseDTO.getLocationDTO().getPositionY());
    }

    private void compareExpectedAndCalculatedResults() {
        double[] calculatedPosition = new double[]{
                mainResponseDTO.getLocationDTO().getPositionX(), mainResponseDTO.getLocationDTO().getPositionY()
        };

        for (int i = 0; i < calculatedPosition.length; i++) {
            assertEquals(expectedPosition[i], calculatedPosition[i], acceptedDelta);
        }
    }

    private void printDoubleArray(String tag, double[] values) {
        output.append(tag);
        for (double p : values) {
            output.append(p).append(" ");
        }
        output.append("\n");
    }
}