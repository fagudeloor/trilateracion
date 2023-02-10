package com.challenge.meli.trilateracion.api.operation;

import com.challenge.meli.trilateracion.api.model.dto.CalledHelpSatellitesDTO;
import com.challenge.meli.trilateracion.api.model.dto.LocationDTO;
import com.challenge.meli.trilateracion.api.model.dto.MainResponseDTO;
import com.challenge.meli.trilateracion.api.model.dto.SatelliteLocationsDTO;
import com.challenge.meli.trilateracion.api.services.exception.IncompleteComputeException;
import com.challenge.meli.trilateracion.api.services.exception.IncompleteMessageException;


public class ComputeTrilateration {

    private static double[][] positions   = new double[3][2];
    private static double[] distances = new double[3];

    public static MainResponseDTO computeTrilateration
            (CalledHelpSatellitesDTO callHelpSatellitesDTO, SatelliteLocationsDTO satelliteLocationsDTO){

        //preparo las distancias y las posiciones de los satelites
        getDistances(callHelpSatellitesDTO);
        getPositions(satelliteLocationsDTO);

        //Cargo la respuesta en el objeto retorno
        MainResponseDTO mainResponseDTO = new MainResponseDTO();
        mainResponseDTO.setLocationDTO(getPosition(getLocationByTrilateration()));
        mainResponseDTO.setMessage(getMessageResponse(callHelpSatellitesDTO));

        return mainResponseDTO;
    }

    private static String getMessageResponse(CalledHelpSatellitesDTO satellitesDTO) {

        String[] message = new String[satellitesDTO.getSatellites().get(0).getMessage().length];
        StringBuilder messageResponse = new StringBuilder();
        for (int i = 0; i < message.length; i++) {
            if(!satellitesDTO.getSatellites().get(0).getMessage()[i].isEmpty()){
                messageResponse.append(satellitesDTO.getSatellites().get(0).getMessage()[i]).append(" ");
            }else if(!satellitesDTO.getSatellites().get(1).getMessage()[i].isEmpty()){
                messageResponse.append(satellitesDTO.getSatellites().get(1).getMessage()[i]).append(" ");
            }else if(!satellitesDTO.getSatellites().get(2).getMessage()[i].isEmpty()) {
                messageResponse.append(satellitesDTO.getSatellites().get(2).getMessage()[i]).append(" ");
            }else {
                throw new IncompleteMessageException();
            }
        }
        return messageResponse.toString();
    }

    private static LocationDTO getPosition(double[] localizacion) {
        return new LocationDTO(localizacion[0], localizacion[1]);
    }

    private static void getDistances(CalledHelpSatellitesDTO calledHelpSatellitesDTO){
        try{
            for (int i = 0; i < 3; i++) {
                System.out.println(calledHelpSatellitesDTO.getSatellites().get(i).getName() + " distance " + calledHelpSatellitesDTO.getSatellites().get(i).getDistance());
                distances[i] = calledHelpSatellitesDTO.getSatellites().get(i).getDistance()/100000;
            }
        }catch(Exception e){
            throw new IncompleteComputeException();
        }
    }

    private static void getPositions(SatelliteLocationsDTO satelliteLocationsDTO){
        for (int i = 0; i <3; i++) {
            System.out.println(satelliteLocationsDTO.getSatellitesLocation().get(i).getName() + ", X " +
                    satelliteLocationsDTO.getSatellitesLocation().get(i).getPositionX() + ", Y " +
                    satelliteLocationsDTO.getSatellitesLocation().get(i).getPositionY());
            positions[i][0] = satelliteLocationsDTO.getSatellitesLocation().get(i).getPositionX();
            positions[i][1] = satelliteLocationsDTO.getSatellitesLocation().get(i).getPositionY();
        }

    }


    /**
     * Este método computa una ubicación especifica en un plano bidimencional a partir de la distancia de este a tres diferentes puntos
     * @return
     */
    private static double[] getLocationByTrilateration(){

        //Variables temporales para realizar el calculo
        double[] retorno = new double[2];
        double[] ex   = new double[2];
        double[] ey   = new double[2];
        double[] p3p1 = new double[2];
        double jval  = 0;
        double temp  = 0;
        double ival  = 0;
        double p3p1i = 0;
        double triptx;
        double xval;
        double yval;
        double t1;
        double t2;
        double t3;
        double t;
        double exx;
        double d;
        double eyy;

        for (int i=0; i<2; i++) {
            t1   = positions[1][i];
            t2   = positions[0][i];
            t    = t1 - t2;
            temp += (t*t);
        }
        d = Math.sqrt(temp);
        for (int i=0; i<2; i++) {
            t1    = positions[1][i];
            t2    = positions[0][i];
            exx   = (t1 - t2)/(Math.sqrt(temp));
            ex[i] = exx;
        }
        for (int i=0; i<2; i++) {
            t1      = positions[2][i];
            t2      = positions[0][i];
            t3      = t1 - t2;
            p3p1[i] = t3;
        }
        for (int i = 0; i < ex.length; i++) {
            t1 = ex[i];
            t2 = p3p1[i];
            ival += (t1*t2);
        }
        for (int i=0; i<2; i++) {
            t1 = positions[2][i];
            t2 = positions[0][i];
            t3 = ex[i] * ival;
            t  = t1 - t2 -t3;
            p3p1i += (t*t);
        }
        for (int i=0; i<2; i++) {
            t1 = positions[2][i];
            t2 = positions[0][i];
            t3 = ex[i] * ival;
            eyy = (t1 - t2 - t3)/Math.sqrt(p3p1i);
            ey[i] = eyy;
        }
        for (int i = 0; i < ey.length; i++) {
            t1 = ey[i];
            t2 = p3p1[i];
            jval += (t1*t2);
        }

        xval = (Math.pow(distances[0], 2) - Math.pow(distances[1], 2) + Math.pow(d, 2))/(2*d);
        yval = ((Math.pow(distances[0], 2) - Math.pow(distances[2], 2) + Math.pow(ival, 2) + Math.pow(jval, 2))/(2*jval)) - ((ival/jval)*xval);

        t1 = positions[0][0];
        System.out.println("posicion 1x = " + positions[0][0]);
        t2 = ex[0] * xval;
        t3 = ey[0] * yval;
        triptx = t1 + t2 + t3;
        retorno[0]=triptx;
        t1 = positions[0][1];
        System.out.println("posicion 1y = " + positions[0][1]);
        t2 = ex[1] * xval;
        t3 = ey[1] * yval;
        triptx = t1 + t2 + t3;
        retorno[1] = triptx;

        return retorno;
    }

}
