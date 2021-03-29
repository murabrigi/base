package hu.bme.mit.train.sensor;

import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainUser;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class TrainSensorTest {

    TrainController mockTrainController;
    TrainUser mockTrainUser;
    TrainSensorImpl trainSensor;


    @Before
    public void before() {
        mockTrainController = mock(TrainController.class);
        mockTrainUser = mock(TrainUser.class);
        trainSensor=new TrainSensorImpl(mockTrainController, mockTrainUser);
    }

    //@Test
    //public void ThisIsAnExampleTestStub() {
    //    // TODO Delete this and add test cases based on the issues
    //}

    @Test
    public void under_AbsoluteMargin_alarmOn(){
        trainSensor.overrideSpeedLimit(-1);
        verify(mockTrainUser, times(1)).setAlarmState(true);
    }

    @Test
    public void in_AbsoluteMargin_alarmOff(){
        trainSensor.overrideSpeedLimit(10);
        verify(mockTrainUser, times(1)).setAlarmState(false);
    }

    @Test
    public void over_AbsoluteMargin_alarmOn(){
        trainSensor.overrideSpeedLimit(510);
        verify(mockTrainUser, times(1)).setAlarmState(true);
    }


    @Test
    public void over_AbsoluteMargin_alarm(){
        trainSensor.overrideSpeedLimit(512);
        when(mockTrainUser.getAlarmState()).thenReturn(true);
    }

}
