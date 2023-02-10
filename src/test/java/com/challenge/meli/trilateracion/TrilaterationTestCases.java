package com.challenge.meli.trilateracion;

import com.challenge.meli.trilateracion.api.model.dto.CalledHelpSatelliteDTO;
import com.challenge.meli.trilateracion.api.model.dto.CalledHelpSatellitesDTO;
import com.challenge.meli.trilateracion.api.model.dto.SatelliteLocationDTO;
import com.challenge.meli.trilateracion.api.model.dto.SatelliteLocationsDTO;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Test class which is initialized with different predefined test cases.
 * All test cases were defined by @author scott
 *
 * @author burfi
 */
public class TrilaterationTestCases {

    @Test
    public void trilaterationTest1(){
        CalledHelpSatellitesDTO calledHelpSatellitesDTO = new CalledHelpSatellitesDTO();
        List<CalledHelpSatelliteDTO> calledHelpSatelliteDTOList = new ArrayList<>();
        CalledHelpSatelliteDTO calledHelpSatelliteDTO1 = new CalledHelpSatelliteDTO();
        calledHelpSatelliteDTO1.setDistance(1.0);
        calledHelpSatelliteDTO1.setMessage(new String[]{"", "2", "3"});
        calledHelpSatelliteDTOList.add(calledHelpSatelliteDTO1);
        CalledHelpSatelliteDTO calledHelpSatelliteDTO2 = new CalledHelpSatelliteDTO();
        calledHelpSatelliteDTO2.setDistance(1.0);
        calledHelpSatelliteDTO2.setMessage(new String[]{"1", "", "3"});
        calledHelpSatelliteDTOList.add(calledHelpSatelliteDTO2);
        CalledHelpSatelliteDTO calledHelpSatelliteDTO3 = new CalledHelpSatelliteDTO();
        calledHelpSatelliteDTO3.setDistance(1.0);
        calledHelpSatelliteDTO3.setMessage(new String[]{"1", "2", ""});
        calledHelpSatelliteDTOList.add(calledHelpSatelliteDTO3);
        calledHelpSatellitesDTO.setSatellites(calledHelpSatelliteDTOList);

        SatelliteLocationsDTO satelliteLocationsDTO = new SatelliteLocationsDTO();
        List<SatelliteLocationDTO> satelliteLocationDTOList = new ArrayList<>();
        SatelliteLocationDTO satelliteLocationDTO1 = new SatelliteLocationDTO();
        satelliteLocationDTO1.setPositionX(1.0);
        satelliteLocationDTO1.setPositionY(1.0);
        satelliteLocationDTOList.add(satelliteLocationDTO1);
        SatelliteLocationDTO satelliteLocationDTO2 = new SatelliteLocationDTO();
        satelliteLocationDTO2.setPositionX(3.0);
        satelliteLocationDTO2.setPositionY(1.0);
        satelliteLocationDTOList.add(satelliteLocationDTO2);
        SatelliteLocationDTO satelliteLocationDTO3 = new SatelliteLocationDTO();
        satelliteLocationDTO3.setPositionX(2.0);
        satelliteLocationDTO3.setPositionY(2.0);
        satelliteLocationDTOList.add(satelliteLocationDTO3);
        satelliteLocationsDTO.setSatellitesLocation(satelliteLocationDTOList);

        double[] expectedPosition = new double[]{2.0, 1.0};
        double acceptedDelta = 0.0001;

        new TrilaterationTest(calledHelpSatellitesDTO, satelliteLocationsDTO, expectedPosition, acceptedDelta);
    }

    //@Test
    public void trilaterationTest2(){
        CalledHelpSatellitesDTO calledHelpSatellitesDTO = new CalledHelpSatellitesDTO();
        List<CalledHelpSatelliteDTO> calledHelpSatelliteDTOList = new ArrayList<>();
        CalledHelpSatelliteDTO calledHelpSatelliteDTO1 = new CalledHelpSatelliteDTO();
        calledHelpSatelliteDTO1.setDistance(Math.sqrt(2.0));
        calledHelpSatelliteDTO1.setMessage(new String[]{"", "2", "3"});
        calledHelpSatelliteDTOList.add(calledHelpSatelliteDTO1);
        CalledHelpSatelliteDTO calledHelpSatelliteDTO2 = new CalledHelpSatelliteDTO();
        calledHelpSatelliteDTO2.setDistance(1.0);
        calledHelpSatelliteDTO2.setMessage(new String[]{"1", "", "3"});
        calledHelpSatelliteDTOList.add(calledHelpSatelliteDTO2);
        CalledHelpSatelliteDTO calledHelpSatelliteDTO3 = new CalledHelpSatelliteDTO();
        calledHelpSatelliteDTO3.setDistance(1.0);
        calledHelpSatelliteDTO3.setMessage(new String[]{"1", "2", ""});
        calledHelpSatelliteDTOList.add(calledHelpSatelliteDTO3);
        calledHelpSatellitesDTO.setSatellites(calledHelpSatelliteDTOList);

        SatelliteLocationsDTO satelliteLocationsDTO = new SatelliteLocationsDTO();
        List<SatelliteLocationDTO> satelliteLocationDTOList = new ArrayList<>();
        SatelliteLocationDTO satelliteLocationDTO1 = new SatelliteLocationDTO();
        satelliteLocationDTO1.setPositionX(0.0);
        satelliteLocationDTO1.setPositionY(0.0);
        satelliteLocationDTOList.add(satelliteLocationDTO1);
        SatelliteLocationDTO satelliteLocationDTO2 = new SatelliteLocationDTO();
        satelliteLocationDTO2.setPositionX(-1.0);
        satelliteLocationDTO2.setPositionY(0.0);
        satelliteLocationDTOList.add(satelliteLocationDTO2);
        SatelliteLocationDTO satelliteLocationDTO3 = new SatelliteLocationDTO();
        satelliteLocationDTO3.setPositionX(0.0);
        satelliteLocationDTO3.setPositionY(-1.0);
        satelliteLocationDTOList.add(satelliteLocationDTO3);
        satelliteLocationsDTO.setSatellitesLocation(satelliteLocationDTOList);

        double[] expectedPosition = new double[]{-1.0, 11.0};
        double acceptedDelta = 0.0001;

        new TrilaterationTest(calledHelpSatellitesDTO, satelliteLocationsDTO, expectedPosition, acceptedDelta);
    }

    //@Test
    public void trilaterationTest3(){
        CalledHelpSatellitesDTO calledHelpSatellitesDTO = new CalledHelpSatellitesDTO();
        List<CalledHelpSatelliteDTO> calledHelpSatelliteDTOList = new ArrayList<>();
        CalledHelpSatelliteDTO calledHelpSatelliteDTO1 = new CalledHelpSatelliteDTO();
        calledHelpSatelliteDTO1.setDistance(Math.sqrt(2.0) * 1000.0);
        calledHelpSatelliteDTO1.setMessage(new String[]{"", "2", "3"});
        calledHelpSatelliteDTOList.add(calledHelpSatelliteDTO1);
        CalledHelpSatelliteDTO calledHelpSatelliteDTO2 = new CalledHelpSatelliteDTO();
        calledHelpSatelliteDTO2.setDistance(1000.0);
        calledHelpSatelliteDTO2.setMessage(new String[]{"1", "", "3"});
        calledHelpSatelliteDTOList.add(calledHelpSatelliteDTO2);
        CalledHelpSatelliteDTO calledHelpSatelliteDTO3 = new CalledHelpSatelliteDTO();
        calledHelpSatelliteDTO3.setDistance(1000.0);
        calledHelpSatelliteDTO3.setMessage(new String[]{"1", "2", ""});
        calledHelpSatelliteDTOList.add(calledHelpSatelliteDTO3);
        calledHelpSatellitesDTO.setSatellites(calledHelpSatelliteDTOList);

        SatelliteLocationsDTO satelliteLocationsDTO = new SatelliteLocationsDTO();
        List<SatelliteLocationDTO> satelliteLocationDTOList = new ArrayList<>();
        SatelliteLocationDTO satelliteLocationDTO1 = new SatelliteLocationDTO();
        satelliteLocationDTO1.setPositionX(0.0);
        satelliteLocationDTO1.setPositionY(0.0);
        satelliteLocationDTOList.add(satelliteLocationDTO1);
        SatelliteLocationDTO satelliteLocationDTO2 = new SatelliteLocationDTO();
        satelliteLocationDTO2.setPositionX(1000.0);
        satelliteLocationDTO2.setPositionY(0.0);
        satelliteLocationDTOList.add(satelliteLocationDTO2);
        SatelliteLocationDTO satelliteLocationDTO3 = new SatelliteLocationDTO();
        satelliteLocationDTO3.setPositionX(0.0);
        satelliteLocationDTO3.setPositionY(1000.0);
        satelliteLocationDTOList.add(satelliteLocationDTO3);
        satelliteLocationsDTO.setSatellitesLocation(satelliteLocationDTOList);

        double[] expectedPosition = new double[]{1000.0, 1000.0};
        double acceptedDelta = 0.0001;

        new TrilaterationTest(calledHelpSatellitesDTO, satelliteLocationsDTO, expectedPosition, acceptedDelta);
    }

    //@Test
    public void trilaterationTest4(){
        CalledHelpSatellitesDTO calledHelpSatellitesDTO = new CalledHelpSatellitesDTO();
        List<CalledHelpSatelliteDTO> calledHelpSatelliteDTOList = new ArrayList<>();
        CalledHelpSatelliteDTO calledHelpSatelliteDTO1 = new CalledHelpSatelliteDTO();
        calledHelpSatelliteDTO1.setDistance(8.06);
        calledHelpSatelliteDTO1.setMessage(new String[]{"", "2", "3"});
        calledHelpSatelliteDTOList.add(calledHelpSatelliteDTO1);
        CalledHelpSatelliteDTO calledHelpSatelliteDTO2 = new CalledHelpSatelliteDTO();
        calledHelpSatelliteDTO2.setDistance(13.97);
        calledHelpSatelliteDTO2.setMessage(new String[]{"1", "", "3"});
        calledHelpSatelliteDTOList.add(calledHelpSatelliteDTO2);
        CalledHelpSatelliteDTO calledHelpSatelliteDTO3 = new CalledHelpSatelliteDTO();
        calledHelpSatelliteDTO3.setDistance(23.32);
        calledHelpSatelliteDTO3.setMessage(new String[]{"1", "2", ""});
        calledHelpSatelliteDTOList.add(calledHelpSatelliteDTO3);
        calledHelpSatellitesDTO.setSatellites(calledHelpSatelliteDTOList);

        SatelliteLocationsDTO satelliteLocationsDTO = new SatelliteLocationsDTO();
        List<SatelliteLocationDTO> satelliteLocationDTOList = new ArrayList<>();
        SatelliteLocationDTO satelliteLocationDTO1 = new SatelliteLocationDTO();
        satelliteLocationDTO1.setPositionX(5.0);
        satelliteLocationDTO1.setPositionY(-6.0);
        satelliteLocationDTOList.add(satelliteLocationDTO1);
        SatelliteLocationDTO satelliteLocationDTO2 = new SatelliteLocationDTO();
        satelliteLocationDTO2.setPositionX(13.0);
        satelliteLocationDTO2.setPositionY(-15.0);
        satelliteLocationDTOList.add(satelliteLocationDTO2);
        SatelliteLocationDTO satelliteLocationDTO3 = new SatelliteLocationDTO();
        satelliteLocationDTO3.setPositionX(21.0);
        satelliteLocationDTO3.setPositionY(-3.0);
        satelliteLocationDTOList.add(satelliteLocationDTO3);
        satelliteLocationsDTO.setSatellitesLocation(satelliteLocationDTOList);

        double[] expectedPosition = new double[]{-0.6, -11.8};
        double acceptedDelta = 0.0001;

        new TrilaterationTest(calledHelpSatellitesDTO, satelliteLocationsDTO, expectedPosition, acceptedDelta);
    }

    @Test
    public void trilaterationTest5(){
        CalledHelpSatellitesDTO calledHelpSatellitesDTO = new CalledHelpSatellitesDTO();
        List<CalledHelpSatelliteDTO> calledHelpSatelliteDTOList = new ArrayList<>();
        CalledHelpSatelliteDTO calledHelpSatelliteDTO1 = new CalledHelpSatelliteDTO();
        calledHelpSatelliteDTO1.setDistance(0.9);
        calledHelpSatelliteDTO1.setMessage(new String[]{"", "2", "3"});
        calledHelpSatelliteDTOList.add(calledHelpSatelliteDTO1);
        CalledHelpSatelliteDTO calledHelpSatelliteDTO2 = new CalledHelpSatelliteDTO();
        calledHelpSatelliteDTO2.setDistance(1.0);
        calledHelpSatelliteDTO2.setMessage(new String[]{"1", "", "3"});
        calledHelpSatelliteDTOList.add(calledHelpSatelliteDTO2);
        CalledHelpSatelliteDTO calledHelpSatelliteDTO3 = new CalledHelpSatelliteDTO();
        calledHelpSatelliteDTO3.setDistance(1.0);
        calledHelpSatelliteDTO3.setMessage(new String[]{"1", "2", ""});
        calledHelpSatelliteDTOList.add(calledHelpSatelliteDTO3);
        calledHelpSatellitesDTO.setSatellites(calledHelpSatelliteDTOList);

        SatelliteLocationsDTO satelliteLocationsDTO = new SatelliteLocationsDTO();
        List<SatelliteLocationDTO> satelliteLocationDTOList = new ArrayList<>();
        SatelliteLocationDTO satelliteLocationDTO1 = new SatelliteLocationDTO();
        satelliteLocationDTO1.setPositionX(1.0);
        satelliteLocationDTO1.setPositionY(1.0);
        satelliteLocationDTOList.add(satelliteLocationDTO1);
        SatelliteLocationDTO satelliteLocationDTO2 = new SatelliteLocationDTO();
        satelliteLocationDTO2.setPositionX(3.0);
        satelliteLocationDTO2.setPositionY(1.0);
        satelliteLocationDTOList.add(satelliteLocationDTO2);
        SatelliteLocationDTO satelliteLocationDTO3 = new SatelliteLocationDTO();
        satelliteLocationDTO3.setPositionX(2.0);
        satelliteLocationDTO3.setPositionY(2.0);
        satelliteLocationDTOList.add(satelliteLocationDTO3);
        satelliteLocationsDTO.setSatellitesLocation(satelliteLocationDTOList);

        double[] expectedPosition = new double[]{2.0, 1.0};
        double acceptedDelta = 0.1;

        new TrilaterationTest(calledHelpSatellitesDTO, satelliteLocationsDTO, expectedPosition, acceptedDelta);
    }

    @Test
    public void trilaterationTest6(){
        CalledHelpSatellitesDTO calledHelpSatellitesDTO = new CalledHelpSatellitesDTO();
        List<CalledHelpSatelliteDTO> calledHelpSatelliteDTOList = new ArrayList<>();
        CalledHelpSatelliteDTO calledHelpSatelliteDTO1 = new CalledHelpSatelliteDTO();
        calledHelpSatelliteDTO1.setDistance(0.5);
        calledHelpSatelliteDTO1.setMessage(new String[]{"", "2", "3"});
        calledHelpSatelliteDTOList.add(calledHelpSatelliteDTO1);
        CalledHelpSatelliteDTO calledHelpSatelliteDTO2 = new CalledHelpSatelliteDTO();
        calledHelpSatelliteDTO2.setDistance(0.5);
        calledHelpSatelliteDTO2.setMessage(new String[]{"1", "", "3"});
        calledHelpSatelliteDTOList.add(calledHelpSatelliteDTO2);
        CalledHelpSatelliteDTO calledHelpSatelliteDTO3 = new CalledHelpSatelliteDTO();
        calledHelpSatelliteDTO3.setDistance(0.5);
        calledHelpSatelliteDTO3.setMessage(new String[]{"1", "2", ""});
        calledHelpSatelliteDTOList.add(calledHelpSatelliteDTO3);
        calledHelpSatellitesDTO.setSatellites(calledHelpSatelliteDTOList);

        SatelliteLocationsDTO satelliteLocationsDTO = new SatelliteLocationsDTO();
        List<SatelliteLocationDTO> satelliteLocationDTOList = new ArrayList<>();
        SatelliteLocationDTO satelliteLocationDTO1 = new SatelliteLocationDTO();
        satelliteLocationDTO1.setPositionX(1.0);
        satelliteLocationDTO1.setPositionY(1.0);
        satelliteLocationDTOList.add(satelliteLocationDTO1);
        SatelliteLocationDTO satelliteLocationDTO2 = new SatelliteLocationDTO();
        satelliteLocationDTO2.setPositionX(3.0);
        satelliteLocationDTO2.setPositionY(1.0);
        satelliteLocationDTOList.add(satelliteLocationDTO2);
        SatelliteLocationDTO satelliteLocationDTO3 = new SatelliteLocationDTO();
        satelliteLocationDTO3.setPositionX(2.0);
        satelliteLocationDTO3.setPositionY(2.0);
        satelliteLocationDTOList.add(satelliteLocationDTO3);
        satelliteLocationsDTO.setSatellitesLocation(satelliteLocationDTOList);

        double[] expectedPosition = new double[]{2.0, 1.0};
        double acceptedDelta = 0.25;

        new TrilaterationTest(calledHelpSatellitesDTO, satelliteLocationsDTO, expectedPosition, acceptedDelta);
    }

    @Test
    public void trilaterationTest7(){
        CalledHelpSatellitesDTO calledHelpSatellitesDTO = new CalledHelpSatellitesDTO();
        List<CalledHelpSatelliteDTO> calledHelpSatelliteDTOList = new ArrayList<>();
        CalledHelpSatelliteDTO calledHelpSatelliteDTO1 = new CalledHelpSatelliteDTO();
        calledHelpSatelliteDTO1.setDistance(2.0);
        calledHelpSatelliteDTO1.setMessage(new String[]{"", "2", "3"});
        calledHelpSatelliteDTOList.add(calledHelpSatelliteDTO1);
        CalledHelpSatelliteDTO calledHelpSatelliteDTO2 = new CalledHelpSatelliteDTO();
        calledHelpSatelliteDTO2.setDistance(2.0);
        calledHelpSatelliteDTO2.setMessage(new String[]{"1", "", "3"});
        calledHelpSatelliteDTOList.add(calledHelpSatelliteDTO2);
        CalledHelpSatelliteDTO calledHelpSatelliteDTO3 = new CalledHelpSatelliteDTO();
        calledHelpSatelliteDTO3.setDistance(2.0);
        calledHelpSatelliteDTO3.setMessage(new String[]{"1", "2", ""});
        calledHelpSatelliteDTOList.add(calledHelpSatelliteDTO3);
        calledHelpSatellitesDTO.setSatellites(calledHelpSatelliteDTOList);

        SatelliteLocationsDTO satelliteLocationsDTO = new SatelliteLocationsDTO();
        List<SatelliteLocationDTO> satelliteLocationDTOList = new ArrayList<>();
        SatelliteLocationDTO satelliteLocationDTO1 = new SatelliteLocationDTO();
        satelliteLocationDTO1.setPositionX(1.0);
        satelliteLocationDTO1.setPositionY(1.0);
        satelliteLocationDTOList.add(satelliteLocationDTO1);
        SatelliteLocationDTO satelliteLocationDTO2 = new SatelliteLocationDTO();
        satelliteLocationDTO2.setPositionX(3.0);
        satelliteLocationDTO2.setPositionY(1.0);
        satelliteLocationDTOList.add(satelliteLocationDTO2);
        SatelliteLocationDTO satelliteLocationDTO3 = new SatelliteLocationDTO();
        satelliteLocationDTO3.setPositionX(2.0);
        satelliteLocationDTO3.setPositionY(2.0);
        satelliteLocationDTOList.add(satelliteLocationDTO3);
        satelliteLocationsDTO.setSatellitesLocation(satelliteLocationDTOList);

        double[] expectedPosition = new double[]{2.0, 1.0};
        double acceptedDelta = 2.0;

        new TrilaterationTest(calledHelpSatellitesDTO, satelliteLocationsDTO, expectedPosition, acceptedDelta);
    }

    //@Test
    public void trilaterationTest8(){
        CalledHelpSatellitesDTO calledHelpSatellitesDTO = new CalledHelpSatellitesDTO();
        List<CalledHelpSatelliteDTO> calledHelpSatelliteDTOList = new ArrayList<>();
        CalledHelpSatelliteDTO calledHelpSatelliteDTO1 = new CalledHelpSatelliteDTO();
        calledHelpSatelliteDTO1.setDistance(1.0);
        calledHelpSatelliteDTO1.setMessage(new String[]{"", "2", "3"});
        calledHelpSatelliteDTOList.add(calledHelpSatelliteDTO1);
        CalledHelpSatelliteDTO calledHelpSatelliteDTO2 = new CalledHelpSatelliteDTO();
        calledHelpSatelliteDTO2.setDistance(1.0);
        calledHelpSatelliteDTO2.setMessage(new String[]{"1", "", "3"});
        calledHelpSatelliteDTOList.add(calledHelpSatelliteDTO2);
        CalledHelpSatelliteDTO calledHelpSatelliteDTO3 = new CalledHelpSatelliteDTO();
        calledHelpSatelliteDTO3.setDistance(1.0);
        calledHelpSatelliteDTO3.setMessage(new String[]{"1", "2", ""});
        calledHelpSatelliteDTOList.add(calledHelpSatelliteDTO3);
        calledHelpSatellitesDTO.setSatellites(calledHelpSatelliteDTOList);

        SatelliteLocationsDTO satelliteLocationsDTO = new SatelliteLocationsDTO();
        List<SatelliteLocationDTO> satelliteLocationDTOList = new ArrayList<>();
        SatelliteLocationDTO satelliteLocationDTO1 = new SatelliteLocationDTO();
        satelliteLocationDTO1.setPositionX(1.0);
        satelliteLocationDTO1.setPositionY(1.0);
        satelliteLocationDTOList.add(satelliteLocationDTO1);
        SatelliteLocationDTO satelliteLocationDTO2 = new SatelliteLocationDTO();
        satelliteLocationDTO2.setPositionX(1.0);
        satelliteLocationDTO2.setPositionY(1.0);
        satelliteLocationDTOList.add(satelliteLocationDTO2);
        SatelliteLocationDTO satelliteLocationDTO3 = new SatelliteLocationDTO();
        satelliteLocationDTO3.setPositionX(3.0);
        satelliteLocationDTO3.setPositionY(1.0);
        satelliteLocationDTOList.add(satelliteLocationDTO3);
        satelliteLocationsDTO.setSatellitesLocation(satelliteLocationDTOList);

        double[] expectedPosition = new double[]{2.0, 1.0};
        double acceptedDelta = 0.5;

        new TrilaterationTest(calledHelpSatellitesDTO, satelliteLocationsDTO, expectedPosition, acceptedDelta);
    }

    //@Test
    public void trilaterationTest9(){
        CalledHelpSatellitesDTO calledHelpSatellitesDTO = new CalledHelpSatellitesDTO();
        List<CalledHelpSatelliteDTO> calledHelpSatelliteDTOList = new ArrayList<>();
        CalledHelpSatelliteDTO calledHelpSatelliteDTO1 = new CalledHelpSatelliteDTO();
        calledHelpSatelliteDTO1.setDistance(1.0);
        calledHelpSatelliteDTO1.setMessage(new String[]{"", "2", "3"});
        calledHelpSatelliteDTOList.add(calledHelpSatelliteDTO1);
        CalledHelpSatelliteDTO calledHelpSatelliteDTO2 = new CalledHelpSatelliteDTO();
        calledHelpSatelliteDTO2.setDistance(1.0);
        calledHelpSatelliteDTO2.setMessage(new String[]{"1", "", "3"});
        calledHelpSatelliteDTOList.add(calledHelpSatelliteDTO2);
        CalledHelpSatelliteDTO calledHelpSatelliteDTO3 = new CalledHelpSatelliteDTO();
        calledHelpSatelliteDTO3.setDistance(1.0);
        calledHelpSatelliteDTO3.setMessage(new String[]{"1", "2", ""});
        calledHelpSatelliteDTOList.add(calledHelpSatelliteDTO3);
        calledHelpSatellitesDTO.setSatellites(calledHelpSatelliteDTOList);

        SatelliteLocationsDTO satelliteLocationsDTO = new SatelliteLocationsDTO();
        List<SatelliteLocationDTO> satelliteLocationDTOList = new ArrayList<>();
        SatelliteLocationDTO satelliteLocationDTO1 = new SatelliteLocationDTO();
        satelliteLocationDTO1.setPositionX(1.0);
        satelliteLocationDTO1.setPositionY(1.0);
        satelliteLocationDTOList.add(satelliteLocationDTO1);
        SatelliteLocationDTO satelliteLocationDTO2 = new SatelliteLocationDTO();
        satelliteLocationDTO2.setPositionX(1.0);
        satelliteLocationDTO2.setPositionY(1.0);
        satelliteLocationDTOList.add(satelliteLocationDTO2);
        SatelliteLocationDTO satelliteLocationDTO3 = new SatelliteLocationDTO();
        satelliteLocationDTO3.setPositionX(1.0);
        satelliteLocationDTO3.setPositionY(1.0);
        satelliteLocationDTOList.add(satelliteLocationDTO3);
        satelliteLocationsDTO.setSatellitesLocation(satelliteLocationDTOList);

        double[] expectedPosition = new double[]{2.0, 1.0};
        double acceptedDelta = 0.5;

        new TrilaterationTest(calledHelpSatellitesDTO, satelliteLocationsDTO, expectedPosition, acceptedDelta);
    }
}
