package swisseph;

/**
* This class implements some constants and methods used by
* different TransitCalculators.<p>
* You normally don't use this class in your own programs.
*/
class TransitBase
    implements java.io.Serializable
    {
  static final double B0_ARMC_MAX = 360.986667;
  static final double B0_ARMC_MIN = 360.984167;
  static final double B0_ASC_MAX = 393.494420;
  static final double B0_ASC_MIN = 331.162937;
  static final double B0_COASC1_MAX = 394.215000;
  static final double B0_COASC1_MIN = 330.556667;
  static final double B0_COASC2_MAX = 0.000000;
  static final double B0_COASC2_MIN = 0.000000;
  static final double B0_EQUASC_MAX = 394.215000;
  static final double B0_EQUASC_MIN = 330.556667;
  static final double B0_HOUSE10_MAX = 394.215000;
  static final double B0_HOUSE10_MIN = 330.556667;
  static final double B0_HOUSE11_MAX = 394.215000;
  static final double B0_HOUSE11_MIN = 330.556667;
  static final double B0_HOUSE12_MAX = 394.215000;
  static final double B0_HOUSE12_MIN = 330.556667;
  static final double B0_HOUSE1_MAX = 394.215000;
  static final double B0_HOUSE1_MIN = 330.556667;
  static final double B0_HOUSE2_MAX = 394.215000;
  static final double B0_HOUSE2_MIN = 330.556667;
  static final double B0_HOUSE3_MAX = 394.215000;
  static final double B0_HOUSE3_MIN = 330.556667;
  static final double B0_HOUSE4_MAX = 394.215000;
  static final double B0_HOUSE4_MIN = 330.556667;
  static final double B0_HOUSE5_MAX = 394.215000;
  static final double B0_HOUSE5_MIN = 330.556667;
  static final double B0_HOUSE6_MAX = 394.215000;
  static final double B0_HOUSE6_MIN = 330.556667;
  static final double B0_HOUSE7_MAX = 394.215000;
  static final double B0_HOUSE7_MIN = 330.556667;
  static final double B0_HOUSE8_MAX = 394.215000;
  static final double B0_HOUSE8_MIN = 330.556667;
  static final double B0_HOUSE9_MAX = 394.215000;
  static final double B0_HOUSE9_MIN = 330.556667;
  static final double B0_MC_MAX = 394.215000;
  static final double B0_MC_MIN = 330.556667;
  static final double B0_POLASC_MAX = 394.215000;
  static final double B0_POLASC_MIN = 330.556667;
  static final double B0_VERTEX_MAX = 1500000.000000;
  static final double B0_VERTEX_MIN = 0.000000;
  static final double B10_ARMC_MAX = 360.986667;
  static final double B10_ARMC_MIN = 360.984167;
  static final double B10_ASC_MAX = 426.089536;
  static final double B10_ASC_MIN = 328.169552;
  static final double B10_COASC1_MAX = 427.276667;
  static final double B10_COASC1_MIN = 327.558333;
  static final double B10_COASC2_MAX = 2999820.000000;
  static final double B10_COASC2_MIN = -180.000000;
  static final double B10_EQUASC_MAX = 394.215000;
  static final double B10_EQUASC_MIN = 330.556667;
  static final double B10_HOUSE10_MAX = 394.215000;
  static final double B10_HOUSE10_MIN = 330.556667;
  static final double B10_HOUSE11_MAX = 399.389167;
  static final double B10_HOUSE11_MIN = 323.490000;
  static final double B10_HOUSE12_MAX = 413.363333;
  static final double B10_HOUSE12_MIN = 321.252500;
  static final double B10_HOUSE1_MAX = 427.276667;
  static final double B10_HOUSE1_MIN = 327.558333;
  static final double B10_HOUSE2_MAX = 413.363333;
  static final double B10_HOUSE2_MIN = 321.252500;
  static final double B10_HOUSE3_MAX = 399.389167;
  static final double B10_HOUSE3_MIN = 323.490000;
  static final double B10_HOUSE4_MAX = 394.215000;
  static final double B10_HOUSE4_MIN = 330.556667;
  static final double B10_HOUSE5_MAX = 399.389167;
  static final double B10_HOUSE5_MIN = 323.490000;
  static final double B10_HOUSE6_MAX = 413.363333;
  static final double B10_HOUSE6_MIN = 321.252500;
  static final double B10_HOUSE7_MAX = 427.276667;
  static final double B10_HOUSE7_MIN = 327.558333;
  static final double B10_HOUSE8_MAX = 413.363333;
  static final double B10_HOUSE8_MIN = 321.252500;
  static final double B10_HOUSE9_MAX = 399.389167;
  static final double B10_HOUSE9_MIN = 323.490000;
  static final double B10_MC_MAX = 394.215000;
  static final double B10_MC_MIN = 330.556667;
  static final double B10_POLASC_MAX = 427.276667;
  static final double B10_POLASC_MIN = 327.558333;
  static final double B10_VERTEX_MAX = 2999820.000000;
  static final double B10_VERTEX_MIN = -180.000000;
  static final double B20_ARMC_MAX = 360.986667;
  static final double B20_ARMC_MIN = 360.984167;
  static final double B20_ASC_MAX = 467.280896;
  static final double B20_ASC_MIN = 319.225068;
  static final double B20_COASC1_MAX = 469.147500;
  static final double B20_COASC1_MIN = 318.595833;
  static final double B20_COASC2_MAX = 2999819.999167;
  static final double B20_COASC2_MIN = -180.000000;
  static final double B20_EQUASC_MAX = 394.215000;
  static final double B20_EQUASC_MIN = 330.556667;
  static final double B20_HOUSE10_MAX = 394.215000;
  static final double B20_HOUSE10_MIN = 330.556667;
  static final double B20_HOUSE11_MAX = 405.299167;
  static final double B20_HOUSE11_MIN = 316.684167;
  static final double B20_HOUSE12_MAX = 437.906667;
  static final double B20_HOUSE12_MIN = 310.512500;
  static final double B20_HOUSE1_MAX = 469.147500;
  static final double B20_HOUSE1_MIN = 318.595833;
  static final double B20_HOUSE2_MAX = 437.906667;
  static final double B20_HOUSE2_MIN = 310.512500;
  static final double B20_HOUSE3_MAX = 405.299167;
  static final double B20_HOUSE3_MIN = 316.684167;
  static final double B20_HOUSE4_MAX = 394.215000;
  static final double B20_HOUSE4_MIN = 330.556667;
  static final double B20_HOUSE5_MAX = 405.299167;
  static final double B20_HOUSE5_MIN = 316.684167;
  static final double B20_HOUSE6_MAX = 437.906667;
  static final double B20_HOUSE6_MIN = 310.512500;
  static final double B20_HOUSE7_MAX = 469.147500;
  static final double B20_HOUSE7_MIN = 318.595833;
  static final double B20_HOUSE8_MAX = 437.906667;
  static final double B20_HOUSE8_MIN = 310.512500;
  static final double B20_HOUSE9_MAX = 405.299167;
  static final double B20_HOUSE9_MIN = 316.684167;
  static final double B20_MC_MAX = 394.215000;
  static final double B20_MC_MIN = 330.556667;
  static final double B20_POLASC_MAX = 469.147500;
  static final double B20_POLASC_MIN = 318.595833;
  static final double B20_VERTEX_MAX = 2999819.999167;
  static final double B20_VERTEX_MIN = -180.000000;
  static final double B30_ARMC_MAX = 360.986667;
  static final double B30_ARMC_MIN = 360.984167;
  static final double B30_ASC_MAX = 524.994891;
  static final double B30_ASC_MIN = 304.407972;
  static final double B30_COASC1_MAX = 527.985000;
  static final double B30_COASC1_MIN = 303.743333;
  static final double B30_COASC2_MAX = 1643.109167;
  static final double B30_COASC2_MIN = 218.980000;
  static final double B30_EQUASC_MAX = 394.215000;
  static final double B30_EQUASC_MIN = 330.556667;
  static final double B30_HOUSE10_MAX = 394.215000;
  static final double B30_HOUSE10_MIN = 330.556667;
  static final double B30_HOUSE11_MAX = 413.281667;
  static final double B30_HOUSE11_MIN = 309.792500;
  static final double B30_HOUSE12_MAX = 473.058333;
  static final double B30_HOUSE12_MIN = 298.329167;
  static final double B30_HOUSE1_MAX = 527.985000;
  static final double B30_HOUSE1_MIN = 303.743333;
  static final double B30_HOUSE2_MAX = 473.058333;
  static final double B30_HOUSE2_MIN = 298.328333;
  static final double B30_HOUSE3_MAX = 413.281667;
  static final double B30_HOUSE3_MIN = 309.792500;
  static final double B30_HOUSE4_MAX = 394.215000;
  static final double B30_HOUSE4_MIN = 330.556667;
  static final double B30_HOUSE5_MAX = 413.281667;
  static final double B30_HOUSE5_MIN = 309.792500;
  static final double B30_HOUSE6_MAX = 473.058333;
  static final double B30_HOUSE6_MIN = 298.329167;
  static final double B30_HOUSE7_MAX = 527.985000;
  static final double B30_HOUSE7_MIN = 303.743333;
  static final double B30_HOUSE8_MAX = 473.058333;
  static final double B30_HOUSE8_MIN = 298.328333;
  static final double B30_HOUSE9_MAX = 413.281667;
  static final double B30_HOUSE9_MIN = 309.792500;
  static final double B30_MC_MAX = 394.215000;
  static final double B30_MC_MIN = 330.556667;
  static final double B30_POLASC_MAX = 527.985000;
  static final double B30_POLASC_MIN = 303.743333;
  static final double B30_VERTEX_MAX = 1643.108333;
  static final double B30_VERTEX_MIN = 218.980000;
  static final double B40_ARMC_MAX = 360.986667;
  static final double B40_ARMC_MIN = 360.984167;
  static final double B40_ASC_MAX = 618.738596;
  static final double B40_ASC_MIN = 283.720808;
  static final double B40_COASC1_MAX = 623.978333;
  static final double B40_COASC1_MIN = 282.993333;
  static final double B40_COASC2_MAX = 826.410833;
  static final double B40_COASC2_MIN = 255.830833;
  static final double B40_EQUASC_MAX = 394.215000;
  static final double B40_EQUASC_MIN = 330.556667;
  static final double B40_HOUSE10_MAX = 394.215000;
  static final double B40_HOUSE10_MIN = 330.556667;
  static final double B40_HOUSE11_MAX = 428.438333;
  static final double B40_HOUSE11_MIN = 302.411667;
  static final double B40_HOUSE12_MAX = 531.760000;
  static final double B40_HOUSE12_MIN = 284.177500;
  static final double B40_HOUSE1_MAX = 623.978333;
  static final double B40_HOUSE1_MIN = 282.993333;
  static final double B40_HOUSE2_MAX = 531.760000;
  static final double B40_HOUSE2_MIN = 284.177500;
  static final double B40_HOUSE3_MAX = 428.438333;
  static final double B40_HOUSE3_MIN = 302.411667;
  static final double B40_HOUSE4_MAX = 394.215000;
  static final double B40_HOUSE4_MIN = 330.556667;
  static final double B40_HOUSE5_MAX = 428.438333;
  static final double B40_HOUSE5_MIN = 302.411667;
  static final double B40_HOUSE6_MAX = 531.760000;
  static final double B40_HOUSE6_MIN = 284.177500;
  static final double B40_HOUSE7_MAX = 623.978333;
  static final double B40_HOUSE7_MIN = 282.993333;
  static final double B40_HOUSE8_MAX = 531.760000;
  static final double B40_HOUSE8_MIN = 284.177500;
  static final double B40_HOUSE9_MAX = 428.438333;
  static final double B40_HOUSE9_MIN = 302.411667;
  static final double B40_MC_MAX = 394.215000;
  static final double B40_MC_MIN = 330.556667;
  static final double B40_POLASC_MAX = 623.978333;
  static final double B40_POLASC_MIN = 282.993333;
  static final double B40_VERTEX_MAX = 826.410833;
  static final double B40_VERTEX_MIN = 255.830833;
  static final double B50_ARMC_MAX = 360.986667;
  static final double B50_ARMC_MIN = 360.984167;
  static final double B50_ASC_MAX = 814.745889;
  static final double B50_ASC_MIN = 256.684961;
  static final double B50_COASC1_MAX = 826.410833;
  static final double B50_COASC1_MIN = 255.830833;
  static final double B50_COASC2_MAX = 623.978333;
  static final double B50_COASC2_MIN = 282.993333;
  static final double B50_EQUASC_MAX = 394.215000;
  static final double B50_EQUASC_MIN = 330.556667;
  static final double B50_HOUSE10_MAX = 394.215000;
  static final double B50_HOUSE10_MIN = 330.556667;
  static final double B50_HOUSE11_MAX = 476.782500;
  static final double B50_HOUSE11_MIN = 293.994167;
  static final double B50_HOUSE12_MAX = 658.338333;
  static final double B50_HOUSE12_MIN = 266.850000;
  static final double B50_HOUSE1_MAX = 826.410833;
  static final double B50_HOUSE1_MIN = 255.830833;
  static final double B50_HOUSE2_MAX = 658.338333;
  static final double B50_HOUSE2_MIN = 266.850000;
  static final double B50_HOUSE3_MAX = 476.782500;
  static final double B50_HOUSE3_MIN = 293.994167;
  static final double B50_HOUSE4_MAX = 394.215000;
  static final double B50_HOUSE4_MIN = 330.556667;
  static final double B50_HOUSE5_MAX = 476.782500;
  static final double B50_HOUSE5_MIN = 293.994167;
  static final double B50_HOUSE6_MAX = 658.338333;
  static final double B50_HOUSE6_MIN = 266.850000;
  static final double B50_HOUSE7_MAX = 826.410833;
  static final double B50_HOUSE7_MIN = 255.830833;
  static final double B50_HOUSE8_MAX = 658.338333;
  static final double B50_HOUSE8_MIN = 266.850000;
  static final double B50_HOUSE9_MAX = 476.782500;
  static final double B50_HOUSE9_MIN = 293.994167;
  static final double B50_MC_MAX = 394.215000;
  static final double B50_MC_MIN = 330.556667;
  static final double B50_POLASC_MAX = 826.410833;
  static final double B50_POLASC_MIN = 255.830833;
  static final double B50_VERTEX_MAX = 623.978333;
  static final double B50_VERTEX_MIN = 282.993333;
  static final double B60_ARMC_MAX = 360.986667;
  static final double B60_ARMC_MIN = 360.984167;
  static final double B60_ASC_MAX = 1583.084164;
  static final double B60_ASC_MIN = 220.207028;
  static final double B60_COASC1_MAX = 1643.108333;
  static final double B60_COASC1_MIN = 218.980000;
  static final double B60_COASC2_MAX = 527.985000;
  static final double B60_COASC2_MIN = 303.743333;
  static final double B60_EQUASC_MAX = 394.215000;
  static final double B60_EQUASC_MIN = 330.556667;
  static final double B60_HOUSE10_MAX = 394.215000;
  static final double B60_HOUSE10_MIN = 330.556667;
  static final double B60_HOUSE11_MAX = 710.359167;
  static final double B60_HOUSE11_MIN = 283.660833;
  static final double B60_HOUSE12_MAX = 1176.875000;
  static final double B60_HOUSE12_MIN = 243.426667;
  static final double B60_HOUSE1_MAX = 1643.109167;
  static final double B60_HOUSE1_MIN = 218.980000;
  static final double B60_HOUSE2_MAX = 1176.875833;
  static final double B60_HOUSE2_MIN = 243.426667;
  static final double B60_HOUSE3_MAX = 710.359167;
  static final double B60_HOUSE3_MIN = 283.660833;
  static final double B60_HOUSE4_MAX = 394.215000;
  static final double B60_HOUSE4_MIN = 330.556667;
  static final double B60_HOUSE5_MAX = 710.359167;
  static final double B60_HOUSE5_MIN = 283.660833;
  static final double B60_HOUSE6_MAX = 1176.875000;
  static final double B60_HOUSE6_MIN = 243.426667;
  static final double B60_HOUSE7_MAX = 1643.109167;
  static final double B60_HOUSE7_MIN = 218.980000;
  static final double B60_HOUSE8_MAX = 1176.875833;
  static final double B60_HOUSE8_MIN = 243.426667;
  static final double B60_HOUSE9_MAX = 710.359167;
  static final double B60_HOUSE9_MIN = 283.660833;
  static final double B60_MC_MAX = 394.215000;
  static final double B60_MC_MIN = 330.556667;
  static final double B60_POLASC_MAX = 1643.108333;
  static final double B60_POLASC_MIN = 218.980000;
  static final double B60_VERTEX_MAX = 527.985000;
  static final double B60_VERTEX_MIN = 303.743333;
  static final double B66_ARMC_MAX = 360.986667;
  static final double B66_ARMC_MIN = 360.984167;
  static final double B66_ASC_MAX = 15382.763492;
  static final double B66_ASC_MIN = 180.714519;
  static final double B66_COASC1_MAX = 27433.717500;
  static final double B66_COASC1_MIN = 176.632500;
  static final double B66_COASC2_MAX = 489.939167;
  static final double B66_COASC2_MIN = 313.358333;
  static final double B66_EQUASC_MAX = 394.215000;
  static final double B66_EQUASC_MIN = 330.556667;
  static final double B66_HOUSE10_MAX = 394.215000;
  static final double B66_HOUSE10_MIN = 330.556667;
  static final double B66_HOUSE11_MAX = 8225.980000;
  static final double B66_HOUSE11_MIN = 275.904167;
  static final double B66_HOUSE12_MAX = 17624.720000;
  static final double B66_HOUSE12_MIN = 221.919167;
  static final double B66_HOUSE1_MAX = 27433.547500;
  static final double B66_HOUSE1_MIN = 176.632500;
  static final double B66_HOUSE2_MAX = 17624.807500;
  static final double B66_HOUSE2_MIN = 221.919167;
  static final double B66_HOUSE3_MAX = 8225.979167;
  static final double B66_HOUSE3_MIN = 275.904167;
  static final double B66_HOUSE4_MAX = 394.215000;
  static final double B66_HOUSE4_MIN = 330.556667;
  static final double B66_HOUSE5_MAX = 8225.980000;
  static final double B66_HOUSE5_MIN = 275.904167;
  static final double B66_HOUSE6_MAX = 17624.720000;
  static final double B66_HOUSE6_MIN = 221.919167;
  static final double B66_HOUSE7_MAX = 27433.547500;
  static final double B66_HOUSE7_MIN = 176.632500;
  static final double B66_HOUSE8_MAX = 17624.807500;
  static final double B66_HOUSE8_MIN = 221.919167;
  static final double B66_HOUSE9_MAX = 8225.979167;
  static final double B66_HOUSE9_MIN = 275.904167;
  static final double B66_MC_MAX = 394.215000;
  static final double B66_MC_MIN = 330.556667;
  static final double B66_POLASC_MAX = 27433.717500;
  static final double B66_POLASC_MIN = 176.632500;
  static final double B66_VERTEX_MAX = 489.939167;
  static final double B66_VERTEX_MIN = 313.358333;
  static final double B70_ARMC_MAX = 360.986667;
  static final double B70_ARMC_MIN = 360.984167;
  static final double B70_ASC_MAX = 1553150.329680;
  static final double B70_ASC_MIN = -777600.393020;
  static final double B70_COASC1_MAX = 2999819.999167;
  static final double B70_COASC1_MIN = -180.000000;
  static final double B70_COASC2_MAX = 469.147500;
  static final double B70_COASC2_MIN = 318.595833;
  static final double B70_EQUASC_MAX = 394.215000;
  static final double B70_EQUASC_MIN = 330.556667;
  static final double B70_HOUSE10_MAX = 394.215000;
  static final double B70_HOUSE10_MIN = 330.556667;
  static final double B70_HOUSE11_MAX = 2999819.998333;
  static final double B70_HOUSE11_MIN = -180.000000;
  static final double B70_HOUSE12_MAX = 2999819.999167;
  static final double B70_HOUSE12_MIN = -179.999167;
  static final double B70_HOUSE1_MAX = 2999820.000000;
  static final double B70_HOUSE1_MIN = -179.999167;
  static final double B70_HOUSE2_MAX = 2999819.999167;
  static final double B70_HOUSE2_MIN = -180.000000;
  static final double B70_HOUSE3_MAX = 2999819.999167;
  static final double B70_HOUSE3_MIN = -179.998333;
  static final double B70_HOUSE4_MAX = 394.215000;
  static final double B70_HOUSE4_MIN = 330.556667;
  static final double B70_HOUSE5_MAX = 2999820.000000;
  static final double B70_HOUSE5_MIN = -179.999167;
  static final double B70_HOUSE6_MAX = 2999819.999167;
  static final double B70_HOUSE6_MIN = -179.999167;
  static final double B70_HOUSE7_MAX = 2999819.999167;
  static final double B70_HOUSE7_MIN = -180.000000;
  static final double B70_HOUSE8_MAX = 2999820.000000;
  static final double B70_HOUSE8_MIN = -179.999167;
  static final double B70_HOUSE9_MAX = 2999819.999167;
  static final double B70_HOUSE9_MIN = -179.998333;
  static final double B70_MC_MAX = 394.215000;
  static final double B70_MC_MIN = 330.556667;
  static final double B70_POLASC_MAX = 2999820.000000;
  static final double B70_POLASC_MIN = -180.000000;
  static final double B70_VERTEX_MAX = 469.147500;
  static final double B70_VERTEX_MIN = 318.595833;
  static final double B80_ARMC_MAX = 360.986667;
  static final double B80_ARMC_MIN = 360.984167;
  static final double B80_ASC_MAX = 1554930.566184;
  static final double B80_ASC_MIN = -777600.124007;
  static final double B80_COASC1_MAX = 2999820.000000;
  static final double B80_COASC1_MIN = -180.000000;
  static final double B80_COASC2_MAX = 427.276667;
  static final double B80_COASC2_MIN = 327.558333;
  static final double B80_EQUASC_MAX = 394.215000;
  static final double B80_EQUASC_MIN = 330.556667;
  static final double B80_HOUSE10_MAX = 394.215000;
  static final double B80_HOUSE10_MIN = 330.556667;
  static final double B80_HOUSE11_MAX = 536487.306667;
  static final double B80_HOUSE11_MIN = 150.026667;
  static final double B80_HOUSE12_MAX = 1011794.165000;
  static final double B80_HOUSE12_MIN = -48.723333;
  static final double B80_HOUSE1_MAX = 2999820.000000;
  static final double B80_HOUSE1_MIN = -180.000000;
  static final double B80_HOUSE2_MAX = 1011794.169167;
  static final double B80_HOUSE2_MIN = -48.723333;
  static final double B80_HOUSE3_MAX = 536487.456667;
  static final double B80_HOUSE3_MIN = 150.026667;
  static final double B80_HOUSE4_MAX = 394.215000;
  static final double B80_HOUSE4_MIN = 330.556667;
  static final double B80_HOUSE5_MAX = 536487.306667;
  static final double B80_HOUSE5_MIN = 150.026667;
  static final double B80_HOUSE6_MAX = 1011794.165000;
  static final double B80_HOUSE6_MIN = -48.723333;
  static final double B80_HOUSE7_MAX = 2999820.000000;
  static final double B80_HOUSE7_MIN = -180.000000;
  static final double B80_HOUSE8_MAX = 1011794.169167;
  static final double B80_HOUSE8_MIN = -48.723333;
  static final double B80_HOUSE9_MAX = 536487.456667;
  static final double B80_HOUSE9_MIN = 150.026667;
  static final double B80_MC_MAX = 394.215000;
  static final double B80_MC_MIN = 330.556667;
  static final double B80_POLASC_MAX = 2999820.000000;
  static final double B80_POLASC_MIN = -180.000000;
  static final double B80_VERTEX_MAX = 427.276667;
  static final double B80_VERTEX_MIN = 327.558333;
  static final double B85_ARMC_MAX = 360.986667;
  static final double B85_ARMC_MIN = 360.984167;
  static final double B85_ASC_MAX = 1555100.603952;
  static final double B85_ASC_MIN = -777600.058703;
  static final double B85_COASC1_MAX = 2999901.836667;
  static final double B85_COASC1_MIN = -100.323333;
  static final double B85_COASC2_MAX = 409.954167;
  static final double B85_COASC2_MIN = 329.806667;
  static final double B85_EQUASC_MAX = 394.215000;
  static final double B85_EQUASC_MIN = 330.556667;
  static final double B85_HOUSE10_MAX = 394.215000;
  static final double B85_HOUSE10_MIN = 330.556667;
  static final double B85_HOUSE11_MAX = 529542.535000;
  static final double B85_HOUSE11_MIN = 198.702500;
  static final double B85_HOUSE12_MAX = 996864.422500;
  static final double B85_HOUSE12_MIN = 61.263333;
  static final double B85_HOUSE1_MAX = 2999901.836667;
  static final double B85_HOUSE1_MIN = -100.323333;
  static final double B85_HOUSE2_MAX = 996864.541667;
  static final double B85_HOUSE2_MIN = 61.263333;
  static final double B85_HOUSE3_MAX = 529542.608333;
  static final double B85_HOUSE3_MIN = 198.702500;
  static final double B85_HOUSE4_MAX = 394.215000;
  static final double B85_HOUSE4_MIN = 330.556667;
  static final double B85_HOUSE5_MAX = 529542.535000;
  static final double B85_HOUSE5_MIN = 198.702500;
  static final double B85_HOUSE6_MAX = 996864.422500;
  static final double B85_HOUSE6_MIN = 61.263333;
  static final double B85_HOUSE7_MAX = 1500000.030833;
  static final double B85_HOUSE7_MIN = -100.323333;
  static final double B85_HOUSE8_MAX = 996864.541667;
  static final double B85_HOUSE8_MIN = 61.263333;
  static final double B85_HOUSE9_MAX = 529542.608333;
  static final double B85_HOUSE9_MIN = 198.702500;
  static final double B85_MC_MAX = 394.215000;
  static final double B85_MC_MIN = 330.556667;
  static final double B85_POLASC_MAX = 66.413333;
  static final double B85_POLASC_MIN = -100.323333;
  static final double B85_VERTEX_MAX = 409.954167;
  static final double B85_VERTEX_MIN = 329.806667;
  static final double B88_ARMC_MAX = 360.985931;
  static final double B88_ARMC_MIN = 360.985828;
  static final double B88_ASC_MAX = 1555165.554408;
  static final double B88_ASC_MIN = -777600.023170;
  static final double B88_COASC1_MAX = 1555165.554409;
  static final double B88_COASC1_MIN = -34.489296;
  static final double B88_COASC2_MAX = 399.547623;
  static final double B88_COASC2_MIN = 331.043079;
  static final double B88_EQUASC_MAX = 393.494420;
  static final double B88_EQUASC_MIN = 331.162937;
  static final double B88_HOUSE10_MAX = 393.494420;
  static final double B88_HOUSE10_MIN = 331.162936;
  static final double B88_HOUSE11_MAX = 271066.072583;
  static final double B88_HOUSE11_MIN = 213.853833;
  static final double B88_HOUSE12_MAX = 512298.186003;
  static final double B88_HOUSE12_MIN = 102.932767;
  static final double B88_HOUSE1_MAX = 1555199.976849;
  static final double B88_HOUSE1_MIN = 0.023142;
  static final double B88_HOUSE2_MAX = 512298.259258;
  static final double B88_HOUSE2_MIN = 102.932766;
  static final double B88_HOUSE3_MAX = 271066.008245;
  static final double B88_HOUSE3_MIN = 213.853836;
  static final double B88_HOUSE4_MAX = 393.494420;
  static final double B88_HOUSE4_MIN = 331.162936;
  static final double B88_HOUSE5_MAX = 271066.072583;
  static final double B88_HOUSE5_MIN = 213.853833;
  static final double B88_HOUSE6_MAX = 512298.186003;
  static final double B88_HOUSE6_MIN = 102.932767;
  static final double B88_HOUSE7_MAX = 1555199.976849;
  static final double B88_HOUSE7_MIN = 0.023142;
  static final double B88_HOUSE8_MAX = 512298.259258;
  static final double B88_HOUSE8_MIN = 102.932766;
  static final double B88_HOUSE9_MAX = 271066.008245;
  static final double B88_HOUSE9_MIN = 213.853836;
  static final double B88_MC_MAX = 393.494420;
  static final double B88_MC_MIN = 331.162936;
  static final double B88_POLASC_MAX = 29.344230;
  static final double B88_POLASC_MIN = -34.489313;
  static final double B88_VERTEX_MAX = 399.547621;
  static final double B88_VERTEX_MIN = 331.043081;
  static final double B89x_ARMC_MAX = 360.986667;
  static final double B89x_ARMC_MIN = 360.984167;
  static final double B89x_ASC_MAX = 1555200.000000;
  static final double B89x_ASC_MIN = -777600.000000;
  static final double B89x_COASC1_MAX = 2999998.426667;
  static final double B89x_COASC1_MIN = -1.600833;
  static final double B89x_COASC2_MAX = 394.516667;
  static final double B89x_COASC2_MIN = 330.556667;
  static final double B89x_EQUASC_MAX = 394.215000;
  static final double B89x_EQUASC_MIN = 330.556667;
  static final double B89x_HOUSE10_MAX = 394.215000;
  static final double B89x_HOUSE10_MIN = 330.556667;
  static final double B89x_HOUSE11_MAX = 518317.743333;
  static final double B89x_HOUSE11_MIN = 220.060000;
  static final double B89x_HOUSE12_MAX = 983218.436667;
  static final double B89x_HOUSE12_MIN = 114.757500;
  static final double B89x_HOUSE1_MAX = 2999998.426667;
  static final double B89x_HOUSE1_MIN = -1.600833;
  static final double B89x_HOUSE2_MAX = 983218.190833;
  static final double B89x_HOUSE2_MIN = 114.736667;
  static final double B89x_HOUSE3_MAX = 518317.656667;
  static final double B89x_HOUSE3_MIN = 220.060000;
  static final double B89x_HOUSE4_MAX = 394.215000;
  static final double B89x_HOUSE4_MIN = 330.556667;
  static final double B89x_HOUSE5_MAX = 518317.743333;
  static final double B89x_HOUSE5_MIN = 220.060000;
  static final double B89x_HOUSE6_MAX = 983218.436667;
  static final double B89x_HOUSE6_MIN = 114.757500;
  static final double B89x_HOUSE7_MAX = 1500000.000833;
  static final double B89x_HOUSE7_MIN = -1.600833;
  static final double B89x_HOUSE8_MAX = 983218.190833;
  static final double B89x_HOUSE8_MIN = 114.736667;
  static final double B89x_HOUSE9_MAX = 518317.656667;
  static final double B89x_HOUSE9_MIN = 220.060000;
  static final double B89x_MC_MAX = 394.215000;
  static final double B89x_MC_MIN = 330.556667;
  static final double B89x_POLASC_MAX = 1.588333;
  static final double B89x_POLASC_MIN = -1.600833;
  static final double B89x_VERTEX_MAX = 394.516667;
  static final double B89x_VERTEX_MIN = 330.556667;
  static final double C0_ARMC_MAX = 360.986667;
  static final double C0_ARMC_MIN = 360.984167;
  static final double C0_ASC_MAX = 393.494420;
  static final double C0_ASC_MIN = 331.162937;
  static final double C0_COASC1_MAX = 394.215000;
  static final double C0_COASC1_MIN = 330.556667;
  static final double C0_COASC2_MAX = 0.000000;
  static final double C0_COASC2_MIN = 0.000000;
  static final double C0_EQUASC_MAX = 394.215000;
  static final double C0_EQUASC_MIN = 330.556667;
  static final double C0_HOUSE10_MAX = 394.215000;
  static final double C0_HOUSE10_MIN = 330.556667;
  static final double C0_HOUSE11_MAX = 394.215000;
  static final double C0_HOUSE11_MIN = 330.556667;
  static final double C0_HOUSE12_MAX = 394.215000;
  static final double C0_HOUSE12_MIN = 330.556667;
  static final double C0_HOUSE1_MAX = 394.215000;
  static final double C0_HOUSE1_MIN = 330.556667;
  static final double C0_HOUSE2_MAX = 394.215000;
  static final double C0_HOUSE2_MIN = 330.556667;
  static final double C0_HOUSE3_MAX = 394.215000;
  static final double C0_HOUSE3_MIN = 330.556667;
  static final double C0_HOUSE4_MAX = 394.215000;
  static final double C0_HOUSE4_MIN = 330.556667;
  static final double C0_HOUSE5_MAX = 394.215000;
  static final double C0_HOUSE5_MIN = 330.556667;
  static final double C0_HOUSE6_MAX = 394.215000;
  static final double C0_HOUSE6_MIN = 330.556667;
  static final double C0_HOUSE7_MAX = 394.215000;
  static final double C0_HOUSE7_MIN = 330.556667;
  static final double C0_HOUSE8_MAX = 394.215000;
  static final double C0_HOUSE8_MIN = 330.556667;
  static final double C0_HOUSE9_MAX = 394.215000;
  static final double C0_HOUSE9_MIN = 330.556667;
  static final double C0_MC_MAX = 394.215000;
  static final double C0_MC_MIN = 330.556667;
  static final double C0_POLASC_MAX = 394.215000;
  static final double C0_POLASC_MIN = 330.556667;
  static final double C0_VERTEX_MAX = 1500000.000000;
  static final double C0_VERTEX_MIN = 0.000000;
  static final double C10_ARMC_MAX = 360.986667;
  static final double C10_ARMC_MIN = 360.984167;
  static final double C10_ASC_MAX = 426.089536;
  static final double C10_ASC_MIN = 328.169552;
  static final double C10_COASC1_MAX = 427.276667;
  static final double C10_COASC1_MIN = 327.558333;
  static final double C10_COASC2_MAX = 2999820.000000;
  static final double C10_COASC2_MIN = -180.000000;
  static final double C10_EQUASC_MAX = 394.215000;
  static final double C10_EQUASC_MIN = 330.556667;
  static final double C10_HOUSE10_MAX = 394.215000;
  static final double C10_HOUSE10_MIN = 330.556667;
  static final double C10_HOUSE11_MAX = 409.891667;
  static final double C10_HOUSE11_MIN = 329.812500;
  static final double C10_HOUSE12_MAX = 422.411667;
  static final double C10_HOUSE12_MIN = 328.312500;
  static final double C10_HOUSE1_MAX = 427.276667;
  static final double C10_HOUSE1_MIN = 327.558333;
  static final double C10_HOUSE2_MAX = 422.411667;
  static final double C10_HOUSE2_MIN = 328.312500;
  static final double C10_HOUSE3_MAX = 409.891667;
  static final double C10_HOUSE3_MIN = 329.812500;
  static final double C10_HOUSE4_MAX = 394.215000;
  static final double C10_HOUSE4_MIN = 330.556667;
  static final double C10_HOUSE5_MAX = 409.891667;
  static final double C10_HOUSE5_MIN = 329.812500;
  static final double C10_HOUSE6_MAX = 422.411667;
  static final double C10_HOUSE6_MIN = 328.312500;
  static final double C10_HOUSE7_MAX = 427.276667;
  static final double C10_HOUSE7_MIN = 327.558333;
  static final double C10_HOUSE8_MAX = 422.411667;
  static final double C10_HOUSE8_MIN = 328.312500;
  static final double C10_HOUSE9_MAX = 409.891667;
  static final double C10_HOUSE9_MIN = 329.812500;
  static final double C10_MC_MAX = 394.215000;
  static final double C10_MC_MIN = 330.556667;
  static final double C10_POLASC_MAX = 427.276667;
  static final double C10_POLASC_MIN = 327.558333;
  static final double C10_VERTEX_MAX = 2999820.000000;
  static final double C10_VERTEX_MIN = -180.000000;
  static final double C20_ARMC_MAX = 360.986667;
  static final double C20_ARMC_MIN = 360.984167;
  static final double C20_ASC_MAX = 467.280896;
  static final double C20_ASC_MIN = 319.225068;
  static final double C20_COASC1_MAX = 469.147500;
  static final double C20_COASC1_MIN = 318.595833;
  static final double C20_COASC2_MAX = 2999819.999167;
  static final double C20_COASC2_MIN = -180.000000;
  static final double C20_EQUASC_MAX = 394.215000;
  static final double C20_EQUASC_MIN = 330.556667;
  static final double C20_HOUSE10_MAX = 394.215000;
  static final double C20_HOUSE10_MIN = 330.556667;
  static final double C20_HOUSE11_MAX = 426.716667;
  static final double C20_HOUSE11_MIN = 327.649167;
  static final double C20_HOUSE12_MAX = 456.313333;
  static final double C20_HOUSE12_MIN = 321.671667;
  static final double C20_HOUSE1_MAX = 469.147500;
  static final double C20_HOUSE1_MIN = 318.595833;
  static final double C20_HOUSE2_MAX = 456.313333;
  static final double C20_HOUSE2_MIN = 321.671667;
  static final double C20_HOUSE3_MAX = 426.716667;
  static final double C20_HOUSE3_MIN = 327.649167;
  static final double C20_HOUSE4_MAX = 394.215000;
  static final double C20_HOUSE4_MIN = 330.556667;
  static final double C20_HOUSE5_MAX = 426.716667;
  static final double C20_HOUSE5_MIN = 327.649167;
  static final double C20_HOUSE6_MAX = 456.313333;
  static final double C20_HOUSE6_MIN = 321.671667;
  static final double C20_HOUSE7_MAX = 469.147500;
  static final double C20_HOUSE7_MIN = 318.595833;
  static final double C20_HOUSE8_MAX = 456.313333;
  static final double C20_HOUSE8_MIN = 321.671667;
  static final double C20_HOUSE9_MAX = 426.716667;
  static final double C20_HOUSE9_MIN = 327.649167;
  static final double C20_MC_MAX = 394.215000;
  static final double C20_MC_MIN = 330.556667;
  static final double C20_POLASC_MAX = 469.147500;
  static final double C20_POLASC_MIN = 318.595833;
  static final double C20_VERTEX_MAX = 2999819.999167;
  static final double C20_VERTEX_MIN = -180.000000;
  static final double C30_ARMC_MAX = 360.986667;
  static final double C30_ARMC_MIN = 360.984167;
  static final double C30_ASC_MAX = 524.994891;
  static final double C30_ASC_MIN = 304.407972;
  static final double C30_COASC1_MAX = 527.985000;
  static final double C30_COASC1_MIN = 303.743333;
  static final double C30_COASC2_MAX = 1643.109167;
  static final double C30_COASC2_MIN = 218.980000;
  static final double C30_EQUASC_MAX = 394.215000;
  static final double C30_EQUASC_MIN = 330.556667;
  static final double C30_HOUSE10_MAX = 394.215000;
  static final double C30_HOUSE10_MIN = 330.556667;
  static final double C30_HOUSE11_MAX = 444.589167;
  static final double C30_HOUSE11_MIN = 324.278333;
  static final double C30_HOUSE12_MAX = 499.516667;
  static final double C30_HOUSE12_MIN = 310.910833;
  static final double C30_HOUSE1_MAX = 527.985000;
  static final double C30_HOUSE1_MIN = 303.743333;
  static final double C30_HOUSE2_MAX = 499.516667;
  static final double C30_HOUSE2_MIN = 310.910833;
  static final double C30_HOUSE3_MAX = 444.589167;
  static final double C30_HOUSE3_MIN = 324.278333;
  static final double C30_HOUSE4_MAX = 394.215000;
  static final double C30_HOUSE4_MIN = 330.556667;
  static final double C30_HOUSE5_MAX = 444.589167;
  static final double C30_HOUSE5_MIN = 324.278333;
  static final double C30_HOUSE6_MAX = 499.516667;
  static final double C30_HOUSE6_MIN = 310.910833;
  static final double C30_HOUSE7_MAX = 527.985000;
  static final double C30_HOUSE7_MIN = 303.743333;
  static final double C30_HOUSE8_MAX = 499.516667;
  static final double C30_HOUSE8_MIN = 310.910833;
  static final double C30_HOUSE9_MAX = 444.589167;
  static final double C30_HOUSE9_MIN = 324.278333;
  static final double C30_MC_MAX = 394.215000;
  static final double C30_MC_MIN = 330.556667;
  static final double C30_POLASC_MAX = 527.985000;
  static final double C30_POLASC_MIN = 303.743333;
  static final double C30_VERTEX_MAX = 1643.108333;
  static final double C30_VERTEX_MIN = 218.980000;
  static final double C40_ARMC_MAX = 360.986667;
  static final double C40_ARMC_MIN = 360.984167;
  static final double C40_ASC_MAX = 618.738596;
  static final double C40_ASC_MIN = 283.720808;
  static final double C40_COASC1_MAX = 623.978333;
  static final double C40_COASC1_MIN = 282.993333;
  static final double C40_COASC2_MAX = 826.410833;
  static final double C40_COASC2_MIN = 255.830833;
  static final double C40_EQUASC_MAX = 394.215000;
  static final double C40_EQUASC_MIN = 330.556667;
  static final double C40_HOUSE10_MAX = 394.215000;
  static final double C40_HOUSE10_MIN = 330.556667;
  static final double C40_HOUSE11_MAX = 463.204167;
  static final double C40_HOUSE11_MIN = 320.042500;
  static final double C40_HOUSE12_MAX = 558.424167;
  static final double C40_HOUSE12_MIN = 296.510000;
  static final double C40_HOUSE1_MAX = 623.978333;
  static final double C40_HOUSE1_MIN = 282.993333;
  static final double C40_HOUSE2_MAX = 558.424167;
  static final double C40_HOUSE2_MIN = 296.510000;
  static final double C40_HOUSE3_MAX = 463.204167;
  static final double C40_HOUSE3_MIN = 320.042500;
  static final double C40_HOUSE4_MAX = 394.215000;
  static final double C40_HOUSE4_MIN = 330.556667;
  static final double C40_HOUSE5_MAX = 463.204167;
  static final double C40_HOUSE5_MIN = 320.042500;
  static final double C40_HOUSE6_MAX = 558.424167;
  static final double C40_HOUSE6_MIN = 296.510000;
  static final double C40_HOUSE7_MAX = 623.978333;
  static final double C40_HOUSE7_MIN = 282.993333;
  static final double C40_HOUSE8_MAX = 558.424167;
  static final double C40_HOUSE8_MIN = 296.510000;
  static final double C40_HOUSE9_MAX = 463.204167;
  static final double C40_HOUSE9_MIN = 320.042500;
  static final double C40_MC_MAX = 394.215000;
  static final double C40_MC_MIN = 330.556667;
  static final double C40_POLASC_MAX = 623.978333;
  static final double C40_POLASC_MIN = 282.993333;
  static final double C40_VERTEX_MAX = 826.410833;
  static final double C40_VERTEX_MIN = 255.830833;
  static final double C50_ARMC_MAX = 360.986667;
  static final double C50_ARMC_MIN = 360.984167;
  static final double C50_ASC_MAX = 814.745889;
  static final double C50_ASC_MIN = 256.684961;
  static final double C50_COASC1_MAX = 826.410833;
  static final double C50_COASC1_MIN = 255.830833;
  static final double C50_COASC2_MAX = 623.978333;
  static final double C50_COASC2_MIN = 282.993333;
  static final double C50_EQUASC_MAX = 394.215000;
  static final double C50_EQUASC_MIN = 330.556667;
  static final double C50_HOUSE10_MAX = 394.215000;
  static final double C50_HOUSE10_MIN = 330.556667;
  static final double C50_HOUSE11_MAX = 481.900833;
  static final double C50_HOUSE11_MIN = 315.404167;
  static final double C50_HOUSE12_MAX = 645.276667;
  static final double C50_HOUSE12_MIN = 279.204167;
  static final double C50_HOUSE1_MAX = 826.410833;
  static final double C50_HOUSE1_MIN = 255.830833;
  static final double C50_HOUSE2_MAX = 645.276667;
  static final double C50_HOUSE2_MIN = 279.204167;
  static final double C50_HOUSE3_MAX = 481.900833;
  static final double C50_HOUSE3_MIN = 315.404167;
  static final double C50_HOUSE4_MAX = 394.215000;
  static final double C50_HOUSE4_MIN = 330.556667;
  static final double C50_HOUSE5_MAX = 481.900833;
  static final double C50_HOUSE5_MIN = 315.404167;
  static final double C50_HOUSE6_MAX = 645.276667;
  static final double C50_HOUSE6_MIN = 279.204167;
  static final double C50_HOUSE7_MAX = 826.410833;
  static final double C50_HOUSE7_MIN = 255.830833;
  static final double C50_HOUSE8_MAX = 645.276667;
  static final double C50_HOUSE8_MIN = 279.204167;
  static final double C50_HOUSE9_MAX = 481.900833;
  static final double C50_HOUSE9_MIN = 315.404167;
  static final double C50_MC_MAX = 394.215000;
  static final double C50_MC_MIN = 330.556667;
  static final double C50_POLASC_MAX = 826.410833;
  static final double C50_POLASC_MIN = 255.830833;
  static final double C50_VERTEX_MAX = 623.978333;
  static final double C50_VERTEX_MIN = 282.993333;
  static final double C60_ARMC_MAX = 360.986667;
  static final double C60_ARMC_MIN = 360.984167;
  static final double C60_ASC_MAX = 1583.084164;
  static final double C60_ASC_MIN = 220.207028;
  static final double C60_COASC1_MAX = 1643.108333;
  static final double C60_COASC1_MIN = 218.980000;
  static final double C60_COASC2_MAX = 527.985000;
  static final double C60_COASC2_MIN = 303.743333;
  static final double C60_EQUASC_MAX = 394.215000;
  static final double C60_EQUASC_MIN = 330.556667;
  static final double C60_HOUSE10_MAX = 394.215000;
  static final double C60_HOUSE10_MIN = 330.556667;
  static final double C60_HOUSE11_MAX = 499.516667;
  static final double C60_HOUSE11_MIN = 310.910833;
  static final double C60_HOUSE12_MAX = 784.645833;
  static final double C60_HOUSE12_MIN = 260.105000;
  static final double C60_HOUSE1_MAX = 1643.109167;
  static final double C60_HOUSE1_MIN = 218.980000;
  static final double C60_HOUSE2_MAX = 784.645833;
  static final double C60_HOUSE2_MIN = 260.105000;
  static final double C60_HOUSE3_MAX = 499.516667;
  static final double C60_HOUSE3_MIN = 310.910833;
  static final double C60_HOUSE4_MAX = 394.215000;
  static final double C60_HOUSE4_MIN = 330.556667;
  static final double C60_HOUSE5_MAX = 499.516667;
  static final double C60_HOUSE5_MIN = 310.910833;
  static final double C60_HOUSE6_MAX = 784.645833;
  static final double C60_HOUSE6_MIN = 260.105000;
  static final double C60_HOUSE7_MAX = 1643.109167;
  static final double C60_HOUSE7_MIN = 218.980000;
  static final double C60_HOUSE8_MAX = 784.645833;
  static final double C60_HOUSE8_MIN = 260.105000;
  static final double C60_HOUSE9_MAX = 499.516667;
  static final double C60_HOUSE9_MIN = 310.910833;
  static final double C60_MC_MAX = 394.215000;
  static final double C60_MC_MIN = 330.556667;
  static final double C60_POLASC_MAX = 1643.108333;
  static final double C60_POLASC_MIN = 218.980000;
  static final double C60_VERTEX_MAX = 527.985000;
  static final double C60_VERTEX_MIN = 303.743333;
  static final double C66_ARMC_MAX = 360.986667;
  static final double C66_ARMC_MIN = 360.984167;
  static final double C66_ASC_MAX = 15382.763492;
  static final double C66_ASC_MIN = 180.714519;
  static final double C66_COASC1_MAX = 27433.717500;
  static final double C66_COASC1_MIN = 176.632500;
  static final double C66_COASC2_MAX = 489.939167;
  static final double C66_COASC2_MIN = 313.358333;
  static final double C66_EQUASC_MAX = 394.215000;
  static final double C66_EQUASC_MIN = 330.556667;
  static final double C66_HOUSE10_MAX = 394.215000;
  static final double C66_HOUSE10_MIN = 330.556667;
  static final double C66_HOUSE11_MAX = 508.878333;
  static final double C66_HOUSE11_MIN = 308.526667;
  static final double C66_HOUSE12_MAX = 911.791667;
  static final double C66_HOUSE12_MIN = 248.500833;
  static final double C66_HOUSE1_MAX = 27433.547500;
  static final double C66_HOUSE1_MIN = 176.632500;
  static final double C66_HOUSE2_MAX = 911.791667;
  static final double C66_HOUSE2_MIN = 248.500833;
  static final double C66_HOUSE3_MAX = 508.878333;
  static final double C66_HOUSE3_MIN = 308.526667;
  static final double C66_HOUSE4_MAX = 394.215000;
  static final double C66_HOUSE4_MIN = 330.556667;
  static final double C66_HOUSE5_MAX = 508.878333;
  static final double C66_HOUSE5_MIN = 308.526667;
  static final double C66_HOUSE6_MAX = 911.791667;
  static final double C66_HOUSE6_MIN = 248.500833;
  static final double C66_HOUSE7_MAX = 27433.547500;
  static final double C66_HOUSE7_MIN = 176.632500;
  static final double C66_HOUSE8_MAX = 911.791667;
  static final double C66_HOUSE8_MIN = 248.500833;
  static final double C66_HOUSE9_MAX = 508.878333;
  static final double C66_HOUSE9_MIN = 308.526667;
  static final double C66_MC_MAX = 394.215000;
  static final double C66_MC_MIN = 330.556667;
  static final double C66_POLASC_MAX = 27433.717500;
  static final double C66_POLASC_MIN = 176.632500;
  static final double C66_VERTEX_MAX = 489.939167;
  static final double C66_VERTEX_MIN = 313.358333;
  static final double C70_ARMC_MAX = 360.986667;
  static final double C70_ARMC_MIN = 360.984167;
  static final double C70_ASC_MAX = 1553150.329680;
  static final double C70_ASC_MIN = -777600.393020;
  static final double C70_COASC1_MAX = 2999819.999167;
  static final double C70_COASC1_MIN = -180.000000;
  static final double C70_COASC2_MAX = 469.147500;
  static final double C70_COASC2_MIN = 318.595833;
  static final double C70_EQUASC_MAX = 394.215000;
  static final double C70_EQUASC_MIN = 330.556667;
  static final double C70_HOUSE10_MAX = 1500348.120833;
  static final double C70_HOUSE10_MIN = 330.556667;
  static final double C70_HOUSE11_MAX = 1500401.565000;
  static final double C70_HOUSE11_MIN = 307.142500;
  static final double C70_HOUSE12_MAX = 1500579.558333;
  static final double C70_HOUSE12_MIN = 241.054167;
  static final double C70_HOUSE1_MAX = 2999820.000000;
  static final double C70_HOUSE1_MIN = -179.999167;
  static final double C70_HOUSE2_MAX = 1500579.555000;
  static final double C70_HOUSE2_MIN = 241.054167;
  static final double C70_HOUSE3_MAX = 1500401.565000;
  static final double C70_HOUSE3_MIN = 307.142500;
  static final double C70_HOUSE4_MAX = 1500348.120833;
  static final double C70_HOUSE4_MIN = 330.556667;
  static final double C70_HOUSE5_MAX = 1500401.565000;
  static final double C70_HOUSE5_MIN = 307.142500;
  static final double C70_HOUSE6_MAX = 1500579.558333;
  static final double C70_HOUSE6_MIN = 241.054167;
  static final double C70_HOUSE7_MAX = 2999819.999167;
  static final double C70_HOUSE7_MIN = -180.000000;
  static final double C70_HOUSE8_MAX = 1500579.555000;
  static final double C70_HOUSE8_MIN = 241.054167;
  static final double C70_HOUSE9_MAX = 1500401.565000;
  static final double C70_HOUSE9_MIN = 307.142500;
  static final double C70_MC_MAX = 1500348.120833;
  static final double C70_MC_MIN = 330.556667;
  static final double C70_POLASC_MAX = 2999820.000000;
  static final double C70_POLASC_MIN = -180.000000;
  static final double C70_VERTEX_MAX = 469.147500;
  static final double C70_VERTEX_MIN = 318.595833;
  static final double C80_ARMC_MAX = 360.986667;
  static final double C80_ARMC_MIN = 360.984167;
  static final double C80_ASC_MAX = 1554930.566184;
  static final double C80_ASC_MIN = -777600.124007;
  static final double C80_COASC1_MAX = 2999820.000000;
  static final double C80_COASC1_MIN = -180.000000;
  static final double C80_COASC2_MAX = 427.276667;
  static final double C80_COASC2_MIN = 327.558333;
  static final double C80_EQUASC_MAX = 394.215000;
  static final double C80_EQUASC_MIN = 330.556667;
  static final double C80_HOUSE10_MAX = 1500382.346667;
  static final double C80_HOUSE10_MIN = 330.556667;
  static final double C80_HOUSE11_MAX = 1500495.612500;
  static final double C80_HOUSE11_MIN = 304.627500;
  static final double C80_HOUSE12_MAX = 1501216.370833;
  static final double C80_HOUSE12_MIN = 225.450000;
  static final double C80_HOUSE1_MAX = 2999820.000000;
  static final double C80_HOUSE1_MIN = -180.000000;
  static final double C80_HOUSE2_MAX = 1501216.388333;
  static final double C80_HOUSE2_MIN = 225.450000;
  static final double C80_HOUSE3_MAX = 1500495.614167;
  static final double C80_HOUSE3_MIN = 304.627500;
  static final double C80_HOUSE4_MAX = 1500382.346667;
  static final double C80_HOUSE4_MIN = 330.556667;
  static final double C80_HOUSE5_MAX = 1500495.612500;
  static final double C80_HOUSE5_MIN = 304.627500;
  static final double C80_HOUSE6_MAX = 1501216.370833;
  static final double C80_HOUSE6_MIN = 225.450000;
  static final double C80_HOUSE7_MAX = 2999820.000000;
  static final double C80_HOUSE7_MIN = -180.000000;
  static final double C80_HOUSE8_MAX = 1501216.388333;
  static final double C80_HOUSE8_MIN = 225.450000;
  static final double C80_HOUSE9_MAX = 1500495.614167;
  static final double C80_HOUSE9_MIN = 304.627500;
  static final double C80_MC_MAX = 1500382.346667;
  static final double C80_MC_MIN = 330.556667;
  static final double C80_POLASC_MAX = 2999820.000000;
  static final double C80_POLASC_MIN = -180.000000;
  static final double C80_VERTEX_MAX = 427.276667;
  static final double C80_VERTEX_MIN = 327.558333;
  static final double C85_ARMC_MAX = 360.986667;
  static final double C85_ARMC_MIN = 360.984167;
  static final double C85_ASC_MAX = 1555100.603952;
  static final double C85_ASC_MIN = -777600.058703;
  static final double C85_COASC1_MAX = 2999901.836667;
  static final double C85_COASC1_MIN = -100.323333;
  static final double C85_COASC2_MAX = 409.954167;
  static final double C85_COASC2_MIN = 329.806667;
  static final double C85_EQUASC_MAX = 394.215000;
  static final double C85_EQUASC_MIN = 330.556667;
  static final double C85_HOUSE10_MAX = 1500391.230833;
  static final double C85_HOUSE10_MIN = 330.556667;
  static final double C85_HOUSE11_MAX = 1500519.809167;
  static final double C85_HOUSE11_MIN = 303.966667;
  static final double C85_HOUSE12_MAX = 1501516.993333;
  static final double C85_HOUSE12_MIN = 220.680833;
  static final double C85_HOUSE1_MAX = 2999901.836667;
  static final double C85_HOUSE1_MIN = -100.323333;
  static final double C85_HOUSE2_MAX = 1501517.001667;
  static final double C85_HOUSE2_MIN = 220.680833;
  static final double C85_HOUSE3_MAX = 1500519.810000;
  static final double C85_HOUSE3_MIN = 303.966667;
  static final double C85_HOUSE4_MAX = 1500391.230833;
  static final double C85_HOUSE4_MIN = 330.556667;
  static final double C85_HOUSE5_MAX = 1500519.809167;
  static final double C85_HOUSE5_MIN = 303.966667;
  static final double C85_HOUSE6_MAX = 1501516.993333;
  static final double C85_HOUSE6_MIN = 220.680833;
  static final double C85_HOUSE7_MAX = 1500000.030833;
  static final double C85_HOUSE7_MIN = -100.323333;
  static final double C85_HOUSE8_MAX = 1501517.001667;
  static final double C85_HOUSE8_MIN = 220.680833;
  static final double C85_HOUSE9_MAX = 1500519.810000;
  static final double C85_HOUSE9_MIN = 303.966667;
  static final double C85_MC_MAX = 1500391.230833;
  static final double C85_MC_MIN = 330.556667;
  static final double C85_POLASC_MAX = 66.413333;
  static final double C85_POLASC_MIN = -100.323333;
  static final double C85_VERTEX_MAX = 409.954167;
  static final double C85_VERTEX_MIN = 329.806667;
  static final double C88_ARMC_MAX = 360.985931;
  static final double C88_ARMC_MIN = 360.985828;
  static final double C88_ASC_MAX = 1555165.554408;
  static final double C88_ASC_MIN = -777600.023170;
  static final double C88_COASC1_MAX = 1555165.554409;
  static final double C88_COASC1_MIN = -34.489296;
  static final double C88_COASC2_MAX = 399.547623;
  static final double C88_COASC2_MIN = 331.043079;
  static final double C88_EQUASC_MAX = 393.494420;
  static final double C88_EQUASC_MIN = 331.162937;
  static final double C88_HOUSE10_MAX = 777993.023575;
  static final double C88_HOUSE10_MIN = 331.162936;
  static final double C88_HOUSE11_MAX = 778123.708399;
  static final double C88_HOUSE11_MIN = 304.443697;
  static final double C88_HOUSE12_MAX = 779163.540891;
  static final double C88_HOUSE12_MIN = 220.478740;
  static final double C88_HOUSE1_MAX = 1555199.976849;
  static final double C88_HOUSE1_MIN = 0.023142;
  static final double C88_HOUSE2_MAX = 779163.542082;
  static final double C88_HOUSE2_MIN = 220.478743;
  static final double C88_HOUSE3_MAX = 778123.708457;
  static final double C88_HOUSE3_MIN = 304.443698;
  static final double C88_HOUSE4_MAX = 777993.023575;
  static final double C88_HOUSE4_MIN = 331.162936;
  static final double C88_HOUSE5_MAX = 778123.708399;
  static final double C88_HOUSE5_MIN = 304.443697;
  static final double C88_HOUSE6_MAX = 779163.540891;
  static final double C88_HOUSE6_MIN = 220.478740;
  static final double C88_HOUSE7_MAX = 1555199.976849;
  static final double C88_HOUSE7_MIN = 0.023142;
  static final double C88_HOUSE8_MAX = 779163.542082;
  static final double C88_HOUSE8_MIN = 220.478743;
  static final double C88_HOUSE9_MAX = 778123.708457;
  static final double C88_HOUSE9_MIN = 304.443698;
  static final double C88_MC_MAX = 777993.023523;
  static final double C88_MC_MIN = -777207.078222;
  static final double C88_POLASC_MAX = 29.344230;
  static final double C88_POLASC_MIN = -34.489313;
  static final double C88_VERTEX_MAX = 399.547621;
  static final double C88_VERTEX_MIN = 331.043081;
  static final double C89x_ARMC_MAX = 360.986667;
  static final double C89x_ARMC_MIN = 360.984167;
  static final double C89x_ASC_MAX = 1555200.000000;
  static final double C89x_ASC_MIN = -777600.000000;
  static final double C89x_COASC1_MAX = 2999998.426667;
  static final double C89x_COASC1_MIN = -1.600833;
  static final double C89x_COASC2_MAX = 394.516667;
  static final double C89x_COASC2_MIN = 330.556667;
  static final double C89x_EQUASC_MAX = 394.215000;
  static final double C89x_EQUASC_MIN = 330.556667;
  static final double C89x_HOUSE10_MAX = 1500394.213333;
  static final double C89x_HOUSE10_MIN = 330.556667;
  static final double C89x_HOUSE11_MAX = 1500527.981667;
  static final double C89x_HOUSE11_MIN = 303.743333;
  static final double C89x_HOUSE12_MAX = 1501643.065000;
  static final double C89x_HOUSE12_MIN = 218.980000;
  static final double C89x_HOUSE1_MAX = 2999998.426667;
  static final double C89x_HOUSE1_MIN = -1.600833;
  static final double C89x_HOUSE2_MAX = 1501643.065833;
  static final double C89x_HOUSE2_MIN = 218.980000;
  static final double C89x_HOUSE3_MAX = 1500527.981667;
  static final double C89x_HOUSE3_MIN = 303.743333;
  static final double C89x_HOUSE4_MAX = 1500394.213333;
  static final double C89x_HOUSE4_MIN = 330.556667;
  static final double C89x_HOUSE5_MAX = 1500527.981667;
  static final double C89x_HOUSE5_MIN = 303.743333;
  static final double C89x_HOUSE6_MAX = 1501643.065000;
  static final double C89x_HOUSE6_MIN = 218.980000;
  static final double C89x_HOUSE7_MAX = 1500000.000833;
  static final double C89x_HOUSE7_MIN = -1.600833;
  static final double C89x_HOUSE8_MAX = 1501643.065833;
  static final double C89x_HOUSE8_MIN = 218.980000;
  static final double C89x_HOUSE9_MAX = 1500527.981667;
  static final double C89x_HOUSE9_MIN = 303.743333;
  static final double C89x_MC_MAX = 1500394.213333;
  static final double C89x_MC_MIN = 330.556667;
  static final double C89x_POLASC_MAX = 1.588333;
  static final double C89x_POLASC_MIN = -1.600833;
  static final double C89x_VERTEX_MAX = 394.516667;
  static final double C89x_VERTEX_MIN = 330.556667;
  static final double E0_ARMC_MAX = 360.986667;
  static final double E0_ARMC_MIN = 360.984167;
  static final double E0_ASC_MAX = 393.494420;
  static final double E0_ASC_MIN = 331.162937;
  static final double E0_COASC1_MAX = 394.215000;
  static final double E0_COASC1_MIN = 330.556667;
  static final double E0_COASC2_MAX = 0.000000;
  static final double E0_COASC2_MIN = 0.000000;
  static final double E0_EQUASC_MAX = 394.215000;
  static final double E0_EQUASC_MIN = 330.556667;
  static final double E0_HOUSE10_MAX = 394.215000;
  static final double E0_HOUSE10_MIN = 330.556667;
  static final double E0_HOUSE11_MAX = 394.215000;
  static final double E0_HOUSE11_MIN = 330.556667;
  static final double E0_HOUSE12_MAX = 394.215000;
  static final double E0_HOUSE12_MIN = 330.556667;
  static final double E0_HOUSE1_MAX = 394.215000;
  static final double E0_HOUSE1_MIN = 330.556667;
  static final double E0_HOUSE2_MAX = 394.215000;
  static final double E0_HOUSE2_MIN = 330.556667;
  static final double E0_HOUSE3_MAX = 394.215000;
  static final double E0_HOUSE3_MIN = 330.556667;
  static final double E0_HOUSE4_MAX = 394.215000;
  static final double E0_HOUSE4_MIN = 330.556667;
  static final double E0_HOUSE5_MAX = 394.215000;
  static final double E0_HOUSE5_MIN = 330.556667;
  static final double E0_HOUSE6_MAX = 394.215000;
  static final double E0_HOUSE6_MIN = 330.556667;
  static final double E0_HOUSE7_MAX = 394.215000;
  static final double E0_HOUSE7_MIN = 330.556667;
  static final double E0_HOUSE8_MAX = 394.215000;
  static final double E0_HOUSE8_MIN = 330.556667;
  static final double E0_HOUSE9_MAX = 394.215000;
  static final double E0_HOUSE9_MIN = 330.556667;
  static final double E0_MC_MAX = 394.215000;
  static final double E0_MC_MIN = 330.556667;
  static final double E0_POLASC_MAX = 394.215000;
  static final double E0_POLASC_MIN = 330.556667;
  static final double E0_VERTEX_MAX = 1500000.000000;
  static final double E0_VERTEX_MIN = 0.000000;
  static final double E10_ARMC_MAX = 360.986667;
  static final double E10_ARMC_MIN = 360.984167;
  static final double E10_ASC_MAX = 426.089536;
  static final double E10_ASC_MIN = 328.169552;
  static final double E10_COASC1_MAX = 427.276667;
  static final double E10_COASC1_MIN = 327.558333;
  static final double E10_COASC2_MAX = 2999820.000000;
  static final double E10_COASC2_MIN = -180.000000;
  static final double E10_EQUASC_MAX = 394.215000;
  static final double E10_EQUASC_MIN = 330.556667;
  static final double E10_HOUSE10_MAX = 427.276667;
  static final double E10_HOUSE10_MIN = 327.558333;
  static final double E10_HOUSE11_MAX = 427.276667;
  static final double E10_HOUSE11_MIN = 327.558333;
  static final double E10_HOUSE12_MAX = 427.276667;
  static final double E10_HOUSE12_MIN = 327.558333;
  static final double E10_HOUSE1_MAX = 427.276667;
  static final double E10_HOUSE1_MIN = 327.558333;
  static final double E10_HOUSE2_MAX = 427.276667;
  static final double E10_HOUSE2_MIN = 327.558333;
  static final double E10_HOUSE3_MAX = 427.276667;
  static final double E10_HOUSE3_MIN = 327.558333;
  static final double E10_HOUSE4_MAX = 427.276667;
  static final double E10_HOUSE4_MIN = 327.558333;
  static final double E10_HOUSE5_MAX = 427.276667;
  static final double E10_HOUSE5_MIN = 327.558333;
  static final double E10_HOUSE6_MAX = 427.276667;
  static final double E10_HOUSE6_MIN = 327.558333;
  static final double E10_HOUSE7_MAX = 427.276667;
  static final double E10_HOUSE7_MIN = 327.558333;
  static final double E10_HOUSE8_MAX = 427.276667;
  static final double E10_HOUSE8_MIN = 327.558333;
  static final double E10_HOUSE9_MAX = 427.276667;
  static final double E10_HOUSE9_MIN = 327.558333;
  static final double E10_MC_MAX = 394.215000;
  static final double E10_MC_MIN = 330.556667;
  static final double E10_POLASC_MAX = 427.276667;
  static final double E10_POLASC_MIN = 327.558333;
  static final double E10_VERTEX_MAX = 2999820.000000;
  static final double E10_VERTEX_MIN = -180.000000;
  static final double E20_ARMC_MAX = 360.986667;
  static final double E20_ARMC_MIN = 360.984167;
  static final double E20_ASC_MAX = 467.280896;
  static final double E20_ASC_MIN = 319.225068;
  static final double E20_COASC1_MAX = 469.147500;
  static final double E20_COASC1_MIN = 318.595833;
  static final double E20_COASC2_MAX = 2999819.999167;
  static final double E20_COASC2_MIN = -180.000000;
  static final double E20_EQUASC_MAX = 394.215000;
  static final double E20_EQUASC_MIN = 330.556667;
  static final double E20_HOUSE10_MAX = 469.147500;
  static final double E20_HOUSE10_MIN = 318.595833;
  static final double E20_HOUSE11_MAX = 469.147500;
  static final double E20_HOUSE11_MIN = 318.595833;
  static final double E20_HOUSE12_MAX = 469.147500;
  static final double E20_HOUSE12_MIN = 318.595833;
  static final double E20_HOUSE1_MAX = 469.147500;
  static final double E20_HOUSE1_MIN = 318.595833;
  static final double E20_HOUSE2_MAX = 469.147500;
  static final double E20_HOUSE2_MIN = 318.595833;
  static final double E20_HOUSE3_MAX = 469.147500;
  static final double E20_HOUSE3_MIN = 318.595833;
  static final double E20_HOUSE4_MAX = 469.147500;
  static final double E20_HOUSE4_MIN = 318.595833;
  static final double E20_HOUSE5_MAX = 469.147500;
  static final double E20_HOUSE5_MIN = 318.595833;
  static final double E20_HOUSE6_MAX = 469.147500;
  static final double E20_HOUSE6_MIN = 318.595833;
  static final double E20_HOUSE7_MAX = 469.147500;
  static final double E20_HOUSE7_MIN = 318.595833;
  static final double E20_HOUSE8_MAX = 469.147500;
  static final double E20_HOUSE8_MIN = 318.595833;
  static final double E20_HOUSE9_MAX = 469.147500;
  static final double E20_HOUSE9_MIN = 318.595833;
  static final double E20_MC_MAX = 394.215000;
  static final double E20_MC_MIN = 330.556667;
  static final double E20_POLASC_MAX = 469.147500;
  static final double E20_POLASC_MIN = 318.595833;
  static final double E20_VERTEX_MAX = 2999819.999167;
  static final double E20_VERTEX_MIN = -180.000000;
  static final double E30_ARMC_MAX = 360.986667;
  static final double E30_ARMC_MIN = 360.984167;
  static final double E30_ASC_MAX = 524.994891;
  static final double E30_ASC_MIN = 304.407972;
  static final double E30_COASC1_MAX = 527.985000;
  static final double E30_COASC1_MIN = 303.743333;
  static final double E30_COASC2_MAX = 1643.109167;
  static final double E30_COASC2_MIN = 218.980000;
  static final double E30_EQUASC_MAX = 394.215000;
  static final double E30_EQUASC_MIN = 330.556667;
  static final double E30_HOUSE10_MAX = 527.985000;
  static final double E30_HOUSE10_MIN = 303.743333;
  static final double E30_HOUSE11_MAX = 527.985000;
  static final double E30_HOUSE11_MIN = 303.743333;
  static final double E30_HOUSE12_MAX = 527.985000;
  static final double E30_HOUSE12_MIN = 303.743333;
  static final double E30_HOUSE1_MAX = 527.985000;
  static final double E30_HOUSE1_MIN = 303.743333;
  static final double E30_HOUSE2_MAX = 527.985000;
  static final double E30_HOUSE2_MIN = 303.743333;
  static final double E30_HOUSE3_MAX = 527.985000;
  static final double E30_HOUSE3_MIN = 303.743333;
  static final double E30_HOUSE4_MAX = 527.985000;
  static final double E30_HOUSE4_MIN = 303.743333;
  static final double E30_HOUSE5_MAX = 527.985000;
  static final double E30_HOUSE5_MIN = 303.743333;
  static final double E30_HOUSE6_MAX = 527.985000;
  static final double E30_HOUSE6_MIN = 303.743333;
  static final double E30_HOUSE7_MAX = 527.985000;
  static final double E30_HOUSE7_MIN = 303.743333;
  static final double E30_HOUSE8_MAX = 527.985000;
  static final double E30_HOUSE8_MIN = 303.743333;
  static final double E30_HOUSE9_MAX = 527.985000;
  static final double E30_HOUSE9_MIN = 303.743333;
  static final double E30_MC_MAX = 394.215000;
  static final double E30_MC_MIN = 330.556667;
  static final double E30_POLASC_MAX = 527.985000;
  static final double E30_POLASC_MIN = 303.743333;
  static final double E30_VERTEX_MAX = 1643.108333;
  static final double E30_VERTEX_MIN = 218.980000;
  static final double E40_ARMC_MAX = 360.986667;
  static final double E40_ARMC_MIN = 360.984167;
  static final double E40_ASC_MAX = 618.738596;
  static final double E40_ASC_MIN = 283.720808;
  static final double E40_COASC1_MAX = 623.978333;
  static final double E40_COASC1_MIN = 282.993333;
  static final double E40_COASC2_MAX = 826.410833;
  static final double E40_COASC2_MIN = 255.830833;
  static final double E40_EQUASC_MAX = 394.215000;
  static final double E40_EQUASC_MIN = 330.556667;
  static final double E40_HOUSE10_MAX = 623.978333;
  static final double E40_HOUSE10_MIN = 282.993333;
  static final double E40_HOUSE11_MAX = 623.978333;
  static final double E40_HOUSE11_MIN = 282.993333;
  static final double E40_HOUSE12_MAX = 623.978333;
  static final double E40_HOUSE12_MIN = 282.993333;
  static final double E40_HOUSE1_MAX = 623.978333;
  static final double E40_HOUSE1_MIN = 282.993333;
  static final double E40_HOUSE2_MAX = 623.978333;
  static final double E40_HOUSE2_MIN = 282.993333;
  static final double E40_HOUSE3_MAX = 623.978333;
  static final double E40_HOUSE3_MIN = 282.993333;
  static final double E40_HOUSE4_MAX = 623.978333;
  static final double E40_HOUSE4_MIN = 282.993333;
  static final double E40_HOUSE5_MAX = 623.978333;
  static final double E40_HOUSE5_MIN = 282.993333;
  static final double E40_HOUSE6_MAX = 623.978333;
  static final double E40_HOUSE6_MIN = 282.993333;
  static final double E40_HOUSE7_MAX = 623.978333;
  static final double E40_HOUSE7_MIN = 282.993333;
  static final double E40_HOUSE8_MAX = 623.978333;
  static final double E40_HOUSE8_MIN = 282.993333;
  static final double E40_HOUSE9_MAX = 623.978333;
  static final double E40_HOUSE9_MIN = 282.993333;
  static final double E40_MC_MAX = 394.215000;
  static final double E40_MC_MIN = 330.556667;
  static final double E40_POLASC_MAX = 623.978333;
  static final double E40_POLASC_MIN = 282.993333;
  static final double E40_VERTEX_MAX = 826.410833;
  static final double E40_VERTEX_MIN = 255.830833;
  static final double E50_ARMC_MAX = 360.986667;
  static final double E50_ARMC_MIN = 360.984167;
  static final double E50_ASC_MAX = 814.745889;
  static final double E50_ASC_MIN = 256.684961;
  static final double E50_COASC1_MAX = 826.410833;
  static final double E50_COASC1_MIN = 255.830833;
  static final double E50_COASC2_MAX = 623.978333;
  static final double E50_COASC2_MIN = 282.993333;
  static final double E50_EQUASC_MAX = 394.215000;
  static final double E50_EQUASC_MIN = 330.556667;
  static final double E50_HOUSE10_MAX = 826.410833;
  static final double E50_HOUSE10_MIN = 255.830833;
  static final double E50_HOUSE11_MAX = 826.410833;
  static final double E50_HOUSE11_MIN = 255.830833;
  static final double E50_HOUSE12_MAX = 826.410833;
  static final double E50_HOUSE12_MIN = 255.830833;
  static final double E50_HOUSE1_MAX = 826.410833;
  static final double E50_HOUSE1_MIN = 255.830833;
  static final double E50_HOUSE2_MAX = 826.410833;
  static final double E50_HOUSE2_MIN = 255.830833;
  static final double E50_HOUSE3_MAX = 826.410833;
  static final double E50_HOUSE3_MIN = 255.830833;
  static final double E50_HOUSE4_MAX = 826.410833;
  static final double E50_HOUSE4_MIN = 255.830833;
  static final double E50_HOUSE5_MAX = 826.410833;
  static final double E50_HOUSE5_MIN = 255.830833;
  static final double E50_HOUSE6_MAX = 826.410833;
  static final double E50_HOUSE6_MIN = 255.830833;
  static final double E50_HOUSE7_MAX = 826.410833;
  static final double E50_HOUSE7_MIN = 255.830833;
  static final double E50_HOUSE8_MAX = 826.410833;
  static final double E50_HOUSE8_MIN = 255.830833;
  static final double E50_HOUSE9_MAX = 826.410833;
  static final double E50_HOUSE9_MIN = 255.830833;
  static final double E50_MC_MAX = 394.215000;
  static final double E50_MC_MIN = 330.556667;
  static final double E50_POLASC_MAX = 826.410833;
  static final double E50_POLASC_MIN = 255.830833;
  static final double E50_VERTEX_MAX = 623.978333;
  static final double E50_VERTEX_MIN = 282.993333;
  static final double E60_ARMC_MAX = 360.986667;
  static final double E60_ARMC_MIN = 360.984167;
  static final double E60_ASC_MAX = 1583.084164;
  static final double E60_ASC_MIN = 220.207028;
  static final double E60_COASC1_MAX = 1643.108333;
  static final double E60_COASC1_MIN = 218.980000;
  static final double E60_COASC2_MAX = 527.985000;
  static final double E60_COASC2_MIN = 303.743333;
  static final double E60_EQUASC_MAX = 394.215000;
  static final double E60_EQUASC_MIN = 330.556667;
  static final double E60_HOUSE10_MAX = 1643.109167;
  static final double E60_HOUSE10_MIN = 218.980000;
  static final double E60_HOUSE11_MAX = 1643.109167;
  static final double E60_HOUSE11_MIN = 218.980000;
  static final double E60_HOUSE12_MAX = 1643.109167;
  static final double E60_HOUSE12_MIN = 218.980000;
  static final double E60_HOUSE1_MAX = 1643.109167;
  static final double E60_HOUSE1_MIN = 218.980000;
  static final double E60_HOUSE2_MAX = 1643.109167;
  static final double E60_HOUSE2_MIN = 218.980000;
  static final double E60_HOUSE3_MAX = 1643.109167;
  static final double E60_HOUSE3_MIN = 218.980000;
  static final double E60_HOUSE4_MAX = 1643.109167;
  static final double E60_HOUSE4_MIN = 218.980000;
  static final double E60_HOUSE5_MAX = 1643.109167;
  static final double E60_HOUSE5_MIN = 218.980000;
  static final double E60_HOUSE6_MAX = 1643.109167;
  static final double E60_HOUSE6_MIN = 218.980000;
  static final double E60_HOUSE7_MAX = 1643.109167;
  static final double E60_HOUSE7_MIN = 218.980000;
  static final double E60_HOUSE8_MAX = 1643.109167;
  static final double E60_HOUSE8_MIN = 218.980000;
  static final double E60_HOUSE9_MAX = 1643.109167;
  static final double E60_HOUSE9_MIN = 218.980000;
  static final double E60_MC_MAX = 394.215000;
  static final double E60_MC_MIN = 330.556667;
  static final double E60_POLASC_MAX = 1643.108333;
  static final double E60_POLASC_MIN = 218.980000;
  static final double E60_VERTEX_MAX = 527.985000;
  static final double E60_VERTEX_MIN = 303.743333;
  static final double E66_ARMC_MAX = 360.986667;
  static final double E66_ARMC_MIN = 360.984167;
  static final double E66_ASC_MAX = 15382.763492;
  static final double E66_ASC_MIN = 180.714519;
  static final double E66_COASC1_MAX = 27433.717500;
  static final double E66_COASC1_MIN = 176.632500;
  static final double E66_COASC2_MAX = 489.939167;
  static final double E66_COASC2_MIN = 313.358333;
  static final double E66_EQUASC_MAX = 394.215000;
  static final double E66_EQUASC_MIN = 330.556667;
  static final double E66_HOUSE10_MAX = 27433.547500;
  static final double E66_HOUSE10_MIN = 176.632500;
  static final double E66_HOUSE11_MAX = 27433.547500;
  static final double E66_HOUSE11_MIN = 176.632500;
  static final double E66_HOUSE12_MAX = 27433.547500;
  static final double E66_HOUSE12_MIN = 176.632500;
  static final double E66_HOUSE1_MAX = 27433.547500;
  static final double E66_HOUSE1_MIN = 176.632500;
  static final double E66_HOUSE2_MAX = 27433.547500;
  static final double E66_HOUSE2_MIN = 176.632500;
  static final double E66_HOUSE3_MAX = 27433.547500;
  static final double E66_HOUSE3_MIN = 176.632500;
  static final double E66_HOUSE4_MAX = 27433.547500;
  static final double E66_HOUSE4_MIN = 176.632500;
  static final double E66_HOUSE5_MAX = 27433.547500;
  static final double E66_HOUSE5_MIN = 176.632500;
  static final double E66_HOUSE6_MAX = 27433.547500;
  static final double E66_HOUSE6_MIN = 176.632500;
  static final double E66_HOUSE7_MAX = 27433.547500;
  static final double E66_HOUSE7_MIN = 176.632500;
  static final double E66_HOUSE8_MAX = 27433.547500;
  static final double E66_HOUSE8_MIN = 176.632500;
  static final double E66_HOUSE9_MAX = 27433.547500;
  static final double E66_HOUSE9_MIN = 176.632500;
  static final double E66_MC_MAX = 394.215000;
  static final double E66_MC_MIN = 330.556667;
  static final double E66_POLASC_MAX = 27433.717500;
  static final double E66_POLASC_MIN = 176.632500;
  static final double E66_VERTEX_MAX = 489.939167;
  static final double E66_VERTEX_MIN = 313.358333;
  static final double E70_ARMC_MAX = 360.986667;
  static final double E70_ARMC_MIN = 360.984167;
  static final double E70_ASC_MAX = 1553150.329680;
  static final double E70_ASC_MIN = -777600.393020;
  static final double E70_COASC1_MAX = 2999819.999167;
  static final double E70_COASC1_MIN = -180.000000;
  static final double E70_COASC2_MAX = 469.147500;
  static final double E70_COASC2_MIN = 318.595833;
  static final double E70_EQUASC_MAX = 394.215000;
  static final double E70_EQUASC_MIN = 330.556667;
  static final double E70_HOUSE10_MAX = 2999820.000000;
  static final double E70_HOUSE10_MIN = -179.999167;
  static final double E70_HOUSE11_MAX = 2999820.000000;
  static final double E70_HOUSE11_MIN = -179.999167;
  static final double E70_HOUSE12_MAX = 2999820.000000;
  static final double E70_HOUSE12_MIN = -179.999167;
  static final double E70_HOUSE1_MAX = 2999820.000000;
  static final double E70_HOUSE1_MIN = -179.999167;
  static final double E70_HOUSE2_MAX = 2999820.000000;
  static final double E70_HOUSE2_MIN = -179.999167;
  static final double E70_HOUSE3_MAX = 2999819.999167;
  static final double E70_HOUSE3_MIN = -180.000000;
  static final double E70_HOUSE4_MAX = 2999819.999167;
  static final double E70_HOUSE4_MIN = -180.000000;
  static final double E70_HOUSE5_MAX = 2999819.999167;
  static final double E70_HOUSE5_MIN = -180.000000;
  static final double E70_HOUSE6_MAX = 2999819.999167;
  static final double E70_HOUSE6_MIN = -180.000000;
  static final double E70_HOUSE7_MAX = 2999819.999167;
  static final double E70_HOUSE7_MIN = -180.000000;
  static final double E70_HOUSE8_MAX = 2999820.000000;
  static final double E70_HOUSE8_MIN = -179.999167;
  static final double E70_HOUSE9_MAX = 2999820.000000;
  static final double E70_HOUSE9_MIN = -179.999167;
  static final double E70_MC_MAX = 394.215000;
  static final double E70_MC_MIN = 330.556667;
  static final double E70_POLASC_MAX = 2999820.000000;
  static final double E70_POLASC_MIN = -180.000000;
  static final double E70_VERTEX_MAX = 469.147500;
  static final double E70_VERTEX_MIN = 318.595833;
  static final double E80_ARMC_MAX = 360.986667;
  static final double E80_ARMC_MIN = 360.984167;
  static final double E80_ASC_MAX = 1554930.566184;
  static final double E80_ASC_MIN = -777600.124007;
  static final double E80_COASC1_MAX = 2999820.000000;
  static final double E80_COASC1_MIN = -180.000000;
  static final double E80_COASC2_MAX = 427.276667;
  static final double E80_COASC2_MIN = 327.558333;
  static final double E80_EQUASC_MAX = 394.215000;
  static final double E80_EQUASC_MIN = 330.556667;
  static final double E80_HOUSE10_MAX = 2999820.000000;
  static final double E80_HOUSE10_MIN = -180.000000;
  static final double E80_HOUSE11_MAX = 2999820.000000;
  static final double E80_HOUSE11_MIN = -180.000000;
  static final double E80_HOUSE12_MAX = 2999820.000000;
  static final double E80_HOUSE12_MIN = -180.000000;
  static final double E80_HOUSE1_MAX = 2999820.000000;
  static final double E80_HOUSE1_MIN = -180.000000;
  static final double E80_HOUSE2_MAX = 2999820.000000;
  static final double E80_HOUSE2_MIN = -180.000000;
  static final double E80_HOUSE3_MAX = 2999820.000000;
  static final double E80_HOUSE3_MIN = -180.000000;
  static final double E80_HOUSE4_MAX = 2999820.000000;
  static final double E80_HOUSE4_MIN = -180.000000;
  static final double E80_HOUSE5_MAX = 2999820.000000;
  static final double E80_HOUSE5_MIN = -180.000000;
  static final double E80_HOUSE6_MAX = 2999820.000000;
  static final double E80_HOUSE6_MIN = -180.000000;
  static final double E80_HOUSE7_MAX = 2999820.000000;
  static final double E80_HOUSE7_MIN = -180.000000;
  static final double E80_HOUSE8_MAX = 2999820.000000;
  static final double E80_HOUSE8_MIN = -180.000000;
  static final double E80_HOUSE9_MAX = 2999820.000000;
  static final double E80_HOUSE9_MIN = -180.000000;
  static final double E80_MC_MAX = 394.215000;
  static final double E80_MC_MIN = 330.556667;
  static final double E80_POLASC_MAX = 2999820.000000;
  static final double E80_POLASC_MIN = -180.000000;
  static final double E80_VERTEX_MAX = 427.276667;
  static final double E80_VERTEX_MIN = 327.558333;
  static final double E85_ARMC_MAX = 360.986667;
  static final double E85_ARMC_MIN = 360.984167;
  static final double E85_ASC_MAX = 1555100.603952;
  static final double E85_ASC_MIN = -777600.058703;
  static final double E85_COASC1_MAX = 2999901.836667;
  static final double E85_COASC1_MIN = -100.323333;
  static final double E85_COASC2_MAX = 409.954167;
  static final double E85_COASC2_MIN = 329.806667;
  static final double E85_EQUASC_MAX = 394.215000;
  static final double E85_EQUASC_MIN = 330.556667;
  static final double E85_HOUSE10_MAX = 1500000.030833;
  static final double E85_HOUSE10_MIN = -100.323333;
  static final double E85_HOUSE11_MAX = 1500000.030833;
  static final double E85_HOUSE11_MIN = -100.323333;
  static final double E85_HOUSE12_MAX = 1500000.030833;
  static final double E85_HOUSE12_MIN = -100.323333;
  static final double E85_HOUSE1_MAX = 2999901.836667;
  static final double E85_HOUSE1_MIN = -100.323333;
  static final double E85_HOUSE2_MAX = 1500000.030833;
  static final double E85_HOUSE2_MIN = -100.323333;
  static final double E85_HOUSE3_MAX = 1500000.030833;
  static final double E85_HOUSE3_MIN = -100.323333;
  static final double E85_HOUSE4_MAX = 1500000.030833;
  static final double E85_HOUSE4_MIN = -100.323333;
  static final double E85_HOUSE5_MAX = 1500000.030833;
  static final double E85_HOUSE5_MIN = -100.323333;
  static final double E85_HOUSE6_MAX = 1500000.030833;
  static final double E85_HOUSE6_MIN = -100.323333;
  static final double E85_HOUSE7_MAX = 1500000.030833;
  static final double E85_HOUSE7_MIN = -100.323333;
  static final double E85_HOUSE8_MAX = 1500000.030833;
  static final double E85_HOUSE8_MIN = -100.323333;
  static final double E85_HOUSE9_MAX = 1500000.030833;
  static final double E85_HOUSE9_MIN = -100.323333;
  static final double E85_MC_MAX = 394.215000;
  static final double E85_MC_MIN = 330.556667;
  static final double E85_POLASC_MAX = 66.413333;
  static final double E85_POLASC_MIN = -100.323333;
  static final double E85_VERTEX_MAX = 409.954167;
  static final double E85_VERTEX_MIN = 329.806667;
  static final double E88_ARMC_MAX = 360.985931;
  static final double E88_ARMC_MIN = 360.985828;
  static final double E88_ASC_MAX = 1555165.554408;
  static final double E88_ASC_MIN = -777600.023170;
  static final double E88_COASC1_MAX = 1555165.554409;
  static final double E88_COASC1_MIN = -34.489296;
  static final double E88_COASC2_MAX = 399.547623;
  static final double E88_COASC2_MIN = 331.043079;
  static final double E88_EQUASC_MAX = 393.494420;
  static final double E88_EQUASC_MIN = 331.162937;
  static final double E88_HOUSE10_MAX = 1555199.976849;
  static final double E88_HOUSE10_MIN = 0.023142;
  static final double E88_HOUSE11_MAX = 1555199.976849;
  static final double E88_HOUSE11_MIN = 0.023142;
  static final double E88_HOUSE12_MAX = 1555199.976849;
  static final double E88_HOUSE12_MIN = 0.023142;
  static final double E88_HOUSE1_MAX = 1555199.976849;
  static final double E88_HOUSE1_MIN = 0.023142;
  static final double E88_HOUSE2_MAX = 1555199.976849;
  static final double E88_HOUSE2_MIN = 0.023142;
  static final double E88_HOUSE3_MAX = 1555199.976849;
  static final double E88_HOUSE3_MIN = 0.023142;
  static final double E88_HOUSE4_MAX = 1555199.976849;
  static final double E88_HOUSE4_MIN = 0.023142;
  static final double E88_HOUSE5_MAX = 1555199.976849;
  static final double E88_HOUSE5_MIN = 0.023142;
  static final double E88_HOUSE6_MAX = 1555199.976849;
  static final double E88_HOUSE6_MIN = 0.023142;
  static final double E88_HOUSE7_MAX = 1555199.976849;
  static final double E88_HOUSE7_MIN = 0.023142;
  static final double E88_HOUSE8_MAX = 1555199.976849;
  static final double E88_HOUSE8_MIN = 0.023142;
  static final double E88_HOUSE9_MAX = 1555199.976849;
  static final double E88_HOUSE9_MIN = 0.023142;
  static final double E88_MC_MAX = 393.494420;
  static final double E88_MC_MIN = 331.162936;
  static final double E88_POLASC_MAX = 29.344230;
  static final double E88_POLASC_MIN = -34.489313;
  static final double E88_VERTEX_MAX = 399.547621;
  static final double E88_VERTEX_MIN = 331.043081;
  static final double E89x_ARMC_MAX = 360.986667;
  static final double E89x_ARMC_MIN = 360.984167;
  static final double E89x_ASC_MAX = 1555200.000000;
  static final double E89x_ASC_MIN = -777600.000000;
  static final double E89x_COASC1_MAX = 2999998.426667;
  static final double E89x_COASC1_MIN = -1.600833;
  static final double E89x_COASC2_MAX = 394.516667;
  static final double E89x_COASC2_MIN = 330.556667;
  static final double E89x_EQUASC_MAX = 394.215000;
  static final double E89x_EQUASC_MIN = 330.556667;
  static final double E89x_HOUSE10_MAX = 1500000.000833;
  static final double E89x_HOUSE10_MIN = -1.600833;
  static final double E89x_HOUSE11_MAX = 1500000.000833;
  static final double E89x_HOUSE11_MIN = -1.600833;
  static final double E89x_HOUSE12_MAX = 1500000.000833;
  static final double E89x_HOUSE12_MIN = -1.600833;
  static final double E89x_HOUSE1_MAX = 2999998.426667;
  static final double E89x_HOUSE1_MIN = -1.600833;
  static final double E89x_HOUSE2_MAX = 1500000.000833;
  static final double E89x_HOUSE2_MIN = -1.600833;
  static final double E89x_HOUSE3_MAX = 1500000.000833;
  static final double E89x_HOUSE3_MIN = -1.600833;
  static final double E89x_HOUSE4_MAX = 1500000.000833;
  static final double E89x_HOUSE4_MIN = -1.600833;
  static final double E89x_HOUSE5_MAX = 1500000.000833;
  static final double E89x_HOUSE5_MIN = -1.600833;
  static final double E89x_HOUSE6_MAX = 1500000.000833;
  static final double E89x_HOUSE6_MIN = -1.600833;
  static final double E89x_HOUSE7_MAX = 1500000.000833;
  static final double E89x_HOUSE7_MIN = -1.600833;
  static final double E89x_HOUSE8_MAX = 1500000.000833;
  static final double E89x_HOUSE8_MIN = -1.600833;
  static final double E89x_HOUSE9_MAX = 1500000.000833;
  static final double E89x_HOUSE9_MIN = -1.600833;
  static final double E89x_MC_MAX = 394.215000;
  static final double E89x_MC_MIN = 330.556667;
  static final double E89x_POLASC_MAX = 1.588333;
  static final double E89x_POLASC_MIN = -1.600833;
  static final double E89x_VERTEX_MAX = 394.516667;
  static final double E89x_VERTEX_MIN = 330.556667;
  static final double G0_ARMC_MAX = 360.985931;
  static final double G0_ARMC_MIN = 360.985828;
  static final double G0_ASC_MAX = 393.494420;
  static final double G0_ASC_MIN = 331.162937;
  static final double G0_COASC1_MAX = 393.494420;
  static final double G0_COASC1_MIN = 331.162937;
  static final double G0_COASC2_MAX = 1./0.;
  static final double G0_COASC2_MIN = 1./0.;
  static final double G0_EQUASC_MAX = 393.494420;
  static final double G0_EQUASC_MIN = 331.162937;
  static final double G0_HOUSE10_MAX = 618069.268650;
  static final double G0_HOUSE11_MAX = 618069.271879;
  static final double G0_HOUSE12_MAX = 618069.269675;
  static final double G0_HOUSE1_MAX = 618069.268986;
  static final double G0_HOUSE2_MAX = 618069.272193;
  static final double G0_HOUSE3_MAX = 618069.269514;
  static final double G0_HOUSE4_MAX = 618069.268981;
  static final double G0_HOUSE5_MAX = 618069.272083;
  static final double G0_HOUSE6_MAX = 618069.269644;
  static final double G0_HOUSE7_MAX = 618069.268869;
  static final double G0_HOUSE8_MAX = 618069.271867;
  static final double G0_HOUSE9_MAX = 618069.269698;
  static final double G0_MC_MAX = 393.494420;
  static final double G0_MC_MIN = 331.162936;
  static final double G0_POLASC_MAX = 393.494420;
  static final double G0_POLASC_MIN = 331.162937;
  static final double G0_VERTEX_MAX = 0.0;
  static final double G0_VERTEX_MIN = 0.0;
  static final double G10_ARMC_MAX = 360.985931;
  static final double G10_ARMC_MIN = 360.985828;
  static final double G10_ASC_MAX = 426.089536;
  static final double G10_ASC_MIN = 328.169552;
  static final double G10_COASC1_MAX = 426.089531;
  static final double G10_COASC1_MIN = 328.169550;
  static final double G10_COASC2_MAX = 113.797795;
  static final double G10_COASC2_MIN = -269.996070;
  static final double G10_EQUASC_MAX = 393.494420;
  static final double G10_EQUASC_MIN = 331.162937;
  static final double G10_HOUSE10_MAX = 625566.056490;
  static final double G10_HOUSE11_MAX = 625519.156807;
  static final double G10_HOUSE12_MAX = 625503.499422;
  static final double G10_HOUSE1_MAX = 626259.230911;
  static final double G10_HOUSE2_MAX = 622607.544407;
  static final double G10_HOUSE3_MAX = 618981.972839;
  static final double G10_HOUSE4_MAX = 622607.550167;
  static final double G10_HOUSE5_MAX = 626259.235177;
  static final double G10_HOUSE6_MAX = 626060.954671;
  static final double G10_HOUSE7_MAX = 625891.938453;
  static final double G10_HOUSE8_MAX = 625752.799804;
  static final double G10_HOUSE9_MAX = 625644.037926;
  static final double G10_MC_MAX = 393.494420;
  static final double G10_MC_MIN = 331.162936;
  static final double G10_POLASC_MAX = 426.089531;
  static final double G10_POLASC_MIN = 328.169550;
  static final double G10_VERTEX_MAX = 1554930.566243;
  static final double G10_VERTEX_MIN = -777600.124028;
  static final double G20_ARMC_MAX = 360.985931;
  static final double G20_ARMC_MIN = 360.985828;
  static final double G20_ASC_MAX = 467.280896;
  static final double G20_ASC_MIN = 319.225068;
  static final double G20_COASC1_MAX = 467.280888;
  static final double G20_COASC1_MIN = 319.225070;
  static final double G20_COASC2_MAX = 179.610407;
  static final double G20_COASC2_MIN = -2066.757500;
  static final double G20_EQUASC_MAX = 393.494420;
  static final double G20_EQUASC_MIN = 331.162937;
  static final double G20_HOUSE10_MAX = 633757.325623;
  static final double G20_HOUSE11_MAX = 633591.944009;
  static final double G20_HOUSE12_MAX = 633536.546825;
  static final double G20_HOUSE1_MAX = 636105.591001;
  static final double G20_HOUSE2_MAX = 628862.994299;
  static final double G20_HOUSE3_MAX = 621813.876521;
  static final double G20_HOUSE4_MAX = 628862.996048;
  static final double G20_HOUSE5_MAX = 636105.595255;
  static final double G20_HOUSE6_MAX = 635451.214241;
  static final double G20_HOUSE7_MAX = 634882.813844;
  static final double G20_HOUSE8_MAX = 634407.177802;
  static final double G20_HOUSE9_MAX = 634030.335144;
  static final double G20_MC_MAX = 393.494420;
  static final double G20_MC_MIN = 331.162936;
  static final double G20_POLASC_MAX = 467.280888;
  static final double G20_POLASC_MIN = 319.225070;
  static final double G20_VERTEX_MAX = 1553150.334620;
  static final double G20_VERTEX_MIN = -777600.393091;
  static final double G30_ARMC_MAX = 360.985931;
  static final double G30_ARMC_MIN = 360.985828;
  static final double G30_ASC_MAX = 524.994891;
  static final double G30_ASC_MIN = 304.407972;
  static final double G30_COASC1_MAX = 524.994878;
  static final double G30_COASC1_MIN = 304.407972;
  static final double G30_COASC2_MAX = 1583.084164;
  static final double G30_COASC2_MIN = 220.207028;
  static final double G30_EQUASC_MAX = 393.494420;
  static final double G30_EQUASC_MIN = 331.162937;
  static final double G30_HOUSE10_MAX = 643338.504381;
  static final double G30_HOUSE11_MAX = 643000.097945;
  static final double G30_HOUSE12_MAX = 642886.058685;
  static final double G30_HOUSE1_MAX = 647860.611906;
  static final double G30_HOUSE2_MAX = 636985.811051;
  static final double G30_HOUSE3_MAX = 626838.903213;
  static final double G30_HOUSE4_MAX = 636985.804802;
  static final double G30_HOUSE5_MAX = 647860.615574;
  static final double G30_HOUSE6_MAX = 646648.019389;
  static final double G30_HOUSE7_MAX = 645566.843184;
  static final double G30_HOUSE8_MAX = 644640.212711;
  static final double G30_HOUSE9_MAX = 643890.658803;
  static final double G30_MC_MAX = 393.494420;
  static final double G30_MC_MIN = 331.162936;
  static final double G30_POLASC_MAX = 524.994878;
  static final double G30_POLASC_MIN = 304.407972;
  static final double G30_VERTEX_MAX = 1583.084212;
  static final double G30_VERTEX_MIN = 220.207025;
  static final double G40_ARMC_MAX = 360.985931;
  static final double G40_ARMC_MIN = 360.985828;
  static final double G40_ASC_MAX = 618.738596;
  static final double G40_ASC_MIN = 283.720808;
  static final double G40_COASC1_MAX = 618.738574;
  static final double G40_COASC1_MIN = 283.720804;
  static final double G40_COASC2_MAX = 814.745889;
  static final double G40_COASC2_MIN = 256.684961;
  static final double G40_EQUASC_MAX = 393.494420;
  static final double G40_EQUASC_MIN = 331.162937;
  static final double G40_HOUSE10_MAX = 655542.982582;
  static final double G40_HOUSE11_MAX = 654984.466139;
  static final double G40_HOUSE12_MAX = 654794.496837;
  static final double G40_HOUSE1_MAX = 662426.923641;
  static final double G40_HOUSE2_MAX = 647516.608835;
  static final double G40_HOUSE3_MAX = 634495.596469;
  static final double G40_HOUSE4_MAX = 647516.602274;
  static final double G40_HOUSE5_MAX = 662426.924775;
  static final double G40_HOUSE6_MAX = 660669.275697;
  static final double G40_HOUSE7_MAX = 659053.150387;
  static final double G40_HOUSE8_MAX = 657625.757986;
  static final double G40_HOUSE9_MAX = 656438.527042;
  static final double G40_MC_MAX = 393.494420;
  static final double G40_MC_MIN = 331.162936;
  static final double G40_POLASC_MAX = 618.738574;
  static final double G40_POLASC_MIN = 283.720804;
  static final double G40_VERTEX_MAX = 814.745850;
  static final double G40_VERTEX_MIN = 256.684960;
  static final double G50_ARMC_MAX = 360.985931;
  static final double G50_ARMC_MIN = 360.985828;
  static final double G50_ASC_MAX = 814.745889;
  static final double G50_ASC_MIN = 256.684961;
  static final double G50_COASC1_MAX = 814.745850;
  static final double G50_COASC1_MIN = 256.684960;
  static final double G50_COASC2_MAX = 618.738596;
  static final double G50_COASC2_MIN = 283.720808;
  static final double G50_EQUASC_MAX = 393.494420;
  static final double G50_EQUASC_MIN = 331.162937;
  static final double G50_HOUSE10_MAX = 673078.010261;
  static final double G50_HOUSE11_MAX = 672271.164629;
  static final double G50_HOUSE12_MAX = 671992.714643;
  static final double G50_HOUSE1_MAX = 682028.400403;
  static final double G50_HOUSE2_MAX = 661833.556130;
  static final double G50_HOUSE3_MAX = 645460.039452;
  static final double G50_HOUSE4_MAX = 661833.552021;
  static final double G50_HOUSE5_MAX = 682028.392125;
  static final double G50_HOUSE6_MAX = 679877.214011;
  static final double G50_HOUSE7_MAX = 677829.789784;
  static final double G50_HOUSE8_MAX = 675954.995592;
  static final double G50_HOUSE9_MAX = 674338.421562;
  static final double G50_MC_MAX = 393.494420;
  static final double G50_MC_MIN = 331.162936;
  static final double G50_POLASC_MAX = 814.745850;
  static final double G50_POLASC_MIN = 256.684960;
  static final double G50_VERTEX_MAX = 618.738574;
  static final double G50_VERTEX_MIN = 283.720804;
  static final double G60_ARMC_MAX = 360.985931;
  static final double G60_ARMC_MIN = 360.985828;
  static final double G60_ASC_MAX = 1583.084164;
  static final double G60_ASC_MIN = 220.207028;
  static final double G60_COASC1_MAX = 1583.084212;
  static final double G60_COASC1_MIN = 220.207025;
  static final double G60_COASC2_MAX = 524.994891;
  static final double G60_COASC2_MIN = 304.407972;
  static final double G60_EQUASC_MAX = 393.494420;
  static final double G60_EQUASC_MIN = 331.162937;
  static final double G60_HOUSE10_MAX = 704539.539703;
  static final double G60_HOUSE11_MAX = 703592.906555;
  static final double G60_HOUSE12_MAX = 703258.014848;
  static final double G60_HOUSE1_MAX = 713644.738826;
  static final double G60_HOUSE2_MAX = 684351.324974;
  static final double G60_HOUSE3_MAX = 661579.518493;
  static final double G60_HOUSE4_MAX = 684351.329299;
  static final double G60_HOUSE5_MAX = 713644.731227;
  static final double G60_HOUSE6_MAX = 711618.608226;
  static final double G60_HOUSE7_MAX = 709612.762295;
  static final double G60_HOUSE8_MAX = 707693.631935;
  static final double G60_HOUSE9_MAX = 705958.513528;
  static final double G60_MC_MAX = 393.494420;
  static final double G60_MC_MIN = 331.162936;
  static final double G60_POLASC_MAX = 1583.084212;
  static final double G60_POLASC_MIN = 220.207025;
  static final double G60_VERTEX_MAX = 524.994878;
  static final double G60_VERTEX_MIN = 304.407972;
  static final double G66_ARMC_MAX = 360.985931;
  static final double G66_ARMC_MIN = 360.985828;
  static final double G66_ASC_MAX = 15382.763492;
  static final double G66_ASC_MIN = 180.714519;
  static final double G66_COASC1_MAX = 15382.960178;
  static final double G66_COASC1_MIN = 180.714532;
  static final double G66_COASC2_MAX = 487.697885;
  static final double G66_COASC2_MIN = 313.998924;
  static final double G66_EQUASC_MAX = 393.494420;
  static final double G66_EQUASC_MIN = 331.162937;
  static final double G66_HOUSE10_MAX = 754716.060187;
  static final double G66_HOUSE11_MAX = 754299.736921;
  static final double G66_HOUSE12_MAX = 754148.739990;
  static final double G66_HOUSE1_MAX = 758295.347687;
  static final double G66_HOUSE2_MAX = 715025.938248;
  static final double G66_HOUSE3_MAX = 680264.439391;
  static final double G66_HOUSE4_MAX = 715025.943727;
  static final double G66_HOUSE5_MAX = 758295.323647;
  static final double G66_HOUSE6_MAX = 757541.363295;
  static final double G66_HOUSE7_MAX = 756776.012625;
  static final double G66_HOUSE8_MAX = 756022.464545;
  static final double G66_HOUSE9_MAX = 755316.703909;
  static final double G66_MC_MAX = 393.494420;
  static final double G66_MC_MIN = 331.162936;
  static final double G66_POLASC_MAX = 15382.960178;
  static final double G66_POLASC_MIN = 180.714532;
  static final double G66_VERTEX_MAX = 487.697876;
  static final double G66_VERTEX_MIN = 313.998925;
  static final double H0_ARMC_MAX = 360.986667;
  static final double H0_ARMC_MIN = 360.984167;
  static final double H0_ASC_MAX = 393.494420;
  static final double H0_ASC_MIN = 331.162937;
  static final double H0_COASC1_MAX = 394.215000;
  static final double H0_COASC1_MIN = 330.556667;
  static final double H0_COASC2_MAX = 3000000.000000;
  static final double H0_COASC2_MIN = 0.000000;
  static final double H0_EQUASC_MAX = 394.215000;
  static final double H0_EQUASC_MIN = 330.556667;
  static final double H0_HOUSE10_MAX = 394.215000;
  static final double H0_HOUSE10_MIN = 330.556667;
  static final double H0_HOUSE11_MAX = 527.985000;
  static final double H0_HOUSE11_MIN = 303.743333;
  static final double H0_HOUSE12_MAX = 1643.108333;
  static final double H0_HOUSE12_MIN = 218.980000;
  static final double H0_HOUSE1_MAX = 0.000000;
  static final double H0_HOUSE1_MIN = 0.000000;
  static final double H0_HOUSE2_MAX = 1643.108333;
  static final double H0_HOUSE2_MIN = 218.980000;
  static final double H0_HOUSE3_MAX = 527.985000;
  static final double H0_HOUSE3_MIN = 303.743333;
  static final double H0_HOUSE4_MAX = 394.215000;
  static final double H0_HOUSE4_MIN = 330.556667;
  static final double H0_HOUSE5_MAX = 527.985000;
  static final double H0_HOUSE5_MIN = 303.743333;
  static final double H0_HOUSE6_MAX = 1643.108333;
  static final double H0_HOUSE6_MIN = 218.980000;
  static final double H0_HOUSE7_MAX = 3000000.000000;
  static final double H0_HOUSE7_MIN = 0.000000;
  static final double H0_HOUSE8_MAX = 1643.108333;
  static final double H0_HOUSE8_MIN = 218.980000;
  static final double H0_HOUSE9_MAX = 527.985000;
  static final double H0_HOUSE9_MIN = 303.743333;
  static final double H0_MC_MAX = 394.215000;
  static final double H0_MC_MIN = 330.556667;
  static final double H0_POLASC_MAX = 394.215000;
  static final double H0_POLASC_MIN = 330.556667;
  static final double H0_VERTEX_MAX = 1500000.000000;
  static final double H0_VERTEX_MIN = 0.000000;
  static final double H10_ARMC_MAX = 360.986667;
  static final double H10_ARMC_MIN = 360.984167;
  static final double H10_ASC_MAX = 426.089536;
  static final double H10_ASC_MIN = 328.169552;
  static final double H10_COASC1_MAX = 427.276667;
  static final double H10_COASC1_MIN = 327.558333;
  static final double H10_COASC2_MAX = 2999820.000000;
  static final double H10_COASC2_MIN = -180.000000;
  static final double H10_EQUASC_MAX = 394.215000;
  static final double H10_EQUASC_MIN = 330.556667;
  static final double H10_HOUSE10_MAX = 394.215000;
  static final double H10_HOUSE10_MIN = 330.556667;
  static final double H10_HOUSE11_MAX = 524.406667;
  static final double H10_HOUSE11_MIN = 304.627500;
  static final double H10_HOUSE12_MAX = 1392.063333;
  static final double H10_HOUSE12_MIN = 225.450000;
  static final double H10_HOUSE1_MAX = 2999820.000000;
  static final double H10_HOUSE1_MIN = -180.000000;
  static final double H10_HOUSE2_MAX = 1392.063333;
  static final double H10_HOUSE2_MIN = 225.450000;
  static final double H10_HOUSE3_MAX = 524.406667;
  static final double H10_HOUSE3_MIN = 304.627500;
  static final double H10_HOUSE4_MAX = 394.215000;
  static final double H10_HOUSE4_MIN = 330.556667;
  static final double H10_HOUSE5_MAX = 524.406667;
  static final double H10_HOUSE5_MIN = 304.627500;
  static final double H10_HOUSE6_MAX = 1392.063333;
  static final double H10_HOUSE6_MIN = 225.450000;
  static final double H10_HOUSE7_MAX = 2999820.000000;
  static final double H10_HOUSE7_MIN = -180.000000;
  static final double H10_HOUSE8_MAX = 1392.063333;
  static final double H10_HOUSE8_MIN = 225.450000;
  static final double H10_HOUSE9_MAX = 524.406667;
  static final double H10_HOUSE9_MIN = 304.627500;
  static final double H10_MC_MAX = 394.215000;
  static final double H10_MC_MIN = 330.556667;
  static final double H10_POLASC_MAX = 427.276667;
  static final double H10_POLASC_MIN = 327.558333;
  static final double H10_VERTEX_MAX = 2999820.000000;
  static final double H10_VERTEX_MIN = -180.000000;
  static final double H20_ARMC_MAX = 360.986667;
  static final double H20_ARMC_MIN = 360.984167;
  static final double H20_ASC_MAX = 467.280896;
  static final double H20_ASC_MIN = 319.225068;
  static final double H20_COASC1_MAX = 469.147500;
  static final double H20_COASC1_MIN = 318.595833;
  static final double H20_COASC2_MAX = 2999819.999167;
  static final double H20_COASC2_MIN = -180.000000;
  static final double H20_EQUASC_MAX = 394.215000;
  static final double H20_EQUASC_MIN = 330.556667;
  static final double H20_HOUSE10_MAX = 394.215000;
  static final double H20_HOUSE10_MIN = 330.556667;
  static final double H20_HOUSE11_MAX = 514.351667;
  static final double H20_HOUSE11_MIN = 307.142500;
  static final double H20_HOUSE12_MAX = 1022.629167;
  static final double H20_HOUSE12_MIN = 241.054167;
  static final double H20_HOUSE1_MAX = 2999819.999167;
  static final double H20_HOUSE1_MIN = -180.000000;
  static final double H20_HOUSE2_MAX = 1022.629167;
  static final double H20_HOUSE2_MIN = 241.054167;
  static final double H20_HOUSE3_MAX = 514.351667;
  static final double H20_HOUSE3_MIN = 307.142500;
  static final double H20_HOUSE4_MAX = 394.215000;
  static final double H20_HOUSE4_MIN = 330.556667;
  static final double H20_HOUSE5_MAX = 514.351667;
  static final double H20_HOUSE5_MIN = 307.142500;
  static final double H20_HOUSE6_MAX = 1022.629167;
  static final double H20_HOUSE6_MIN = 241.054167;
  static final double H20_HOUSE7_MAX = 2999820.000000;
  static final double H20_HOUSE7_MIN = -180.000000;
  static final double H20_HOUSE8_MAX = 1022.629167;
  static final double H20_HOUSE8_MIN = 241.054167;
  static final double H20_HOUSE9_MAX = 514.351667;
  static final double H20_HOUSE9_MIN = 307.142500;
  static final double H20_MC_MAX = 394.215000;
  static final double H20_MC_MIN = 330.556667;
  static final double H20_POLASC_MAX = 469.147500;
  static final double H20_POLASC_MIN = 318.595833;
  static final double H20_VERTEX_MAX = 2999819.999167;
  static final double H20_VERTEX_MIN = -180.000000;
  static final double H30_ARMC_MAX = 360.986667;
  static final double H30_ARMC_MIN = 360.984167;
  static final double H30_ASC_MAX = 524.994891;
  static final double H30_ASC_MIN = 304.407972;
  static final double H30_COASC1_MAX = 527.985000;
  static final double H30_COASC1_MIN = 303.743333;
  static final double H30_COASC2_MAX = 1643.109167;
  static final double H30_COASC2_MIN = 218.980000;
  static final double H30_EQUASC_MAX = 394.215000;
  static final double H30_EQUASC_MIN = 330.556667;
  static final double H30_HOUSE10_MAX = 394.215000;
  static final double H30_HOUSE10_MIN = 330.556667;
  static final double H30_HOUSE11_MAX = 499.516667;
  static final double H30_HOUSE11_MIN = 310.910833;
  static final double H30_HOUSE12_MAX = 784.645833;
  static final double H30_HOUSE12_MIN = 260.105000;
  static final double H30_HOUSE1_MAX = 1643.108333;
  static final double H30_HOUSE1_MIN = 218.980000;
  static final double H30_HOUSE2_MAX = 784.645833;
  static final double H30_HOUSE2_MIN = 260.105000;
  static final double H30_HOUSE3_MAX = 499.516667;
  static final double H30_HOUSE3_MIN = 310.910833;
  static final double H30_HOUSE4_MAX = 394.215000;
  static final double H30_HOUSE4_MIN = 330.556667;
  static final double H30_HOUSE5_MAX = 499.516667;
  static final double H30_HOUSE5_MIN = 310.910833;
  static final double H30_HOUSE6_MAX = 784.645833;
  static final double H30_HOUSE6_MIN = 260.105000;
  static final double H30_HOUSE7_MAX = 1643.108333;
  static final double H30_HOUSE7_MIN = 218.980000;
  static final double H30_HOUSE8_MAX = 784.645833;
  static final double H30_HOUSE8_MIN = 260.105000;
  static final double H30_HOUSE9_MAX = 499.516667;
  static final double H30_HOUSE9_MIN = 310.910833;
  static final double H30_MC_MAX = 394.215000;
  static final double H30_MC_MIN = 330.556667;
  static final double H30_POLASC_MAX = 527.985000;
  static final double H30_POLASC_MIN = 303.743333;
  static final double H30_VERTEX_MAX = 1643.108333;
  static final double H30_VERTEX_MIN = 218.980000;
  static final double H40_ARMC_MAX = 360.986667;
  static final double H40_ARMC_MIN = 360.984167;
  static final double H40_ASC_MAX = 618.738596;
  static final double H40_ASC_MIN = 283.720808;
  static final double H40_COASC1_MAX = 623.978333;
  static final double H40_COASC1_MIN = 282.993333;
  static final double H40_COASC2_MAX = 826.410833;
  static final double H40_COASC2_MIN = 255.830833;
  static final double H40_EQUASC_MAX = 394.215000;
  static final double H40_EQUASC_MIN = 330.556667;
  static final double H40_HOUSE10_MAX = 394.215000;
  static final double H40_HOUSE10_MIN = 330.556667;
  static final double H40_HOUSE11_MAX = 481.900833;
  static final double H40_HOUSE11_MIN = 315.404167;
  static final double H40_HOUSE12_MAX = 645.276667;
  static final double H40_HOUSE12_MIN = 279.204167;
  static final double H40_HOUSE1_MAX = 826.410833;
  static final double H40_HOUSE1_MIN = 255.830833;
  static final double H40_HOUSE2_MAX = 645.276667;
  static final double H40_HOUSE2_MIN = 279.204167;
  static final double H40_HOUSE3_MAX = 481.900833;
  static final double H40_HOUSE3_MIN = 315.404167;
  static final double H40_HOUSE4_MAX = 394.215000;
  static final double H40_HOUSE4_MIN = 330.556667;
  static final double H40_HOUSE5_MAX = 481.900833;
  static final double H40_HOUSE5_MIN = 315.404167;
  static final double H40_HOUSE6_MAX = 645.276667;
  static final double H40_HOUSE6_MIN = 279.204167;
  static final double H40_HOUSE7_MAX = 826.410833;
  static final double H40_HOUSE7_MIN = 255.830833;
  static final double H40_HOUSE8_MAX = 645.276667;
  static final double H40_HOUSE8_MIN = 279.204167;
  static final double H40_HOUSE9_MAX = 481.900833;
  static final double H40_HOUSE9_MIN = 315.404167;
  static final double H40_MC_MAX = 394.215000;
  static final double H40_MC_MIN = 330.556667;
  static final double H40_POLASC_MAX = 623.978333;
  static final double H40_POLASC_MIN = 282.993333;
  static final double H40_VERTEX_MAX = 826.410833;
  static final double H40_VERTEX_MIN = 255.830833;
  static final double H50_ARMC_MAX = 360.986667;
  static final double H50_ARMC_MIN = 360.984167;
  static final double H50_ASC_MAX = 814.745889;
  static final double H50_ASC_MIN = 256.684961;
  static final double H50_COASC1_MAX = 826.410833;
  static final double H50_COASC1_MIN = 255.830833;
  static final double H50_COASC2_MAX = 623.978333;
  static final double H50_COASC2_MIN = 282.993333;
  static final double H50_EQUASC_MAX = 394.215000;
  static final double H50_EQUASC_MIN = 330.556667;
  static final double H50_HOUSE10_MAX = 394.215000;
  static final double H50_HOUSE10_MIN = 330.556667;
  static final double H50_HOUSE11_MAX = 463.204167;
  static final double H50_HOUSE11_MIN = 320.042500;
  static final double H50_HOUSE12_MAX = 558.424167;
  static final double H50_HOUSE12_MIN = 296.510000;
  static final double H50_HOUSE1_MAX = 623.978333;
  static final double H50_HOUSE1_MIN = 282.993333;
  static final double H50_HOUSE2_MAX = 558.424167;
  static final double H50_HOUSE2_MIN = 296.510000;
  static final double H50_HOUSE3_MAX = 463.204167;
  static final double H50_HOUSE3_MIN = 320.042500;
  static final double H50_HOUSE4_MAX = 394.215000;
  static final double H50_HOUSE4_MIN = 330.556667;
  static final double H50_HOUSE5_MAX = 463.204167;
  static final double H50_HOUSE5_MIN = 320.042500;
  static final double H50_HOUSE6_MAX = 558.424167;
  static final double H50_HOUSE6_MIN = 296.510000;
  static final double H50_HOUSE7_MAX = 623.978333;
  static final double H50_HOUSE7_MIN = 282.993333;
  static final double H50_HOUSE8_MAX = 558.424167;
  static final double H50_HOUSE8_MIN = 296.510000;
  static final double H50_HOUSE9_MAX = 463.204167;
  static final double H50_HOUSE9_MIN = 320.042500;
  static final double H50_MC_MAX = 394.215000;
  static final double H50_MC_MIN = 330.556667;
  static final double H50_POLASC_MAX = 826.410833;
  static final double H50_POLASC_MIN = 255.830833;
  static final double H50_VERTEX_MAX = 623.978333;
  static final double H50_VERTEX_MIN = 282.993333;
  static final double H60_ARMC_MAX = 360.986667;
  static final double H60_ARMC_MIN = 360.984167;
  static final double H60_ASC_MAX = 1583.084164;
  static final double H60_ASC_MIN = 220.207028;
  static final double H60_COASC1_MAX = 1643.108333;
  static final double H60_COASC1_MIN = 218.980000;
  static final double H60_COASC2_MAX = 527.985000;
  static final double H60_COASC2_MIN = 303.743333;
  static final double H60_EQUASC_MAX = 394.215000;
  static final double H60_EQUASC_MIN = 330.556667;
  static final double H60_HOUSE10_MAX = 394.215000;
  static final double H60_HOUSE10_MIN = 330.556667;
  static final double H60_HOUSE11_MAX = 444.589167;
  static final double H60_HOUSE11_MIN = 324.278333;
  static final double H60_HOUSE12_MAX = 499.516667;
  static final double H60_HOUSE12_MIN = 310.910833;
  static final double H60_HOUSE1_MAX = 527.985000;
  static final double H60_HOUSE1_MIN = 303.743333;
  static final double H60_HOUSE2_MAX = 499.516667;
  static final double H60_HOUSE2_MIN = 310.910833;
  static final double H60_HOUSE3_MAX = 444.589167;
  static final double H60_HOUSE3_MIN = 324.278333;
  static final double H60_HOUSE4_MAX = 394.215000;
  static final double H60_HOUSE4_MIN = 330.556667;
  static final double H60_HOUSE5_MAX = 444.589167;
  static final double H60_HOUSE5_MIN = 324.278333;
  static final double H60_HOUSE6_MAX = 499.516667;
  static final double H60_HOUSE6_MIN = 310.910833;
  static final double H60_HOUSE7_MAX = 527.985000;
  static final double H60_HOUSE7_MIN = 303.743333;
  static final double H60_HOUSE8_MAX = 499.516667;
  static final double H60_HOUSE8_MIN = 310.910833;
  static final double H60_HOUSE9_MAX = 444.589167;
  static final double H60_HOUSE9_MIN = 324.278333;
  static final double H60_MC_MAX = 394.215000;
  static final double H60_MC_MIN = 330.556667;
  static final double H60_POLASC_MAX = 1643.108333;
  static final double H60_POLASC_MIN = 218.980000;
  static final double H60_VERTEX_MAX = 527.985000;
  static final double H60_VERTEX_MIN = 303.743333;
  static final double H66_ARMC_MAX = 360.986667;
  static final double H66_ARMC_MIN = 360.984167;
  static final double H66_ASC_MAX = 15382.763492;
  static final double H66_ASC_MIN = 180.714519;
  static final double H66_COASC1_MAX = 27433.717500;
  static final double H66_COASC1_MIN = 176.632500;
  static final double H66_COASC2_MAX = 489.939167;
  static final double H66_COASC2_MIN = 313.358333;
  static final double H66_EQUASC_MAX = 394.215000;
  static final double H66_EQUASC_MIN = 330.556667;
  static final double H66_HOUSE10_MAX = 394.215000;
  static final double H66_HOUSE10_MIN = 330.556667;
  static final double H66_HOUSE11_MAX = 433.750833;
  static final double H66_HOUSE11_MIN = 326.429167;
  static final double H66_HOUSE12_MAX = 472.205000;
  static final double H66_HOUSE12_MIN = 317.839167;
  static final double H66_HOUSE1_MAX = 489.939167;
  static final double H66_HOUSE1_MIN = 313.358333;
  static final double H66_HOUSE2_MAX = 472.205000;
  static final double H66_HOUSE2_MIN = 317.839167;
  static final double H66_HOUSE3_MAX = 433.750833;
  static final double H66_HOUSE3_MIN = 326.429167;
  static final double H66_HOUSE4_MAX = 394.215000;
  static final double H66_HOUSE4_MIN = 330.556667;
  static final double H66_HOUSE5_MAX = 433.750833;
  static final double H66_HOUSE5_MIN = 326.429167;
  static final double H66_HOUSE6_MAX = 472.205000;
  static final double H66_HOUSE6_MIN = 317.839167;
  static final double H66_HOUSE7_MAX = 489.939167;
  static final double H66_HOUSE7_MIN = 313.358333;
  static final double H66_HOUSE8_MAX = 472.205000;
  static final double H66_HOUSE8_MIN = 317.839167;
  static final double H66_HOUSE9_MAX = 433.750833;
  static final double H66_HOUSE9_MIN = 326.429167;
  static final double H66_MC_MAX = 394.215000;
  static final double H66_MC_MIN = 330.556667;
  static final double H66_POLASC_MAX = 27433.717500;
  static final double H66_POLASC_MIN = 176.632500;
  static final double H66_VERTEX_MAX = 489.939167;
  static final double H66_VERTEX_MIN = 313.358333;
  static final double H70_ARMC_MAX = 360.986667;
  static final double H70_ARMC_MIN = 360.984167;
  static final double H70_ASC_MAX = 179.610407;
  static final double H70_ASC_MIN = -2066.757500;
  static final double H70_COASC1_MAX = 2999819.999167;
  static final double H70_COASC1_MIN = -180.000000;
  static final double H70_COASC2_MAX = 469.147500;
  static final double H70_COASC2_MIN = 318.595833;
  static final double H70_EQUASC_MAX = 394.215000;
  static final double H70_EQUASC_MIN = 330.556667;
  static final double H70_HOUSE10_MAX = 394.215000;
  static final double H70_HOUSE10_MIN = 330.556667;
  static final double H70_HOUSE11_MAX = 426.716667;
  static final double H70_HOUSE11_MIN = 327.649167;
  static final double H70_HOUSE12_MAX = 456.313333;
  static final double H70_HOUSE12_MIN = 321.671667;
  static final double H70_HOUSE1_MAX = 469.147500;
  static final double H70_HOUSE1_MIN = 318.595833;
  static final double H70_HOUSE2_MAX = 456.313333;
  static final double H70_HOUSE2_MIN = 321.671667;
  static final double H70_HOUSE3_MAX = 426.716667;
  static final double H70_HOUSE3_MIN = 327.649167;
  static final double H70_HOUSE4_MAX = 394.215000;
  static final double H70_HOUSE4_MIN = 330.556667;
  static final double H70_HOUSE5_MAX = 426.716667;
  static final double H70_HOUSE5_MIN = 327.649167;
  static final double H70_HOUSE6_MAX = 456.313333;
  static final double H70_HOUSE6_MIN = 321.671667;
  static final double H70_HOUSE7_MAX = 469.147500;
  static final double H70_HOUSE7_MIN = 318.595833;
  static final double H70_HOUSE8_MAX = 456.313333;
  static final double H70_HOUSE8_MIN = 321.671667;
  static final double H70_HOUSE9_MAX = 426.716667;
  static final double H70_HOUSE9_MIN = 327.649167;
  static final double H70_MC_MAX = 394.215000;
  static final double H70_MC_MIN = 330.556667;
  static final double H70_POLASC_MAX = 2999820.000000;
  static final double H70_POLASC_MIN = -180.000000;
  static final double H70_VERTEX_MAX = 469.147500;
  static final double H70_VERTEX_MIN = 318.595833;
  static final double H80_ARMC_MAX = 360.986667;
  static final double H80_ARMC_MIN = 360.984167;
  static final double H80_ASC_MAX = 113.797795;
  static final double H80_ASC_MIN = -269.996070;
  static final double H80_COASC1_MAX = 2999820.000000;
  static final double H80_COASC1_MIN = -180.000000;
  static final double H80_COASC2_MAX = 427.276667;
  static final double H80_COASC2_MIN = 327.558333;
  static final double H80_EQUASC_MAX = 394.215000;
  static final double H80_EQUASC_MIN = 330.556667;
  static final double H80_HOUSE10_MAX = 394.215000;
  static final double H80_HOUSE10_MIN = 330.556667;
  static final double H80_HOUSE11_MAX = 409.891667;
  static final double H80_HOUSE11_MIN = 329.812500;
  static final double H80_HOUSE12_MAX = 422.411667;
  static final double H80_HOUSE12_MIN = 328.312500;
  static final double H80_HOUSE1_MAX = 427.276667;
  static final double H80_HOUSE1_MIN = 327.558333;
  static final double H80_HOUSE2_MAX = 422.411667;
  static final double H80_HOUSE2_MIN = 328.312500;
  static final double H80_HOUSE3_MAX = 409.891667;
  static final double H80_HOUSE3_MIN = 329.812500;
  static final double H80_HOUSE4_MAX = 394.215000;
  static final double H80_HOUSE4_MIN = 330.556667;
  static final double H80_HOUSE5_MAX = 409.891667;
  static final double H80_HOUSE5_MIN = 329.812500;
  static final double H80_HOUSE6_MAX = 422.411667;
  static final double H80_HOUSE6_MIN = 328.312500;
  static final double H80_HOUSE7_MAX = 427.276667;
  static final double H80_HOUSE7_MIN = 327.558333;
  static final double H80_HOUSE8_MAX = 422.411667;
  static final double H80_HOUSE8_MIN = 328.312500;
  static final double H80_HOUSE9_MAX = 409.891667;
  static final double H80_HOUSE9_MIN = 329.812500;
  static final double H80_MC_MAX = 394.215000;
  static final double H80_MC_MIN = 330.556667;
  static final double H80_POLASC_MAX = 2999820.000000;
  static final double H80_POLASC_MIN = -180.000000;
  static final double H80_VERTEX_MAX = 427.276667;
  static final double H80_VERTEX_MIN = 327.558333;
  static final double H85_ARMC_MAX = 360.986667;
  static final double H85_ARMC_MIN = 360.984167;
  static final double H85_ASC_MAX = 66.096028;
  static final double H85_ASC_MIN = -99.544650;
  static final double H85_COASC1_MAX = 2999901.836667;
  static final double H85_COASC1_MIN = -100.323333;
  static final double H85_COASC2_MAX = 409.954167;
  static final double H85_COASC2_MIN = 329.806667;
  static final double H85_EQUASC_MAX = 394.215000;
  static final double H85_EQUASC_MIN = 330.556667;
  static final double H85_HOUSE10_MAX = 394.215000;
  static final double H85_HOUSE10_MIN = 330.556667;
  static final double H85_HOUSE11_MAX = 401.908333;
  static final double H85_HOUSE11_MIN = 330.370000;
  static final double H85_HOUSE12_MAX = 407.759167;
  static final double H85_HOUSE12_MIN = 329.994167;
  static final double H85_HOUSE1_MAX = 409.954167;
  static final double H85_HOUSE1_MIN = 329.806667;
  static final double H85_HOUSE2_MAX = 407.759167;
  static final double H85_HOUSE2_MIN = 329.994167;
  static final double H85_HOUSE3_MAX = 401.907500;
  static final double H85_HOUSE3_MIN = 330.370000;
  static final double H85_HOUSE4_MAX = 394.215000;
  static final double H85_HOUSE4_MIN = 330.556667;
  static final double H85_HOUSE5_MAX = 401.908333;
  static final double H85_HOUSE5_MIN = 330.370000;
  static final double H85_HOUSE6_MAX = 407.759167;
  static final double H85_HOUSE6_MIN = 329.994167;
  static final double H85_HOUSE7_MAX = 409.954167;
  static final double H85_HOUSE7_MIN = 329.806667;
  static final double H85_HOUSE8_MAX = 407.759167;
  static final double H85_HOUSE8_MIN = 329.994167;
  static final double H85_HOUSE9_MAX = 401.907500;
  static final double H85_HOUSE9_MIN = 330.370000;
  static final double H85_MC_MAX = 394.215000;
  static final double H85_MC_MIN = 330.556667;
  static final double H85_POLASC_MAX = 66.413333;
  static final double H85_POLASC_MIN = -100.323333;
  static final double H85_VERTEX_MAX = 409.954167;
  static final double H85_VERTEX_MIN = 329.806667;
  static final double H88_ARMC_MAX = 360.985931;
  static final double H88_ARMC_MIN = 360.985828;
  static final double H88_ASC_MAX = 29.344231;
  static final double H88_ASC_MIN = -34.489311;
  static final double H88_COASC1_MAX = 1555165.554409;
  static final double H88_COASC1_MIN = -34.489296;
  static final double H88_COASC2_MAX = 399.547623;
  static final double H88_COASC2_MIN = 331.043079;
  static final double H88_EQUASC_MAX = 393.494420;
  static final double H88_EQUASC_MIN = 331.162937;
  static final double H88_HOUSE10_MAX = 393.494420;
  static final double H88_HOUSE10_MIN = 331.162936;
  static final double H88_HOUSE11_MAX = 396.496529;
  static final double H88_HOUSE11_MIN = 331.132982;
  static final double H88_HOUSE12_MAX = 398.725050;
  static final double H88_HOUSE12_MIN = 331.073048;
  static final double H88_HOUSE1_MAX = 399.547621;
  static final double H88_HOUSE1_MIN = 331.043081;
  static final double H88_HOUSE2_MAX = 398.725059;
  static final double H88_HOUSE2_MIN = 331.073058;
  static final double H88_HOUSE3_MAX = 396.496538;
  static final double H88_HOUSE3_MIN = 331.132983;
  static final double H88_HOUSE4_MAX = 393.494420;
  static final double H88_HOUSE4_MIN = 331.162936;
  static final double H88_HOUSE5_MAX = 396.496529;
  static final double H88_HOUSE5_MIN = 331.132982;
  static final double H88_HOUSE6_MAX = 398.725050;
  static final double H88_HOUSE6_MIN = 331.073048;
  static final double H88_HOUSE7_MAX = 399.547621;
  static final double H88_HOUSE7_MIN = 331.043081;
  static final double H88_HOUSE8_MAX = 398.725059;
  static final double H88_HOUSE8_MIN = 331.073058;
  static final double H88_HOUSE9_MAX = 396.496538;
  static final double H88_HOUSE9_MIN = 331.132983;
  static final double H88_MC_MAX = 393.494420;
  static final double H88_MC_MIN = 331.162936;
  static final double H88_POLASC_MAX = 29.344230;
  static final double H88_POLASC_MIN = -34.489313;
  static final double H88_VERTEX_MAX = 399.547621;
  static final double H88_VERTEX_MIN = 331.043081;
  static final double H89x_ARMC_MAX = 360.986667;
  static final double H89x_ARMC_MIN = 360.984167;
  static final double H89x_ASC_MAX = 0.000000;
  static final double H89x_ASC_MIN = -0.000000;
  static final double H89x_COASC1_MAX = 2999998.426667;
  static final double H89x_COASC1_MIN = -1.600833;
  static final double H89x_COASC2_MAX = 394.516667;
  static final double H89x_COASC2_MIN = 330.556667;
  static final double H89x_EQUASC_MAX = 394.215000;
  static final double H89x_EQUASC_MIN = 330.556667;
  static final double H89x_HOUSE10_MAX = 394.215000;
  static final double H89x_HOUSE10_MIN = 330.556667;
  static final double H89x_HOUSE11_MAX = 394.365833;
  static final double H89x_HOUSE11_MIN = 330.556667;
  static final double H89x_HOUSE12_MAX = 394.476667;
  static final double H89x_HOUSE12_MIN = 330.556667;
  static final double H89x_HOUSE1_MAX = 394.516667;
  static final double H89x_HOUSE1_MIN = 330.556667;
  static final double H89x_HOUSE2_MAX = 394.476667;
  static final double H89x_HOUSE2_MIN = 330.556667;
  static final double H89x_HOUSE3_MAX = 394.365833;
  static final double H89x_HOUSE3_MIN = 330.556667;
  static final double H89x_HOUSE4_MAX = 394.215000;
  static final double H89x_HOUSE4_MIN = 330.556667;
  static final double H89x_HOUSE5_MAX = 394.365833;
  static final double H89x_HOUSE5_MIN = 330.556667;
  static final double H89x_HOUSE6_MAX = 394.476667;
  static final double H89x_HOUSE6_MIN = 330.556667;
  static final double H89x_HOUSE7_MAX = 394.516667;
  static final double H89x_HOUSE7_MIN = 330.556667;
  static final double H89x_HOUSE8_MAX = 394.476667;
  static final double H89x_HOUSE8_MIN = 330.556667;
  static final double H89x_HOUSE9_MAX = 394.365833;
  static final double H89x_HOUSE9_MIN = 330.556667;
  static final double H89x_MC_MAX = 394.215000;
  static final double H89x_MC_MIN = 330.556667;
  static final double H89x_POLASC_MAX = 1.588333;
  static final double H89x_POLASC_MIN = -1.600833;
  static final double H89x_VERTEX_MAX = 394.516667;
  static final double H89x_VERTEX_MIN = 330.556667;
  static final double K0_ARMC_MAX = 360.986667;
  static final double K0_ARMC_MIN = 360.984167;
  static final double K0_ASC_MAX = 393.494420;
  static final double K0_ASC_MIN = 331.162937;
  static final double K0_COASC1_MAX = 394.215000;
  static final double K0_COASC1_MIN = 330.556667;
  static final double K0_COASC2_MAX = 0.000000;
  static final double K0_COASC2_MIN = 0.000000;
  static final double K0_EQUASC_MAX = 394.215000;
  static final double K0_EQUASC_MIN = 330.556667;
  static final double K0_HOUSE10_MAX = 394.215000;
  static final double K0_HOUSE10_MIN = 330.556667;
  static final double K0_HOUSE11_MAX = 394.215000;
  static final double K0_HOUSE11_MIN = 330.556667;
  static final double K0_HOUSE12_MAX = 394.215000;
  static final double K0_HOUSE12_MIN = 330.556667;
  static final double K0_HOUSE1_MAX = 394.215000;
  static final double K0_HOUSE1_MIN = 330.556667;
  static final double K0_HOUSE2_MAX = 394.215000;
  static final double K0_HOUSE2_MIN = 330.556667;
  static final double K0_HOUSE3_MAX = 394.215000;
  static final double K0_HOUSE3_MIN = 330.556667;
  static final double K0_HOUSE4_MAX = 394.215000;
  static final double K0_HOUSE4_MIN = 330.556667;
  static final double K0_HOUSE5_MAX = 394.215000;
  static final double K0_HOUSE5_MIN = 330.556667;
  static final double K0_HOUSE6_MAX = 394.215000;
  static final double K0_HOUSE6_MIN = 330.556667;
  static final double K0_HOUSE7_MAX = 394.215000;
  static final double K0_HOUSE7_MIN = 330.556667;
  static final double K0_HOUSE8_MAX = 394.215000;
  static final double K0_HOUSE8_MIN = 330.556667;
  static final double K0_HOUSE9_MAX = 394.215000;
  static final double K0_HOUSE9_MIN = 330.556667;
  static final double K0_MC_MAX = 394.215000;
  static final double K0_MC_MIN = 330.556667;
  static final double K0_POLASC_MAX = 394.215000;
  static final double K0_POLASC_MIN = 330.556667;
  static final double K0_VERTEX_MAX = 1500000.000000;
  static final double K0_VERTEX_MIN = 0.000000;
  static final double K10_ARMC_MAX = 360.986667;
  static final double K10_ARMC_MIN = 360.984167;
  static final double K10_ASC_MAX = 426.089536;
  static final double K10_ASC_MIN = 328.169552;
  static final double K10_COASC1_MAX = 427.276667;
  static final double K10_COASC1_MIN = 327.558333;
  static final double K10_COASC2_MAX = 2999820.000000;
  static final double K10_COASC2_MIN = -180.000000;
  static final double K10_EQUASC_MAX = 394.215000;
  static final double K10_EQUASC_MIN = 330.556667;
  static final double K10_HOUSE10_MAX = 394.215000;
  static final double K10_HOUSE10_MIN = 330.556667;
  static final double K10_HOUSE11_MAX = 408.830000;
  static final double K10_HOUSE11_MIN = 321.080000;
  static final double K10_HOUSE12_MAX = 422.182500;
  static final double K10_HOUSE12_MIN = 320.949167;
  static final double K10_HOUSE1_MAX = 427.276667;
  static final double K10_HOUSE1_MIN = 327.558333;
  static final double K10_HOUSE2_MAX = 422.182500;
  static final double K10_HOUSE2_MIN = 320.949167;
  static final double K10_HOUSE3_MAX = 408.830000;
  static final double K10_HOUSE3_MIN = 321.080000;
  static final double K10_HOUSE4_MAX = 394.215000;
  static final double K10_HOUSE4_MIN = 330.556667;
  static final double K10_HOUSE5_MAX = 408.830000;
  static final double K10_HOUSE5_MIN = 321.080000;
  static final double K10_HOUSE6_MAX = 422.182500;
  static final double K10_HOUSE6_MIN = 320.949167;
  static final double K10_HOUSE7_MAX = 427.276667;
  static final double K10_HOUSE7_MIN = 327.558333;
  static final double K10_HOUSE8_MAX = 422.182500;
  static final double K10_HOUSE8_MIN = 320.949167;
  static final double K10_HOUSE9_MAX = 408.830000;
  static final double K10_HOUSE9_MIN = 321.080000;
  static final double K10_MC_MAX = 394.215000;
  static final double K10_MC_MIN = 330.556667;
  static final double K10_POLASC_MAX = 427.276667;
  static final double K10_POLASC_MIN = 327.558333;
  static final double K10_VERTEX_MAX = 2999820.000000;
  static final double K10_VERTEX_MIN = -180.000000;
  static final double K20_ARMC_MAX = 360.986667;
  static final double K20_ARMC_MIN = 360.984167;
  static final double K20_ASC_MAX = 467.280896;
  static final double K20_ASC_MIN = 319.225068;
  static final double K20_COASC1_MAX = 469.147500;
  static final double K20_COASC1_MIN = 318.595833;
  static final double K20_COASC2_MAX = 2999819.999167;
  static final double K20_COASC2_MIN = -180.000000;
  static final double K20_EQUASC_MAX = 394.215000;
  static final double K20_EQUASC_MIN = 330.556667;
  static final double K20_HOUSE10_MAX = 394.215000;
  static final double K20_HOUSE10_MIN = 330.556667;
  static final double K20_HOUSE11_MAX = 428.745000;
  static final double K20_HOUSE11_MIN = 309.223333;
  static final double K20_HOUSE12_MAX = 458.311667;
  static final double K20_HOUSE12_MIN = 306.862500;
  static final double K20_HOUSE1_MAX = 469.147500;
  static final double K20_HOUSE1_MIN = 318.595833;
  static final double K20_HOUSE2_MAX = 458.311667;
  static final double K20_HOUSE2_MIN = 306.862500;
  static final double K20_HOUSE3_MAX = 428.745000;
  static final double K20_HOUSE3_MIN = 309.223333;
  static final double K20_HOUSE4_MAX = 394.215000;
  static final double K20_HOUSE4_MIN = 330.556667;
  static final double K20_HOUSE5_MAX = 428.745000;
  static final double K20_HOUSE5_MIN = 309.223333;
  static final double K20_HOUSE6_MAX = 458.311667;
  static final double K20_HOUSE6_MIN = 306.862500;
  static final double K20_HOUSE7_MAX = 469.147500;
  static final double K20_HOUSE7_MIN = 318.595833;
  static final double K20_HOUSE8_MAX = 458.311667;
  static final double K20_HOUSE8_MIN = 306.862500;
  static final double K20_HOUSE9_MAX = 428.745000;
  static final double K20_HOUSE9_MIN = 309.223333;
  static final double K20_MC_MAX = 394.215000;
  static final double K20_MC_MIN = 330.556667;
  static final double K20_POLASC_MAX = 469.147500;
  static final double K20_POLASC_MIN = 318.595833;
  static final double K20_VERTEX_MAX = 2999819.999167;
  static final double K20_VERTEX_MIN = -180.000000;
  static final double K30_ARMC_MAX = 360.986667;
  static final double K30_ARMC_MIN = 360.984167;
  static final double K30_ASC_MAX = 524.994891;
  static final double K30_ASC_MIN = 304.407972;
  static final double K30_COASC1_MAX = 527.985000;
  static final double K30_COASC1_MIN = 303.743333;
  static final double K30_COASC2_MAX = 1643.109167;
  static final double K30_COASC2_MIN = 218.980000;
  static final double K30_EQUASC_MAX = 394.215000;
  static final double K30_EQUASC_MIN = 330.556667;
  static final double K30_HOUSE10_MAX = 394.215000;
  static final double K30_HOUSE10_MIN = 330.556667;
  static final double K30_HOUSE11_MAX = 458.239167;
  static final double K30_HOUSE11_MIN = 293.878333;
  static final double K30_HOUSE12_MAX = 509.640833;
  static final double K30_HOUSE12_MIN = 288.060000;
  static final double K30_HOUSE1_MAX = 527.985000;
  static final double K30_HOUSE1_MIN = 303.743333;
  static final double K30_HOUSE2_MAX = 509.640833;
  static final double K30_HOUSE2_MIN = 288.060000;
  static final double K30_HOUSE3_MAX = 458.239167;
  static final double K30_HOUSE3_MIN = 293.878333;
  static final double K30_HOUSE4_MAX = 394.215000;
  static final double K30_HOUSE4_MIN = 330.556667;
  static final double K30_HOUSE5_MAX = 458.239167;
  static final double K30_HOUSE5_MIN = 293.878333;
  static final double K30_HOUSE6_MAX = 509.640833;
  static final double K30_HOUSE6_MIN = 288.060000;
  static final double K30_HOUSE7_MAX = 527.985000;
  static final double K30_HOUSE7_MIN = 303.743333;
  static final double K30_HOUSE8_MAX = 509.640833;
  static final double K30_HOUSE8_MIN = 288.060000;
  static final double K30_HOUSE9_MAX = 458.239167;
  static final double K30_HOUSE9_MIN = 293.878333;
  static final double K30_MC_MAX = 394.215000;
  static final double K30_MC_MIN = 330.556667;
  static final double K30_POLASC_MAX = 527.985000;
  static final double K30_POLASC_MIN = 303.743333;
  static final double K30_VERTEX_MAX = 1643.108333;
  static final double K30_VERTEX_MIN = 218.980000;
  static final double K40_ARMC_MAX = 360.986667;
  static final double K40_ARMC_MIN = 360.984167;
  static final double K40_ASC_MAX = 618.738596;
  static final double K40_ASC_MIN = 283.720808;
  static final double K40_COASC1_MAX = 623.978333;
  static final double K40_COASC1_MIN = 282.993333;
  static final double K40_COASC2_MAX = 826.410833;
  static final double K40_COASC2_MIN = 255.830833;
  static final double K40_EQUASC_MAX = 394.215000;
  static final double K40_EQUASC_MIN = 330.556667;
  static final double K40_HOUSE10_MAX = 394.215000;
  static final double K40_HOUSE10_MIN = 330.556667;
  static final double K40_HOUSE11_MAX = 508.083333;
  static final double K40_HOUSE11_MIN = 272.127500;
  static final double K40_HOUSE12_MAX = 593.937500;
  static final double K40_HOUSE12_MIN = 263.176667;
  static final double K40_HOUSE1_MAX = 623.978333;
  static final double K40_HOUSE1_MIN = 282.993333;
  static final double K40_HOUSE2_MAX = 593.937500;
  static final double K40_HOUSE2_MIN = 263.176667;
  static final double K40_HOUSE3_MAX = 508.083333;
  static final double K40_HOUSE3_MIN = 272.127500;
  static final double K40_HOUSE4_MAX = 394.215000;
  static final double K40_HOUSE4_MIN = 330.556667;
  static final double K40_HOUSE5_MAX = 508.083333;
  static final double K40_HOUSE5_MIN = 272.127500;
  static final double K40_HOUSE6_MAX = 593.937500;
  static final double K40_HOUSE6_MIN = 263.176667;
  static final double K40_HOUSE7_MAX = 623.978333;
  static final double K40_HOUSE7_MIN = 282.993333;
  static final double K40_HOUSE8_MAX = 593.937500;
  static final double K40_HOUSE8_MIN = 263.176667;
  static final double K40_HOUSE9_MAX = 508.083333;
  static final double K40_HOUSE9_MIN = 272.127500;
  static final double K40_MC_MAX = 394.215000;
  static final double K40_MC_MIN = 330.556667;
  static final double K40_POLASC_MAX = 623.978333;
  static final double K40_POLASC_MIN = 282.993333;
  static final double K40_VERTEX_MAX = 826.410833;
  static final double K40_VERTEX_MIN = 255.830833;
  static final double K50_ARMC_MAX = 360.986667;
  static final double K50_ARMC_MIN = 360.984167;
  static final double K50_ASC_MAX = 814.745889;
  static final double K50_ASC_MIN = 256.684961;
  static final double K50_COASC1_MAX = 826.410833;
  static final double K50_COASC1_MIN = 255.830833;
  static final double K50_COASC2_MAX = 623.978333;
  static final double K50_COASC2_MIN = 282.993333;
  static final double K50_EQUASC_MAX = 394.215000;
  static final double K50_EQUASC_MIN = 330.556667;
  static final double K50_HOUSE10_MAX = 394.215000;
  static final double K50_HOUSE10_MIN = 330.556667;
  static final double K50_HOUSE11_MAX = 615.785000;
  static final double K50_HOUSE11_MIN = 235.509167;
  static final double K50_HOUSE12_MAX = 772.554167;
  static final double K50_HOUSE12_MIN = 228.176667;
  static final double K50_HOUSE1_MAX = 826.410833;
  static final double K50_HOUSE1_MIN = 255.830833;
  static final double K50_HOUSE2_MAX = 772.554167;
  static final double K50_HOUSE2_MIN = 228.176667;
  static final double K50_HOUSE3_MAX = 615.785000;
  static final double K50_HOUSE3_MIN = 235.509167;
  static final double K50_HOUSE4_MAX = 394.215000;
  static final double K50_HOUSE4_MIN = 330.556667;
  static final double K50_HOUSE5_MAX = 615.785000;
  static final double K50_HOUSE5_MIN = 235.509167;
  static final double K50_HOUSE6_MAX = 772.554167;
  static final double K50_HOUSE6_MIN = 228.176667;
  static final double K50_HOUSE7_MAX = 826.410833;
  static final double K50_HOUSE7_MIN = 255.830833;
  static final double K50_HOUSE8_MAX = 772.554167;
  static final double K50_HOUSE8_MIN = 228.176667;
  static final double K50_HOUSE9_MAX = 615.785000;
  static final double K50_HOUSE9_MIN = 235.509167;
  static final double K50_MC_MAX = 394.215000;
  static final double K50_MC_MIN = 330.556667;
  static final double K50_POLASC_MAX = 826.410833;
  static final double K50_POLASC_MIN = 255.830833;
  static final double K50_VERTEX_MAX = 623.978333;
  static final double K50_VERTEX_MIN = 282.993333;
  static final double K60_ARMC_MAX = 360.986667;
  static final double K60_ARMC_MIN = 360.984167;
  static final double K60_ASC_MAX = 1583.084164;
  static final double K60_ASC_MIN = 220.207028;
  static final double K60_COASC1_MAX = 1643.108333;
  static final double K60_COASC1_MIN = 218.980000;
  static final double K60_COASC2_MAX = 527.985000;
  static final double K60_COASC2_MIN = 303.743333;
  static final double K60_EQUASC_MAX = 394.215000;
  static final double K60_EQUASC_MIN = 330.556667;
  static final double K60_HOUSE10_MAX = 394.215000;
  static final double K60_HOUSE10_MIN = 330.556667;
  static final double K60_HOUSE11_MAX = 1060.511667;
  static final double K60_HOUSE11_MIN = 155.710000;
  static final double K60_HOUSE12_MAX = 1496.450833;
  static final double K60_HOUSE12_MIN = 172.501667;
  static final double K60_HOUSE1_MAX = 1643.109167;
  static final double K60_HOUSE1_MIN = 218.980000;
  static final double K60_HOUSE2_MAX = 1496.450000;
  static final double K60_HOUSE2_MIN = 172.501667;
  static final double K60_HOUSE3_MAX = 1060.511667;
  static final double K60_HOUSE3_MIN = 155.710000;
  static final double K60_HOUSE4_MAX = 394.215000;
  static final double K60_HOUSE4_MIN = 330.556667;
  static final double K60_HOUSE5_MAX = 1060.511667;
  static final double K60_HOUSE5_MIN = 155.710000;
  static final double K60_HOUSE6_MAX = 1496.450833;
  static final double K60_HOUSE6_MIN = 172.501667;
  static final double K60_HOUSE7_MAX = 1643.109167;
  static final double K60_HOUSE7_MIN = 218.980000;
  static final double K60_HOUSE8_MAX = 1496.450000;
  static final double K60_HOUSE8_MIN = 172.501667;
  static final double K60_HOUSE9_MAX = 1060.511667;
  static final double K60_HOUSE9_MIN = 155.710000;
  static final double K60_MC_MAX = 394.215000;
  static final double K60_MC_MIN = 330.556667;
  static final double K60_POLASC_MAX = 1643.108333;
  static final double K60_POLASC_MIN = 218.980000;
  static final double K60_VERTEX_MAX = 527.985000;
  static final double K60_VERTEX_MIN = 303.743333;
  static final double K66_ARMC_MAX = 360.986667;
  static final double K66_ARMC_MIN = 360.984167;
  static final double K66_ASC_MAX = 15382.763492;
  static final double K66_ASC_MIN = 180.714519;
  static final double K66_COASC1_MAX = 27433.717500;
  static final double K66_COASC1_MIN = 176.632500;
  static final double K66_COASC2_MAX = 489.939167;
  static final double K66_COASC2_MIN = 313.358333;
  static final double K66_EQUASC_MAX = 394.215000;
  static final double K66_EQUASC_MIN = 330.556667;
  static final double K66_HOUSE10_MAX = 394.215000;
  static final double K66_HOUSE10_MIN = 330.556667;
  static final double K66_HOUSE11_MAX = 15380.065000;
  static final double K66_HOUSE11_MIN = 61.725833;
  static final double K66_HOUSE12_MAX = 24420.205833;
  static final double K66_HOUSE12_MIN = 118.620833;
  static final double K66_HOUSE1_MAX = 27433.547500;
  static final double K66_HOUSE1_MIN = 176.632500;
  static final double K66_HOUSE2_MAX = 24421.120833;
  static final double K66_HOUSE2_MIN = 118.620833;
  static final double K66_HOUSE3_MAX = 15379.604167;
  static final double K66_HOUSE3_MIN = 61.725833;
  static final double K66_HOUSE4_MAX = 394.215000;
  static final double K66_HOUSE4_MIN = 330.556667;
  static final double K66_HOUSE5_MAX = 15380.065000;
  static final double K66_HOUSE5_MIN = 61.725833;
  static final double K66_HOUSE6_MAX = 24420.205833;
  static final double K66_HOUSE6_MIN = 118.620833;
  static final double K66_HOUSE7_MAX = 27433.547500;
  static final double K66_HOUSE7_MIN = 176.632500;
  static final double K66_HOUSE8_MAX = 24421.120833;
  static final double K66_HOUSE8_MIN = 118.620833;
  static final double K66_HOUSE9_MAX = 15379.604167;
  static final double K66_HOUSE9_MIN = 61.725833;
  static final double K66_MC_MAX = 394.215000;
  static final double K66_MC_MIN = 330.556667;
  static final double K66_POLASC_MAX = 27433.717500;
  static final double K66_POLASC_MIN = 176.632500;
  static final double K66_VERTEX_MAX = 489.939167;
  static final double K66_VERTEX_MIN = 313.358333;
  static final double K70_ARMC_MAX = 1./0.;
  static final double K70_ARMC_MIN = 1./0.;
  static final double K70_ASC_MAX = 1./0.;
  static final double K70_ASC_MIN = 1./0.;
  static final double K70_COASC1_MAX = 1./0.;
  static final double K70_COASC1_MIN = 1./0.;
  static final double K70_COASC2_MAX = 1./0.;
  static final double K70_COASC2_MIN = 1./0.;
  static final double K70_EQUASC_MAX = 1./0.;
  static final double K70_EQUASC_MIN = 1./0.;
  static final double K70_HOUSE10_MAX = 1./0.;
  static final double K70_HOUSE10_MIN = 1./0.;
  static final double K70_HOUSE11_MAX = 1./0.;
  static final double K70_HOUSE11_MIN = 1./0.;
  static final double K70_HOUSE12_MAX = 1./0.;
  static final double K70_HOUSE12_MIN = 1./0.;
  static final double K70_HOUSE1_MAX = 1./0.;
  static final double K70_HOUSE1_MIN = 1./0.;
  static final double K70_HOUSE2_MAX = 1./0.;
  static final double K70_HOUSE2_MIN = 1./0.;
  static final double K70_HOUSE3_MAX = 1./0.;
  static final double K70_HOUSE3_MIN = 1./0.;
  static final double K70_HOUSE4_MAX = 1./0.;
  static final double K70_HOUSE4_MIN = 1./0.;
  static final double K70_HOUSE5_MAX = 1./0.;
  static final double K70_HOUSE5_MIN = 1./0.;
  static final double K70_HOUSE6_MAX = 1./0.;
  static final double K70_HOUSE6_MIN = 1./0.;
  static final double K70_HOUSE7_MAX = 1./0.;
  static final double K70_HOUSE7_MIN = 1./0.;
  static final double K70_HOUSE8_MAX = 1./0.;
  static final double K70_HOUSE8_MIN = 1./0.;
  static final double K70_HOUSE9_MAX = 1./0.;
  static final double K70_HOUSE9_MIN = 1./0.;
  static final double K70_MC_MAX = 1./0.;
  static final double K70_MC_MIN = 1./0.;
  static final double K70_POLASC_MAX = 1./0.;
  static final double K70_POLASC_MIN = 1./0.;
  static final double K70_VERTEX_MAX = 1./0.;
  static final double K70_VERTEX_MIN = 1./0.;
  static final double K80_ARMC_MAX = 1./0.;
  static final double K80_ARMC_MIN = 1./0.;
  static final double K80_ASC_MAX = 1./0.;
  static final double K80_ASC_MIN = 1./0.;
  static final double K80_COASC1_MAX = 1./0.;
  static final double K80_COASC1_MIN = 1./0.;
  static final double K80_COASC2_MAX = 1./0.;
  static final double K80_COASC2_MIN = 1./0.;
  static final double K80_EQUASC_MAX = 1./0.;
  static final double K80_EQUASC_MIN = 1./0.;
  static final double K80_HOUSE10_MAX = 1./0.;
  static final double K80_HOUSE10_MIN = 1./0.;
  static final double K80_HOUSE11_MAX = 1./0.;
  static final double K80_HOUSE11_MIN = 1./0.;
  static final double K80_HOUSE12_MAX = 1./0.;
  static final double K80_HOUSE12_MIN = 1./0.;
  static final double K80_HOUSE1_MAX = 1./0.;
  static final double K80_HOUSE1_MIN = 1./0.;
  static final double K80_HOUSE2_MAX = 1./0.;
  static final double K80_HOUSE2_MIN = 1./0.;
  static final double K80_HOUSE3_MAX = 1./0.;
  static final double K80_HOUSE3_MIN = 1./0.;
  static final double K80_HOUSE4_MAX = 1./0.;
  static final double K80_HOUSE4_MIN = 1./0.;
  static final double K80_HOUSE5_MAX = 1./0.;
  static final double K80_HOUSE5_MIN = 1./0.;
  static final double K80_HOUSE6_MAX = 1./0.;
  static final double K80_HOUSE6_MIN = 1./0.;
  static final double K80_HOUSE7_MAX = 1./0.;
  static final double K80_HOUSE7_MIN = 1./0.;
  static final double K80_HOUSE8_MAX = 1./0.;
  static final double K80_HOUSE8_MIN = 1./0.;
  static final double K80_HOUSE9_MAX = 1./0.;
  static final double K80_HOUSE9_MIN = 1./0.;
  static final double K80_MC_MAX = 1./0.;
  static final double K80_MC_MIN = 1./0.;
  static final double K80_POLASC_MAX = 1./0.;
  static final double K80_POLASC_MIN = 1./0.;
  static final double K80_VERTEX_MAX = 1./0.;
  static final double K80_VERTEX_MIN = 1./0.;
  static final double K85_ARMC_MAX = 1./0.;
  static final double K85_ARMC_MIN = 1./0.;
  static final double K85_ASC_MAX = 1./0.;
  static final double K85_ASC_MIN = 1./0.;
  static final double K85_COASC1_MAX = 1./0.;
  static final double K85_COASC1_MIN = 1./0.;
  static final double K85_COASC2_MAX = 1./0.;
  static final double K85_COASC2_MIN = 1./0.;
  static final double K85_EQUASC_MAX = 1./0.;
  static final double K85_EQUASC_MIN = 1./0.;
  static final double K85_HOUSE10_MAX = 1./0.;
  static final double K85_HOUSE10_MIN = 1./0.;
  static final double K85_HOUSE11_MAX = 1./0.;
  static final double K85_HOUSE11_MIN = 1./0.;
  static final double K85_HOUSE12_MAX = 1./0.;
  static final double K85_HOUSE12_MIN = 1./0.;
  static final double K85_HOUSE1_MAX = 1./0.;
  static final double K85_HOUSE1_MIN = 1./0.;
  static final double K85_HOUSE2_MAX = 1./0.;
  static final double K85_HOUSE2_MIN = 1./0.;
  static final double K85_HOUSE3_MAX = 1./0.;
  static final double K85_HOUSE3_MIN = 1./0.;
  static final double K85_HOUSE4_MAX = 1./0.;
  static final double K85_HOUSE4_MIN = 1./0.;
  static final double K85_HOUSE5_MAX = 1./0.;
  static final double K85_HOUSE5_MIN = 1./0.;
  static final double K85_HOUSE6_MAX = 1./0.;
  static final double K85_HOUSE6_MIN = 1./0.;
  static final double K85_HOUSE7_MAX = 1./0.;
  static final double K85_HOUSE7_MIN = 1./0.;
  static final double K85_HOUSE8_MAX = 1./0.;
  static final double K85_HOUSE8_MIN = 1./0.;
  static final double K85_HOUSE9_MAX = 1./0.;
  static final double K85_HOUSE9_MIN = 1./0.;
  static final double K85_MC_MAX = 1./0.;
  static final double K85_MC_MIN = 1./0.;
  static final double K85_POLASC_MAX = 1./0.;
  static final double K85_POLASC_MIN = 1./0.;
  static final double K85_VERTEX_MAX = 1./0.;
  static final double K85_VERTEX_MIN = 1./0.;
  static final double K88_ARMC_MAX = 1./0.;
  static final double K88_ARMC_MIN = 1./0.;
  static final double K88_ASC_MAX = 1./0.;
  static final double K88_ASC_MIN = 1./0.;
  static final double K88_COASC1_MAX = 1./0.;
  static final double K88_COASC1_MIN = 1./0.;
  static final double K88_COASC2_MAX = 1./0.;
  static final double K88_COASC2_MIN = 1./0.;
  static final double K88_EQUASC_MAX = 1./0.;
  static final double K88_EQUASC_MIN = 1./0.;
  static final double K88_HOUSE10_MAX = 1./0.;
  static final double K88_HOUSE10_MIN = 1./0.;
  static final double K88_HOUSE11_MAX = 1./0.;
  static final double K88_HOUSE11_MIN = 1./0.;
  static final double K88_HOUSE12_MAX = 1./0.;
  static final double K88_HOUSE12_MIN = 1./0.;
  static final double K88_HOUSE1_MAX = 1./0.;
  static final double K88_HOUSE1_MIN = 1./0.;
  static final double K88_HOUSE2_MAX = 1./0.;
  static final double K88_HOUSE2_MIN = 1./0.;
  static final double K88_HOUSE3_MAX = 1./0.;
  static final double K88_HOUSE3_MIN = 1./0.;
  static final double K88_HOUSE4_MAX = 1./0.;
  static final double K88_HOUSE4_MIN = 1./0.;
  static final double K88_HOUSE5_MAX = 1./0.;
  static final double K88_HOUSE5_MIN = 1./0.;
  static final double K88_HOUSE6_MAX = 1./0.;
  static final double K88_HOUSE6_MIN = 1./0.;
  static final double K88_HOUSE7_MAX = 1./0.;
  static final double K88_HOUSE7_MIN = 1./0.;
  static final double K88_HOUSE8_MAX = 1./0.;
  static final double K88_HOUSE8_MIN = 1./0.;
  static final double K88_HOUSE9_MAX = 1./0.;
  static final double K88_HOUSE9_MIN = 1./0.;
  static final double K88_MC_MAX = 1./0.;
  static final double K88_MC_MIN = 1./0.;
  static final double K88_POLASC_MAX = 1./0.;
  static final double K88_POLASC_MIN = 1./0.;
  static final double K88_VERTEX_MAX = 1./0.;
  static final double K88_VERTEX_MIN = 1./0.;
  static final double K89x_ARMC_MAX = 1./0.;
  static final double K89x_ARMC_MIN = 1./0.;
  static final double K89x_ASC_MAX = 1./0.;
  static final double K89x_ASC_MIN = 1./0.;
  static final double K89x_COASC1_MAX = 1./0.;
  static final double K89x_COASC1_MIN = 1./0.;
  static final double K89x_COASC2_MAX = 1./0.;
  static final double K89x_COASC2_MIN = 1./0.;
  static final double K89x_EQUASC_MAX = 1./0.;
  static final double K89x_EQUASC_MIN = 1./0.;
  static final double K89x_HOUSE10_MAX = 1./0.;
  static final double K89x_HOUSE10_MIN = 1./0.;
  static final double K89x_HOUSE11_MAX = 1./0.;
  static final double K89x_HOUSE11_MIN = 1./0.;
  static final double K89x_HOUSE12_MAX = 1./0.;
  static final double K89x_HOUSE12_MIN = 1./0.;
  static final double K89x_HOUSE1_MAX = 1./0.;
  static final double K89x_HOUSE1_MIN = 1./0.;
  static final double K89x_HOUSE2_MAX = 1./0.;
  static final double K89x_HOUSE2_MIN = 1./0.;
  static final double K89x_HOUSE3_MAX = 1./0.;
  static final double K89x_HOUSE3_MIN = 1./0.;
  static final double K89x_HOUSE4_MAX = 1./0.;
  static final double K89x_HOUSE4_MIN = 1./0.;
  static final double K89x_HOUSE5_MAX = 1./0.;
  static final double K89x_HOUSE5_MIN = 1./0.;
  static final double K89x_HOUSE6_MAX = 1./0.;
  static final double K89x_HOUSE6_MIN = 1./0.;
  static final double K89x_HOUSE7_MAX = 1./0.;
  static final double K89x_HOUSE7_MIN = 1./0.;
  static final double K89x_HOUSE8_MAX = 1./0.;
  static final double K89x_HOUSE8_MIN = 1./0.;
  static final double K89x_HOUSE9_MAX = 1./0.;
  static final double K89x_HOUSE9_MIN = 1./0.;
  static final double K89x_MC_MAX = 1./0.;
  static final double K89x_MC_MIN = 1./0.;
  static final double K89x_POLASC_MAX = 1./0.;
  static final double K89x_POLASC_MIN = 1./0.;
  static final double K89x_VERTEX_MAX = 1./0.;
  static final double K89x_VERTEX_MIN = 1./0.;
  static final double O0_ARMC_MAX = 360.986667;
  static final double O0_ARMC_MIN = 360.984167;
  static final double O0_ASC_MAX = 393.494420;
  static final double O0_ASC_MIN = 331.162937;
  static final double O0_COASC1_MAX = 394.215000;
  static final double O0_COASC1_MIN = 330.556667;
  static final double O0_COASC2_MAX = 0.000000;
  static final double O0_COASC2_MIN = 0.000000;
  static final double O0_EQUASC_MAX = 394.215000;
  static final double O0_EQUASC_MIN = 330.556667;
  static final double O0_HOUSE10_MAX = 394.215000;
  static final double O0_HOUSE10_MIN = 330.556667;
  static final double O0_HOUSE11_MAX = 372.995833;
  static final double O0_HOUSE11_MIN = 351.775833;
  static final double O0_HOUSE12_MAX = 372.995833;
  static final double O0_HOUSE12_MIN = 351.775833;
  static final double O0_HOUSE1_MAX = 394.215000;
  static final double O0_HOUSE1_MIN = 330.556667;
  static final double O0_HOUSE2_MAX = 372.995833;
  static final double O0_HOUSE2_MIN = 351.775833;
  static final double O0_HOUSE3_MAX = 372.995833;
  static final double O0_HOUSE3_MIN = 351.775833;
  static final double O0_HOUSE4_MAX = 394.215000;
  static final double O0_HOUSE4_MIN = 330.556667;
  static final double O0_HOUSE5_MAX = 372.995833;
  static final double O0_HOUSE5_MIN = 351.775833;
  static final double O0_HOUSE6_MAX = 372.995833;
  static final double O0_HOUSE6_MIN = 351.775833;
  static final double O0_HOUSE7_MAX = 394.215000;
  static final double O0_HOUSE7_MIN = 330.556667;
  static final double O0_HOUSE8_MAX = 372.995833;
  static final double O0_HOUSE8_MIN = 351.775833;
  static final double O0_HOUSE9_MAX = 372.995833;
  static final double O0_HOUSE9_MIN = 351.775833;
  static final double O0_MC_MAX = 394.215000;
  static final double O0_MC_MIN = 330.556667;
  static final double O0_POLASC_MAX = 394.215000;
  static final double O0_POLASC_MIN = 330.556667;
  static final double O0_VERTEX_MAX = 1500000.000000;
  static final double O0_VERTEX_MIN = 0.000000;
  static final double O10_ARMC_MAX = 360.986667;
  static final double O10_ARMC_MIN = 360.984167;
  static final double O10_ASC_MAX = 426.089536;
  static final double O10_ASC_MIN = 328.169552;
  static final double O10_COASC1_MAX = 427.276667;
  static final double O10_COASC1_MIN = 327.558333;
  static final double O10_COASC2_MAX = 2999820.000000;
  static final double O10_COASC2_MIN = -180.000000;
  static final double O10_EQUASC_MAX = 394.215000;
  static final double O10_EQUASC_MIN = 330.556667;
  static final double O10_HOUSE10_MAX = 394.215000;
  static final double O10_HOUSE10_MIN = 330.556667;
  static final double O10_HOUSE11_MAX = 372.698333;
  static final double O10_HOUSE11_MIN = 342.338333;
  static final double O10_HOUSE12_MAX = 395.037500;
  static final double O10_HOUSE12_MIN = 347.697500;
  static final double O10_HOUSE1_MAX = 427.276667;
  static final double O10_HOUSE1_MIN = 327.558333;
  static final double O10_HOUSE2_MAX = 395.037500;
  static final double O10_HOUSE2_MIN = 347.697500;
  static final double O10_HOUSE3_MAX = 372.698333;
  static final double O10_HOUSE3_MIN = 342.338333;
  static final double O10_HOUSE4_MAX = 394.215000;
  static final double O10_HOUSE4_MIN = 330.556667;
  static final double O10_HOUSE5_MAX = 372.698333;
  static final double O10_HOUSE5_MIN = 342.338333;
  static final double O10_HOUSE6_MAX = 395.037500;
  static final double O10_HOUSE6_MIN = 347.697500;
  static final double O10_HOUSE7_MAX = 427.276667;
  static final double O10_HOUSE7_MIN = 327.558333;
  static final double O10_HOUSE8_MAX = 395.037500;
  static final double O10_HOUSE8_MIN = 347.697500;
  static final double O10_HOUSE9_MAX = 372.698333;
  static final double O10_HOUSE9_MIN = 342.338333;
  static final double O10_MC_MAX = 394.215000;
  static final double O10_MC_MIN = 330.556667;
  static final double O10_POLASC_MAX = 427.276667;
  static final double O10_POLASC_MIN = 327.558333;
  static final double O10_VERTEX_MAX = 2999820.000000;
  static final double O10_VERTEX_MIN = -180.000000;
  static final double O20_ARMC_MAX = 360.986667;
  static final double O20_ARMC_MIN = 360.984167;
  static final double O20_ASC_MAX = 467.280896;
  static final double O20_ASC_MIN = 319.225068;
  static final double O20_COASC1_MAX = 469.147500;
  static final double O20_COASC1_MIN = 318.595833;
  static final double O20_COASC2_MAX = 2999819.999167;
  static final double O20_COASC2_MIN = -180.000000;
  static final double O20_EQUASC_MAX = 394.215000;
  static final double O20_EQUASC_MIN = 330.556667;
  static final double O20_HOUSE10_MAX = 394.215000;
  static final double O20_HOUSE10_MIN = 330.556667;
  static final double O20_HOUSE11_MAX = 376.755000;
  static final double O20_HOUSE11_MIN = 333.678333;
  static final double O20_HOUSE12_MAX = 422.951667;
  static final double O20_HOUSE12_MIN = 336.372500;
  static final double O20_HOUSE1_MAX = 469.147500;
  static final double O20_HOUSE1_MIN = 318.595833;
  static final double O20_HOUSE2_MAX = 422.951667;
  static final double O20_HOUSE2_MIN = 336.372500;
  static final double O20_HOUSE3_MAX = 376.755000;
  static final double O20_HOUSE3_MIN = 333.678333;
  static final double O20_HOUSE4_MAX = 394.215000;
  static final double O20_HOUSE4_MIN = 330.556667;
  static final double O20_HOUSE5_MAX = 376.755000;
  static final double O20_HOUSE5_MIN = 333.678333;
  static final double O20_HOUSE6_MAX = 422.951667;
  static final double O20_HOUSE6_MIN = 336.372500;
  static final double O20_HOUSE7_MAX = 469.147500;
  static final double O20_HOUSE7_MIN = 318.595833;
  static final double O20_HOUSE8_MAX = 422.951667;
  static final double O20_HOUSE8_MIN = 336.372500;
  static final double O20_HOUSE9_MAX = 376.755000;
  static final double O20_HOUSE9_MIN = 333.678333;
  static final double O20_MC_MAX = 394.215000;
  static final double O20_MC_MIN = 330.556667;
  static final double O20_POLASC_MAX = 469.147500;
  static final double O20_POLASC_MIN = 318.595833;
  static final double O20_VERTEX_MAX = 2999819.999167;
  static final double O20_VERTEX_MIN = -180.000000;
  static final double O30_ARMC_MAX = 360.986667;
  static final double O30_ARMC_MIN = 360.984167;
  static final double O30_ASC_MAX = 524.994891;
  static final double O30_ASC_MIN = 304.407972;
  static final double O30_COASC1_MAX = 527.985000;
  static final double O30_COASC1_MIN = 303.743333;
  static final double O30_COASC2_MAX = 1643.109167;
  static final double O30_COASC2_MIN = 218.980000;
  static final double O30_EQUASC_MAX = 394.215000;
  static final double O30_EQUASC_MIN = 330.556667;
  static final double O30_HOUSE10_MAX = 394.215000;
  static final double O30_HOUSE10_MIN = 330.556667;
  static final double O30_HOUSE11_MAX = 396.366667;
  static final double O30_HOUSE11_MIN = 325.213333;
  static final double O30_HOUSE12_MAX = 462.175833;
  static final double O30_HOUSE12_MIN = 319.869167;
  static final double O30_HOUSE1_MAX = 527.985000;
  static final double O30_HOUSE1_MIN = 303.743333;
  static final double O30_HOUSE2_MAX = 462.175833;
  static final double O30_HOUSE2_MIN = 319.869167;
  static final double O30_HOUSE3_MAX = 396.366667;
  static final double O30_HOUSE3_MIN = 325.213333;
  static final double O30_HOUSE4_MAX = 394.215000;
  static final double O30_HOUSE4_MIN = 330.556667;
  static final double O30_HOUSE5_MAX = 396.366667;
  static final double O30_HOUSE5_MIN = 325.213333;
  static final double O30_HOUSE6_MAX = 462.175833;
  static final double O30_HOUSE6_MIN = 319.869167;
  static final double O30_HOUSE7_MAX = 527.985000;
  static final double O30_HOUSE7_MIN = 303.743333;
  static final double O30_HOUSE8_MAX = 462.175833;
  static final double O30_HOUSE8_MIN = 319.869167;
  static final double O30_HOUSE9_MAX = 396.366667;
  static final double O30_HOUSE9_MIN = 325.213333;
  static final double O30_MC_MAX = 394.215000;
  static final double O30_MC_MIN = 330.556667;
  static final double O30_POLASC_MAX = 527.985000;
  static final double O30_POLASC_MIN = 303.743333;
  static final double O30_VERTEX_MAX = 1643.108333;
  static final double O30_VERTEX_MIN = 218.980000;
  static final double O40_ARMC_MAX = 360.986667;
  static final double O40_ARMC_MIN = 360.984167;
  static final double O40_ASC_MAX = 618.738596;
  static final double O40_ASC_MIN = 283.720808;
  static final double O40_COASC1_MAX = 623.978333;
  static final double O40_COASC1_MIN = 282.993333;
  static final double O40_COASC2_MAX = 826.410833;
  static final double O40_COASC2_MIN = 255.830833;
  static final double O40_EQUASC_MAX = 394.215000;
  static final double O40_EQUASC_MIN = 330.556667;
  static final double O40_HOUSE10_MAX = 394.215000;
  static final double O40_HOUSE10_MIN = 330.556667;
  static final double O40_HOUSE11_MAX = 428.365000;
  static final double O40_HOUSE11_MIN = 316.411667;
  static final double O40_HOUSE12_MAX = 526.171667;
  static final double O40_HOUSE12_MIN = 302.265833;
  static final double O40_HOUSE1_MAX = 623.978333;
  static final double O40_HOUSE1_MIN = 282.993333;
  static final double O40_HOUSE2_MAX = 526.171667;
  static final double O40_HOUSE2_MIN = 302.265833;
  static final double O40_HOUSE3_MAX = 428.365000;
  static final double O40_HOUSE3_MIN = 316.411667;
  static final double O40_HOUSE4_MAX = 394.215000;
  static final double O40_HOUSE4_MIN = 330.556667;
  static final double O40_HOUSE5_MAX = 428.365000;
  static final double O40_HOUSE5_MIN = 316.411667;
  static final double O40_HOUSE6_MAX = 526.171667;
  static final double O40_HOUSE6_MIN = 302.265833;
  static final double O40_HOUSE7_MAX = 623.978333;
  static final double O40_HOUSE7_MIN = 282.993333;
  static final double O40_HOUSE8_MAX = 526.171667;
  static final double O40_HOUSE8_MIN = 302.265833;
  static final double O40_HOUSE9_MAX = 428.365000;
  static final double O40_HOUSE9_MIN = 316.411667;
  static final double O40_MC_MAX = 394.215000;
  static final double O40_MC_MIN = 330.556667;
  static final double O40_POLASC_MAX = 623.978333;
  static final double O40_POLASC_MIN = 282.993333;
  static final double O40_VERTEX_MAX = 826.410833;
  static final double O40_VERTEX_MIN = 255.830833;
  static final double O50_ARMC_MAX = 360.986667;
  static final double O50_ARMC_MIN = 360.984167;
  static final double O50_ASC_MAX = 814.745889;
  static final double O50_ASC_MIN = 256.684961;
  static final double O50_COASC1_MAX = 826.410833;
  static final double O50_COASC1_MIN = 255.830833;
  static final double O50_COASC2_MAX = 623.978333;
  static final double O50_COASC2_MIN = 282.993333;
  static final double O50_EQUASC_MAX = 394.215000;
  static final double O50_EQUASC_MIN = 330.556667;
  static final double O50_HOUSE10_MAX = 394.215000;
  static final double O50_HOUSE10_MIN = 330.556667;
  static final double O50_HOUSE11_MAX = 495.841667;
  static final double O50_HOUSE11_MIN = 306.652500;
  static final double O50_HOUSE12_MAX = 661.126667;
  static final double O50_HOUSE12_MIN = 282.748333;
  static final double O50_HOUSE1_MAX = 826.410833;
  static final double O50_HOUSE1_MIN = 255.830833;
  static final double O50_HOUSE2_MAX = 661.126667;
  static final double O50_HOUSE2_MIN = 282.748333;
  static final double O50_HOUSE3_MAX = 495.841667;
  static final double O50_HOUSE3_MIN = 306.652500;
  static final double O50_HOUSE4_MAX = 394.215000;
  static final double O50_HOUSE4_MIN = 330.556667;
  static final double O50_HOUSE5_MAX = 495.841667;
  static final double O50_HOUSE5_MIN = 306.652500;
  static final double O50_HOUSE6_MAX = 661.126667;
  static final double O50_HOUSE6_MIN = 282.748333;
  static final double O50_HOUSE7_MAX = 826.410833;
  static final double O50_HOUSE7_MIN = 255.830833;
  static final double O50_HOUSE8_MAX = 661.126667;
  static final double O50_HOUSE8_MIN = 282.748333;
  static final double O50_HOUSE9_MAX = 495.841667;
  static final double O50_HOUSE9_MIN = 306.652500;
  static final double O50_MC_MAX = 394.215000;
  static final double O50_MC_MIN = 330.556667;
  static final double O50_POLASC_MAX = 826.410833;
  static final double O50_POLASC_MIN = 255.830833;
  static final double O50_VERTEX_MAX = 623.978333;
  static final double O50_VERTEX_MIN = 282.993333;
  static final double O60_ARMC_MAX = 360.986667;
  static final double O60_ARMC_MIN = 360.984167;
  static final double O60_ASC_MAX = 1583.084164;
  static final double O60_ASC_MIN = 220.207028;
  static final double O60_COASC1_MAX = 1643.108333;
  static final double O60_COASC1_MIN = 218.980000;
  static final double O60_COASC2_MAX = 527.985000;
  static final double O60_COASC2_MIN = 303.743333;
  static final double O60_EQUASC_MAX = 394.215000;
  static final double O60_EQUASC_MIN = 330.556667;
  static final double O60_HOUSE10_MAX = 394.215000;
  static final double O60_HOUSE10_MIN = 330.556667;
  static final double O60_HOUSE11_MAX = 768.075000;
  static final double O60_HOUSE11_MIN = 295.030000;
  static final double O60_HOUSE12_MAX = 1205.592500;
  static final double O60_HOUSE12_MIN = 259.502500;
  static final double O60_HOUSE1_MAX = 1643.109167;
  static final double O60_HOUSE1_MIN = 218.980000;
  static final double O60_HOUSE2_MAX = 1205.592500;
  static final double O60_HOUSE2_MIN = 259.502500;
  static final double O60_HOUSE3_MAX = 768.075000;
  static final double O60_HOUSE3_MIN = 295.030000;
  static final double O60_HOUSE4_MAX = 394.215000;
  static final double O60_HOUSE4_MIN = 330.556667;
  static final double O60_HOUSE5_MAX = 768.075000;
  static final double O60_HOUSE5_MIN = 295.030000;
  static final double O60_HOUSE6_MAX = 1205.592500;
  static final double O60_HOUSE6_MIN = 259.502500;
  static final double O60_HOUSE7_MAX = 1643.109167;
  static final double O60_HOUSE7_MIN = 218.980000;
  static final double O60_HOUSE8_MAX = 1205.592500;
  static final double O60_HOUSE8_MIN = 259.502500;
  static final double O60_HOUSE9_MAX = 768.075000;
  static final double O60_HOUSE9_MIN = 295.030000;
  static final double O60_MC_MAX = 394.215000;
  static final double O60_MC_MIN = 330.556667;
  static final double O60_POLASC_MAX = 1643.108333;
  static final double O60_POLASC_MIN = 218.980000;
  static final double O60_VERTEX_MAX = 527.985000;
  static final double O60_VERTEX_MIN = 303.743333;
  static final double O66_ARMC_MAX = 360.986667;
  static final double O66_ARMC_MIN = 360.984167;
  static final double O66_ASC_MAX = 15382.763492;
  static final double O66_ASC_MIN = 180.714519;
  static final double O66_COASC1_MAX = 27433.717500;
  static final double O66_COASC1_MIN = 176.632500;
  static final double O66_COASC2_MAX = 489.939167;
  static final double O66_COASC2_MIN = 313.358333;
  static final double O66_EQUASC_MAX = 394.215000;
  static final double O66_EQUASC_MIN = 330.556667;
  static final double O66_HOUSE10_MAX = 394.215000;
  static final double O66_HOUSE10_MIN = 330.556667;
  static final double O66_HOUSE11_MAX = 9364.887500;
  static final double O66_HOUSE11_MIN = 286.549167;
  static final double O66_HOUSE12_MAX = 18399.217500;
  static final double O66_HOUSE12_MIN = 236.826667;
  static final double O66_HOUSE1_MAX = 27433.547500;
  static final double O66_HOUSE1_MIN = 176.632500;
  static final double O66_HOUSE2_MAX = 18399.217500;
  static final double O66_HOUSE2_MIN = 236.826667;
  static final double O66_HOUSE3_MAX = 9364.887500;
  static final double O66_HOUSE3_MIN = 286.549167;
  static final double O66_HOUSE4_MAX = 394.215000;
  static final double O66_HOUSE4_MIN = 330.556667;
  static final double O66_HOUSE5_MAX = 9364.887500;
  static final double O66_HOUSE5_MIN = 286.549167;
  static final double O66_HOUSE6_MAX = 18399.217500;
  static final double O66_HOUSE6_MIN = 236.826667;
  static final double O66_HOUSE7_MAX = 27433.547500;
  static final double O66_HOUSE7_MIN = 176.632500;
  static final double O66_HOUSE8_MAX = 18399.217500;
  static final double O66_HOUSE8_MIN = 236.826667;
  static final double O66_HOUSE9_MAX = 9364.887500;
  static final double O66_HOUSE9_MIN = 286.549167;
  static final double O66_MC_MAX = 394.215000;
  static final double O66_MC_MIN = 330.556667;
  static final double O66_POLASC_MAX = 27433.717500;
  static final double O66_POLASC_MIN = 176.632500;
  static final double O66_VERTEX_MAX = 489.939167;
  static final double O66_VERTEX_MIN = 313.358333;
  static final double O70_ARMC_MAX = 360.986667;
  static final double O70_ARMC_MIN = 360.984167;
  static final double O70_ASC_MAX = 1553150.329680;
  static final double O70_ASC_MIN = -777600.393020;
  static final double O70_COASC1_MAX = 2999819.999167;
  static final double O70_COASC1_MIN = -180.000000;
  static final double O70_COASC2_MAX = 469.147500;
  static final double O70_COASC2_MIN = 318.595833;
  static final double O70_EQUASC_MAX = 394.215000;
  static final double O70_EQUASC_MIN = 330.556667;
  static final double O70_HOUSE10_MAX = 394.215000;
  static final double O70_HOUSE10_MIN = 330.556667;
  static final double O70_HOUSE11_MAX = 2999819.998333;
  static final double O70_HOUSE11_MIN = -179.998333;
  static final double O70_HOUSE12_MAX = 2999918.900000;
  static final double O70_HOUSE12_MIN = -180.000000;
  static final double O70_HOUSE1_MAX = 2999820.000000;
  static final double O70_HOUSE1_MIN = -179.999167;
  static final double O70_HOUSE2_MAX = 2999918.880000;
  static final double O70_HOUSE2_MIN = -179.999167;
  static final double O70_HOUSE3_MAX = 2999819.998333;
  static final double O70_HOUSE3_MIN = -179.998333;
  static final double O70_HOUSE4_MAX = 394.215000;
  static final double O70_HOUSE4_MIN = 330.556667;
  static final double O70_HOUSE5_MAX = 2999819.998333;
  static final double O70_HOUSE5_MIN = -179.998333;
  static final double O70_HOUSE6_MAX = 2999820.000000;
  static final double O70_HOUSE6_MIN = -179.999167;
  static final double O70_HOUSE7_MAX = 2999819.999167;
  static final double O70_HOUSE7_MIN = -180.000000;
  static final double O70_HOUSE8_MAX = 2999819.999167;
  static final double O70_HOUSE8_MIN = -180.000000;
  static final double O70_HOUSE9_MAX = 2999819.998333;
  static final double O70_HOUSE9_MIN = -179.998333;
  static final double O70_MC_MAX = 394.215000;
  static final double O70_MC_MIN = 330.556667;
  static final double O70_POLASC_MAX = 2999820.000000;
  static final double O70_POLASC_MIN = -180.000000;
  static final double O70_VERTEX_MAX = 469.147500;
  static final double O70_VERTEX_MIN = 318.595833;
  static final double O80_ARMC_MAX = 360.986667;
  static final double O80_ARMC_MIN = 360.984167;
  static final double O80_ASC_MAX = 1554930.566184;
  static final double O80_ASC_MIN = -777600.124007;
  static final double O80_COASC1_MAX = 2999820.000000;
  static final double O80_COASC1_MIN = -180.000000;
  static final double O80_COASC2_MAX = 427.276667;
  static final double O80_COASC2_MIN = 327.558333;
  static final double O80_EQUASC_MAX = 394.215000;
  static final double O80_EQUASC_MIN = 330.556667;
  static final double O80_HOUSE10_MAX = 394.215000;
  static final double O80_HOUSE10_MIN = 330.556667;
  static final double O80_HOUSE11_MAX = 500254.918333;
  static final double O80_HOUSE11_MIN = 130.085000;
  static final double O80_HOUSE12_MAX = 1000127.490833;
  static final double O80_HOUSE12_MIN = -71.432500;
  static final double O80_HOUSE1_MAX = 2999820.000000;
  static final double O80_HOUSE1_MIN = -180.000000;
  static final double O80_HOUSE2_MAX = 1000127.490833;
  static final double O80_HOUSE2_MIN = -71.432500;
  static final double O80_HOUSE3_MAX = 500254.918333;
  static final double O80_HOUSE3_MIN = 130.085000;
  static final double O80_HOUSE4_MAX = 394.215000;
  static final double O80_HOUSE4_MIN = 330.556667;
  static final double O80_HOUSE5_MAX = 500254.918333;
  static final double O80_HOUSE5_MIN = 130.085000;
  static final double O80_HOUSE6_MAX = 1000127.490833;
  static final double O80_HOUSE6_MIN = -71.432500;
  static final double O80_HOUSE7_MAX = 2999820.000000;
  static final double O80_HOUSE7_MIN = -180.000000;
  static final double O80_HOUSE8_MAX = 1000127.490833;
  static final double O80_HOUSE8_MIN = -71.432500;
  static final double O80_HOUSE9_MAX = 500254.918333;
  static final double O80_HOUSE9_MIN = 130.085000;
  static final double O80_MC_MAX = 394.215000;
  static final double O80_MC_MIN = 330.556667;
  static final double O80_POLASC_MAX = 2999820.000000;
  static final double O80_POLASC_MIN = -180.000000;
  static final double O80_VERTEX_MAX = 427.276667;
  static final double O80_VERTEX_MIN = 327.558333;
  static final double O85_ARMC_MAX = 360.986667;
  static final double O85_ARMC_MIN = 360.984167;
  static final double O85_ASC_MAX = 1555100.603952;
  static final double O85_ASC_MIN = -777600.058703;
  static final double O85_COASC1_MAX = 2999901.836667;
  static final double O85_COASC1_MIN = -100.323333;
  static final double O85_COASC2_MAX = 409.954167;
  static final double O85_COASC2_MIN = 329.806667;
  static final double O85_EQUASC_MAX = 394.215000;
  static final double O85_EQUASC_MIN = 330.556667;
  static final double O85_HOUSE10_MAX = 394.215000;
  static final double O85_HOUSE10_MIN = 330.556667;
  static final double O85_HOUSE11_MAX = 500260.830000;
  static final double O85_HOUSE11_MIN = 187.627500;
  static final double O85_HOUSE12_MAX = 1000130.430000;
  static final double O85_HOUSE12_MIN = 43.652500;
  static final double O85_HOUSE1_MAX = 2999901.836667;
  static final double O85_HOUSE1_MIN = -100.323333;
  static final double O85_HOUSE2_MAX = 1000130.430000;
  static final double O85_HOUSE2_MIN = 43.652500;
  static final double O85_HOUSE3_MAX = 500260.830000;
  static final double O85_HOUSE3_MIN = 187.627500;
  static final double O85_HOUSE4_MAX = 394.215000;
  static final double O85_HOUSE4_MIN = 330.556667;
  static final double O85_HOUSE5_MAX = 500260.830000;
  static final double O85_HOUSE5_MIN = 187.627500;
  static final double O85_HOUSE6_MAX = 1000130.430000;
  static final double O85_HOUSE6_MIN = 43.652500;
  static final double O85_HOUSE7_MAX = 1500000.030833;
  static final double O85_HOUSE7_MIN = -100.323333;
  static final double O85_HOUSE8_MAX = 1000130.430000;
  static final double O85_HOUSE8_MIN = 43.652500;
  static final double O85_HOUSE9_MAX = 500260.830000;
  static final double O85_HOUSE9_MIN = 187.627500;
  static final double O85_MC_MAX = 394.215000;
  static final double O85_MC_MIN = 330.556667;
  static final double O85_POLASC_MAX = 66.413333;
  static final double O85_POLASC_MIN = -100.323333;
  static final double O85_VERTEX_MAX = 409.954167;
  static final double O85_VERTEX_MIN = 329.806667;
  static final double O88_ARMC_MAX = 360.985931;
  static final double O88_ARMC_MIN = 360.985828;
  static final double O88_ASC_MAX = 1555165.554408;
  static final double O88_ASC_MIN = -777600.023170;
  static final double O88_COASC1_MAX = 1555165.554409;
  static final double O88_COASC1_MIN = -34.489296;
  static final double O88_COASC2_MAX = 399.547623;
  static final double O88_COASC2_MIN = 331.043079;
  static final double O88_EQUASC_MAX = 393.494420;
  static final double O88_EQUASC_MIN = 331.162937;
  static final double O88_HOUSE10_MAX = 393.494420;
  static final double O88_HOUSE10_MIN = 331.162936;
  static final double O88_HOUSE11_MAX = 259462.023358;
  static final double O88_HOUSE11_MIN = 209.293425;
  static final double O88_HOUSE12_MAX = 518531.023142;
  static final double O88_HOUSE12_MIN = 87.418623;
  static final double O88_HOUSE1_MAX = 1555199.976849;
  static final double O88_HOUSE1_MIN = 0.023142;
  static final double O88_HOUSE2_MAX = 518531.023142;
  static final double O88_HOUSE2_MIN = 87.418623;
  static final double O88_HOUSE3_MAX = 259462.023358;
  static final double O88_HOUSE3_MIN = 209.293425;
  static final double O88_HOUSE4_MAX = 393.494420;
  static final double O88_HOUSE4_MIN = 331.162936;
  static final double O88_HOUSE5_MAX = 259462.023358;
  static final double O88_HOUSE5_MIN = 209.293425;
  static final double O88_HOUSE6_MAX = 518531.023142;
  static final double O88_HOUSE6_MIN = 87.418623;
  static final double O88_HOUSE7_MAX = 1555199.976849;
  static final double O88_HOUSE7_MIN = 0.023142;
  static final double O88_HOUSE8_MAX = 518531.023142;
  static final double O88_HOUSE8_MIN = 87.418623;
  static final double O88_HOUSE9_MAX = 259462.023358;
  static final double O88_HOUSE9_MIN = 209.293425;
  static final double O88_MC_MAX = 393.494420;
  static final double O88_MC_MIN = 331.162936;
  static final double O88_POLASC_MAX = 29.344230;
  static final double O88_POLASC_MIN = -34.489313;
  static final double O88_VERTEX_MAX = 399.547621;
  static final double O88_VERTEX_MIN = 331.043081;
  static final double O89x_ARMC_MAX = 360.986667;
  static final double O89x_ARMC_MIN = 360.984167;
  static final double O89x_ASC_MAX = 1555200.000000;
  static final double O89x_ASC_MIN = -777600.000000;
  static final double O89x_COASC1_MAX = 2999998.426667;
  static final double O89x_COASC1_MIN = -1.600833;
  static final double O89x_COASC2_MAX = 394.516667;
  static final double O89x_COASC2_MIN = 330.556667;
  static final double O89x_EQUASC_MAX = 394.215000;
  static final double O89x_EQUASC_MIN = 330.556667;
  static final double O89x_HOUSE10_MAX = 394.215000;
  static final double O89x_HOUSE10_MIN = 330.556667;
  static final double O89x_HOUSE11_MAX = 500262.809167;
  static final double O89x_HOUSE11_MIN = 219.846667;
  static final double O89x_HOUSE12_MAX = 1000131.405000;
  static final double O89x_HOUSE12_MIN = 109.135833;
  static final double O89x_HOUSE1_MAX = 2999998.426667;
  static final double O89x_HOUSE1_MIN = -1.600833;
  static final double O89x_HOUSE2_MAX = 1000131.405000;
  static final double O89x_HOUSE2_MIN = 109.135833;
  static final double O89x_HOUSE3_MAX = 500262.809167;
  static final double O89x_HOUSE3_MIN = 219.846667;
  static final double O89x_HOUSE4_MAX = 394.215000;
  static final double O89x_HOUSE4_MIN = 330.556667;
  static final double O89x_HOUSE5_MAX = 500262.809167;
  static final double O89x_HOUSE5_MIN = 219.846667;
  static final double O89x_HOUSE6_MAX = 1000131.405000;
  static final double O89x_HOUSE6_MIN = 109.135833;
  static final double O89x_HOUSE7_MAX = 1500000.000833;
  static final double O89x_HOUSE7_MIN = -1.600833;
  static final double O89x_HOUSE8_MAX = 1000131.405000;
  static final double O89x_HOUSE8_MIN = 109.135833;
  static final double O89x_HOUSE9_MAX = 500262.809167;
  static final double O89x_HOUSE9_MIN = 219.846667;
  static final double O89x_MC_MAX = 394.215000;
  static final double O89x_MC_MIN = 330.556667;
  static final double O89x_POLASC_MAX = 1.588333;
  static final double O89x_POLASC_MIN = -1.600833;
  static final double O89x_VERTEX_MAX = 394.516667;
  static final double O89x_VERTEX_MIN = 330.556667;
  static final double P0_ARMC_MAX = 360.986667;
  static final double P0_ARMC_MIN = 360.984167;
  static final double P0_ASC_MAX = 393.494420;
  static final double P0_ASC_MIN = 331.162937;
  static final double P0_COASC1_MAX = 394.215000;
  static final double P0_COASC1_MIN = 330.556667;
  static final double P0_COASC2_MAX = 0.000000;
  static final double P0_COASC2_MIN = 0.000000;
  static final double P0_EQUASC_MAX = 394.215000;
  static final double P0_EQUASC_MIN = 330.556667;
  static final double P0_HOUSE10_MAX = 394.215000;
  static final double P0_HOUSE10_MIN = 330.556667;
  static final double P0_HOUSE11_MAX = 394.215000;
  static final double P0_HOUSE11_MIN = 330.556667;
  static final double P0_HOUSE12_MAX = 394.215000;
  static final double P0_HOUSE12_MIN = 330.556667;
  static final double P0_HOUSE1_MAX = 394.215000;
  static final double P0_HOUSE1_MIN = 330.556667;
  static final double P0_HOUSE2_MAX = 394.215000;
  static final double P0_HOUSE2_MIN = 330.556667;
  static final double P0_HOUSE3_MAX = 394.215000;
  static final double P0_HOUSE3_MIN = 330.556667;
  static final double P0_HOUSE4_MAX = 394.215000;
  static final double P0_HOUSE4_MIN = 330.556667;
  static final double P0_HOUSE5_MAX = 394.215000;
  static final double P0_HOUSE5_MIN = 330.556667;
  static final double P0_HOUSE6_MAX = 394.215000;
  static final double P0_HOUSE6_MIN = 330.556667;
  static final double P0_HOUSE7_MAX = 394.215000;
  static final double P0_HOUSE7_MIN = 330.556667;
  static final double P0_HOUSE8_MAX = 394.215000;
  static final double P0_HOUSE8_MIN = 330.556667;
  static final double P0_HOUSE9_MAX = 394.215000;
  static final double P0_HOUSE9_MIN = 330.556667;
  static final double P0_MC_MAX = 394.215000;
  static final double P0_MC_MIN = 330.556667;
  static final double P0_POLASC_MAX = 394.215000;
  static final double P0_POLASC_MIN = 330.556667;
  static final double P0_VERTEX_MAX = 1500000.000000;
  static final double P0_VERTEX_MIN = 0.000000;
  static final double P10_ARMC_MAX = 360.986667;
  static final double P10_ARMC_MIN = 360.984167;
  static final double P10_ASC_MAX = 426.089536;
  static final double P10_ASC_MIN = 328.169552;
  static final double P10_COASC1_MAX = 427.276667;
  static final double P10_COASC1_MIN = 327.558333;
  static final double P10_COASC2_MAX = 2999820.000000;
  static final double P10_COASC2_MIN = -180.000000;
  static final double P10_EQUASC_MAX = 394.215000;
  static final double P10_EQUASC_MIN = 330.556667;
  static final double P10_HOUSE10_MAX = 394.215000;
  static final double P10_HOUSE10_MIN = 330.556667;
  static final double P10_HOUSE11_MAX = 404.651667;
  static final double P10_HOUSE11_MIN = 330.215833;
  static final double P10_HOUSE12_MAX = 415.656667;
  static final double P10_HOUSE12_MIN = 329.204167;
  static final double P10_HOUSE1_MAX = 427.276667;
  static final double P10_HOUSE1_MIN = 327.558333;
  static final double P10_HOUSE2_MAX = 415.656667;
  static final double P10_HOUSE2_MIN = 329.204167;
  static final double P10_HOUSE3_MAX = 404.651667;
  static final double P10_HOUSE3_MIN = 330.215833;
  static final double P10_HOUSE4_MAX = 394.215000;
  static final double P10_HOUSE4_MIN = 330.556667;
  static final double P10_HOUSE5_MAX = 404.651667;
  static final double P10_HOUSE5_MIN = 330.215833;
  static final double P10_HOUSE6_MAX = 415.656667;
  static final double P10_HOUSE6_MIN = 329.204167;
  static final double P10_HOUSE7_MAX = 427.276667;
  static final double P10_HOUSE7_MIN = 327.558333;
  static final double P10_HOUSE8_MAX = 415.656667;
  static final double P10_HOUSE8_MIN = 329.204167;
  static final double P10_HOUSE9_MAX = 404.651667;
  static final double P10_HOUSE9_MIN = 330.215833;
  static final double P10_MC_MAX = 394.215000;
  static final double P10_MC_MIN = 330.556667;
  static final double P10_POLASC_MAX = 427.276667;
  static final double P10_POLASC_MIN = 327.558333;
  static final double P10_VERTEX_MAX = 2999820.000000;
  static final double P10_VERTEX_MIN = -180.000000;
  static final double P20_ARMC_MAX = 360.986667;
  static final double P20_ARMC_MIN = 360.984167;
  static final double P20_ASC_MAX = 467.280896;
  static final double P20_ASC_MIN = 319.225068;
  static final double P20_COASC1_MAX = 469.147500;
  static final double P20_COASC1_MIN = 318.595833;
  static final double P20_COASC2_MAX = 2999819.999167;
  static final double P20_COASC2_MIN = -180.000000;
  static final double P20_EQUASC_MAX = 394.215000;
  static final double P20_EQUASC_MIN = 330.556667;
  static final double P20_HOUSE10_MAX = 394.215000;
  static final double P20_HOUSE10_MIN = 330.556667;
  static final double P20_HOUSE11_MAX = 416.383333;
  static final double P20_HOUSE11_MIN = 329.089167;
  static final double P20_HOUSE12_MAX = 441.193333;
  static final double P20_HOUSE12_MIN = 324.914167;
  static final double P20_HOUSE1_MAX = 469.147500;
  static final double P20_HOUSE1_MIN = 318.595833;
  static final double P20_HOUSE2_MAX = 441.193333;
  static final double P20_HOUSE2_MIN = 324.914167;
  static final double P20_HOUSE3_MAX = 416.383333;
  static final double P20_HOUSE3_MIN = 329.089167;
  static final double P20_HOUSE4_MAX = 394.215000;
  static final double P20_HOUSE4_MIN = 330.556667;
  static final double P20_HOUSE5_MAX = 416.383333;
  static final double P20_HOUSE5_MIN = 329.089167;
  static final double P20_HOUSE6_MAX = 441.193333;
  static final double P20_HOUSE6_MIN = 324.914167;
  static final double P20_HOUSE7_MAX = 469.147500;
  static final double P20_HOUSE7_MIN = 318.595833;
  static final double P20_HOUSE8_MAX = 441.193333;
  static final double P20_HOUSE8_MIN = 324.914167;
  static final double P20_HOUSE9_MAX = 416.383333;
  static final double P20_HOUSE9_MIN = 329.089167;
  static final double P20_MC_MAX = 394.215000;
  static final double P20_MC_MIN = 330.556667;
  static final double P20_POLASC_MAX = 469.147500;
  static final double P20_POLASC_MIN = 318.595833;
  static final double P20_VERTEX_MAX = 2999819.999167;
  static final double P20_VERTEX_MIN = -180.000000;
  static final double P30_ARMC_MAX = 360.986667;
  static final double P30_ARMC_MIN = 360.984167;
  static final double P30_ASC_MAX = 524.994891;
  static final double P30_ASC_MIN = 304.407972;
  static final double P30_COASC1_MAX = 527.985000;
  static final double P30_COASC1_MIN = 303.743333;
  static final double P30_COASC2_MAX = 1643.109167;
  static final double P30_COASC2_MIN = 218.980000;
  static final double P30_EQUASC_MAX = 394.215000;
  static final double P30_EQUASC_MIN = 330.556667;
  static final double P30_HOUSE10_MAX = 394.215000;
  static final double P30_HOUSE10_MIN = 330.556667;
  static final double P30_HOUSE11_MAX = 430.578333;
  static final double P30_HOUSE11_MIN = 326.804167;
  static final double P30_HOUSE12_MAX = 474.332500;
  static final double P30_HOUSE12_MIN = 316.967500;
  static final double P30_HOUSE1_MAX = 527.985000;
  static final double P30_HOUSE1_MIN = 303.743333;
  static final double P30_HOUSE2_MAX = 474.332500;
  static final double P30_HOUSE2_MIN = 316.967500;
  static final double P30_HOUSE3_MAX = 430.578333;
  static final double P30_HOUSE3_MIN = 326.804167;
  static final double P30_HOUSE4_MAX = 394.215000;
  static final double P30_HOUSE4_MIN = 330.556667;
  static final double P30_HOUSE5_MAX = 430.578333;
  static final double P30_HOUSE5_MIN = 326.804167;
  static final double P30_HOUSE6_MAX = 474.332500;
  static final double P30_HOUSE6_MIN = 316.967500;
  static final double P30_HOUSE7_MAX = 527.985000;
  static final double P30_HOUSE7_MIN = 303.743333;
  static final double P30_HOUSE8_MAX = 474.332500;
  static final double P30_HOUSE8_MIN = 316.967500;
  static final double P30_HOUSE9_MAX = 430.578333;
  static final double P30_HOUSE9_MIN = 326.804167;
  static final double P30_MC_MAX = 394.215000;
  static final double P30_MC_MIN = 330.556667;
  static final double P30_POLASC_MAX = 527.985000;
  static final double P30_POLASC_MIN = 303.743333;
  static final double P30_VERTEX_MAX = 1643.108333;
  static final double P30_VERTEX_MIN = 218.980000;
  static final double P40_ARMC_MAX = 360.986667;
  static final double P40_ARMC_MIN = 360.984167;
  static final double P40_ASC_MAX = 618.738596;
  static final double P40_ASC_MIN = 283.720808;
  static final double P40_COASC1_MAX = 623.978333;
  static final double P40_COASC1_MIN = 282.993333;
  static final double P40_COASC2_MAX = 826.410833;
  static final double P40_COASC2_MIN = 255.830833;
  static final double P40_EQUASC_MAX = 394.215000;
  static final double P40_EQUASC_MIN = 330.556667;
  static final double P40_HOUSE10_MAX = 394.215000;
  static final double P40_HOUSE10_MIN = 330.556667;
  static final double P40_HOUSE11_MAX = 449.370833;
  static final double P40_HOUSE11_MIN = 322.445833;
  static final double P40_HOUSE12_MAX = 522.472500;
  static final double P40_HOUSE12_MIN = 304.082500;
  static final double P40_HOUSE1_MAX = 623.978333;
  static final double P40_HOUSE1_MIN = 282.993333;
  static final double P40_HOUSE2_MAX = 522.472500;
  static final double P40_HOUSE2_MIN = 304.082500;
  static final double P40_HOUSE3_MAX = 449.370833;
  static final double P40_HOUSE3_MIN = 322.445833;
  static final double P40_HOUSE4_MAX = 394.215000;
  static final double P40_HOUSE4_MIN = 330.556667;
  static final double P40_HOUSE5_MAX = 449.370833;
  static final double P40_HOUSE5_MIN = 322.445833;
  static final double P40_HOUSE6_MAX = 522.472500;
  static final double P40_HOUSE6_MIN = 304.082500;
  static final double P40_HOUSE7_MAX = 623.978333;
  static final double P40_HOUSE7_MIN = 282.993333;
  static final double P40_HOUSE8_MAX = 522.472500;
  static final double P40_HOUSE8_MIN = 304.082500;
  static final double P40_HOUSE9_MAX = 449.370833;
  static final double P40_HOUSE9_MIN = 322.445833;
  static final double P40_MC_MAX = 394.215000;
  static final double P40_MC_MIN = 330.556667;
  static final double P40_POLASC_MAX = 623.978333;
  static final double P40_POLASC_MIN = 282.993333;
  static final double P40_VERTEX_MAX = 826.410833;
  static final double P40_VERTEX_MIN = 255.830833;
  static final double P50_ARMC_MAX = 360.986667;
  static final double P50_ARMC_MIN = 360.984167;
  static final double P50_ASC_MAX = 814.745889;
  static final double P50_ASC_MIN = 256.684961;
  static final double P50_COASC1_MAX = 826.410833;
  static final double P50_COASC1_MIN = 255.830833;
  static final double P50_COASC2_MAX = 623.978333;
  static final double P50_COASC2_MIN = 282.993333;
  static final double P50_EQUASC_MAX = 394.215000;
  static final double P50_EQUASC_MIN = 330.556667;
  static final double P50_HOUSE10_MAX = 394.215000;
  static final double P50_HOUSE10_MIN = 330.556667;
  static final double P50_HOUSE11_MAX = 477.445833;
  static final double P50_HOUSE11_MIN = 313.775833;
  static final double P50_HOUSE12_MAX = 605.230000;
  static final double P50_HOUSE12_MIN = 284.182500;
  static final double P50_HOUSE1_MAX = 826.410833;
  static final double P50_HOUSE1_MIN = 255.830833;
  static final double P50_HOUSE2_MAX = 605.230000;
  static final double P50_HOUSE2_MIN = 284.182500;
  static final double P50_HOUSE3_MAX = 477.445833;
  static final double P50_HOUSE3_MIN = 313.775000;
  static final double P50_HOUSE4_MAX = 394.215000;
  static final double P50_HOUSE4_MIN = 330.556667;
  static final double P50_HOUSE5_MAX = 477.445833;
  static final double P50_HOUSE5_MIN = 313.775833;
  static final double P50_HOUSE6_MAX = 605.230000;
  static final double P50_HOUSE6_MIN = 284.182500;
  static final double P50_HOUSE7_MAX = 826.410833;
  static final double P50_HOUSE7_MIN = 255.830833;
  static final double P50_HOUSE8_MAX = 605.230000;
  static final double P50_HOUSE8_MIN = 284.182500;
  static final double P50_HOUSE9_MAX = 477.445833;
  static final double P50_HOUSE9_MIN = 313.775000;
  static final double P50_MC_MAX = 394.215000;
  static final double P50_MC_MIN = 330.556667;
  static final double P50_POLASC_MAX = 826.410833;
  static final double P50_POLASC_MIN = 255.830833;
  static final double P50_VERTEX_MAX = 623.978333;
  static final double P50_VERTEX_MIN = 282.993333;
  static final double P60_ARMC_MAX = 360.986667;
  static final double P60_ARMC_MIN = 360.984167;
  static final double P60_ASC_MAX = 1583.084164;
  static final double P60_ASC_MIN = 220.207028;
  static final double P60_COASC1_MAX = 1643.108333;
  static final double P60_COASC1_MIN = 218.980000;
  static final double P60_COASC2_MAX = 527.985000;
  static final double P60_COASC2_MIN = 303.743333;
  static final double P60_EQUASC_MAX = 394.215000;
  static final double P60_EQUASC_MIN = 330.556667;
  static final double P60_HOUSE10_MAX = 394.215000;
  static final double P60_HOUSE10_MIN = 330.556667;
  static final double P60_HOUSE11_MAX = 527.985000;
  static final double P60_HOUSE11_MIN = 294.414167;
  static final double P60_HOUSE12_MAX = 799.170000;
  static final double P60_HOUSE12_MIN = 252.362500;
  static final double P60_HOUSE1_MAX = 1643.109167;
  static final double P60_HOUSE1_MIN = 218.980000;
  static final double P60_HOUSE2_MAX = 799.170000;
  static final double P60_HOUSE2_MIN = 252.362500;
  static final double P60_HOUSE3_MAX = 527.985000;
  static final double P60_HOUSE3_MIN = 294.414167;
  static final double P60_HOUSE4_MAX = 394.215000;
  static final double P60_HOUSE4_MIN = 330.556667;
  static final double P60_HOUSE5_MAX = 527.985000;
  static final double P60_HOUSE5_MIN = 294.414167;
  static final double P60_HOUSE6_MAX = 799.170000;
  static final double P60_HOUSE6_MIN = 252.362500;
  static final double P60_HOUSE7_MAX = 1643.109167;
  static final double P60_HOUSE7_MIN = 218.980000;
  static final double P60_HOUSE8_MAX = 799.170000;
  static final double P60_HOUSE8_MIN = 252.362500;
  static final double P60_HOUSE9_MAX = 527.985000;
  static final double P60_HOUSE9_MIN = 294.414167;
  static final double P60_MC_MAX = 394.215000;
  static final double P60_MC_MIN = 330.556667;
  static final double P60_POLASC_MAX = 1643.108333;
  static final double P60_POLASC_MIN = 218.980000;
  static final double P60_VERTEX_MAX = 527.985000;
  static final double P60_VERTEX_MIN = 303.743333;
  static final double P66_ARMC_MAX = 360.986667;
  static final double P66_ARMC_MIN = 360.984167;
  static final double P66_ASC_MAX = 15382.763492;
  static final double P66_ASC_MIN = 180.714519;
  static final double P66_COASC1_MAX = 27433.717500;
  static final double P66_COASC1_MIN = 176.632500;
  static final double P66_COASC2_MAX = 489.939167;
  static final double P66_COASC2_MIN = 313.358333;
  static final double P66_EQUASC_MAX = 394.215000;
  static final double P66_EQUASC_MIN = 330.556667;
  static final double P66_HOUSE10_MAX = 394.215000;
  static final double P66_HOUSE10_MIN = 330.556667;
  static final double P66_HOUSE11_MAX = 587.104167;
  static final double P66_HOUSE11_MIN = 259.559167;
  static final double P66_HOUSE12_MAX = 1149.612500;
  static final double P66_HOUSE12_MIN = 210.556667;
  static final double P66_HOUSE1_MAX = 27433.547500;
  static final double P66_HOUSE1_MIN = 176.632500;
  static final double P66_HOUSE2_MAX = 1149.612500;
  static final double P66_HOUSE2_MIN = 210.556667;
  static final double P66_HOUSE3_MAX = 587.104167;
  static final double P66_HOUSE3_MIN = 259.559167;
  static final double P66_HOUSE4_MAX = 394.215000;
  static final double P66_HOUSE4_MIN = 330.556667;
  static final double P66_HOUSE5_MAX = 587.104167;
  static final double P66_HOUSE5_MIN = 259.559167;
  static final double P66_HOUSE6_MAX = 1149.612500;
  static final double P66_HOUSE6_MIN = 210.556667;
  static final double P66_HOUSE7_MAX = 27433.547500;
  static final double P66_HOUSE7_MIN = 176.632500;
  static final double P66_HOUSE8_MAX = 1149.612500;
  static final double P66_HOUSE8_MIN = 210.556667;
  static final double P66_HOUSE9_MAX = 587.104167;
  static final double P66_HOUSE9_MIN = 259.559167;
  static final double P66_MC_MAX = 394.215000;
  static final double P66_MC_MIN = 330.556667;
  static final double P66_POLASC_MAX = 27433.717500;
  static final double P66_POLASC_MIN = 176.632500;
  static final double P66_VERTEX_MAX = 489.939167;
  static final double P66_VERTEX_MIN = 313.358333;
  static final double P70_ARMC_MAX = 1./0.;
  static final double P70_ARMC_MIN = 1./0.;
  static final double P70_ASC_MAX = 1./0.;
  static final double P70_ASC_MIN = 1./0.;
  static final double P70_COASC1_MAX = 1./0.;
  static final double P70_COASC1_MIN = 1./0.;
  static final double P70_COASC2_MAX = 1./0.;
  static final double P70_COASC2_MIN = 1./0.;
  static final double P70_EQUASC_MAX = 1./0.;
  static final double P70_EQUASC_MIN = 1./0.;
  static final double P70_HOUSE10_MAX = 1./0.;
  static final double P70_HOUSE10_MIN = 1./0.;
  static final double P70_HOUSE11_MAX = 1./0.;
  static final double P70_HOUSE11_MIN = 1./0.;
  static final double P70_HOUSE12_MAX = 1./0.;
  static final double P70_HOUSE12_MIN = 1./0.;
  static final double P70_HOUSE1_MAX = 1./0.;
  static final double P70_HOUSE1_MIN = 1./0.;
  static final double P70_HOUSE2_MAX = 1./0.;
  static final double P70_HOUSE2_MIN = 1./0.;
  static final double P70_HOUSE3_MAX = 1./0.;
  static final double P70_HOUSE3_MIN = 1./0.;
  static final double P70_HOUSE4_MAX = 1./0.;
  static final double P70_HOUSE4_MIN = 1./0.;
  static final double P70_HOUSE5_MAX = 1./0.;
  static final double P70_HOUSE5_MIN = 1./0.;
  static final double P70_HOUSE6_MAX = 1./0.;
  static final double P70_HOUSE6_MIN = 1./0.;
  static final double P70_HOUSE7_MAX = 1./0.;
  static final double P70_HOUSE7_MIN = 1./0.;
  static final double P70_HOUSE8_MAX = 1./0.;
  static final double P70_HOUSE8_MIN = 1./0.;
  static final double P70_HOUSE9_MAX = 1./0.;
  static final double P70_HOUSE9_MIN = 1./0.;
  static final double P70_MC_MAX = 1./0.;
  static final double P70_MC_MIN = 1./0.;
  static final double P70_POLASC_MAX = 1./0.;
  static final double P70_POLASC_MIN = 1./0.;
  static final double P70_VERTEX_MAX = 1./0.;
  static final double P70_VERTEX_MIN = 1./0.;
  static final double P80_ARMC_MAX = 1./0.;
  static final double P80_ARMC_MIN = 1./0.;
  static final double P80_ASC_MAX = 1./0.;
  static final double P80_ASC_MIN = 1./0.;
  static final double P80_COASC1_MAX = 1./0.;
  static final double P80_COASC1_MIN = 1./0.;
  static final double P80_COASC2_MAX = 1./0.;
  static final double P80_COASC2_MIN = 1./0.;
  static final double P80_EQUASC_MAX = 1./0.;
  static final double P80_EQUASC_MIN = 1./0.;
  static final double P80_HOUSE10_MAX = 1./0.;
  static final double P80_HOUSE10_MIN = 1./0.;
  static final double P80_HOUSE11_MAX = 1./0.;
  static final double P80_HOUSE11_MIN = 1./0.;
  static final double P80_HOUSE12_MAX = 1./0.;
  static final double P80_HOUSE12_MIN = 1./0.;
  static final double P80_HOUSE1_MAX = 1./0.;
  static final double P80_HOUSE1_MIN = 1./0.;
  static final double P80_HOUSE2_MAX = 1./0.;
  static final double P80_HOUSE2_MIN = 1./0.;
  static final double P80_HOUSE3_MAX = 1./0.;
  static final double P80_HOUSE3_MIN = 1./0.;
  static final double P80_HOUSE4_MAX = 1./0.;
  static final double P80_HOUSE4_MIN = 1./0.;
  static final double P80_HOUSE5_MAX = 1./0.;
  static final double P80_HOUSE5_MIN = 1./0.;
  static final double P80_HOUSE6_MAX = 1./0.;
  static final double P80_HOUSE6_MIN = 1./0.;
  static final double P80_HOUSE7_MAX = 1./0.;
  static final double P80_HOUSE7_MIN = 1./0.;
  static final double P80_HOUSE8_MAX = 1./0.;
  static final double P80_HOUSE8_MIN = 1./0.;
  static final double P80_HOUSE9_MAX = 1./0.;
  static final double P80_HOUSE9_MIN = 1./0.;
  static final double P80_MC_MAX = 1./0.;
  static final double P80_MC_MIN = 1./0.;
  static final double P80_POLASC_MAX = 1./0.;
  static final double P80_POLASC_MIN = 1./0.;
  static final double P80_VERTEX_MAX = 1./0.;
  static final double P80_VERTEX_MIN = 1./0.;
  static final double P85_ARMC_MAX = 1./0.;
  static final double P85_ARMC_MIN = 1./0.;
  static final double P85_ASC_MAX = 1./0.;
  static final double P85_ASC_MIN = 1./0.;
  static final double P85_COASC1_MAX = 1./0.;
  static final double P85_COASC1_MIN = 1./0.;
  static final double P85_COASC2_MAX = 1./0.;
  static final double P85_COASC2_MIN = 1./0.;
  static final double P85_EQUASC_MAX = 1./0.;
  static final double P85_EQUASC_MIN = 1./0.;
  static final double P85_HOUSE10_MAX = 1./0.;
  static final double P85_HOUSE10_MIN = 1./0.;
  static final double P85_HOUSE11_MAX = 1./0.;
  static final double P85_HOUSE11_MIN = 1./0.;
  static final double P85_HOUSE12_MAX = 1./0.;
  static final double P85_HOUSE12_MIN = 1./0.;
  static final double P85_HOUSE1_MAX = 1./0.;
  static final double P85_HOUSE1_MIN = 1./0.;
  static final double P85_HOUSE2_MAX = 1./0.;
  static final double P85_HOUSE2_MIN = 1./0.;
  static final double P85_HOUSE3_MAX = 1./0.;
  static final double P85_HOUSE3_MIN = 1./0.;
  static final double P85_HOUSE4_MAX = 1./0.;
  static final double P85_HOUSE4_MIN = 1./0.;
  static final double P85_HOUSE5_MAX = 1./0.;
  static final double P85_HOUSE5_MIN = 1./0.;
  static final double P85_HOUSE6_MAX = 1./0.;
  static final double P85_HOUSE6_MIN = 1./0.;
  static final double P85_HOUSE7_MAX = 1./0.;
  static final double P85_HOUSE7_MIN = 1./0.;
  static final double P85_HOUSE8_MAX = 1./0.;
  static final double P85_HOUSE8_MIN = 1./0.;
  static final double P85_HOUSE9_MAX = 1./0.;
  static final double P85_HOUSE9_MIN = 1./0.;
  static final double P85_MC_MAX = 1./0.;
  static final double P85_MC_MIN = 1./0.;
  static final double P85_POLASC_MAX = 1./0.;
  static final double P85_POLASC_MIN = 1./0.;
  static final double P85_VERTEX_MAX = 1./0.;
  static final double P85_VERTEX_MIN = 1./0.;
  static final double P88_ARMC_MAX = 1./0.;
  static final double P88_ARMC_MIN = 1./0.;
  static final double P88_ASC_MAX = 1./0.;
  static final double P88_ASC_MIN = 1./0.;
  static final double P88_COASC1_MAX = 1./0.;
  static final double P88_COASC1_MIN = 1./0.;
  static final double P88_COASC2_MAX = 1./0.;
  static final double P88_COASC2_MIN = 1./0.;
  static final double P88_EQUASC_MAX = 1./0.;
  static final double P88_EQUASC_MIN = 1./0.;
  static final double P88_HOUSE10_MAX = 1./0.;
  static final double P88_HOUSE10_MIN = 1./0.;
  static final double P88_HOUSE11_MAX = 1./0.;
  static final double P88_HOUSE11_MIN = 1./0.;
  static final double P88_HOUSE12_MAX = 1./0.;
  static final double P88_HOUSE12_MIN = 1./0.;
  static final double P88_HOUSE1_MAX = 1./0.;
  static final double P88_HOUSE1_MIN = 1./0.;
  static final double P88_HOUSE2_MAX = 1./0.;
  static final double P88_HOUSE2_MIN = 1./0.;
  static final double P88_HOUSE3_MAX = 1./0.;
  static final double P88_HOUSE3_MIN = 1./0.;
  static final double P88_HOUSE4_MAX = 1./0.;
  static final double P88_HOUSE4_MIN = 1./0.;
  static final double P88_HOUSE5_MAX = 1./0.;
  static final double P88_HOUSE5_MIN = 1./0.;
  static final double P88_HOUSE6_MAX = 1./0.;
  static final double P88_HOUSE6_MIN = 1./0.;
  static final double P88_HOUSE7_MAX = 1./0.;
  static final double P88_HOUSE7_MIN = 1./0.;
  static final double P88_HOUSE8_MAX = 1./0.;
  static final double P88_HOUSE8_MIN = 1./0.;
  static final double P88_HOUSE9_MAX = 1./0.;
  static final double P88_HOUSE9_MIN = 1./0.;
  static final double P88_MC_MAX = 1./0.;
  static final double P88_MC_MIN = 1./0.;
  static final double P88_POLASC_MAX = 1./0.;
  static final double P88_POLASC_MIN = 1./0.;
  static final double P88_VERTEX_MAX = 1./0.;
  static final double P88_VERTEX_MIN = 1./0.;
  static final double P89x_ARMC_MAX = 1./0.;
  static final double P89x_ARMC_MIN = 1./0.;
  static final double P89x_ASC_MAX = 1./0.;
  static final double P89x_ASC_MIN = 1./0.;
  static final double P89x_COASC1_MAX = 1./0.;
  static final double P89x_COASC1_MIN = 1./0.;
  static final double P89x_COASC2_MAX = 1./0.;
  static final double P89x_COASC2_MIN = 1./0.;
  static final double P89x_EQUASC_MAX = 1./0.;
  static final double P89x_EQUASC_MIN = 1./0.;
  static final double P89x_HOUSE10_MAX = 1./0.;
  static final double P89x_HOUSE10_MIN = 1./0.;
  static final double P89x_HOUSE11_MAX = 1./0.;
  static final double P89x_HOUSE11_MIN = 1./0.;
  static final double P89x_HOUSE12_MAX = 1./0.;
  static final double P89x_HOUSE12_MIN = 1./0.;
  static final double P89x_HOUSE1_MAX = 1./0.;
  static final double P89x_HOUSE1_MIN = 1./0.;
  static final double P89x_HOUSE2_MAX = 1./0.;
  static final double P89x_HOUSE2_MIN = 1./0.;
  static final double P89x_HOUSE3_MAX = 1./0.;
  static final double P89x_HOUSE3_MIN = 1./0.;
  static final double P89x_HOUSE4_MAX = 1./0.;
  static final double P89x_HOUSE4_MIN = 1./0.;
  static final double P89x_HOUSE5_MAX = 1./0.;
  static final double P89x_HOUSE5_MIN = 1./0.;
  static final double P89x_HOUSE6_MAX = 1./0.;
  static final double P89x_HOUSE6_MIN = 1./0.;
  static final double P89x_HOUSE7_MAX = 1./0.;
  static final double P89x_HOUSE7_MIN = 1./0.;
  static final double P89x_HOUSE8_MAX = 1./0.;
  static final double P89x_HOUSE8_MIN = 1./0.;
  static final double P89x_HOUSE9_MAX = 1./0.;
  static final double P89x_HOUSE9_MIN = 1./0.;
  static final double P89x_MC_MAX = 1./0.;
  static final double P89x_MC_MIN = 1./0.;
  static final double P89x_POLASC_MAX = 1./0.;
  static final double P89x_POLASC_MIN = 1./0.;
  static final double P89x_VERTEX_MAX = 1./0.;
  static final double P89x_VERTEX_MIN = 1./0.;
  static final double R0_ARMC_MAX = 360.986667;
  static final double R0_ARMC_MIN = 360.984167;
  static final double R0_ASC_MAX = 393.494420;
  static final double R0_ASC_MIN = 331.162937;
  static final double R0_COASC1_MAX = 394.215000;
  static final double R0_COASC1_MIN = 330.556667;
  static final double R0_COASC2_MAX = 0.000000;
  static final double R0_COASC2_MIN = 0.000000;
  static final double R0_EQUASC_MAX = 394.215000;
  static final double R0_EQUASC_MIN = 330.556667;
  static final double R0_HOUSE10_MAX = 394.215000;
  static final double R0_HOUSE10_MIN = 330.556667;
  static final double R0_HOUSE11_MAX = 394.215000;
  static final double R0_HOUSE11_MIN = 330.556667;
  static final double R0_HOUSE12_MAX = 394.215000;
  static final double R0_HOUSE12_MIN = 330.556667;
  static final double R0_HOUSE1_MAX = 394.215000;
  static final double R0_HOUSE1_MIN = 330.556667;
  static final double R0_HOUSE2_MAX = 394.215000;
  static final double R0_HOUSE2_MIN = 330.556667;
  static final double R0_HOUSE3_MAX = 394.215000;
  static final double R0_HOUSE3_MIN = 330.556667;
  static final double R0_HOUSE4_MAX = 394.215000;
  static final double R0_HOUSE4_MIN = 330.556667;
  static final double R0_HOUSE5_MAX = 394.215000;
  static final double R0_HOUSE5_MIN = 330.556667;
  static final double R0_HOUSE6_MAX = 394.215000;
  static final double R0_HOUSE6_MIN = 330.556667;
  static final double R0_HOUSE7_MAX = 394.215000;
  static final double R0_HOUSE7_MIN = 330.556667;
  static final double R0_HOUSE8_MAX = 394.215000;
  static final double R0_HOUSE8_MIN = 330.556667;
  static final double R0_HOUSE9_MAX = 394.215000;
  static final double R0_HOUSE9_MIN = 330.556667;
  static final double R0_MC_MAX = 394.215000;
  static final double R0_MC_MIN = 330.556667;
  static final double R0_POLASC_MAX = 394.215000;
  static final double R0_POLASC_MIN = 330.556667;
  static final double R0_VERTEX_MAX = 1500000.000000;
  static final double R0_VERTEX_MIN = 0.000000;
  static final double R10_ARMC_MAX = 360.986667;
  static final double R10_ARMC_MIN = 360.984167;
  static final double R10_ASC_MAX = 426.089536;
  static final double R10_ASC_MIN = 328.169552;
  static final double R10_COASC1_MAX = 427.276667;
  static final double R10_COASC1_MIN = 327.558333;
  static final double R10_COASC2_MAX = 2999820.000000;
  static final double R10_COASC2_MIN = -180.000000;
  static final double R10_EQUASC_MAX = 394.215000;
  static final double R10_EQUASC_MIN = 330.556667;
  static final double R10_HOUSE10_MAX = 394.215000;
  static final double R10_HOUSE10_MIN = 330.556667;
  static final double R10_HOUSE11_MAX = 410.080000;
  static final double R10_HOUSE11_MIN = 329.795000;
  static final double R10_HOUSE12_MAX = 422.529167;
  static final double R10_HOUSE12_MIN = 328.295833;
  static final double R10_HOUSE1_MAX = 427.276667;
  static final double R10_HOUSE1_MIN = 327.558333;
  static final double R10_HOUSE2_MAX = 422.529167;
  static final double R10_HOUSE2_MIN = 328.295833;
  static final double R10_HOUSE3_MAX = 410.080000;
  static final double R10_HOUSE3_MIN = 329.795000;
  static final double R10_HOUSE4_MAX = 394.215000;
  static final double R10_HOUSE4_MIN = 330.556667;
  static final double R10_HOUSE5_MAX = 410.080000;
  static final double R10_HOUSE5_MIN = 329.795000;
  static final double R10_HOUSE6_MAX = 422.529167;
  static final double R10_HOUSE6_MIN = 328.295833;
  static final double R10_HOUSE7_MAX = 427.276667;
  static final double R10_HOUSE7_MIN = 327.558333;
  static final double R10_HOUSE8_MAX = 422.529167;
  static final double R10_HOUSE8_MIN = 328.295833;
  static final double R10_HOUSE9_MAX = 410.080000;
  static final double R10_HOUSE9_MIN = 329.795000;
  static final double R10_MC_MAX = 394.215000;
  static final double R10_MC_MIN = 330.556667;
  static final double R10_POLASC_MAX = 427.276667;
  static final double R10_POLASC_MIN = 327.558333;
  static final double R10_VERTEX_MAX = 2999820.000000;
  static final double R10_VERTEX_MIN = -180.000000;
  static final double R20_ARMC_MAX = 360.986667;
  static final double R20_ARMC_MIN = 360.984167;
  static final double R20_ASC_MAX = 467.280896;
  static final double R20_ASC_MIN = 319.225068;
  static final double R20_COASC1_MAX = 469.147500;
  static final double R20_COASC1_MIN = 318.595833;
  static final double R20_COASC2_MAX = 2999819.999167;
  static final double R20_COASC2_MIN = -180.000000;
  static final double R20_EQUASC_MAX = 394.215000;
  static final double R20_EQUASC_MIN = 330.556667;
  static final double R20_HOUSE10_MAX = 394.215000;
  static final double R20_HOUSE10_MIN = 330.556667;
  static final double R20_HOUSE11_MAX = 428.429167;
  static final double R20_HOUSE11_MIN = 327.366667;
  static final double R20_HOUSE12_MAX = 457.496667;
  static final double R20_HOUSE12_MIN = 321.395833;
  static final double R20_HOUSE1_MAX = 469.147500;
  static final double R20_HOUSE1_MIN = 318.595833;
  static final double R20_HOUSE2_MAX = 457.497500;
  static final double R20_HOUSE2_MIN = 321.395833;
  static final double R20_HOUSE3_MAX = 428.429167;
  static final double R20_HOUSE3_MIN = 327.366667;
  static final double R20_HOUSE4_MAX = 394.215000;
  static final double R20_HOUSE4_MIN = 330.556667;
  static final double R20_HOUSE5_MAX = 428.429167;
  static final double R20_HOUSE5_MIN = 327.366667;
  static final double R20_HOUSE6_MAX = 457.496667;
  static final double R20_HOUSE6_MIN = 321.395833;
  static final double R20_HOUSE7_MAX = 469.147500;
  static final double R20_HOUSE7_MIN = 318.595833;
  static final double R20_HOUSE8_MAX = 457.497500;
  static final double R20_HOUSE8_MIN = 321.395833;
  static final double R20_HOUSE9_MAX = 428.429167;
  static final double R20_HOUSE9_MIN = 327.366667;
  static final double R20_MC_MAX = 394.215000;
  static final double R20_MC_MIN = 330.556667;
  static final double R20_POLASC_MAX = 469.147500;
  static final double R20_POLASC_MIN = 318.595833;
  static final double R20_VERTEX_MAX = 2999819.999167;
  static final double R20_VERTEX_MIN = -180.000000;
  static final double R30_ARMC_MAX = 360.986667;
  static final double R30_ARMC_MIN = 360.984167;
  static final double R30_ASC_MAX = 524.994891;
  static final double R30_ASC_MIN = 304.407972;
  static final double R30_COASC1_MAX = 527.985000;
  static final double R30_COASC1_MIN = 303.743333;
  static final double R30_COASC2_MAX = 1643.109167;
  static final double R30_COASC2_MIN = 218.980000;
  static final double R30_EQUASC_MAX = 394.215000;
  static final double R30_EQUASC_MIN = 330.556667;
  static final double R30_HOUSE10_MAX = 394.215000;
  static final double R30_HOUSE10_MIN = 330.556667;
  static final double R30_HOUSE11_MAX = 451.397500;
  static final double R30_HOUSE11_MIN = 322.793333;
  static final double R30_HOUSE12_MAX = 505.025000;
  static final double R30_HOUSE12_MIN = 309.505833;
  static final double R30_HOUSE1_MAX = 527.985000;
  static final double R30_HOUSE1_MIN = 303.743333;
  static final double R30_HOUSE2_MAX = 505.025000;
  static final double R30_HOUSE2_MIN = 309.505833;
  static final double R30_HOUSE3_MAX = 451.397500;
  static final double R30_HOUSE3_MIN = 322.793333;
  static final double R30_HOUSE4_MAX = 394.215000;
  static final double R30_HOUSE4_MIN = 330.556667;
  static final double R30_HOUSE5_MAX = 451.397500;
  static final double R30_HOUSE5_MIN = 322.793333;
  static final double R30_HOUSE6_MAX = 505.025000;
  static final double R30_HOUSE6_MIN = 309.505833;
  static final double R30_HOUSE7_MAX = 527.985000;
  static final double R30_HOUSE7_MIN = 303.743333;
  static final double R30_HOUSE8_MAX = 505.025000;
  static final double R30_HOUSE8_MIN = 309.505833;
  static final double R30_HOUSE9_MAX = 451.397500;
  static final double R30_HOUSE9_MIN = 322.793333;
  static final double R30_MC_MAX = 394.215000;
  static final double R30_MC_MIN = 330.556667;
  static final double R30_POLASC_MAX = 527.985000;
  static final double R30_POLASC_MIN = 303.743333;
  static final double R30_VERTEX_MAX = 1643.108333;
  static final double R30_VERTEX_MIN = 218.980000;
  static final double R40_ARMC_MAX = 360.986667;
  static final double R40_ARMC_MIN = 360.984167;
  static final double R40_ASC_MAX = 618.738596;
  static final double R40_ASC_MIN = 283.720808;
  static final double R40_COASC1_MAX = 623.978333;
  static final double R40_COASC1_MIN = 282.993333;
  static final double R40_COASC2_MAX = 826.410833;
  static final double R40_COASC2_MIN = 255.830833;
  static final double R40_EQUASC_MAX = 394.215000;
  static final double R40_EQUASC_MIN = 330.556667;
  static final double R40_HOUSE10_MAX = 394.215000;
  static final double R40_HOUSE10_MIN = 330.556667;
  static final double R40_HOUSE11_MAX = 483.172500;
  static final double R40_HOUSE11_MIN = 315.081667;
  static final double R40_HOUSE12_MAX = 578.783333;
  static final double R40_HOUSE12_MIN = 292.002500;
  static final double R40_HOUSE1_MAX = 623.978333;
  static final double R40_HOUSE1_MIN = 282.993333;
  static final double R40_HOUSE2_MAX = 578.783333;
  static final double R40_HOUSE2_MIN = 292.002500;
  static final double R40_HOUSE3_MAX = 483.172500;
  static final double R40_HOUSE3_MIN = 315.081667;
  static final double R40_HOUSE4_MAX = 394.215000;
  static final double R40_HOUSE4_MIN = 330.556667;
  static final double R40_HOUSE5_MAX = 483.172500;
  static final double R40_HOUSE5_MIN = 315.081667;
  static final double R40_HOUSE6_MAX = 578.783333;
  static final double R40_HOUSE6_MIN = 292.002500;
  static final double R40_HOUSE7_MAX = 623.978333;
  static final double R40_HOUSE7_MIN = 282.993333;
  static final double R40_HOUSE8_MAX = 578.783333;
  static final double R40_HOUSE8_MIN = 292.002500;
  static final double R40_HOUSE9_MAX = 483.172500;
  static final double R40_HOUSE9_MIN = 315.081667;
  static final double R40_MC_MAX = 394.215000;
  static final double R40_MC_MIN = 330.556667;
  static final double R40_POLASC_MAX = 623.978333;
  static final double R40_POLASC_MIN = 282.993333;
  static final double R40_VERTEX_MAX = 826.410833;
  static final double R40_VERTEX_MIN = 255.830833;
  static final double R50_ARMC_MAX = 360.986667;
  static final double R50_ARMC_MIN = 360.984167;
  static final double R50_ASC_MAX = 814.745889;
  static final double R50_ASC_MIN = 256.684961;
  static final double R50_COASC1_MAX = 826.410833;
  static final double R50_COASC1_MIN = 255.830833;
  static final double R50_COASC2_MAX = 623.978333;
  static final double R50_COASC2_MIN = 282.993333;
  static final double R50_EQUASC_MAX = 394.215000;
  static final double R50_EQUASC_MIN = 330.556667;
  static final double R50_HOUSE10_MAX = 394.215000;
  static final double R50_HOUSE10_MIN = 330.556667;
  static final double R50_HOUSE11_MAX = 533.797500;
  static final double R50_HOUSE11_MIN = 302.320833;
  static final double R50_HOUSE12_MAX = 720.571667;
  static final double R50_HOUSE12_MIN = 267.815833;
  static final double R50_HOUSE1_MAX = 826.410833;
  static final double R50_HOUSE1_MIN = 255.830833;
  static final double R50_HOUSE2_MAX = 720.571667;
  static final double R50_HOUSE2_MIN = 267.815833;
  static final double R50_HOUSE3_MAX = 533.796667;
  static final double R50_HOUSE3_MIN = 302.320833;
  static final double R50_HOUSE4_MAX = 394.215000;
  static final double R50_HOUSE4_MIN = 330.556667;
  static final double R50_HOUSE5_MAX = 533.797500;
  static final double R50_HOUSE5_MIN = 302.320833;
  static final double R50_HOUSE6_MAX = 720.571667;
  static final double R50_HOUSE6_MIN = 267.815833;
  static final double R50_HOUSE7_MAX = 826.410833;
  static final double R50_HOUSE7_MIN = 255.830833;
  static final double R50_HOUSE8_MAX = 720.571667;
  static final double R50_HOUSE8_MIN = 267.815833;
  static final double R50_HOUSE9_MAX = 533.796667;
  static final double R50_HOUSE9_MIN = 302.320833;
  static final double R50_MC_MAX = 394.215000;
  static final double R50_MC_MIN = 330.556667;
  static final double R50_POLASC_MAX = 826.410833;
  static final double R50_POLASC_MIN = 255.830833;
  static final double R50_VERTEX_MAX = 623.978333;
  static final double R50_VERTEX_MIN = 282.993333;
  static final double R60_ARMC_MAX = 360.986667;
  static final double R60_ARMC_MIN = 360.984167;
  static final double R60_ASC_MAX = 1583.084164;
  static final double R60_ASC_MIN = 220.207028;
  static final double R60_COASC1_MAX = 1643.108333;
  static final double R60_COASC1_MIN = 218.980000;
  static final double R60_COASC2_MAX = 527.985000;
  static final double R60_COASC2_MIN = 303.743333;
  static final double R60_EQUASC_MAX = 394.215000;
  static final double R60_EQUASC_MIN = 330.556667;
  static final double R60_HOUSE10_MAX = 394.215000;
  static final double R60_HOUSE10_MIN = 330.556667;
  static final double R60_HOUSE11_MAX = 635.870833;
  static final double R60_HOUSE11_MIN = 280.843333;
  static final double R60_HOUSE12_MAX = 1153.512500;
  static final double R60_HOUSE12_MIN = 234.295000;
  static final double R60_HOUSE1_MAX = 1643.109167;
  static final double R60_HOUSE1_MIN = 218.980000;
  static final double R60_HOUSE2_MAX = 1153.512500;
  static final double R60_HOUSE2_MIN = 234.295000;
  static final double R60_HOUSE3_MAX = 635.870833;
  static final double R60_HOUSE3_MIN = 280.843333;
  static final double R60_HOUSE4_MAX = 394.215000;
  static final double R60_HOUSE4_MIN = 330.556667;
  static final double R60_HOUSE5_MAX = 635.870833;
  static final double R60_HOUSE5_MIN = 280.843333;
  static final double R60_HOUSE6_MAX = 1153.512500;
  static final double R60_HOUSE6_MIN = 234.295000;
  static final double R60_HOUSE7_MAX = 1643.109167;
  static final double R60_HOUSE7_MIN = 218.980000;
  static final double R60_HOUSE8_MAX = 1153.512500;
  static final double R60_HOUSE8_MIN = 234.295000;
  static final double R60_HOUSE9_MAX = 635.870833;
  static final double R60_HOUSE9_MIN = 280.843333;
  static final double R60_MC_MAX = 394.215000;
  static final double R60_MC_MIN = 330.556667;
  static final double R60_POLASC_MAX = 1643.108333;
  static final double R60_POLASC_MIN = 218.980000;
  static final double R60_VERTEX_MAX = 527.985000;
  static final double R60_VERTEX_MIN = 303.743333;
  static final double R66_ARMC_MAX = 360.986667;
  static final double R66_ARMC_MIN = 360.984167;
  static final double R66_ASC_MAX = 15382.763492;
  static final double R66_ASC_MIN = 180.714519;
  static final double R66_COASC1_MAX = 27433.717500;
  static final double R66_COASC1_MIN = 176.632500;
  static final double R66_COASC2_MAX = 489.939167;
  static final double R66_COASC2_MIN = 313.358333;
  static final double R66_EQUASC_MAX = 394.215000;
  static final double R66_EQUASC_MIN = 330.556667;
  static final double R66_HOUSE10_MAX = 394.215000;
  static final double R66_HOUSE10_MIN = 330.556667;
  static final double R66_HOUSE11_MAX = 777.262500;
  static final double R66_HOUSE11_MIN = 260.917500;
  static final double R66_HOUSE12_MAX = 2692.424167;
  static final double R66_HOUSE12_MIN = 204.646667;
  static final double R66_HOUSE1_MAX = 27433.547500;
  static final double R66_HOUSE1_MIN = 176.632500;
  static final double R66_HOUSE2_MAX = 2692.425000;
  static final double R66_HOUSE2_MIN = 204.646667;
  static final double R66_HOUSE3_MAX = 777.262500;
  static final double R66_HOUSE3_MIN = 260.917500;
  static final double R66_HOUSE4_MAX = 394.215000;
  static final double R66_HOUSE4_MIN = 330.556667;
  static final double R66_HOUSE5_MAX = 777.262500;
  static final double R66_HOUSE5_MIN = 260.917500;
  static final double R66_HOUSE6_MAX = 2692.424167;
  static final double R66_HOUSE6_MIN = 204.646667;
  static final double R66_HOUSE7_MAX = 27433.547500;
  static final double R66_HOUSE7_MIN = 176.632500;
  static final double R66_HOUSE8_MAX = 2692.425000;
  static final double R66_HOUSE8_MIN = 204.646667;
  static final double R66_HOUSE9_MAX = 777.262500;
  static final double R66_HOUSE9_MIN = 260.917500;
  static final double R66_MC_MAX = 394.215000;
  static final double R66_MC_MIN = 330.556667;
  static final double R66_POLASC_MAX = 27433.717500;
  static final double R66_POLASC_MIN = 176.632500;
  static final double R66_VERTEX_MAX = 489.939167;
  static final double R66_VERTEX_MIN = 313.358333;
  static final double R70_ARMC_MAX = 360.986667;
  static final double R70_ARMC_MIN = 360.984167;
  static final double R70_ASC_MAX = 1553150.329680;
  static final double R70_ASC_MIN = -777600.393020;
  static final double R70_COASC1_MAX = 2999819.999167;
  static final double R70_COASC1_MIN = -180.000000;
  static final double R70_COASC2_MAX = 469.147500;
  static final double R70_COASC2_MIN = 318.595833;
  static final double R70_EQUASC_MAX = 394.215000;
  static final double R70_EQUASC_MIN = 330.556667;
  static final double R70_HOUSE10_MAX = 1500348.120833;
  static final double R70_HOUSE10_MIN = 330.556667;
  static final double R70_HOUSE11_MAX = 1500569.932500;
  static final double R70_HOUSE11_MIN = 242.886667;
  static final double R70_HOUSE12_MAX = 2999820.000000;
  static final double R70_HOUSE12_MIN = -179.999167;
  static final double R70_HOUSE1_MAX = 2999820.000000;
  static final double R70_HOUSE1_MIN = -179.999167;
  static final double R70_HOUSE2_MAX = 2999819.999167;
  static final double R70_HOUSE2_MIN = -179.996667;
  static final double R70_HOUSE3_MAX = 1500569.929167;
  static final double R70_HOUSE3_MIN = 242.886667;
  static final double R70_HOUSE4_MAX = 1500348.120833;
  static final double R70_HOUSE4_MIN = 330.556667;
  static final double R70_HOUSE5_MAX = 1500569.932500;
  static final double R70_HOUSE5_MIN = 242.886667;
  static final double R70_HOUSE6_MAX = 2999820.000000;
  static final double R70_HOUSE6_MIN = -179.999167;
  static final double R70_HOUSE7_MAX = 2999819.999167;
  static final double R70_HOUSE7_MIN = -180.000000;
  static final double R70_HOUSE8_MAX = 2999819.999167;
  static final double R70_HOUSE8_MIN = -179.996667;
  static final double R70_HOUSE9_MAX = 1500569.929167;
  static final double R70_HOUSE9_MIN = 242.886667;
  static final double R70_MC_MAX = 1500348.120833;
  static final double R70_MC_MIN = 330.556667;
  static final double R70_POLASC_MAX = 2999820.000000;
  static final double R70_POLASC_MIN = -180.000000;
  static final double R70_VERTEX_MAX = 469.147500;
  static final double R70_VERTEX_MIN = 318.595833;
  static final double R80_ARMC_MAX = 360.986667;
  static final double R80_ARMC_MIN = 360.984167;
  static final double R80_ASC_MAX = 1554930.566184;
  static final double R80_ASC_MIN = -777600.124007;
  static final double R80_COASC1_MAX = 2999820.000000;
  static final double R80_COASC1_MIN = -180.000000;
  static final double R80_COASC2_MAX = 427.276667;
  static final double R80_COASC2_MIN = 327.558333;
  static final double R80_EQUASC_MAX = 394.215000;
  static final double R80_EQUASC_MIN = 330.556667;
  static final double R80_HOUSE10_MAX = 1500382.346667;
  static final double R80_HOUSE10_MIN = 330.556667;
  static final double R80_HOUSE11_MAX = 2999819.999167;
  static final double R80_HOUSE11_MIN = -180.000000;
  static final double R80_HOUSE12_MAX = 2999819.999167;
  static final double R80_HOUSE12_MIN = -180.000000;
  static final double R80_HOUSE1_MAX = 2999820.000000;
  static final double R80_HOUSE1_MIN = -180.000000;
  static final double R80_HOUSE2_MAX = 2999820.000000;
  static final double R80_HOUSE2_MIN = -180.000000;
  static final double R80_HOUSE3_MAX = 2999820.000000;
  static final double R80_HOUSE3_MIN = -179.999167;
  static final double R80_HOUSE4_MAX = 1500382.346667;
  static final double R80_HOUSE4_MIN = 330.556667;
  static final double R80_HOUSE5_MAX = 2999820.000000;
  static final double R80_HOUSE5_MIN = -179.999167;
  static final double R80_HOUSE6_MAX = 2999820.000000;
  static final double R80_HOUSE6_MIN = -180.000000;
  static final double R80_HOUSE7_MAX = 2999820.000000;
  static final double R80_HOUSE7_MIN = -180.000000;
  static final double R80_HOUSE8_MAX = 2999820.000000;
  static final double R80_HOUSE8_MIN = -179.999167;
  static final double R80_HOUSE9_MAX = 2999819.999167;
  static final double R80_HOUSE9_MIN = -180.000000;
  static final double R80_MC_MAX = 1500382.346667;
  static final double R80_MC_MIN = 330.556667;
  static final double R80_POLASC_MAX = 2999820.000000;
  static final double R80_POLASC_MIN = -180.000000;
  static final double R80_VERTEX_MAX = 427.276667;
  static final double R80_VERTEX_MIN = 327.558333;
  static final double R85_ARMC_MAX = 360.986667;
  static final double R85_ARMC_MIN = 360.984167;
  static final double R85_ASC_MAX = 1555100.603952;
  static final double R85_ASC_MIN = -777600.058703;
  static final double R85_COASC1_MAX = 2999901.836667;
  static final double R85_COASC1_MIN = -100.323333;
  static final double R85_COASC2_MAX = 409.954167;
  static final double R85_COASC2_MIN = 329.806667;
  static final double R85_EQUASC_MAX = 394.215000;
  static final double R85_EQUASC_MIN = 330.556667;
  static final double R85_HOUSE10_MAX = 1500391.230833;
  static final double R85_HOUSE10_MIN = 330.556667;
  static final double R85_HOUSE11_MAX = 2999820.000000;
  static final double R85_HOUSE11_MIN = -180.000000;
  static final double R85_HOUSE12_MAX = 2999882.109167;
  static final double R85_HOUSE12_MIN = -120.605833;
  static final double R85_HOUSE1_MAX = 2999901.836667;
  static final double R85_HOUSE1_MIN = -100.323333;
  static final double R85_HOUSE2_MAX = 2999882.109167;
  static final double R85_HOUSE2_MIN = -120.605833;
  static final double R85_HOUSE3_MAX = 2999820.000000;
  static final double R85_HOUSE3_MIN = -180.000000;
  static final double R85_HOUSE4_MAX = 1500391.230833;
  static final double R85_HOUSE4_MIN = 330.556667;
  static final double R85_HOUSE5_MAX = 2999820.000000;
  static final double R85_HOUSE5_MIN = -180.000000;
  static final double R85_HOUSE6_MAX = 1500041.780833;
  static final double R85_HOUSE6_MIN = -120.605833;
  static final double R85_HOUSE7_MAX = 1500000.030833;
  static final double R85_HOUSE7_MIN = -100.323333;
  static final double R85_HOUSE8_MAX = 1500041.782500;
  static final double R85_HOUSE8_MIN = -120.605833;
  static final double R85_HOUSE9_MAX = 2999820.000000;
  static final double R85_HOUSE9_MIN = -180.000000;
  static final double R85_MC_MAX = 1500391.230833;
  static final double R85_MC_MIN = 330.556667;
  static final double R85_POLASC_MAX = 66.413333;
  static final double R85_POLASC_MIN = -100.323333;
  static final double R85_VERTEX_MAX = 409.954167;
  static final double R85_VERTEX_MIN = 329.806667;
  static final double R88_ARMC_MAX = 360.985931;
  static final double R88_ARMC_MIN = 360.985828;
  static final double R88_ASC_MAX = 1555165.554408;
  static final double R88_ASC_MIN = -777600.023170;
  static final double R88_COASC1_MAX = 1555165.554409;
  static final double R88_COASC1_MIN = -34.489296;
  static final double R88_COASC2_MAX = 399.547623;
  static final double R88_COASC2_MIN = 331.043079;
  static final double R88_EQUASC_MAX = 393.494420;
  static final double R88_EQUASC_MIN = 331.162937;
  static final double R88_HOUSE10_MAX = 777993.023575;
  static final double R88_HOUSE10_MIN = 331.162936;
  static final double R88_HOUSE11_MAX = 1555199.999999;
  static final double R88_HOUSE11_MIN = 0.000001;
  static final double R88_HOUSE12_MAX = 1555200.000000;
  static final double R88_HOUSE12_MIN = 0.000000;
  static final double R88_HOUSE1_MAX = 1555199.976849;
  static final double R88_HOUSE1_MIN = 0.023142;
  static final double R88_HOUSE2_MAX = 1555200.000000;
  static final double R88_HOUSE2_MIN = 0.000001;
  static final double R88_HOUSE3_MAX = 1555200.000000;
  static final double R88_HOUSE3_MIN = 0.000001;
  static final double R88_HOUSE4_MAX = 777993.023575;
  static final double R88_HOUSE4_MIN = 331.162936;
  static final double R88_HOUSE5_MAX = 1555199.999999;
  static final double R88_HOUSE5_MIN = 0.000001;
  static final double R88_HOUSE6_MAX = 1555200.000000;
  static final double R88_HOUSE6_MIN = 0.000000;
  static final double R88_HOUSE7_MAX = 1555199.976849;
  static final double R88_HOUSE7_MIN = 0.023142;
  static final double R88_HOUSE8_MAX = 1555200.000000;
  static final double R88_HOUSE8_MIN = 0.000001;
  static final double R88_HOUSE9_MAX = 1555200.000000;
  static final double R88_HOUSE9_MIN = 0.000001;
  static final double R88_MC_MAX = 777993.023523;
  static final double R88_MC_MIN = -777207.078222;
  static final double R88_POLASC_MAX = 29.344230;
  static final double R88_POLASC_MIN = -34.489313;
  static final double R88_VERTEX_MAX = 399.547621;
  static final double R88_VERTEX_MIN = 331.043081;
  static final double R89x_ARMC_MAX = 360.986667;
  static final double R89x_ARMC_MIN = 360.984167;
  static final double R89x_ASC_MAX = 1555200.000000;
  static final double R89x_ASC_MIN = -777600.000000;
  static final double R89x_COASC1_MAX = 2999998.426667;
  static final double R89x_COASC1_MIN = -1.600833;
  static final double R89x_COASC2_MAX = 394.516667;
  static final double R89x_COASC2_MIN = 330.556667;
  static final double R89x_EQUASC_MAX = 394.215000;
  static final double R89x_EQUASC_MIN = 330.556667;
  static final double R89x_HOUSE10_MAX = 1500394.213333;
  static final double R89x_HOUSE10_MIN = 330.556667;
  static final double R89x_HOUSE11_MAX = 2999996.839167;
  static final double R89x_HOUSE11_MIN = -3.215000;
  static final double R89x_HOUSE12_MAX = 2999998.181667;
  static final double R89x_HOUSE12_MIN = -1.850000;
  static final double R89x_HOUSE1_MAX = 2999998.426667;
  static final double R89x_HOUSE1_MIN = -1.600833;
  static final double R89x_HOUSE2_MAX = 2999998.181667;
  static final double R89x_HOUSE2_MIN = -1.850000;
  static final double R89x_HOUSE3_MAX = 2999996.839167;
  static final double R89x_HOUSE3_MIN = -3.215000;
  static final double R89x_HOUSE4_MAX = 1500394.213333;
  static final double R89x_HOUSE4_MIN = 330.556667;
  static final double R89x_HOUSE5_MAX = 1500002.743333;
  static final double R89x_HOUSE5_MIN = -3.215000;
  static final double R89x_HOUSE6_MAX = 1500000.919167;
  static final double R89x_HOUSE6_MIN = -1.850000;
  static final double R89x_HOUSE7_MAX = 1500000.000833;
  static final double R89x_HOUSE7_MIN = -1.600833;
  static final double R89x_HOUSE8_MAX = 1500000.919167;
  static final double R89x_HOUSE8_MIN = -1.850000;
  static final double R89x_HOUSE9_MAX = 1500002.743333;
  static final double R89x_HOUSE9_MIN = -3.215000;
  static final double R89x_MC_MAX = 1500394.213333;
  static final double R89x_MC_MIN = 330.556667;
  static final double R89x_POLASC_MAX = 1.588333;
  static final double R89x_POLASC_MIN = -1.600833;
  static final double R89x_VERTEX_MAX = 394.516667;
  static final double R89x_VERTEX_MIN = 330.556667;
  static final double T10_HOUSE3_MAX = 404.651667;
  static final double T10_HOUSE9_MIN = 330.217500;
  static final double T10_COASC2_MAX = 2999820.000000;
  static final double T10_HOUSE6_MIN = 329.208333;
  static final double T10_HOUSE10_MAX = 394.215000;
  static final double T10_VERTEX_MAX = 2999820.000000;
  static final double T10_HOUSE3_MIN = 330.217500;
  static final double T10_ASC_MAX = 426.089536;
  static final double T10_COASC2_MIN = -180.000000;
  static final double T10_HOUSE10_MIN = 330.556667;
  static final double T10_VERTEX_MIN = -180.000000;
  static final double T10_HOUSE7_MAX = 427.276667;
  static final double T10_HOUSE4_MAX = 394.215000;
  static final double T10_ASC_MIN = 328.169552;
  static final double T10_HOUSE1_MAX = 427.276667;
  static final double T10_POLASC_MAX = 427.276667;
  static final double T10_HOUSE7_MIN = 327.558333;
  static final double T10_HOUSE11_MAX = 404.651667;
  static final double T10_HOUSE4_MIN = 330.556667;
  static final double T10_EQUASC_MAX = 394.215000;
  static final double T10_MC_MAX = 394.215000;
  static final double T10_HOUSE1_MIN = 327.558333;
  static final double T10_POLASC_MIN = 327.558333;
  static final double T10_HOUSE11_MIN = 330.217500;
  static final double T10_EQUASC_MIN = 330.556667;
  static final double T10_HOUSE8_MAX = 415.656667;
  static final double T10_MC_MIN = 330.556667;
  static final double T10_HOUSE5_MAX = 404.651667;
  static final double T10_HOUSE2_MAX = 415.656667;
  static final double T10_HOUSE8_MIN = 329.208333;
  static final double T10_HOUSE12_MAX = 415.656667;
  static final double T10_COASC1_MAX = 427.276667;
  static final double T10_HOUSE5_MIN = 330.217500;
  static final double T10_ARMC_MAX = 360.986667;
  static final double T10_HOUSE2_MIN = 329.208333;
  static final double T10_HOUSE12_MIN = 329.208333;
  static final double T10_HOUSE9_MAX = 404.651667;
  static final double T10_COASC1_MIN = 327.558333;
  static final double T10_ARMC_MIN = 360.984167;
  static final double T10_HOUSE6_MAX = 415.656667;
  static final double T20_ARMC_MAX = 360.986667;
  static final double T20_ARMC_MIN = 360.984167;
  static final double T20_ASC_MAX = 467.280896;
  static final double T20_ASC_MIN = 319.225068;
  static final double T20_COASC1_MAX = 469.147500;
  static final double T20_COASC1_MIN = 318.595833;
  static final double T20_COASC2_MAX = 2999819.999167;
  static final double T20_COASC2_MIN = -180.000000;
  static final double T20_EQUASC_MAX = 394.215000;
  static final double T20_EQUASC_MIN = 330.556667;
  static final double T20_HOUSE10_MAX = 394.215000;
  static final double T20_HOUSE10_MIN = 330.556667;
  static final double T20_HOUSE11_MAX = 416.383333;
  static final double T20_HOUSE11_MIN = 329.120833;
  static final double T20_HOUSE12_MAX = 441.193333;
  static final double T20_HOUSE12_MIN = 324.983333;
  static final double T20_HOUSE1_MAX = 469.147500;
  static final double T20_HOUSE1_MIN = 318.595833;
  static final double T20_HOUSE2_MAX = 441.193333;
  static final double T20_HOUSE2_MIN = 324.983333;
  static final double T20_HOUSE3_MAX = 416.383333;
  static final double T20_HOUSE3_MIN = 329.120833;
  static final double T20_HOUSE4_MAX = 394.215000;
  static final double T20_HOUSE4_MIN = 330.556667;
  static final double T20_HOUSE5_MAX = 416.383333;
  static final double T20_HOUSE5_MIN = 329.120833;
  static final double T20_HOUSE6_MAX = 441.193333;
  static final double T20_HOUSE6_MIN = 324.983333;
  static final double T20_HOUSE7_MAX = 469.147500;
  static final double T20_HOUSE7_MIN = 318.595833;
  static final double T20_HOUSE8_MAX = 441.193333;
  static final double T20_HOUSE8_MIN = 324.983333;
  static final double T20_HOUSE9_MAX = 416.383333;
  static final double T20_HOUSE9_MIN = 329.120833;
  static final double T20_MC_MAX = 394.215000;
  static final double T20_MC_MIN = 330.556667;
  static final double T20_POLASC_MAX = 469.147500;
  static final double T20_POLASC_MIN = 318.595833;
  static final double T20_VERTEX_MAX = 2999819.999167;
  static final double T20_VERTEX_MIN = -180.000000;
  static final double T30_ARMC_MAX = 360.986667;
  static final double T30_ARMC_MIN = 360.984167;
  static final double T30_ASC_MAX = 524.994891;
  static final double T30_ASC_MIN = 304.407972;
  static final double T30_COASC1_MAX = 527.985000;
  static final double T30_COASC1_MIN = 303.743333;
  static final double T30_COASC2_MAX = 1643.109167;
  static final double T30_COASC2_MIN = 218.980000;
  static final double T30_EQUASC_MAX = 394.215000;
  static final double T30_EQUASC_MIN = 330.556667;
  static final double T30_HOUSE10_MAX = 394.215000;
  static final double T30_HOUSE10_MIN = 330.556667;
  static final double T30_HOUSE11_MAX = 430.578333;
  static final double T30_HOUSE11_MIN = 326.999167;
  static final double T30_HOUSE12_MAX = 474.332500;
  static final double T30_HOUSE12_MIN = 317.309167;
  static final double T30_HOUSE1_MAX = 527.985000;
  static final double T30_HOUSE1_MIN = 303.743333;
  static final double T30_HOUSE2_MAX = 474.332500;
  static final double T30_HOUSE2_MIN = 317.309167;
  static final double T30_HOUSE3_MAX = 430.578333;
  static final double T30_HOUSE3_MIN = 326.999167;
  static final double T30_HOUSE4_MAX = 394.215000;
  static final double T30_HOUSE4_MIN = 330.556667;
  static final double T30_HOUSE5_MAX = 430.578333;
  static final double T30_HOUSE5_MIN = 326.999167;
  static final double T30_HOUSE6_MAX = 474.332500;
  static final double T30_HOUSE6_MIN = 317.309167;
  static final double T30_HOUSE7_MAX = 527.985000;
  static final double T30_HOUSE7_MIN = 303.743333;
  static final double T30_HOUSE8_MAX = 474.332500;
  static final double T30_HOUSE8_MIN = 317.309167;
  static final double T30_HOUSE9_MAX = 430.578333;
  static final double T30_HOUSE9_MIN = 326.999167;
  static final double T30_MC_MAX = 394.215000;
  static final double T30_MC_MIN = 330.556667;
  static final double T30_POLASC_MAX = 527.985000;
  static final double T30_POLASC_MIN = 303.743333;
  static final double T30_VERTEX_MAX = 1643.108333;
  static final double T30_VERTEX_MIN = 218.980000;
  static final double T40_ARMC_MAX = 360.986667;
  static final double T40_ARMC_MIN = 360.984167;
  static final double T40_ASC_MAX = 618.738596;
  static final double T40_ASC_MIN = 283.720808;
  static final double T40_COASC1_MAX = 623.978333;
  static final double T40_COASC1_MIN = 282.993333;
  static final double T40_COASC2_MAX = 826.410833;
  static final double T40_COASC2_MIN = 255.830833;
  static final double T40_EQUASC_MAX = 394.215000;
  static final double T40_EQUASC_MIN = 330.556667;
  static final double T40_HOUSE10_MAX = 394.215000;
  static final double T40_HOUSE10_MIN = 330.556667;
  static final double T40_HOUSE11_MAX = 449.370833;
  static final double T40_HOUSE11_MIN = 323.244167;
  static final double T40_HOUSE12_MAX = 522.472500;
  static final double T40_HOUSE12_MIN = 305.108333;
  static final double T40_HOUSE1_MAX = 623.978333;
  static final double T40_HOUSE1_MIN = 282.993333;
  static final double T40_HOUSE2_MAX = 522.472500;
  static final double T40_HOUSE2_MIN = 305.108333;
  static final double T40_HOUSE3_MAX = 449.370833;
  static final double T40_HOUSE3_MIN = 323.244167;
  static final double T40_HOUSE4_MAX = 394.215000;
  static final double T40_HOUSE4_MIN = 330.556667;
  static final double T40_HOUSE5_MAX = 449.370833;
  static final double T40_HOUSE5_MIN = 323.244167;
  static final double T40_HOUSE6_MAX = 522.472500;
  static final double T40_HOUSE6_MIN = 305.108333;
  static final double T40_HOUSE7_MAX = 623.978333;
  static final double T40_HOUSE7_MIN = 282.993333;
  static final double T40_HOUSE8_MAX = 522.472500;
  static final double T40_HOUSE8_MIN = 305.108333;
  static final double T40_HOUSE9_MAX = 449.370833;
  static final double T40_HOUSE9_MIN = 323.244167;
  static final double T40_MC_MAX = 394.215000;
  static final double T40_MC_MIN = 330.556667;
  static final double T40_POLASC_MAX = 623.978333;
  static final double T40_POLASC_MIN = 282.993333;
  static final double T40_VERTEX_MAX = 826.410833;
  static final double T40_VERTEX_MIN = 255.830833;
  static final double T50_ARMC_MAX = 360.986667;
  static final double T50_ARMC_MIN = 360.984167;
  static final double T50_ASC_MAX = 814.745889;
  static final double T50_ASC_MIN = 256.684961;
  static final double T50_COASC1_MAX = 826.410833;
  static final double T50_COASC1_MIN = 255.830833;
  static final double T50_COASC2_MAX = 623.978333;
  static final double T50_COASC2_MIN = 282.993333;
  static final double T50_EQUASC_MAX = 394.215000;
  static final double T50_EQUASC_MIN = 330.556667;
  static final double T50_HOUSE10_MAX = 394.215000;
  static final double T50_HOUSE10_MIN = 330.556667;
  static final double T50_HOUSE11_MAX = 477.445833;
  static final double T50_HOUSE11_MIN = 316.529167;
  static final double T50_HOUSE12_MAX = 605.230000;
  static final double T50_HOUSE12_MIN = 286.565833;
  static final double T50_HOUSE1_MAX = 826.410833;
  static final double T50_HOUSE1_MIN = 255.830833;
  static final double T50_HOUSE2_MAX = 605.230000;
  static final double T50_HOUSE2_MIN = 286.565833;
  static final double T50_HOUSE3_MAX = 477.445833;
  static final double T50_HOUSE3_MIN = 316.529167;
  static final double T50_HOUSE4_MAX = 394.215000;
  static final double T50_HOUSE4_MIN = 330.556667;
  static final double T50_HOUSE5_MAX = 477.445833;
  static final double T50_HOUSE5_MIN = 316.529167;
  static final double T50_HOUSE6_MAX = 605.230000;
  static final double T50_HOUSE6_MIN = 286.565833;
  static final double T50_HOUSE7_MAX = 826.410833;
  static final double T50_HOUSE7_MIN = 255.830833;
  static final double T50_HOUSE8_MAX = 605.230000;
  static final double T50_HOUSE8_MIN = 286.565833;
  static final double T50_HOUSE9_MAX = 477.445833;
  static final double T50_HOUSE9_MIN = 316.529167;
  static final double T50_MC_MAX = 394.215000;
  static final double T50_MC_MIN = 330.556667;
  static final double T50_POLASC_MAX = 826.410833;
  static final double T50_POLASC_MIN = 255.830833;
  static final double T50_VERTEX_MAX = 623.978333;
  static final double T50_VERTEX_MIN = 282.993333;
  static final double T60_ARMC_MAX = 360.986667;
  static final double T60_ARMC_MIN = 360.984167;
  static final double T60_ASC_MAX = 1583.084164;
  static final double T60_ASC_MIN = 220.207028;
  static final double T60_COASC1_MAX = 1643.108333;
  static final double T60_COASC1_MIN = 218.980000;
  static final double T60_COASC2_MAX = 527.985000;
  static final double T60_COASC2_MIN = 303.743333;
  static final double T60_EQUASC_MAX = 394.215000;
  static final double T60_EQUASC_MIN = 330.556667;
  static final double T60_HOUSE10_MAX = 394.215000;
  static final double T60_HOUSE10_MIN = 330.556667;
  static final double T60_HOUSE11_MAX = 527.985000;
  static final double T60_HOUSE11_MIN = 303.743333;
  static final double T60_HOUSE12_MAX = 799.170000;
  static final double T60_HOUSE12_MIN = 258.559167;
  static final double T60_HOUSE1_MAX = 1643.109167;
  static final double T60_HOUSE1_MIN = 218.980000;
  static final double T60_HOUSE2_MAX = 799.170000;
  static final double T60_HOUSE2_MIN = 258.559167;
  static final double T60_HOUSE3_MAX = 527.985000;
  static final double T60_HOUSE3_MIN = 303.743333;
  static final double T60_HOUSE4_MAX = 394.215000;
  static final double T60_HOUSE4_MIN = 330.556667;
  static final double T60_HOUSE5_MAX = 527.985000;
  static final double T60_HOUSE5_MIN = 303.743333;
  static final double T60_HOUSE6_MAX = 799.170000;
  static final double T60_HOUSE6_MIN = 258.559167;
  static final double T60_HOUSE7_MAX = 1643.109167;
  static final double T60_HOUSE7_MIN = 218.980000;
  static final double T60_HOUSE8_MAX = 799.170000;
  static final double T60_HOUSE8_MIN = 258.559167;
  static final double T60_HOUSE9_MAX = 527.985000;
  static final double T60_HOUSE9_MIN = 303.743333;
  static final double T60_MC_MAX = 394.215000;
  static final double T60_MC_MIN = 330.556667;
  static final double T60_POLASC_MAX = 1643.108333;
  static final double T60_POLASC_MIN = 218.980000;
  static final double T60_VERTEX_MAX = 527.985000;
  static final double T60_VERTEX_MIN = 303.743333;
  static final double T66_ARMC_MAX = 360.986667;
  static final double T66_ARMC_MIN = 360.984167;
  static final double T66_ASC_MAX = 15382.763492;
  static final double T66_ASC_MIN = 180.714519;
  static final double T66_COASC1_MAX = 27433.717500;
  static final double T66_COASC1_MIN = 176.632500;
  static final double T66_COASC2_MAX = 489.939167;
  static final double T66_COASC2_MIN = 313.358333;
  static final double T66_EQUASC_MAX = 394.215000;
  static final double T66_EQUASC_MIN = 330.556667;
  static final double T66_HOUSE10_MAX = 394.215000;
  static final double T66_HOUSE10_MIN = 330.556667;
  static final double T66_HOUSE11_MAX = 587.104167;
  static final double T66_HOUSE11_MIN = 290.240833;
  static final double T66_HOUSE12_MAX = 1149.612500;
  static final double T66_HOUSE12_MIN = 234.472500;
  static final double T66_HOUSE1_MAX = 27433.547500;
  static final double T66_HOUSE1_MIN = 176.632500;
  static final double T66_HOUSE2_MAX = 1149.611667;
  static final double T66_HOUSE2_MIN = 234.472500;
  static final double T66_HOUSE3_MAX = 587.104167;
  static final double T66_HOUSE3_MIN = 290.240833;
  static final double T66_HOUSE4_MAX = 394.215000;
  static final double T66_HOUSE4_MIN = 330.556667;
  static final double T66_HOUSE5_MAX = 587.104167;
  static final double T66_HOUSE5_MIN = 290.240833;
  static final double T66_HOUSE6_MAX = 1149.612500;
  static final double T66_HOUSE6_MIN = 234.472500;
  static final double T66_HOUSE7_MAX = 27433.547500;
  static final double T66_HOUSE7_MIN = 176.632500;
  static final double T66_HOUSE8_MAX = 1149.611667;
  static final double T66_HOUSE8_MIN = 234.472500;
  static final double T66_HOUSE9_MAX = 587.104167;
  static final double T66_HOUSE9_MIN = 290.240833;
  static final double T66_MC_MAX = 394.215000;
  static final double T66_MC_MIN = 330.556667;
  static final double T66_POLASC_MAX = 27433.717500;
  static final double T66_POLASC_MIN = 176.632500;
  static final double T66_VERTEX_MAX = 489.939167;
  static final double T66_VERTEX_MIN = 313.358333;
  static final double T70_ARMC_MAX = 360.986667;
  static final double T70_ARMC_MIN = 360.984167;
  static final double T70_ASC_MAX = 1553150.329680;
  static final double T70_ASC_MIN = -777600.393020;
  static final double T70_COASC1_MAX = 2999819.999167;
  static final double T70_COASC1_MIN = -180.000000;
  static final double T70_COASC2_MAX = 469.147500;
  static final double T70_COASC2_MIN = 318.595833;
  static final double T70_EQUASC_MAX = 394.215000;
  static final double T70_EQUASC_MIN = 330.556667;
  static final double T70_HOUSE10_MAX = 1500348.120833;
  static final double T70_HOUSE10_MIN = 330.556667;
  static final double T70_HOUSE11_MAX = 1500528.809167;
  static final double T70_HOUSE11_MIN = 276.888333;
  static final double T70_HOUSE12_MAX = 1501813.802500;
  static final double T70_HOUSE12_MIN = 212.395833;
  static final double T70_HOUSE1_MAX = 2999820.000000;
  static final double T70_HOUSE1_MIN = -179.999167;
  static final double T70_HOUSE2_MAX = 1501813.803333;
  static final double T70_HOUSE2_MIN = 212.395833;
  static final double T70_HOUSE3_MAX = 1500528.808333;
  static final double T70_HOUSE3_MIN = 276.888333;
  static final double T70_HOUSE4_MAX = 1500348.120833;
  static final double T70_HOUSE4_MIN = 330.556667;
  static final double T70_HOUSE5_MAX = 1500528.809167;
  static final double T70_HOUSE5_MIN = 276.888333;
  static final double T70_HOUSE6_MAX = 1501813.802500;
  static final double T70_HOUSE6_MIN = 212.395833;
  static final double T70_HOUSE7_MAX = 2999819.999167;
  static final double T70_HOUSE7_MIN = -180.000000;
  static final double T70_HOUSE8_MAX = 1501813.803333;
  static final double T70_HOUSE8_MIN = 212.395833;
  static final double T70_HOUSE9_MAX = 1500528.808333;
  static final double T70_HOUSE9_MIN = 276.888333;
  static final double T70_MC_MAX = 1500348.120833;
  static final double T70_MC_MIN = 330.556667;
  static final double T70_POLASC_MAX = 2999820.000000;
  static final double T70_POLASC_MIN = -180.000000;
  static final double T70_VERTEX_MAX = 469.147500;
  static final double T70_VERTEX_MIN = 318.595833;
  static final double T80_ARMC_MAX = 360.986667;
  static final double T80_ARMC_MIN = 360.984167;
  static final double T80_ASC_MAX = 1554930.566184;
  static final double T80_ASC_MIN = -777600.124007;
  static final double T80_COASC1_MAX = 2999820.000000;
  static final double T80_COASC1_MIN = -180.000000;
  static final double T80_COASC2_MAX = 427.276667;
  static final double T80_COASC2_MIN = 327.558333;
  static final double T80_EQUASC_MAX = 394.215000;
  static final double T80_EQUASC_MIN = 330.556667;
  static final double T80_HOUSE10_MAX = 1500382.346667;
  static final double T80_HOUSE10_MIN = 330.556667;
  static final double T80_HOUSE11_MAX = 1501673.067500;
  static final double T80_HOUSE11_MIN = 208.431667;
  static final double T80_HOUSE12_MAX = 2999819.999167;
  static final double T80_HOUSE12_MIN = -180.000000;
  static final double T80_HOUSE1_MAX = 2999820.000000;
  static final double T80_HOUSE1_MIN = -180.000000;
  static final double T80_HOUSE2_MAX = 2999819.999167;
  static final double T80_HOUSE2_MIN = -180.000000;
  static final double T80_HOUSE3_MAX = 1501673.040833;
  static final double T80_HOUSE3_MIN = 208.431667;
  static final double T80_HOUSE4_MAX = 1500382.346667;
  static final double T80_HOUSE4_MIN = 330.556667;
  static final double T80_HOUSE5_MAX = 1501673.067500;
  static final double T80_HOUSE5_MIN = 208.431667;
  static final double T80_HOUSE6_MAX = 2999820.000000;
  static final double T80_HOUSE6_MIN = -179.999167;
  static final double T80_HOUSE7_MAX = 2999820.000000;
  static final double T80_HOUSE7_MIN = -180.000000;
  static final double T80_HOUSE8_MAX = 2999820.000000;
  static final double T80_HOUSE8_MIN = -180.000000;
  static final double T80_HOUSE9_MAX = 1501673.040833;
  static final double T80_HOUSE9_MIN = 208.431667;
  static final double T80_MC_MAX = 1500382.346667;
  static final double T80_MC_MIN = 330.556667;
  static final double T80_POLASC_MAX = 2999820.000000;
  static final double T80_POLASC_MIN = -180.000000;
  static final double T80_VERTEX_MAX = 427.276667;
  static final double T80_VERTEX_MIN = 327.558333;
  static final double T85_ARMC_MAX = 360.986667;
  static final double T85_ARMC_MIN = 360.984167;
  static final double T85_ASC_MAX = 1555100.603952;
  static final double T85_ASC_MIN = -777600.058703;
  static final double T85_COASC1_MAX = 2999901.836667;
  static final double T85_COASC1_MIN = -100.323333;
  static final double T85_COASC2_MAX = 409.954167;
  static final double T85_COASC2_MIN = 329.806667;
  static final double T85_EQUASC_MAX = 394.215000;
  static final double T85_EQUASC_MIN = 330.556667;
  static final double T85_HOUSE10_MAX = 1500391.230833;
  static final double T85_HOUSE10_MIN = 330.556667;
  static final double T85_HOUSE11_MAX = 2999820.000000;
  static final double T85_HOUSE11_MIN = -180.000000;
  static final double T85_HOUSE12_MAX = 2999831.814167;
  static final double T85_HOUSE12_MIN = -172.503333;
  static final double T85_HOUSE1_MAX = 2999901.836667;
  static final double T85_HOUSE1_MIN = -100.323333;
  static final double T85_HOUSE2_MAX = 2999831.814167;
  static final double T85_HOUSE2_MIN = -172.504167;
  static final double T85_HOUSE3_MAX = 2999820.000000;
  static final double T85_HOUSE3_MIN = -180.000000;
  static final double T85_HOUSE4_MAX = 1500391.230833;
  static final double T85_HOUSE4_MIN = 330.556667;
  static final double T85_HOUSE5_MAX = 2999820.000000;
  static final double T85_HOUSE5_MIN = -180.000000;
  static final double T85_HOUSE6_MAX = 1500057.065000;
  static final double T85_HOUSE6_MIN = -172.504167;
  static final double T85_HOUSE7_MAX = 1500000.030833;
  static final double T85_HOUSE7_MIN = -100.323333;
  static final double T85_HOUSE8_MAX = 1500057.065000;
  static final double T85_HOUSE8_MIN = -172.504167;
  static final double T85_HOUSE9_MAX = 2999820.000000;
  static final double T85_HOUSE9_MIN = -180.000000;
  static final double T85_MC_MAX = 1500391.230833;
  static final double T85_MC_MIN = 330.556667;
  static final double T85_POLASC_MAX = 66.413333;
  static final double T85_POLASC_MIN = -100.323333;
  static final double T85_VERTEX_MAX = 409.954167;
  static final double T85_VERTEX_MIN = 329.806667;
  static final double T88_ARMC_MAX = 360.985931;
  static final double T88_ARMC_MIN = 360.985828;
  static final double T88_ASC_MAX = 1555165.554408;
  static final double T88_ASC_MIN = -777600.023170;
  static final double T88_COASC1_MAX = 1555165.554409;
  static final double T88_COASC1_MIN = -34.489296;
  static final double T88_COASC2_MAX = 399.547623;
  static final double T88_COASC2_MIN = 331.043079;
  static final double T88_EQUASC_MAX = 393.494420;
  static final double T88_EQUASC_MIN = 331.162937;
  static final double T88_HOUSE10_MAX = 777993.023575;
  static final double T88_HOUSE10_MIN = 331.162936;
  static final double T88_HOUSE11_MAX = 1555199.999996;
  static final double T88_HOUSE11_MIN = 0.000001;
  static final double T88_HOUSE12_MAX = 1555200.000000;
  static final double T88_HOUSE12_MIN = 0.000001;
  static final double T88_HOUSE1_MAX = 1555199.976849;
  static final double T88_HOUSE1_MIN = 0.023142;
  static final double T88_HOUSE2_MAX = 1555200.000000;
  static final double T88_HOUSE2_MIN = 0.000000;
  static final double T88_HOUSE3_MAX = 1555200.000000;
  static final double T88_HOUSE3_MIN = 0.000000;
  static final double T88_HOUSE4_MAX = 777993.023575;
  static final double T88_HOUSE4_MIN = 331.162936;
  static final double T88_HOUSE5_MAX = 1555199.999996;
  static final double T88_HOUSE5_MIN = 0.000001;
  static final double T88_HOUSE6_MAX = 1555200.000000;
  static final double T88_HOUSE6_MIN = 0.000001;
  static final double T88_HOUSE7_MAX = 1555199.976849;
  static final double T88_HOUSE7_MIN = 0.023142;
  static final double T88_HOUSE8_MAX = 1555200.000000;
  static final double T88_HOUSE8_MIN = 0.000000;
  static final double T88_HOUSE9_MAX = 1555200.000000;
  static final double T88_HOUSE9_MIN = 0.000000;
  static final double T88_MC_MAX = 777993.023523;
  static final double T88_MC_MIN = -777207.078222;
  static final double T88_POLASC_MAX = 29.344230;
  static final double T88_POLASC_MIN = -34.489313;
  static final double T88_VERTEX_MAX = 399.547621;
  static final double T88_VERTEX_MIN = 331.043081;
  static final double T89x_ARMC_MAX = 360.986667;
  static final double T89x_ARMC_MIN = 360.984167;
  static final double T89x_ASC_MAX = 1555200.000000;
  static final double T89x_ASC_MIN = -777600.000000;
  static final double T89x_COASC1_MAX = 2999998.426667;
  static final double T89x_COASC1_MIN = -1.600833;
  static final double T89x_COASC2_MAX = 394.516667;
  static final double T89x_COASC2_MIN = 330.556667;
  static final double T89x_EQUASC_MAX = 394.215000;
  static final double T89x_EQUASC_MIN = 330.556667;
  static final double T89x_HOUSE10_MAX = 1500394.213333;
  static final double T89x_HOUSE10_MIN = 330.556667;
  static final double T89x_HOUSE11_MAX = 2999995.240000;
  static final double T89x_HOUSE11_MIN = -4.842500;
  static final double T89x_HOUSE12_MAX = 2999997.634167;
  static final double T89x_HOUSE12_MIN = -2.406667;
  static final double T89x_HOUSE1_MAX = 2999998.426667;
  static final double T89x_HOUSE1_MIN = -1.600833;
  static final double T89x_HOUSE2_MAX = 2999997.634167;
  static final double T89x_HOUSE2_MIN = -2.406667;
  static final double T89x_HOUSE3_MAX = 2999995.240000;
  static final double T89x_HOUSE3_MIN = -4.842500;
  static final double T89x_HOUSE4_MAX = 1500394.213333;
  static final double T89x_HOUSE4_MIN = 330.556667;
  static final double T89x_HOUSE5_MAX = 1500004.105000;
  static final double T89x_HOUSE5_MIN = -4.842500;
  static final double T89x_HOUSE6_MAX = 1500001.195833;
  static final double T89x_HOUSE6_MIN = -2.406667;
  static final double T89x_HOUSE7_MAX = 1500000.000833;
  static final double T89x_HOUSE7_MIN = -1.600833;
  static final double T89x_HOUSE8_MAX = 1500001.195833;
  static final double T89x_HOUSE8_MIN = -2.406667;
  static final double T89x_HOUSE9_MAX = 1500004.105000;
  static final double T89x_HOUSE9_MIN = -4.842500;
  static final double T89x_MC_MAX = 1500394.213333;
  static final double T89x_MC_MIN = 330.556667;
  static final double T89x_POLASC_MAX = 1.588333;
  static final double T89x_POLASC_MIN = -1.600833;
  static final double T89x_VERTEX_MAX = 394.516667;
  static final double T89x_VERTEX_MIN = 330.556667;
  static final double U0_ARMC_MAX = 360.986667;
  static final double U0_ARMC_MIN = 360.984167;
  static final double U0_ASC_MAX = 393.494420;
  static final double U0_ASC_MIN = 331.162937;
  static final double U0_COASC1_MAX = 394.215000;
  static final double U0_COASC1_MIN = 330.556667;
  static final double U0_COASC2_MAX = 0.000000;
  static final double U0_COASC2_MIN = 0.000000;
  static final double U0_EQUASC_MAX = 394.215000;
  static final double U0_EQUASC_MIN = 330.556667;
  static final double U0_HOUSE10_MAX = 394.215000;
  static final double U0_HOUSE10_MIN = 330.556667;
  static final double U0_HOUSE11_MAX = 384.100000;
  static final double U0_HOUSE11_MIN = 340.740833;
  static final double U0_HOUSE12_MAX = 381.497500;
  static final double U0_HOUSE12_MIN = 340.706667;
  static final double U0_HOUSE1_MAX = 394.215000;
  static final double U0_HOUSE1_MIN = 330.556667;
  static final double U0_HOUSE2_MAX = 381.497500;
  static final double U0_HOUSE2_MIN = 340.706667;
  static final double U0_HOUSE3_MAX = 384.100000;
  static final double U0_HOUSE3_MIN = 340.740833;
  static final double U0_HOUSE4_MAX = 394.215000;
  static final double U0_HOUSE4_MIN = 330.556667;
  static final double U0_HOUSE5_MAX = 384.100000;
  static final double U0_HOUSE5_MIN = 340.740833;
  static final double U0_HOUSE6_MAX = 381.497500;
  static final double U0_HOUSE6_MIN = 340.706667;
  static final double U0_HOUSE7_MAX = 394.215000;
  static final double U0_HOUSE7_MIN = 330.556667;
  static final double U0_HOUSE8_MAX = 381.497500;
  static final double U0_HOUSE8_MIN = 340.706667;
  static final double U0_HOUSE9_MAX = 384.100000;
  static final double U0_HOUSE9_MIN = 340.740833;
  static final double U0_MC_MAX = 394.215000;
  static final double U0_MC_MIN = 330.556667;
  static final double U0_POLASC_MAX = 394.215000;
  static final double U0_POLASC_MIN = 330.556667;
  static final double U0_VERTEX_MAX = 1500000.000000;
  static final double U0_VERTEX_MIN = 0.000000;
  static final double U10_ARMC_MAX = 360.986667;
  static final double U10_ARMC_MIN = 360.984167;
  static final double U10_ASC_MAX = 426.089536;
  static final double U10_ASC_MIN = 328.169552;
  static final double U10_COASC1_MAX = 427.276667;
  static final double U10_COASC1_MIN = 327.558333;
  static final double U10_COASC2_MAX = 2999820.000000;
  static final double U10_COASC2_MIN = -180.000000;
  static final double U10_EQUASC_MAX = 394.215000;
  static final double U10_EQUASC_MIN = 330.556667;
  static final double U10_HOUSE10_MAX = 394.215000;
  static final double U10_HOUSE10_MIN = 330.556667;
  static final double U10_HOUSE11_MAX = 386.440833;
  static final double U10_HOUSE11_MIN = 334.551667;
  static final double U10_HOUSE12_MAX = 404.214167;
  static final double U10_HOUSE12_MIN = 332.057500;
  static final double U10_HOUSE1_MAX = 427.276667;
  static final double U10_HOUSE1_MIN = 327.558333;
  static final double U10_HOUSE2_MAX = 404.214167;
  static final double U10_HOUSE2_MIN = 332.057500;
  static final double U10_HOUSE3_MAX = 386.440833;
  static final double U10_HOUSE3_MIN = 334.551667;
  static final double U10_HOUSE4_MAX = 394.215000;
  static final double U10_HOUSE4_MIN = 330.556667;
  static final double U10_HOUSE5_MAX = 386.440833;
  static final double U10_HOUSE5_MIN = 334.551667;
  static final double U10_HOUSE6_MAX = 404.214167;
  static final double U10_HOUSE6_MIN = 332.057500;
  static final double U10_HOUSE7_MAX = 427.276667;
  static final double U10_HOUSE7_MIN = 327.558333;
  static final double U10_HOUSE8_MAX = 404.214167;
  static final double U10_HOUSE8_MIN = 332.057500;
  static final double U10_HOUSE9_MAX = 386.440833;
  static final double U10_HOUSE9_MIN = 334.551667;
  static final double U10_MC_MAX = 394.215000;
  static final double U10_MC_MIN = 330.556667;
  static final double U10_POLASC_MAX = 427.276667;
  static final double U10_POLASC_MIN = 327.558333;
  static final double U10_VERTEX_MAX = 2999820.000000;
  static final double U10_VERTEX_MIN = -180.000000;
  static final double U20_ARMC_MAX = 360.986667;
  static final double U20_ARMC_MIN = 360.984167;
  static final double U20_ASC_MAX = 467.280896;
  static final double U20_ASC_MIN = 319.225068;
  static final double U20_COASC1_MAX = 469.147500;
  static final double U20_COASC1_MIN = 318.595833;
  static final double U20_COASC2_MAX = 2999819.999167;
  static final double U20_COASC2_MIN = -180.000000;
  static final double U20_EQUASC_MAX = 394.215000;
  static final double U20_EQUASC_MIN = 330.556667;
  static final double U20_HOUSE10_MAX = 394.215000;
  static final double U20_HOUSE10_MIN = 330.556667;
  static final double U20_HOUSE11_MAX = 388.235000;
  static final double U20_HOUSE11_MIN = 328.590000;
  static final double U20_HOUSE12_MAX = 436.111667;
  static final double U20_HOUSE12_MIN = 319.410833;
  static final double U20_HOUSE1_MAX = 469.147500;
  static final double U20_HOUSE1_MIN = 318.595833;
  static final double U20_HOUSE2_MAX = 436.111667;
  static final double U20_HOUSE2_MIN = 319.410833;
  static final double U20_HOUSE3_MAX = 388.235000;
  static final double U20_HOUSE3_MIN = 328.590000;
  static final double U20_HOUSE4_MAX = 394.215000;
  static final double U20_HOUSE4_MIN = 330.556667;
  static final double U20_HOUSE5_MAX = 388.235000;
  static final double U20_HOUSE5_MIN = 328.590000;
  static final double U20_HOUSE6_MAX = 436.111667;
  static final double U20_HOUSE6_MIN = 319.410833;
  static final double U20_HOUSE7_MAX = 469.147500;
  static final double U20_HOUSE7_MIN = 318.595833;
  static final double U20_HOUSE8_MAX = 436.111667;
  static final double U20_HOUSE8_MIN = 319.410833;
  static final double U20_HOUSE9_MAX = 388.235000;
  static final double U20_HOUSE9_MIN = 328.590000;
  static final double U20_MC_MAX = 394.215000;
  static final double U20_MC_MIN = 330.556667;
  static final double U20_POLASC_MAX = 469.147500;
  static final double U20_POLASC_MIN = 318.595833;
  static final double U20_VERTEX_MAX = 2999819.999167;
  static final double U20_VERTEX_MIN = -180.000000;
  static final double U30_ARMC_MAX = 360.986667;
  static final double U30_ARMC_MIN = 360.984167;
  static final double U30_ASC_MAX = 524.994891;
  static final double U30_ASC_MIN = 304.407972;
  static final double U30_COASC1_MAX = 527.985000;
  static final double U30_COASC1_MIN = 303.743333;
  static final double U30_COASC2_MAX = 1643.109167;
  static final double U30_COASC2_MIN = 218.980000;
  static final double U30_EQUASC_MAX = 394.215000;
  static final double U30_EQUASC_MIN = 330.556667;
  static final double U30_HOUSE10_MAX = 394.215000;
  static final double U30_HOUSE10_MIN = 330.556667;
  static final double U30_HOUSE11_MAX = 389.967500;
  static final double U30_HOUSE11_MIN = 321.562500;
  static final double U30_HOUSE12_MAX = 485.364167;
  static final double U30_HOUSE12_MIN = 302.805833;
  static final double U30_HOUSE1_MAX = 527.985000;
  static final double U30_HOUSE1_MIN = 303.743333;
  static final double U30_HOUSE2_MAX = 485.364167;
  static final double U30_HOUSE2_MIN = 302.805833;
  static final double U30_HOUSE3_MAX = 389.967500;
  static final double U30_HOUSE3_MIN = 321.562500;
  static final double U30_HOUSE4_MAX = 394.215000;
  static final double U30_HOUSE4_MIN = 330.556667;
  static final double U30_HOUSE5_MAX = 389.967500;
  static final double U30_HOUSE5_MIN = 321.562500;
  static final double U30_HOUSE6_MAX = 485.364167;
  static final double U30_HOUSE6_MIN = 302.805833;
  static final double U30_HOUSE7_MAX = 527.985000;
  static final double U30_HOUSE7_MIN = 303.743333;
  static final double U30_HOUSE8_MAX = 485.364167;
  static final double U30_HOUSE8_MIN = 302.805833;
  static final double U30_HOUSE9_MAX = 389.967500;
  static final double U30_HOUSE9_MIN = 321.562500;
  static final double U30_MC_MAX = 394.215000;
  static final double U30_MC_MIN = 330.556667;
  static final double U30_POLASC_MAX = 527.985000;
  static final double U30_POLASC_MIN = 303.743333;
  static final double U30_VERTEX_MAX = 1643.108333;
  static final double U30_VERTEX_MIN = 218.980000;
  static final double U40_ARMC_MAX = 360.986667;
  static final double U40_ARMC_MIN = 360.984167;
  static final double U40_ASC_MAX = 618.738596;
  static final double U40_ASC_MIN = 283.720808;
  static final double U40_COASC1_MAX = 623.978333;
  static final double U40_COASC1_MIN = 282.993333;
  static final double U40_COASC2_MAX = 826.410833;
  static final double U40_COASC2_MIN = 255.830833;
  static final double U40_EQUASC_MAX = 394.215000;
  static final double U40_EQUASC_MIN = 330.556667;
  static final double U40_HOUSE10_MAX = 394.215000;
  static final double U40_HOUSE10_MIN = 330.556667;
  static final double U40_HOUSE11_MAX = 425.424167;
  static final double U40_HOUSE11_MIN = 311.539167;
  static final double U40_HOUSE12_MAX = 571.716667;
  static final double U40_HOUSE12_MIN = 281.007500;
  static final double U40_HOUSE1_MAX = 623.978333;
  static final double U40_HOUSE1_MIN = 282.993333;
  static final double U40_HOUSE2_MAX = 571.716667;
  static final double U40_HOUSE2_MIN = 281.007500;
  static final double U40_HOUSE3_MAX = 425.424167;
  static final double U40_HOUSE3_MIN = 311.539167;
  static final double U40_HOUSE4_MAX = 394.215000;
  static final double U40_HOUSE4_MIN = 330.556667;
  static final double U40_HOUSE5_MAX = 425.424167;
  static final double U40_HOUSE5_MIN = 311.539167;
  static final double U40_HOUSE6_MAX = 571.716667;
  static final double U40_HOUSE6_MIN = 281.007500;
  static final double U40_HOUSE7_MAX = 623.978333;
  static final double U40_HOUSE7_MIN = 282.993333;
  static final double U40_HOUSE8_MAX = 571.716667;
  static final double U40_HOUSE8_MIN = 281.007500;
  static final double U40_HOUSE9_MAX = 425.424167;
  static final double U40_HOUSE9_MIN = 311.539167;
  static final double U40_MC_MAX = 394.215000;
  static final double U40_MC_MIN = 330.556667;
  static final double U40_POLASC_MAX = 623.978333;
  static final double U40_POLASC_MIN = 282.993333;
  static final double U40_VERTEX_MAX = 826.410833;
  static final double U40_VERTEX_MIN = 255.830833;
  static final double U50_ARMC_MAX = 360.986667;
  static final double U50_ARMC_MIN = 360.984167;
  static final double U50_ASC_MAX = 814.745889;
  static final double U50_ASC_MIN = 256.684961;
  static final double U50_COASC1_MAX = 826.410833;
  static final double U50_COASC1_MIN = 255.830833;
  static final double U50_COASC2_MAX = 623.978333;
  static final double U50_COASC2_MIN = 282.993333;
  static final double U50_EQUASC_MAX = 394.215000;
  static final double U50_EQUASC_MIN = 330.556667;
  static final double U50_HOUSE10_MAX = 394.215000;
  static final double U50_HOUSE10_MIN = 330.556667;
  static final double U50_HOUSE11_MAX = 531.011667;
  static final double U50_HOUSE11_MIN = 294.705000;
  static final double U50_HOUSE12_MAX = 761.859167;
  static final double U50_HOUSE12_MIN = 250.861667;
  static final double U50_HOUSE1_MAX = 826.410833;
  static final double U50_HOUSE1_MIN = 255.830833;
  static final double U50_HOUSE2_MAX = 761.859167;
  static final double U50_HOUSE2_MIN = 250.861667;
  static final double U50_HOUSE3_MAX = 531.012500;
  static final double U50_HOUSE3_MIN = 294.705000;
  static final double U50_HOUSE4_MAX = 394.215000;
  static final double U50_HOUSE4_MIN = 330.556667;
  static final double U50_HOUSE5_MAX = 531.011667;
  static final double U50_HOUSE5_MIN = 294.705000;
  static final double U50_HOUSE6_MAX = 761.859167;
  static final double U50_HOUSE6_MIN = 250.861667;
  static final double U50_HOUSE7_MAX = 826.410833;
  static final double U50_HOUSE7_MIN = 255.830833;
  static final double U50_HOUSE8_MAX = 761.859167;
  static final double U50_HOUSE8_MIN = 250.861667;
  static final double U50_HOUSE9_MAX = 531.012500;
  static final double U50_HOUSE9_MIN = 294.705000;
  static final double U50_MC_MAX = 394.215000;
  static final double U50_MC_MIN = 330.556667;
  static final double U50_POLASC_MAX = 826.410833;
  static final double U50_POLASC_MIN = 255.830833;
  static final double U50_VERTEX_MAX = 623.978333;
  static final double U50_VERTEX_MIN = 282.993333;
  static final double U60_ARMC_MAX = 360.986667;
  static final double U60_ARMC_MIN = 360.984167;
  static final double U60_ASC_MAX = 1583.084164;
  static final double U60_ASC_MIN = 220.207028;
  static final double U60_COASC1_MAX = 1643.108333;
  static final double U60_COASC1_MIN = 218.980000;
  static final double U60_COASC2_MAX = 527.985000;
  static final double U60_COASC2_MIN = 303.743333;
  static final double U60_EQUASC_MAX = 394.215000;
  static final double U60_EQUASC_MIN = 330.556667;
  static final double U60_HOUSE10_MAX = 394.215000;
  static final double U60_HOUSE10_MIN = 330.556667;
  static final double U60_HOUSE11_MAX = 1023.936667;
  static final double U60_HOUSE11_MIN = 260.526667;
  static final double U60_HOUSE12_MAX = 1540.283333;
  static final double U60_HOUSE12_MIN = 202.989167;
  static final double U60_HOUSE1_MAX = 1643.109167;
  static final double U60_HOUSE1_MIN = 218.980000;
  static final double U60_HOUSE2_MAX = 1540.284167;
  static final double U60_HOUSE2_MIN = 202.989167;
  static final double U60_HOUSE3_MAX = 1023.936667;
  static final double U60_HOUSE3_MIN = 260.526667;
  static final double U60_HOUSE4_MAX = 394.215000;
  static final double U60_HOUSE4_MIN = 330.556667;
  static final double U60_HOUSE5_MAX = 1023.936667;
  static final double U60_HOUSE5_MIN = 260.526667;
  static final double U60_HOUSE6_MAX = 1540.283333;
  static final double U60_HOUSE6_MIN = 202.989167;
  static final double U60_HOUSE7_MAX = 1643.109167;
  static final double U60_HOUSE7_MIN = 218.980000;
  static final double U60_HOUSE8_MAX = 1540.284167;
  static final double U60_HOUSE8_MIN = 202.989167;
  static final double U60_HOUSE9_MAX = 1023.936667;
  static final double U60_HOUSE9_MIN = 260.526667;
  static final double U60_MC_MAX = 394.215000;
  static final double U60_MC_MIN = 330.556667;
  static final double U60_POLASC_MAX = 1643.108333;
  static final double U60_POLASC_MIN = 218.980000;
  static final double U60_VERTEX_MAX = 527.985000;
  static final double U60_VERTEX_MIN = 303.743333;
  static final double U66_ARMC_MAX = 360.986667;
  static final double U66_ARMC_MIN = 360.984167;
  static final double U66_ASC_MAX = 15382.763492;
  static final double U66_ASC_MIN = 180.714519;
  static final double U66_COASC1_MAX = 27433.717500;
  static final double U66_COASC1_MIN = 176.632500;
  static final double U66_COASC2_MAX = 489.939167;
  static final double U66_COASC2_MIN = 313.358333;
  static final double U66_EQUASC_MAX = 394.215000;
  static final double U66_EQUASC_MIN = 330.556667;
  static final double U66_HOUSE10_MAX = 394.215000;
  static final double U66_HOUSE10_MIN = 330.556667;
  static final double U66_HOUSE11_MAX = 17556.621667;
  static final double U66_HOUSE11_MIN = -16.166667;
  static final double U66_HOUSE12_MAX = 26105.735833;
  static final double U66_HOUSE12_MIN = 132.168333;
  static final double U66_HOUSE1_MAX = 27433.547500;
  static final double U66_HOUSE1_MIN = 176.632500;
  static final double U66_HOUSE2_MAX = 26106.808333;
  static final double U66_HOUSE2_MIN = 132.168333;
  static final double U66_HOUSE3_MAX = 17557.355000;
  static final double U66_HOUSE3_MIN = -16.166667;
  static final double U66_HOUSE4_MAX = 394.215000;
  static final double U66_HOUSE4_MIN = 330.556667;
  static final double U66_HOUSE5_MAX = 17556.621667;
  static final double U66_HOUSE5_MIN = -16.166667;
  static final double U66_HOUSE6_MAX = 26105.735833;
  static final double U66_HOUSE6_MIN = 132.168333;
  static final double U66_HOUSE7_MAX = 27433.547500;
  static final double U66_HOUSE7_MIN = 176.632500;
  static final double U66_HOUSE8_MAX = 26106.808333;
  static final double U66_HOUSE8_MIN = 132.168333;
  static final double U66_HOUSE9_MAX = 17557.355000;
  static final double U66_HOUSE9_MIN = -16.166667;
  static final double U66_MC_MAX = 394.215000;
  static final double U66_MC_MIN = 330.556667;
  static final double U66_POLASC_MAX = 27433.717500;
  static final double U66_POLASC_MIN = 176.632500;
  static final double U66_VERTEX_MAX = 489.939167;
  static final double U66_VERTEX_MIN = 313.358333;
  static final double U70_ARMC_MAX = 360.986667;
  static final double U70_ARMC_MIN = 360.984167;
  static final double U70_ASC_MAX = 1553150.329680;
  static final double U70_ASC_MIN = -777600.393020;
  static final double U70_COASC1_MAX = 2999819.999167;
  static final double U70_COASC1_MIN = -180.000000;
  static final double U70_COASC2_MAX = 469.147500;
  static final double U70_COASC2_MIN = 318.595833;
  static final double U70_EQUASC_MAX = 394.215000;
  static final double U70_EQUASC_MIN = 330.556667;
  static final double U70_HOUSE10_MAX = 394.215000;
  static final double U70_HOUSE10_MIN = 330.556667;
  static final double U70_HOUSE11_MAX = 2999820.000000;
  static final double U70_HOUSE11_MIN = -180.000000;
  static final double U70_HOUSE12_MAX = 2999819.999167;
  static final double U70_HOUSE12_MIN = -179.999167;
  static final double U70_HOUSE1_MAX = 2999820.000000;
  static final double U70_HOUSE1_MIN = -179.999167;
  static final double U70_HOUSE2_MAX = 2999820.000000;
  static final double U70_HOUSE2_MIN = -180.000000;
  static final double U70_HOUSE3_MAX = 2999820.000000;
  static final double U70_HOUSE3_MIN = -179.999167;
  static final double U70_HOUSE4_MAX = 394.215000;
  static final double U70_HOUSE4_MIN = 330.556667;
  static final double U70_HOUSE5_MAX = 2999820.000000;
  static final double U70_HOUSE5_MIN = -180.000000;
  static final double U70_HOUSE6_MAX = 2999819.999167;
  static final double U70_HOUSE6_MIN = -179.999167;
  static final double U70_HOUSE7_MAX = 2999819.999167;
  static final double U70_HOUSE7_MIN = -180.000000;
  static final double U70_HOUSE8_MAX = 2999820.000000;
  static final double U70_HOUSE8_MIN = -180.000000;
  static final double U70_HOUSE9_MAX = 2999820.000000;
  static final double U70_HOUSE9_MIN = -180.000000;
  static final double U70_MC_MAX = 394.215000;
  static final double U70_MC_MIN = 330.556667;
  static final double U70_POLASC_MAX = 2999820.000000;
  static final double U70_POLASC_MIN = -180.000000;
  static final double U70_VERTEX_MAX = 469.147500;
  static final double U70_VERTEX_MIN = 318.595833;
  static final double U80_ARMC_MAX = 360.986667;
  static final double U80_ARMC_MIN = 360.984167;
  static final double U80_ASC_MAX = 1554930.566184;
  static final double U80_ASC_MIN = -777600.124007;
  static final double U80_COASC1_MAX = 2999820.000000;
  static final double U80_COASC1_MIN = -180.000000;
  static final double U80_COASC2_MAX = 427.276667;
  static final double U80_COASC2_MIN = 327.558333;
  static final double U80_EQUASC_MAX = 394.215000;
  static final double U80_EQUASC_MIN = 330.556667;
  static final double U80_HOUSE10_MAX = 394.215000;
  static final double U80_HOUSE10_MIN = 330.556667;
  static final double U80_HOUSE11_MAX = 2999820.000000;
  static final double U80_HOUSE11_MIN = -180.000000;
  static final double U80_HOUSE12_MAX = 2999820.000000;
  static final double U80_HOUSE12_MIN = -180.000000;
  static final double U80_HOUSE1_MAX = 2999820.000000;
  static final double U80_HOUSE1_MIN = -180.000000;
  static final double U80_HOUSE2_MAX = 2999820.000000;
  static final double U80_HOUSE2_MIN = -180.000000;
  static final double U80_HOUSE3_MAX = 2999820.000000;
  static final double U80_HOUSE3_MIN = -180.000000;
  static final double U80_HOUSE4_MAX = 394.215000;
  static final double U80_HOUSE4_MIN = 330.556667;
  static final double U80_HOUSE5_MAX = 2999820.000000;
  static final double U80_HOUSE5_MIN = -180.000000;
  static final double U80_HOUSE6_MAX = 2999820.000000;
  static final double U80_HOUSE6_MIN = -180.000000;
  static final double U80_HOUSE7_MAX = 2999820.000000;
  static final double U80_HOUSE7_MIN = -180.000000;
  static final double U80_HOUSE8_MAX = 2999820.000000;
  static final double U80_HOUSE8_MIN = -180.000000;
  static final double U80_HOUSE9_MAX = 2999820.000000;
  static final double U80_HOUSE9_MIN = -180.000000;
  static final double U80_MC_MAX = 394.215000;
  static final double U80_MC_MIN = 330.556667;
  static final double U80_POLASC_MAX = 2999820.000000;
  static final double U80_POLASC_MIN = -180.000000;
  static final double U80_VERTEX_MAX = 427.276667;
  static final double U80_VERTEX_MIN = 327.558333;
  static final double U85_ARMC_MAX = 360.986667;
  static final double U85_ARMC_MIN = 360.984167;
  static final double U85_ASC_MAX = 1555100.603952;
  static final double U85_ASC_MIN = -777600.058703;
  static final double U85_COASC1_MAX = 2999901.836667;
  static final double U85_COASC1_MIN = -100.323333;
  static final double U85_COASC2_MAX = 409.954167;
  static final double U85_COASC2_MIN = 329.806667;
  static final double U85_EQUASC_MAX = 394.215000;
  static final double U85_EQUASC_MIN = 330.556667;
  static final double U85_HOUSE10_MAX = 394.215000;
  static final double U85_HOUSE10_MIN = 330.556667;
  static final double U85_HOUSE11_MAX = 2999886.690833;
  static final double U85_HOUSE11_MIN = -114.849167;
  static final double U85_HOUSE12_MAX = 2999900.564167;
  static final double U85_HOUSE12_MIN = -101.620833;
  static final double U85_HOUSE1_MAX = 2999901.836667;
  static final double U85_HOUSE1_MIN = -100.323333;
  static final double U85_HOUSE2_MAX = 2999900.563333;
  static final double U85_HOUSE2_MIN = -101.620833;
  static final double U85_HOUSE3_MAX = 2999886.690833;
  static final double U85_HOUSE3_MIN = -114.849167;
  static final double U85_HOUSE4_MAX = 394.215000;
  static final double U85_HOUSE4_MIN = 330.556667;
  static final double U85_HOUSE5_MAX = 1500051.408333;
  static final double U85_HOUSE5_MIN = -114.849167;
  static final double U85_HOUSE6_MAX = 1500018.801667;
  static final double U85_HOUSE6_MIN = -101.620833;
  static final double U85_HOUSE7_MAX = 1500000.030833;
  static final double U85_HOUSE7_MIN = -100.323333;
  static final double U85_HOUSE8_MAX = 1500018.750833;
  static final double U85_HOUSE8_MIN = -101.620833;
  static final double U85_HOUSE9_MAX = 1500051.279167;
  static final double U85_HOUSE9_MIN = -114.849167;
  static final double U85_MC_MAX = 394.215000;
  static final double U85_MC_MIN = 330.556667;
  static final double U85_POLASC_MAX = 66.413333;
  static final double U85_POLASC_MIN = -100.323333;
  static final double U85_VERTEX_MAX = 409.954167;
  static final double U85_VERTEX_MIN = 329.806667;
  static final double U88_ARMC_MAX = 360.985931;
  static final double U88_ARMC_MIN = 360.985828;
  static final double U88_ASC_MAX = 1555165.554408;
  static final double U88_ASC_MIN = -777600.023170;
  static final double U88_COASC1_MAX = 1555165.554409;
  static final double U88_COASC1_MIN = -34.489296;
  static final double U88_COASC2_MAX = 399.547623;
  static final double U88_COASC2_MIN = 331.043079;
  static final double U88_EQUASC_MAX = 393.494420;
  static final double U88_EQUASC_MIN = 331.162937;
  static final double U88_HOUSE10_MAX = 393.494420;
  static final double U88_HOUSE10_MIN = 331.162936;
  static final double U88_HOUSE11_MAX = 1555199.999999;
  static final double U88_HOUSE11_MIN = 0.000001;
  static final double U88_HOUSE12_MAX = 1555200.000000;
  static final double U88_HOUSE12_MIN = 0.000000;
  static final double U88_HOUSE1_MAX = 1555199.976849;
  static final double U88_HOUSE1_MIN = 0.023142;
  static final double U88_HOUSE2_MAX = 1555200.000000;
  static final double U88_HOUSE2_MIN = 0.000000;
  static final double U88_HOUSE3_MAX = 1555199.999999;
  static final double U88_HOUSE3_MIN = 0.000000;
  static final double U88_HOUSE4_MAX = 393.494420;
  static final double U88_HOUSE4_MIN = 331.162936;
  static final double U88_HOUSE5_MAX = 1555199.999999;
  static final double U88_HOUSE5_MIN = 0.000001;
  static final double U88_HOUSE6_MAX = 1555200.000000;
  static final double U88_HOUSE6_MIN = 0.000000;
  static final double U88_HOUSE7_MAX = 1555199.976849;
  static final double U88_HOUSE7_MIN = 0.023142;
  static final double U88_HOUSE8_MAX = 1555200.000000;
  static final double U88_HOUSE8_MIN = 0.000000;
  static final double U88_HOUSE9_MAX = 1555199.999999;
  static final double U88_HOUSE9_MIN = 0.000000;
  static final double U88_MC_MAX = 393.494420;
  static final double U88_MC_MIN = 331.162936;
  static final double U88_POLASC_MAX = 29.344230;
  static final double U88_POLASC_MIN = -34.489313;
  static final double U88_VERTEX_MAX = 399.547621;
  static final double U88_VERTEX_MIN = 331.043081;
  static final double U89x_ARMC_MAX = 360.986667;
  static final double U89x_ARMC_MIN = 360.984167;
  static final double U89x_ASC_MAX = 1555200.000000;
  static final double U89x_ASC_MIN = -777600.000000;
  static final double U89x_COASC1_MAX = 2999998.426667;
  static final double U89x_COASC1_MIN = -1.600833;
  static final double U89x_COASC2_MAX = 394.516667;
  static final double U89x_COASC2_MIN = 330.556667;
  static final double U89x_EQUASC_MAX = 394.215000;
  static final double U89x_EQUASC_MIN = 330.556667;
  static final double U89x_HOUSE10_MAX = 394.215000;
  static final double U89x_HOUSE10_MIN = 330.556667;
  static final double U89x_HOUSE11_MAX = 2999998.025833;
  static final double U89x_HOUSE11_MIN = -1.994167;
  static final double U89x_HOUSE12_MAX = 2999998.377500;
  static final double U89x_HOUSE12_MIN = -1.649167;
  static final double U89x_HOUSE1_MAX = 2999998.426667;
  static final double U89x_HOUSE1_MIN = -1.600833;
  static final double U89x_HOUSE2_MAX = 2999998.377500;
  static final double U89x_HOUSE2_MIN = -1.649167;
  static final double U89x_HOUSE3_MAX = 2999998.025833;
  static final double U89x_HOUSE3_MIN = -1.994167;
  static final double U89x_HOUSE4_MAX = 394.215000;
  static final double U89x_HOUSE4_MIN = 330.556667;
  static final double U89x_HOUSE5_MAX = 1500001.185000;
  static final double U89x_HOUSE5_MIN = -1.994167;
  static final double U89x_HOUSE6_MAX = 1500000.395833;
  static final double U89x_HOUSE6_MIN = -1.649167;
  static final double U89x_HOUSE7_MAX = 1500000.000833;
  static final double U89x_HOUSE7_MIN = -1.600833;
  static final double U89x_HOUSE8_MAX = 1500000.396667;
  static final double U89x_HOUSE8_MIN = -1.649167;
  static final double U89x_HOUSE9_MAX = 1500001.185833;
  static final double U89x_HOUSE9_MIN = -1.994167;
  static final double U89x_MC_MAX = 394.215000;
  static final double U89x_MC_MIN = 330.556667;
  static final double U89x_POLASC_MAX = 1.588333;
  static final double U89x_POLASC_MIN = -1.600833;
  static final double U89x_VERTEX_MAX = 394.516667;
  static final double U89x_VERTEX_MIN = 330.556667;
  static final double V0_ARMC_MAX = 360.986667;
  static final double V0_ARMC_MIN = 360.984167;
  static final double V0_ASC_MAX = 393.494420;
  static final double V0_ASC_MIN = 331.162937;
  static final double V0_COASC1_MAX = 394.215000;
  static final double V0_COASC1_MIN = 330.556667;
  static final double V0_COASC2_MAX = 0.000000;
  static final double V0_COASC2_MIN = 0.000000;
  static final double V0_EQUASC_MAX = 394.215000;
  static final double V0_EQUASC_MIN = 330.556667;
  static final double V0_HOUSE10_MAX = 394.215000;
  static final double V0_HOUSE10_MIN = 330.556667;
  static final double V0_HOUSE11_MAX = 394.215000;
  static final double V0_HOUSE11_MIN = 330.556667;
  static final double V0_HOUSE12_MAX = 394.215000;
  static final double V0_HOUSE12_MIN = 330.556667;
  static final double V0_HOUSE1_MAX = 394.215000;
  static final double V0_HOUSE1_MIN = 330.556667;
  static final double V0_HOUSE2_MAX = 394.215000;
  static final double V0_HOUSE2_MIN = 330.556667;
  static final double V0_HOUSE3_MAX = 394.215000;
  static final double V0_HOUSE3_MIN = 330.556667;
  static final double V0_HOUSE4_MAX = 394.215000;
  static final double V0_HOUSE4_MIN = 330.556667;
  static final double V0_HOUSE5_MAX = 394.215000;
  static final double V0_HOUSE5_MIN = 330.556667;
  static final double V0_HOUSE6_MAX = 394.215000;
  static final double V0_HOUSE6_MIN = 330.556667;
  static final double V0_HOUSE7_MAX = 394.215000;
  static final double V0_HOUSE7_MIN = 330.556667;
  static final double V0_HOUSE8_MAX = 394.215000;
  static final double V0_HOUSE8_MIN = 330.556667;
  static final double V0_HOUSE9_MAX = 394.215000;
  static final double V0_HOUSE9_MIN = 330.556667;
  static final double V0_MC_MAX = 394.215000;
  static final double V0_MC_MIN = 330.556667;
  static final double V0_POLASC_MAX = 394.215000;
  static final double V0_POLASC_MIN = 330.556667;
  static final double V0_VERTEX_MAX = 1500000.000000;
  static final double V0_VERTEX_MIN = 0.000000;
  static final double V10_ARMC_MAX = 360.986667;
  static final double V10_ARMC_MIN = 360.984167;
  static final double V10_ASC_MAX = 426.089536;
  static final double V10_ASC_MIN = 328.169552;
  static final double V10_COASC1_MAX = 427.276667;
  static final double V10_COASC1_MIN = 327.558333;
  static final double V10_COASC2_MAX = 2999820.000000;
  static final double V10_COASC2_MIN = -180.000000;
  static final double V10_EQUASC_MAX = 394.215000;
  static final double V10_EQUASC_MIN = 330.556667;
  static final double V10_HOUSE10_MAX = 427.276667;
  static final double V10_HOUSE10_MIN = 327.558333;
  static final double V10_HOUSE11_MAX = 427.276667;
  static final double V10_HOUSE11_MIN = 327.558333;
  static final double V10_HOUSE12_MAX = 427.276667;
  static final double V10_HOUSE12_MIN = 327.558333;
  static final double V10_HOUSE1_MAX = 427.276667;
  static final double V10_HOUSE1_MIN = 327.558333;
  static final double V10_HOUSE2_MAX = 427.276667;
  static final double V10_HOUSE2_MIN = 327.558333;
  static final double V10_HOUSE3_MAX = 427.276667;
  static final double V10_HOUSE3_MIN = 327.558333;
  static final double V10_HOUSE4_MAX = 427.276667;
  static final double V10_HOUSE4_MIN = 327.558333;
  static final double V10_HOUSE5_MAX = 427.276667;
  static final double V10_HOUSE5_MIN = 327.558333;
  static final double V10_HOUSE6_MAX = 427.276667;
  static final double V10_HOUSE6_MIN = 327.558333;
  static final double V10_HOUSE7_MAX = 427.276667;
  static final double V10_HOUSE7_MIN = 327.558333;
  static final double V10_HOUSE8_MAX = 427.276667;
  static final double V10_HOUSE8_MIN = 327.558333;
  static final double V10_HOUSE9_MAX = 427.276667;
  static final double V10_HOUSE9_MIN = 327.558333;
  static final double V10_MC_MAX = 394.215000;
  static final double V10_MC_MIN = 330.556667;
  static final double V10_POLASC_MAX = 427.276667;
  static final double V10_POLASC_MIN = 327.558333;
  static final double V10_VERTEX_MAX = 2999820.000000;
  static final double V10_VERTEX_MIN = -180.000000;
  static final double V20_ARMC_MAX = 360.986667;
  static final double V20_ARMC_MIN = 360.984167;
  static final double V20_ASC_MAX = 467.280896;
  static final double V20_ASC_MIN = 319.225068;
  static final double V20_COASC1_MAX = 469.147500;
  static final double V20_COASC1_MIN = 318.595833;
  static final double V20_COASC2_MAX = 2999819.999167;
  static final double V20_COASC2_MIN = -180.000000;
  static final double V20_EQUASC_MAX = 394.215000;
  static final double V20_EQUASC_MIN = 330.556667;
  static final double V20_HOUSE10_MAX = 469.147500;
  static final double V20_HOUSE10_MIN = 318.595833;
  static final double V20_HOUSE11_MAX = 469.147500;
  static final double V20_HOUSE11_MIN = 318.595833;
  static final double V20_HOUSE12_MAX = 469.147500;
  static final double V20_HOUSE12_MIN = 318.595833;
  static final double V20_HOUSE1_MAX = 469.147500;
  static final double V20_HOUSE1_MIN = 318.595833;
  static final double V20_HOUSE2_MAX = 469.147500;
  static final double V20_HOUSE2_MIN = 318.595833;
  static final double V20_HOUSE3_MAX = 469.147500;
  static final double V20_HOUSE3_MIN = 318.595833;
  static final double V20_HOUSE4_MAX = 469.147500;
  static final double V20_HOUSE4_MIN = 318.595833;
  static final double V20_HOUSE5_MAX = 469.147500;
  static final double V20_HOUSE5_MIN = 318.595833;
  static final double V20_HOUSE6_MAX = 469.147500;
  static final double V20_HOUSE6_MIN = 318.595833;
  static final double V20_HOUSE7_MAX = 469.147500;
  static final double V20_HOUSE7_MIN = 318.595833;
  static final double V20_HOUSE8_MAX = 469.147500;
  static final double V20_HOUSE8_MIN = 318.595833;
  static final double V20_HOUSE9_MAX = 469.147500;
  static final double V20_HOUSE9_MIN = 318.595833;
  static final double V20_MC_MAX = 394.215000;
  static final double V20_MC_MIN = 330.556667;
  static final double V20_POLASC_MAX = 469.147500;
  static final double V20_POLASC_MIN = 318.595833;
  static final double V20_VERTEX_MAX = 2999819.999167;
  static final double V20_VERTEX_MIN = -180.000000;
  static final double V30_ARMC_MAX = 360.986667;
  static final double V30_ARMC_MIN = 360.984167;
  static final double V30_ASC_MAX = 524.994891;
  static final double V30_ASC_MIN = 304.407972;
  static final double V30_COASC1_MAX = 527.985000;
  static final double V30_COASC1_MIN = 303.743333;
  static final double V30_COASC2_MAX = 1643.109167;
  static final double V30_COASC2_MIN = 218.980000;
  static final double V30_EQUASC_MAX = 394.215000;
  static final double V30_EQUASC_MIN = 330.556667;
  static final double V30_HOUSE10_MAX = 527.985000;
  static final double V30_HOUSE10_MIN = 303.743333;
  static final double V30_HOUSE11_MAX = 527.985000;
  static final double V30_HOUSE11_MIN = 303.743333;
  static final double V30_HOUSE12_MAX = 527.985000;
  static final double V30_HOUSE12_MIN = 303.743333;
  static final double V30_HOUSE1_MAX = 527.985000;
  static final double V30_HOUSE1_MIN = 303.743333;
  static final double V30_HOUSE2_MAX = 527.985000;
  static final double V30_HOUSE2_MIN = 303.743333;
  static final double V30_HOUSE3_MAX = 527.985000;
  static final double V30_HOUSE3_MIN = 303.743333;
  static final double V30_HOUSE4_MAX = 527.985000;
  static final double V30_HOUSE4_MIN = 303.743333;
  static final double V30_HOUSE5_MAX = 527.985000;
  static final double V30_HOUSE5_MIN = 303.743333;
  static final double V30_HOUSE6_MAX = 527.985000;
  static final double V30_HOUSE6_MIN = 303.743333;
  static final double V30_HOUSE7_MAX = 527.985000;
  static final double V30_HOUSE7_MIN = 303.743333;
  static final double V30_HOUSE8_MAX = 527.985000;
  static final double V30_HOUSE8_MIN = 303.743333;
  static final double V30_HOUSE9_MAX = 527.985000;
  static final double V30_HOUSE9_MIN = 303.743333;
  static final double V30_MC_MAX = 394.215000;
  static final double V30_MC_MIN = 330.556667;
  static final double V30_POLASC_MAX = 527.985000;
  static final double V30_POLASC_MIN = 303.743333;
  static final double V30_VERTEX_MAX = 1643.108333;
  static final double V30_VERTEX_MIN = 218.980000;
  static final double V40_ARMC_MAX = 360.986667;
  static final double V40_ARMC_MIN = 360.984167;
  static final double V40_ASC_MAX = 618.738596;
  static final double V40_ASC_MIN = 283.720808;
  static final double V40_COASC1_MAX = 623.978333;
  static final double V40_COASC1_MIN = 282.993333;
  static final double V40_COASC2_MAX = 826.410833;
  static final double V40_COASC2_MIN = 255.830833;
  static final double V40_EQUASC_MAX = 394.215000;
  static final double V40_EQUASC_MIN = 330.556667;
  static final double V40_HOUSE10_MAX = 623.978333;
  static final double V40_HOUSE10_MIN = 282.993333;
  static final double V40_HOUSE11_MAX = 623.978333;
  static final double V40_HOUSE11_MIN = 282.993333;
  static final double V40_HOUSE12_MAX = 623.978333;
  static final double V40_HOUSE12_MIN = 282.993333;
  static final double V40_HOUSE1_MAX = 623.978333;
  static final double V40_HOUSE1_MIN = 282.993333;
  static final double V40_HOUSE2_MAX = 623.978333;
  static final double V40_HOUSE2_MIN = 282.993333;
  static final double V40_HOUSE3_MAX = 623.978333;
  static final double V40_HOUSE3_MIN = 282.993333;
  static final double V40_HOUSE4_MAX = 623.978333;
  static final double V40_HOUSE4_MIN = 282.993333;
  static final double V40_HOUSE5_MAX = 623.978333;
  static final double V40_HOUSE5_MIN = 282.993333;
  static final double V40_HOUSE6_MAX = 623.978333;
  static final double V40_HOUSE6_MIN = 282.993333;
  static final double V40_HOUSE7_MAX = 623.978333;
  static final double V40_HOUSE7_MIN = 282.993333;
  static final double V40_HOUSE8_MAX = 623.978333;
  static final double V40_HOUSE8_MIN = 282.993333;
  static final double V40_HOUSE9_MAX = 623.978333;
  static final double V40_HOUSE9_MIN = 282.993333;
  static final double V40_MC_MAX = 394.215000;
  static final double V40_MC_MIN = 330.556667;
  static final double V40_POLASC_MAX = 623.978333;
  static final double V40_POLASC_MIN = 282.993333;
  static final double V40_VERTEX_MAX = 826.410833;
  static final double V40_VERTEX_MIN = 255.830833;
  static final double V50_ARMC_MAX = 360.986667;
  static final double V50_ARMC_MIN = 360.984167;
  static final double V50_ASC_MAX = 814.745889;
  static final double V50_ASC_MIN = 256.684961;
  static final double V50_COASC1_MAX = 826.410833;
  static final double V50_COASC1_MIN = 255.830833;
  static final double V50_COASC2_MAX = 623.978333;
  static final double V50_COASC2_MIN = 282.993333;
  static final double V50_EQUASC_MAX = 394.215000;
  static final double V50_EQUASC_MIN = 330.556667;
  static final double V50_HOUSE10_MAX = 826.410833;
  static final double V50_HOUSE10_MIN = 255.830833;
  static final double V50_HOUSE11_MAX = 826.410833;
  static final double V50_HOUSE11_MIN = 255.830833;
  static final double V50_HOUSE12_MAX = 826.410833;
  static final double V50_HOUSE12_MIN = 255.830833;
  static final double V50_HOUSE1_MAX = 826.410833;
  static final double V50_HOUSE1_MIN = 255.830833;
  static final double V50_HOUSE2_MAX = 826.410833;
  static final double V50_HOUSE2_MIN = 255.830833;
  static final double V50_HOUSE3_MAX = 826.410833;
  static final double V50_HOUSE3_MIN = 255.830833;
  static final double V50_HOUSE4_MAX = 826.410833;
  static final double V50_HOUSE4_MIN = 255.830833;
  static final double V50_HOUSE5_MAX = 826.410833;
  static final double V50_HOUSE5_MIN = 255.830833;
  static final double V50_HOUSE6_MAX = 826.410833;
  static final double V50_HOUSE6_MIN = 255.830833;
  static final double V50_HOUSE7_MAX = 826.410833;
  static final double V50_HOUSE7_MIN = 255.830833;
  static final double V50_HOUSE8_MAX = 826.410833;
  static final double V50_HOUSE8_MIN = 255.830833;
  static final double V50_HOUSE9_MAX = 826.410833;
  static final double V50_HOUSE9_MIN = 255.830833;
  static final double V50_MC_MAX = 394.215000;
  static final double V50_MC_MIN = 330.556667;
  static final double V50_POLASC_MAX = 826.410833;
  static final double V50_POLASC_MIN = 255.830833;
  static final double V50_VERTEX_MAX = 623.978333;
  static final double V50_VERTEX_MIN = 282.993333;
  static final double V60_ARMC_MAX = 360.986667;
  static final double V60_ARMC_MIN = 360.984167;
  static final double V60_ASC_MAX = 1583.084164;
  static final double V60_ASC_MIN = 220.207028;
  static final double V60_COASC1_MAX = 1643.108333;
  static final double V60_COASC1_MIN = 218.980000;
  static final double V60_COASC2_MAX = 527.985000;
  static final double V60_COASC2_MIN = 303.743333;
  static final double V60_EQUASC_MAX = 394.215000;
  static final double V60_EQUASC_MIN = 330.556667;
  static final double V60_HOUSE10_MAX = 1643.109167;
  static final double V60_HOUSE10_MIN = 218.980000;
  static final double V60_HOUSE11_MAX = 1643.109167;
  static final double V60_HOUSE11_MIN = 218.980000;
  static final double V60_HOUSE12_MAX = 1643.109167;
  static final double V60_HOUSE12_MIN = 218.980000;
  static final double V60_HOUSE1_MAX = 1643.109167;
  static final double V60_HOUSE1_MIN = 218.980000;
  static final double V60_HOUSE2_MAX = 1643.109167;
  static final double V60_HOUSE2_MIN = 218.980000;
  static final double V60_HOUSE3_MAX = 1643.109167;
  static final double V60_HOUSE3_MIN = 218.980000;
  static final double V60_HOUSE4_MAX = 1643.109167;
  static final double V60_HOUSE4_MIN = 218.980000;
  static final double V60_HOUSE5_MAX = 1643.109167;
  static final double V60_HOUSE5_MIN = 218.980000;
  static final double V60_HOUSE6_MAX = 1643.109167;
  static final double V60_HOUSE6_MIN = 218.980000;
  static final double V60_HOUSE7_MAX = 1643.109167;
  static final double V60_HOUSE7_MIN = 218.980000;
  static final double V60_HOUSE8_MAX = 1643.109167;
  static final double V60_HOUSE8_MIN = 218.980000;
  static final double V60_HOUSE9_MAX = 1643.109167;
  static final double V60_HOUSE9_MIN = 218.980000;
  static final double V60_MC_MAX = 394.215000;
  static final double V60_MC_MIN = 330.556667;
  static final double V60_POLASC_MAX = 1643.108333;
  static final double V60_POLASC_MIN = 218.980000;
  static final double V60_VERTEX_MAX = 527.985000;
  static final double V60_VERTEX_MIN = 303.743333;
  static final double V66_ARMC_MAX = 360.986667;
  static final double V66_ARMC_MIN = 360.984167;
  static final double V66_ASC_MAX = 15382.763492;
  static final double V66_ASC_MIN = 180.714519;
  static final double V66_COASC1_MAX = 27433.717500;
  static final double V66_COASC1_MIN = 176.632500;
  static final double V66_COASC2_MAX = 489.939167;
  static final double V66_COASC2_MIN = 313.358333;
  static final double V66_EQUASC_MAX = 394.215000;
  static final double V66_EQUASC_MIN = 330.556667;
  static final double V66_HOUSE10_MAX = 27433.547500;
  static final double V66_HOUSE10_MIN = 176.632500;
  static final double V66_HOUSE11_MAX = 27433.547500;
  static final double V66_HOUSE11_MIN = 176.632500;
  static final double V66_HOUSE12_MAX = 27433.547500;
  static final double V66_HOUSE12_MIN = 176.632500;
  static final double V66_HOUSE1_MAX = 27433.547500;
  static final double V66_HOUSE1_MIN = 176.632500;
  static final double V66_HOUSE2_MAX = 27433.547500;
  static final double V66_HOUSE2_MIN = 176.632500;
  static final double V66_HOUSE3_MAX = 27433.547500;
  static final double V66_HOUSE3_MIN = 176.632500;
  static final double V66_HOUSE4_MAX = 27433.547500;
  static final double V66_HOUSE4_MIN = 176.632500;
  static final double V66_HOUSE5_MAX = 27433.547500;
  static final double V66_HOUSE5_MIN = 176.632500;
  static final double V66_HOUSE6_MAX = 27433.547500;
  static final double V66_HOUSE6_MIN = 176.632500;
  static final double V66_HOUSE7_MAX = 27433.547500;
  static final double V66_HOUSE7_MIN = 176.632500;
  static final double V66_HOUSE8_MAX = 27433.547500;
  static final double V66_HOUSE8_MIN = 176.632500;
  static final double V66_HOUSE9_MAX = 27433.547500;
  static final double V66_HOUSE9_MIN = 176.632500;
  static final double V66_MC_MAX = 394.215000;
  static final double V66_MC_MIN = 330.556667;
  static final double V66_POLASC_MAX = 27433.717500;
  static final double V66_POLASC_MIN = 176.632500;
  static final double V66_VERTEX_MAX = 489.939167;
  static final double V66_VERTEX_MIN = 313.358333;
  static final double V70_ARMC_MAX = 360.986667;
  static final double V70_ARMC_MIN = 360.984167;
  static final double V70_ASC_MAX = 1553150.329680;
  static final double V70_ASC_MIN = -777600.393020;
  static final double V70_COASC1_MAX = 2999819.999167;
  static final double V70_COASC1_MIN = -180.000000;
  static final double V70_COASC2_MAX = 469.147500;
  static final double V70_COASC2_MIN = 318.595833;
  static final double V70_EQUASC_MAX = 394.215000;
  static final double V70_EQUASC_MIN = 330.556667;
  static final double V70_HOUSE10_MAX = 2999820.000000;
  static final double V70_HOUSE10_MIN = -179.999167;
  static final double V70_HOUSE11_MAX = 2999820.000000;
  static final double V70_HOUSE11_MIN = -179.999167;
  static final double V70_HOUSE12_MAX = 2999820.000000;
  static final double V70_HOUSE12_MIN = -179.999167;
  static final double V70_HOUSE1_MAX = 2999820.000000;
  static final double V70_HOUSE1_MIN = -179.999167;
  static final double V70_HOUSE2_MAX = 2999820.000000;
  static final double V70_HOUSE2_MIN = -179.999167;
  static final double V70_HOUSE3_MAX = 2999820.000000;
  static final double V70_HOUSE3_MIN = -179.999167;
  static final double V70_HOUSE4_MAX = 2999820.000000;
  static final double V70_HOUSE4_MIN = -179.999167;
  static final double V70_HOUSE5_MAX = 2999819.999167;
  static final double V70_HOUSE5_MIN = -180.000000;
  static final double V70_HOUSE6_MAX = 2999819.999167;
  static final double V70_HOUSE6_MIN = -180.000000;
  static final double V70_HOUSE7_MAX = 2999819.999167;
  static final double V70_HOUSE7_MIN = -180.000000;
  static final double V70_HOUSE8_MAX = 2999820.000000;
  static final double V70_HOUSE8_MIN = -179.999167;
  static final double V70_HOUSE9_MAX = 2999820.000000;
  static final double V70_HOUSE9_MIN = -179.999167;
  static final double V70_MC_MAX = 394.215000;
  static final double V70_MC_MIN = 330.556667;
  static final double V70_POLASC_MAX = 2999820.000000;
  static final double V70_POLASC_MIN = -180.000000;
  static final double V70_VERTEX_MAX = 469.147500;
  static final double V70_VERTEX_MIN = 318.595833;
  static final double V80_ARMC_MAX = 360.986667;
  static final double V80_ARMC_MIN = 360.984167;
  static final double V80_ASC_MAX = 1554930.566184;
  static final double V80_ASC_MIN = -777600.124007;
  static final double V80_COASC1_MAX = 2999820.000000;
  static final double V80_COASC1_MIN = -180.000000;
  static final double V80_COASC2_MAX = 427.276667;
  static final double V80_COASC2_MIN = 327.558333;
  static final double V80_EQUASC_MAX = 394.215000;
  static final double V80_EQUASC_MIN = 330.556667;
  static final double V80_HOUSE10_MAX = 2999820.000000;
  static final double V80_HOUSE10_MIN = -180.000000;
  static final double V80_HOUSE11_MAX = 2999820.000000;
  static final double V80_HOUSE11_MIN = -180.000000;
  static final double V80_HOUSE12_MAX = 2999820.000000;
  static final double V80_HOUSE12_MIN = -180.000000;
  static final double V80_HOUSE1_MAX = 2999820.000000;
  static final double V80_HOUSE1_MIN = -180.000000;
  static final double V80_HOUSE2_MAX = 2999820.000000;
  static final double V80_HOUSE2_MIN = -180.000000;
  static final double V80_HOUSE3_MAX = 2999820.000000;
  static final double V80_HOUSE3_MIN = -180.000000;
  static final double V80_HOUSE4_MAX = 2999820.000000;
  static final double V80_HOUSE4_MIN = -180.000000;
  static final double V80_HOUSE5_MAX = 2999820.000000;
  static final double V80_HOUSE5_MIN = -180.000000;
  static final double V80_HOUSE6_MAX = 2999820.000000;
  static final double V80_HOUSE6_MIN = -180.000000;
  static final double V80_HOUSE7_MAX = 2999820.000000;
  static final double V80_HOUSE7_MIN = -180.000000;
  static final double V80_HOUSE8_MAX = 2999820.000000;
  static final double V80_HOUSE8_MIN = -180.000000;
  static final double V80_HOUSE9_MAX = 2999820.000000;
  static final double V80_HOUSE9_MIN = -180.000000;
  static final double V80_MC_MAX = 394.215000;
  static final double V80_MC_MIN = 330.556667;
  static final double V80_POLASC_MAX = 2999820.000000;
  static final double V80_POLASC_MIN = -180.000000;
  static final double V80_VERTEX_MAX = 427.276667;
  static final double V80_VERTEX_MIN = 327.558333;
  static final double V85_ARMC_MAX = 360.986667;
  static final double V85_ARMC_MIN = 360.984167;
  static final double V85_ASC_MAX = 1555100.603952;
  static final double V85_ASC_MIN = -777600.058703;
  static final double V85_COASC1_MAX = 2999901.836667;
  static final double V85_COASC1_MIN = -100.323333;
  static final double V85_COASC2_MAX = 409.954167;
  static final double V85_COASC2_MIN = 329.806667;
  static final double V85_EQUASC_MAX = 394.215000;
  static final double V85_EQUASC_MIN = 330.556667;
  static final double V85_HOUSE10_MAX = 1500000.030833;
  static final double V85_HOUSE10_MIN = -100.323333;
  static final double V85_HOUSE11_MAX = 1500000.030833;
  static final double V85_HOUSE11_MIN = -100.323333;
  static final double V85_HOUSE12_MAX = 1500000.030833;
  static final double V85_HOUSE12_MIN = -100.323333;
  static final double V85_HOUSE1_MAX = 1500000.030833;
  static final double V85_HOUSE1_MIN = -100.323333;
  static final double V85_HOUSE2_MAX = 1500000.030833;
  static final double V85_HOUSE2_MIN = -100.323333;
  static final double V85_HOUSE3_MAX = 1500000.030833;
  static final double V85_HOUSE3_MIN = -100.323333;
  static final double V85_HOUSE4_MAX = 1500000.030833;
  static final double V85_HOUSE4_MIN = -100.323333;
  static final double V85_HOUSE5_MAX = 1500000.030833;
  static final double V85_HOUSE5_MIN = -100.323333;
  static final double V85_HOUSE6_MAX = 1500000.030833;
  static final double V85_HOUSE6_MIN = -100.323333;
  static final double V85_HOUSE7_MAX = 1500000.030833;
  static final double V85_HOUSE7_MIN = -100.323333;
  static final double V85_HOUSE8_MAX = 1500000.030833;
  static final double V85_HOUSE8_MIN = -100.323333;
  static final double V85_HOUSE9_MAX = 1500000.030833;
  static final double V85_HOUSE9_MIN = -100.323333;
  static final double V85_MC_MAX = 394.215000;
  static final double V85_MC_MIN = 330.556667;
  static final double V85_POLASC_MAX = 66.413333;
  static final double V85_POLASC_MIN = -100.323333;
  static final double V85_VERTEX_MAX = 409.954167;
  static final double V85_VERTEX_MIN = 329.806667;
  static final double V88_ARMC_MAX = 360.985931;
  static final double V88_ARMC_MIN = 360.985828;
  static final double V88_ASC_MAX = 1555165.554408;
  static final double V88_ASC_MIN = -777600.023170;
  static final double V88_COASC1_MAX = 1555165.554409;
  static final double V88_COASC1_MIN = -34.489296;
  static final double V88_COASC2_MAX = 399.547623;
  static final double V88_COASC2_MIN = 331.043079;
  static final double V88_EQUASC_MAX = 393.494420;
  static final double V88_EQUASC_MIN = 331.162937;
  static final double V88_HOUSE10_MAX = 1555199.976849;
  static final double V88_HOUSE10_MIN = 0.023142;
  static final double V88_HOUSE11_MAX = 1555199.976849;
  static final double V88_HOUSE11_MIN = 0.023142;
  static final double V88_HOUSE12_MAX = 1555199.976849;
  static final double V88_HOUSE12_MIN = 0.023142;
  static final double V88_HOUSE1_MAX = 1555199.976849;
  static final double V88_HOUSE1_MIN = 0.023142;
  static final double V88_HOUSE2_MAX = 1555199.976849;
  static final double V88_HOUSE2_MIN = 0.023142;
  static final double V88_HOUSE3_MAX = 1555199.976849;
  static final double V88_HOUSE3_MIN = 0.023142;
  static final double V88_HOUSE4_MAX = 1555199.976849;
  static final double V88_HOUSE4_MIN = 0.023142;
  static final double V88_HOUSE5_MAX = 1555199.976849;
  static final double V88_HOUSE5_MIN = 0.023142;
  static final double V88_HOUSE6_MAX = 1555199.976849;
  static final double V88_HOUSE6_MIN = 0.023142;
  static final double V88_HOUSE7_MAX = 1555199.976849;
  static final double V88_HOUSE7_MIN = 0.023142;
  static final double V88_HOUSE8_MAX = 1555199.976849;
  static final double V88_HOUSE8_MIN = 0.023142;
  static final double V88_HOUSE9_MAX = 1555199.976849;
  static final double V88_HOUSE9_MIN = 0.023142;
  static final double V88_MC_MAX = 393.494420;
  static final double V88_MC_MIN = 331.162936;
  static final double V88_POLASC_MAX = 29.344230;
  static final double V88_POLASC_MIN = -34.489313;
  static final double V88_VERTEX_MAX = 399.547621;
  static final double V88_VERTEX_MIN = 331.043081;
  static final double V89x_ARMC_MAX = 360.986667;
  static final double V89x_ARMC_MIN = 360.984167;
  static final double V89x_ASC_MAX = 1555200.000000;
  static final double V89x_ASC_MIN = -777600.000000;
  static final double V89x_COASC1_MAX = 2999998.426667;
  static final double V89x_COASC1_MIN = -1.600833;
  static final double V89x_COASC2_MAX = 394.516667;
  static final double V89x_COASC2_MIN = 330.556667;
  static final double V89x_EQUASC_MAX = 394.215000;
  static final double V89x_EQUASC_MIN = 330.556667;
  static final double V89x_HOUSE10_MAX = 1500000.000833;
  static final double V89x_HOUSE10_MIN = -1.600833;
  static final double V89x_HOUSE11_MAX = 1500000.000833;
  static final double V89x_HOUSE11_MIN = -1.600833;
  static final double V89x_HOUSE12_MAX = 1500000.000833;
  static final double V89x_HOUSE12_MIN = -1.600833;
  static final double V89x_HOUSE1_MAX = 1500000.000833;
  static final double V89x_HOUSE1_MIN = -1.600833;
  static final double V89x_HOUSE2_MAX = 1500000.000833;
  static final double V89x_HOUSE2_MIN = -1.600833;
  static final double V89x_HOUSE3_MAX = 1500000.000833;
  static final double V89x_HOUSE3_MIN = -1.600833;
  static final double V89x_HOUSE4_MAX = 1500000.000833;
  static final double V89x_HOUSE4_MIN = -1.600833;
  static final double V89x_HOUSE5_MAX = 1500000.000833;
  static final double V89x_HOUSE5_MIN = -1.600833;
  static final double V89x_HOUSE6_MAX = 1500000.000833;
  static final double V89x_HOUSE6_MIN = -1.600833;
  static final double V89x_HOUSE7_MAX = 1500000.000833;
  static final double V89x_HOUSE7_MIN = -1.600833;
  static final double V89x_HOUSE8_MAX = 1500000.000833;
  static final double V89x_HOUSE8_MIN = -1.600833;
  static final double V89x_HOUSE9_MAX = 1500000.000833;
  static final double V89x_HOUSE9_MIN = -1.600833;
  static final double V89x_MC_MAX = 394.215000;
  static final double V89x_MC_MIN = 330.556667;
  static final double V89x_POLASC_MAX = 1.588333;
  static final double V89x_POLASC_MIN = -1.600833;
  static final double V89x_VERTEX_MAX = 394.516667;
  static final double V89x_VERTEX_MIN = 330.556667;
  static final double W0_ARMC_MAX = 360.986667;
  static final double W0_ARMC_MIN = 360.984167;
  static final double W0_ASC_MAX = 393.494420;
  static final double W0_ASC_MIN = 331.162937;
  static final double W0_COASC1_MAX = 394.215000;
  static final double W0_COASC1_MIN = 330.556667;
  static final double W0_COASC2_MAX = 0.000000;
  static final double W0_COASC2_MIN = 0.000000;
  static final double W0_EQUASC_MAX = 394.215000;
  static final double W0_EQUASC_MIN = 330.556667;
  static final double W0_HOUSE10_MAX = 250000.000000;
  static final double W0_HOUSE10_MIN = 0.000000;
  static final double W0_HOUSE11_MAX = 250000.000000;
  static final double W0_HOUSE11_MIN = 0.000000;
  static final double W0_HOUSE12_MAX = 250000.000000;
  static final double W0_HOUSE12_MIN = 0.000000;
  static final double W0_HOUSE1_MAX = 250000.000000;
  static final double W0_HOUSE1_MIN = 0.000000;
  static final double W0_HOUSE2_MAX = 250000.000000;
  static final double W0_HOUSE2_MIN = 0.000000;
  static final double W0_HOUSE3_MAX = 250000.000000;
  static final double W0_HOUSE3_MIN = 0.000000;
  static final double W0_HOUSE4_MAX = 250000.000000;
  static final double W0_HOUSE4_MIN = 0.000000;
  static final double W0_HOUSE5_MAX = 250000.000000;
  static final double W0_HOUSE5_MIN = 0.000000;
  static final double W0_HOUSE6_MAX = 250000.000000;
  static final double W0_HOUSE6_MIN = 0.000000;
  static final double W0_HOUSE7_MAX = 250000.000000;
  static final double W0_HOUSE7_MIN = 0.000000;
  static final double W0_HOUSE8_MAX = 250000.000000;
  static final double W0_HOUSE8_MIN = 0.000000;
  static final double W0_HOUSE9_MAX = 250000.000000;
  static final double W0_HOUSE9_MIN = 0.000000;
  static final double W0_MC_MAX = 394.215000;
  static final double W0_MC_MIN = 330.556667;
  static final double W0_POLASC_MAX = 394.215000;
  static final double W0_POLASC_MIN = 330.556667;
  static final double W0_VERTEX_MAX = 1500000.000000;
  static final double W0_VERTEX_MIN = 0.000000;
  static final double W10_ARMC_MAX = 360.986667;
  static final double W10_ARMC_MIN = 360.984167;
  static final double W10_ASC_MAX = 426.089536;
  static final double W10_ASC_MIN = 328.169552;
  static final double W10_COASC1_MAX = 427.276667;
  static final double W10_COASC1_MIN = 327.558333;
  static final double W10_COASC2_MAX = 2999820.000000;
  static final double W10_COASC2_MIN = -180.000000;
  static final double W10_EQUASC_MAX = 394.215000;
  static final double W10_EQUASC_MIN = 330.556667;
  static final double W10_HOUSE10_MAX = 250000.000000;
  static final double W10_HOUSE10_MIN = 0.000000;
  static final double W10_HOUSE11_MAX = 250000.000000;
  static final double W10_HOUSE11_MIN = 0.000000;
  static final double W10_HOUSE12_MAX = 250000.000000;
  static final double W10_HOUSE12_MIN = 0.000000;
  static final double W10_HOUSE1_MAX = 250000.000000;
  static final double W10_HOUSE1_MIN = 0.000000;
  static final double W10_HOUSE2_MAX = 250000.000000;
  static final double W10_HOUSE2_MIN = 0.000000;
  static final double W10_HOUSE3_MAX = 250000.000000;
  static final double W10_HOUSE3_MIN = 0.000000;
  static final double W10_HOUSE4_MAX = 250000.000000;
  static final double W10_HOUSE4_MIN = 0.000000;
  static final double W10_HOUSE5_MAX = 250000.000000;
  static final double W10_HOUSE5_MIN = 0.000000;
  static final double W10_HOUSE6_MAX = 250000.000000;
  static final double W10_HOUSE6_MIN = 0.000000;
  static final double W10_HOUSE7_MAX = 250000.000000;
  static final double W10_HOUSE7_MIN = 0.000000;
  static final double W10_HOUSE8_MAX = 250000.000000;
  static final double W10_HOUSE8_MIN = 0.000000;
  static final double W10_HOUSE9_MAX = 250000.000000;
  static final double W10_HOUSE9_MIN = 0.000000;
  static final double W10_MC_MAX = 394.215000;
  static final double W10_MC_MIN = 330.556667;
  static final double W10_POLASC_MAX = 427.276667;
  static final double W10_POLASC_MIN = 327.558333;
  static final double W10_VERTEX_MAX = 2999820.000000;
  static final double W10_VERTEX_MIN = -180.000000;
  static final double W20_ARMC_MAX = 360.986667;
  static final double W20_ARMC_MIN = 360.984167;
  static final double W20_ASC_MAX = 467.280896;
  static final double W20_ASC_MIN = 319.225068;
  static final double W20_COASC1_MAX = 469.147500;
  static final double W20_COASC1_MIN = 318.595833;
  static final double W20_COASC2_MAX = 2999819.999167;
  static final double W20_COASC2_MIN = -180.000000;
  static final double W20_EQUASC_MAX = 394.215000;
  static final double W20_EQUASC_MIN = 330.556667;
  static final double W20_HOUSE10_MAX = 250000.000000;
  static final double W20_HOUSE10_MIN = 0.000000;
  static final double W20_HOUSE11_MAX = 250000.000000;
  static final double W20_HOUSE11_MIN = 0.000000;
  static final double W20_HOUSE12_MAX = 250000.000000;
  static final double W20_HOUSE12_MIN = 0.000000;
  static final double W20_HOUSE1_MAX = 250000.000000;
  static final double W20_HOUSE1_MIN = 0.000000;
  static final double W20_HOUSE2_MAX = 250000.000000;
  static final double W20_HOUSE2_MIN = 0.000000;
  static final double W20_HOUSE3_MAX = 250000.000000;
  static final double W20_HOUSE3_MIN = 0.000000;
  static final double W20_HOUSE4_MAX = 250000.000000;
  static final double W20_HOUSE4_MIN = 0.000000;
  static final double W20_HOUSE5_MAX = 250000.000000;
  static final double W20_HOUSE5_MIN = 0.000000;
  static final double W20_HOUSE6_MAX = 250000.000000;
  static final double W20_HOUSE6_MIN = 0.000000;
  static final double W20_HOUSE7_MAX = 250000.000000;
  static final double W20_HOUSE7_MIN = 0.000000;
  static final double W20_HOUSE8_MAX = 250000.000000;
  static final double W20_HOUSE8_MIN = 0.000000;
  static final double W20_HOUSE9_MAX = 250000.000000;
  static final double W20_HOUSE9_MIN = 0.000000;
  static final double W20_MC_MAX = 394.215000;
  static final double W20_MC_MIN = 330.556667;
  static final double W20_POLASC_MAX = 469.147500;
  static final double W20_POLASC_MIN = 318.595833;
  static final double W20_VERTEX_MAX = 2999819.999167;
  static final double W20_VERTEX_MIN = -180.000000;
  static final double W30_ARMC_MAX = 360.986667;
  static final double W30_ARMC_MIN = 360.984167;
  static final double W30_ASC_MAX = 524.994891;
  static final double W30_ASC_MIN = 304.407972;
  static final double W30_COASC1_MAX = 527.985000;
  static final double W30_COASC1_MIN = 303.743333;
  static final double W30_COASC2_MAX = 1643.109167;
  static final double W30_COASC2_MIN = 218.980000;
  static final double W30_EQUASC_MAX = 394.215000;
  static final double W30_EQUASC_MIN = 330.556667;
  static final double W30_HOUSE10_MAX = 250000.000000;
  static final double W30_HOUSE10_MIN = 0.000000;
  static final double W30_HOUSE11_MAX = 250000.000000;
  static final double W30_HOUSE11_MIN = 0.000000;
  static final double W30_HOUSE12_MAX = 250000.000000;
  static final double W30_HOUSE12_MIN = 0.000000;
  static final double W30_HOUSE1_MAX = 250000.000000;
  static final double W30_HOUSE1_MIN = 0.000000;
  static final double W30_HOUSE2_MAX = 250000.000000;
  static final double W30_HOUSE2_MIN = 0.000000;
  static final double W30_HOUSE3_MAX = 250000.000000;
  static final double W30_HOUSE3_MIN = 0.000000;
  static final double W30_HOUSE4_MAX = 250000.000000;
  static final double W30_HOUSE4_MIN = 0.000000;
  static final double W30_HOUSE5_MAX = 250000.000000;
  static final double W30_HOUSE5_MIN = 0.000000;
  static final double W30_HOUSE6_MAX = 250000.000000;
  static final double W30_HOUSE6_MIN = 0.000000;
  static final double W30_HOUSE7_MAX = 250000.000000;
  static final double W30_HOUSE7_MIN = 0.000000;
  static final double W30_HOUSE8_MAX = 250000.000000;
  static final double W30_HOUSE8_MIN = 0.000000;
  static final double W30_HOUSE9_MAX = 250000.000000;
  static final double W30_HOUSE9_MIN = 0.000000;
  static final double W30_MC_MAX = 394.215000;
  static final double W30_MC_MIN = 330.556667;
  static final double W30_POLASC_MAX = 527.985000;
  static final double W30_POLASC_MIN = 303.743333;
  static final double W30_VERTEX_MAX = 1643.108333;
  static final double W30_VERTEX_MIN = 218.980000;
  static final double W40_ARMC_MAX = 360.986667;
  static final double W40_ARMC_MIN = 360.984167;
  static final double W40_ASC_MAX = 618.738596;
  static final double W40_ASC_MIN = 283.720808;
  static final double W40_COASC1_MAX = 623.978333;
  static final double W40_COASC1_MIN = 282.993333;
  static final double W40_COASC2_MAX = 826.410833;
  static final double W40_COASC2_MIN = 255.830833;
  static final double W40_EQUASC_MAX = 394.215000;
  static final double W40_EQUASC_MIN = 330.556667;
  static final double W40_HOUSE10_MAX = 250000.000000;
  static final double W40_HOUSE10_MIN = 0.000000;
  static final double W40_HOUSE11_MAX = 250000.000000;
  static final double W40_HOUSE11_MIN = 0.000000;
  static final double W40_HOUSE12_MAX = 250000.000000;
  static final double W40_HOUSE12_MIN = 0.000000;
  static final double W40_HOUSE1_MAX = 250000.000000;
  static final double W40_HOUSE1_MIN = 0.000000;
  static final double W40_HOUSE2_MAX = 250000.000000;
  static final double W40_HOUSE2_MIN = 0.000000;
  static final double W40_HOUSE3_MAX = 250000.000000;
  static final double W40_HOUSE3_MIN = 0.000000;
  static final double W40_HOUSE4_MAX = 250000.000000;
  static final double W40_HOUSE4_MIN = 0.000000;
  static final double W40_HOUSE5_MAX = 250000.000000;
  static final double W40_HOUSE5_MIN = 0.000000;
  static final double W40_HOUSE6_MAX = 250000.000000;
  static final double W40_HOUSE6_MIN = 0.000000;
  static final double W40_HOUSE7_MAX = 250000.000000;
  static final double W40_HOUSE7_MIN = 0.000000;
  static final double W40_HOUSE8_MAX = 250000.000000;
  static final double W40_HOUSE8_MIN = 0.000000;
  static final double W40_HOUSE9_MAX = 250000.000000;
  static final double W40_HOUSE9_MIN = 0.000000;
  static final double W40_MC_MAX = 394.215000;
  static final double W40_MC_MIN = 330.556667;
  static final double W40_POLASC_MAX = 623.978333;
  static final double W40_POLASC_MIN = 282.993333;
  static final double W40_VERTEX_MAX = 826.410833;
  static final double W40_VERTEX_MIN = 255.830833;
  static final double W50_ARMC_MAX = 360.986667;
  static final double W50_ARMC_MIN = 360.984167;
  static final double W50_ASC_MAX = 814.745889;
  static final double W50_ASC_MIN = 256.684961;
  static final double W50_COASC1_MAX = 826.410833;
  static final double W50_COASC1_MIN = 255.830833;
  static final double W50_COASC2_MAX = 623.978333;
  static final double W50_COASC2_MIN = 282.993333;
  static final double W50_EQUASC_MAX = 394.215000;
  static final double W50_EQUASC_MIN = 330.556667;
  static final double W50_HOUSE10_MAX = 250000.000000;
  static final double W50_HOUSE10_MIN = 0.000000;
  static final double W50_HOUSE11_MAX = 250000.000000;
  static final double W50_HOUSE11_MIN = 0.000000;
  static final double W50_HOUSE12_MAX = 250000.000000;
  static final double W50_HOUSE12_MIN = 0.000000;
  static final double W50_HOUSE1_MAX = 250000.000000;
  static final double W50_HOUSE1_MIN = 0.000000;
  static final double W50_HOUSE2_MAX = 250000.000000;
  static final double W50_HOUSE2_MIN = 0.000000;
  static final double W50_HOUSE3_MAX = 250000.000000;
  static final double W50_HOUSE3_MIN = 0.000000;
  static final double W50_HOUSE4_MAX = 250000.000000;
  static final double W50_HOUSE4_MIN = 0.000000;
  static final double W50_HOUSE5_MAX = 250000.000000;
  static final double W50_HOUSE5_MIN = 0.000000;
  static final double W50_HOUSE6_MAX = 250000.000000;
  static final double W50_HOUSE6_MIN = 0.000000;
  static final double W50_HOUSE7_MAX = 250000.000000;
  static final double W50_HOUSE7_MIN = 0.000000;
  static final double W50_HOUSE8_MAX = 250000.000000;
  static final double W50_HOUSE8_MIN = 0.000000;
  static final double W50_HOUSE9_MAX = 250000.000000;
  static final double W50_HOUSE9_MIN = 0.000000;
  static final double W50_MC_MAX = 394.215000;
  static final double W50_MC_MIN = 330.556667;
  static final double W50_POLASC_MAX = 826.410833;
  static final double W50_POLASC_MIN = 255.830833;
  static final double W50_VERTEX_MAX = 623.978333;
  static final double W50_VERTEX_MIN = 282.993333;
  static final double W60_ARMC_MAX = 360.986667;
  static final double W60_ARMC_MIN = 360.984167;
  static final double W60_ASC_MAX = 1583.084164;
  static final double W60_ASC_MIN = 220.207028;
  static final double W60_COASC1_MAX = 1643.108333;
  static final double W60_COASC1_MIN = 218.980000;
  static final double W60_COASC2_MAX = 527.985000;
  static final double W60_COASC2_MIN = 303.743333;
  static final double W60_EQUASC_MAX = 394.215000;
  static final double W60_EQUASC_MIN = 330.556667;
  static final double W60_HOUSE10_MAX = 250000.000000;
  static final double W60_HOUSE10_MIN = 0.000000;
  static final double W60_HOUSE11_MAX = 250000.000000;
  static final double W60_HOUSE11_MIN = 0.000000;
  static final double W60_HOUSE12_MAX = 250000.000000;
  static final double W60_HOUSE12_MIN = 0.000000;
  static final double W60_HOUSE1_MAX = 250000.000000;
  static final double W60_HOUSE1_MIN = 0.000000;
  static final double W60_HOUSE2_MAX = 250000.000000;
  static final double W60_HOUSE2_MIN = 0.000000;
  static final double W60_HOUSE3_MAX = 250000.000000;
  static final double W60_HOUSE3_MIN = 0.000000;
  static final double W60_HOUSE4_MAX = 250000.000000;
  static final double W60_HOUSE4_MIN = 0.000000;
  static final double W60_HOUSE5_MAX = 250000.000000;
  static final double W60_HOUSE5_MIN = 0.000000;
  static final double W60_HOUSE6_MAX = 250000.000000;
  static final double W60_HOUSE6_MIN = 0.000000;
  static final double W60_HOUSE7_MAX = 250000.000000;
  static final double W60_HOUSE7_MIN = 0.000000;
  static final double W60_HOUSE8_MAX = 250000.000000;
  static final double W60_HOUSE8_MIN = 0.000000;
  static final double W60_HOUSE9_MAX = 250000.000000;
  static final double W60_HOUSE9_MIN = 0.000000;
  static final double W60_MC_MAX = 394.215000;
  static final double W60_MC_MIN = 330.556667;
  static final double W60_POLASC_MAX = 1643.108333;
  static final double W60_POLASC_MIN = 218.980000;
  static final double W60_VERTEX_MAX = 527.985000;
  static final double W60_VERTEX_MIN = 303.743333;
  static final double W66_ARMC_MAX = 360.986667;
  static final double W66_ARMC_MIN = 360.984167;
  static final double W66_ASC_MAX = 15382.763492;
  static final double W66_ASC_MIN = 180.714519;
  static final double W66_COASC1_MAX = 27433.717500;
  static final double W66_COASC1_MIN = 176.632500;
  static final double W66_COASC2_MAX = 489.939167;
  static final double W66_COASC2_MIN = 313.358333;
  static final double W66_EQUASC_MAX = 394.215000;
  static final double W66_EQUASC_MIN = 330.556667;
  static final double W66_HOUSE10_MAX = 250000.000000;
  static final double W66_HOUSE10_MIN = 0.000000;
  static final double W66_HOUSE11_MAX = 250000.000000;
  static final double W66_HOUSE11_MIN = 0.000000;
  static final double W66_HOUSE12_MAX = 250000.000000;
  static final double W66_HOUSE12_MIN = 0.000000;
  static final double W66_HOUSE1_MAX = 250000.000000;
  static final double W66_HOUSE1_MIN = 0.000000;
  static final double W66_HOUSE2_MAX = 250000.000000;
  static final double W66_HOUSE2_MIN = 0.000000;
  static final double W66_HOUSE3_MAX = 250000.000000;
  static final double W66_HOUSE3_MIN = 0.000000;
  static final double W66_HOUSE4_MAX = 250000.000000;
  static final double W66_HOUSE4_MIN = 0.000000;
  static final double W66_HOUSE5_MAX = 250000.000000;
  static final double W66_HOUSE5_MIN = 0.000000;
  static final double W66_HOUSE6_MAX = 250000.000000;
  static final double W66_HOUSE6_MIN = 0.000000;
  static final double W66_HOUSE7_MAX = 250000.000000;
  static final double W66_HOUSE7_MIN = 0.000000;
  static final double W66_HOUSE8_MAX = 250000.000000;
  static final double W66_HOUSE8_MIN = 0.000000;
  static final double W66_HOUSE9_MAX = 250000.000000;
  static final double W66_HOUSE9_MIN = 0.000000;
  static final double W66_MC_MAX = 394.215000;
  static final double W66_MC_MIN = 330.556667;
  static final double W66_POLASC_MAX = 27433.717500;
  static final double W66_POLASC_MIN = 176.632500;
  static final double W66_VERTEX_MAX = 489.939167;
  static final double W66_VERTEX_MIN = 313.358333;
  static final double W70_ARMC_MAX = 360.986667;
  static final double W70_ARMC_MIN = 360.984167;
  static final double W70_ASC_MAX = 1553150.329680;
  static final double W70_ASC_MIN = -777600.393020;
  static final double W70_COASC1_MAX = 2999819.999167;
  static final double W70_COASC1_MIN = -180.000000;
  static final double W70_COASC2_MAX = 469.147500;
  static final double W70_COASC2_MIN = 318.595833;
  static final double W70_EQUASC_MAX = 394.215000;
  static final double W70_EQUASC_MIN = 330.556667;
  static final double W70_HOUSE10_MAX = 2750000.000000;
  static final double W70_HOUSE10_MIN = 0.000000;
  static final double W70_HOUSE11_MAX = 2750000.000000;
  static final double W70_HOUSE11_MIN = 0.000000;
  static final double W70_HOUSE12_MAX = 2750000.000000;
  static final double W70_HOUSE12_MIN = 0.000000;
  static final double W70_HOUSE1_MAX = 2750000.000000;
  static final double W70_HOUSE1_MIN = 0.000000;
  static final double W70_HOUSE2_MAX = 2750000.000000;
  static final double W70_HOUSE2_MIN = 0.000000;
  static final double W70_HOUSE3_MAX = 2750000.000000;
  static final double W70_HOUSE3_MIN = 0.000000;
  static final double W70_HOUSE4_MAX = 2750000.000000;
  static final double W70_HOUSE4_MIN = 0.000000;
  static final double W70_HOUSE5_MAX = 2750000.000000;
  static final double W70_HOUSE5_MIN = 0.000000;
  static final double W70_HOUSE6_MAX = 2750000.000000;
  static final double W70_HOUSE6_MIN = 0.000000;
  static final double W70_HOUSE7_MAX = 2750000.000000;
  static final double W70_HOUSE7_MIN = 0.000000;
  static final double W70_HOUSE8_MAX = 2750000.000000;
  static final double W70_HOUSE8_MIN = 0.000000;
  static final double W70_HOUSE9_MAX = 2750000.000000;
  static final double W70_HOUSE9_MIN = 0.000000;
  static final double W70_MC_MAX = 394.215000;
  static final double W70_MC_MIN = 330.556667;
  static final double W70_POLASC_MAX = 2999820.000000;
  static final double W70_POLASC_MIN = -180.000000;
  static final double W70_VERTEX_MAX = 469.147500;
  static final double W70_VERTEX_MIN = 318.595833;
  static final double W80_ARMC_MAX = 360.986667;
  static final double W80_ARMC_MIN = 360.984167;
  static final double W80_ASC_MAX = 1554930.566184;
  static final double W80_ASC_MIN = -777600.124007;
  static final double W80_COASC1_MAX = 2999820.000000;
  static final double W80_COASC1_MIN = -180.000000;
  static final double W80_COASC2_MAX = 427.276667;
  static final double W80_COASC2_MIN = 327.558333;
  static final double W80_EQUASC_MAX = 394.215000;
  static final double W80_EQUASC_MIN = 330.556667;
  static final double W80_HOUSE10_MAX = 2750000.000000;
  static final double W80_HOUSE10_MIN = 0.000000;
  static final double W80_HOUSE11_MAX = 2750000.000000;
  static final double W80_HOUSE11_MIN = 0.000000;
  static final double W80_HOUSE12_MAX = 2750000.000000;
  static final double W80_HOUSE12_MIN = 0.000000;
  static final double W80_HOUSE1_MAX = 2750000.000000;
  static final double W80_HOUSE1_MIN = 0.000000;
  static final double W80_HOUSE2_MAX = 2750000.000000;
  static final double W80_HOUSE2_MIN = 0.000000;
  static final double W80_HOUSE3_MAX = 2750000.000000;
  static final double W80_HOUSE3_MIN = 0.000000;
  static final double W80_HOUSE4_MAX = 2750000.000000;
  static final double W80_HOUSE4_MIN = 0.000000;
  static final double W80_HOUSE5_MAX = 2750000.000000;
  static final double W80_HOUSE5_MIN = 0.000000;
  static final double W80_HOUSE6_MAX = 2750000.000000;
  static final double W80_HOUSE6_MIN = 0.000000;
  static final double W80_HOUSE7_MAX = 2750000.000000;
  static final double W80_HOUSE7_MIN = 0.000000;
  static final double W80_HOUSE8_MAX = 2750000.000000;
  static final double W80_HOUSE8_MIN = 0.000000;
  static final double W80_HOUSE9_MAX = 2750000.000000;
  static final double W80_HOUSE9_MIN = 0.000000;
  static final double W80_MC_MAX = 394.215000;
  static final double W80_MC_MIN = 330.556667;
  static final double W80_POLASC_MAX = 2999820.000000;
  static final double W80_POLASC_MIN = -180.000000;
  static final double W80_VERTEX_MAX = 427.276667;
  static final double W80_VERTEX_MIN = 327.558333;
  static final double W85_ARMC_MAX = 360.986667;
  static final double W85_ARMC_MIN = 360.984167;
  static final double W85_ASC_MAX = 1555100.603952;
  static final double W85_ASC_MIN = -777600.058703;
  static final double W85_COASC1_MAX = 2999901.836667;
  static final double W85_COASC1_MIN = -100.323333;
  static final double W85_COASC2_MAX = 409.954167;
  static final double W85_COASC2_MIN = 329.806667;
  static final double W85_EQUASC_MAX = 394.215000;
  static final double W85_EQUASC_MIN = 330.556667;
  static final double W85_HOUSE10_MAX = 2750000.000000;
  static final double W85_HOUSE10_MIN = 0.000000;
  static final double W85_HOUSE11_MAX = 2750000.000000;
  static final double W85_HOUSE11_MIN = 0.000000;
  static final double W85_HOUSE12_MAX = 2750000.000000;
  static final double W85_HOUSE12_MIN = 0.000000;
  static final double W85_HOUSE1_MAX = 2750000.000000;
  static final double W85_HOUSE1_MIN = 0.000000;
  static final double W85_HOUSE2_MAX = 2750000.000000;
  static final double W85_HOUSE2_MIN = 0.000000;
  static final double W85_HOUSE3_MAX = 2750000.000000;
  static final double W85_HOUSE3_MIN = 0.000000;
  static final double W85_HOUSE4_MAX = 2750000.000000;
  static final double W85_HOUSE4_MIN = 0.000000;
  static final double W85_HOUSE5_MAX = 2750000.000000;
  static final double W85_HOUSE5_MIN = 0.000000;
  static final double W85_HOUSE6_MAX = 2750000.000000;
  static final double W85_HOUSE6_MIN = 0.000000;
  static final double W85_HOUSE7_MAX = 2750000.000000;
  static final double W85_HOUSE7_MIN = 0.000000;
  static final double W85_HOUSE8_MAX = 2750000.000000;
  static final double W85_HOUSE8_MIN = 0.000000;
  static final double W85_HOUSE9_MAX = 2750000.000000;
  static final double W85_HOUSE9_MIN = 0.000000;
  static final double W85_MC_MAX = 394.215000;
  static final double W85_MC_MIN = 330.556667;
  static final double W85_POLASC_MAX = 66.413333;
  static final double W85_POLASC_MIN = -100.323333;
  static final double W85_VERTEX_MAX = 409.954167;
  static final double W85_VERTEX_MIN = 329.806667;
  static final double W88_ARMC_MAX = 360.985931;
  static final double W88_ARMC_MIN = 360.985828;
  static final double W88_ASC_MAX = 1555165.554408;
  static final double W88_ASC_MIN = -777600.023170;
  static final double W88_COASC1_MAX = 1555165.554409;
  static final double W88_COASC1_MIN = -34.489296;
  static final double W88_COASC2_MAX = 399.547623;
  static final double W88_COASC2_MIN = 331.043079;
  static final double W88_EQUASC_MAX = 393.494420;
  static final double W88_EQUASC_MIN = 331.162937;
  static final double W88_HOUSE10_MAX = 1425600.000000;
  static final double W88_HOUSE10_MIN = 0.000000;
  static final double W88_HOUSE11_MAX = 1425600.000000;
  static final double W88_HOUSE11_MIN = 0.000000;
  static final double W88_HOUSE12_MAX = 1425600.000000;
  static final double W88_HOUSE12_MIN = 0.000000;
  static final double W88_HOUSE1_MAX = 1425600.000000;
  static final double W88_HOUSE1_MIN = 0.000000;
  static final double W88_HOUSE2_MAX = 1425600.000000;
  static final double W88_HOUSE2_MIN = 0.000000;
  static final double W88_HOUSE3_MAX = 1425600.000000;
  static final double W88_HOUSE3_MIN = 0.000000;
  static final double W88_HOUSE4_MAX = 1425600.000000;
  static final double W88_HOUSE4_MIN = 0.000000;
  static final double W88_HOUSE5_MAX = 1425600.000000;
  static final double W88_HOUSE5_MIN = 0.000000;
  static final double W88_HOUSE6_MAX = 1425600.000000;
  static final double W88_HOUSE6_MIN = 0.000000;
  static final double W88_HOUSE7_MAX = 1425600.000000;
  static final double W88_HOUSE7_MIN = 0.000000;
  static final double W88_HOUSE8_MAX = 1425600.000000;
  static final double W88_HOUSE8_MIN = 0.000000;
  static final double W88_HOUSE9_MAX = 1425600.000000;
  static final double W88_HOUSE9_MIN = 0.000000;
  static final double W88_MC_MAX = 393.494420;
  static final double W88_MC_MIN = 331.162936;
  static final double W88_POLASC_MAX = 29.344230;
  static final double W88_POLASC_MIN = -34.489313;
  static final double W88_VERTEX_MAX = 399.547621;
  static final double W88_VERTEX_MIN = 331.043081;
  static final double W89x_ARMC_MAX = 360.986667;
  static final double W89x_ARMC_MIN = 360.984167;
  static final double W89x_ASC_MAX = 1555200.000000;
  static final double W89x_ASC_MIN = -777600.000000;
  static final double W89x_COASC1_MAX = 2999998.426667;
  static final double W89x_COASC1_MIN = -1.600833;
  static final double W89x_COASC2_MAX = 394.516667;
  static final double W89x_COASC2_MIN = 330.556667;
  static final double W89x_EQUASC_MAX = 394.215000;
  static final double W89x_EQUASC_MIN = 330.556667;
  static final double W89x_HOUSE10_MAX = 2750000.000000;
  static final double W89x_HOUSE10_MIN = 0.000000;
  static final double W89x_HOUSE11_MAX = 2750000.000000;
  static final double W89x_HOUSE11_MIN = 0.000000;
  static final double W89x_HOUSE12_MAX = 2750000.000000;
  static final double W89x_HOUSE12_MIN = 0.000000;
  static final double W89x_HOUSE1_MAX = 2750000.000000;
  static final double W89x_HOUSE1_MIN = 0.000000;
  static final double W89x_HOUSE2_MAX = 2750000.000000;
  static final double W89x_HOUSE2_MIN = 0.000000;
  static final double W89x_HOUSE3_MAX = 2750000.000000;
  static final double W89x_HOUSE3_MIN = 0.000000;
  static final double W89x_HOUSE4_MAX = 2750000.000000;
  static final double W89x_HOUSE4_MIN = 0.000000;
  static final double W89x_HOUSE5_MAX = 2750000.000000;
  static final double W89x_HOUSE5_MIN = 0.000000;
  static final double W89x_HOUSE6_MAX = 2750000.000000;
  static final double W89x_HOUSE6_MIN = 0.000000;
  static final double W89x_HOUSE7_MAX = 2750000.000000;
  static final double W89x_HOUSE7_MIN = 0.000000;
  static final double W89x_HOUSE8_MAX = 2750000.000000;
  static final double W89x_HOUSE8_MIN = 0.000000;
  static final double W89x_HOUSE9_MAX = 2750000.000000;
  static final double W89x_HOUSE9_MIN = 0.000000;
  static final double W89x_MC_MAX = 394.215000;
  static final double W89x_MC_MIN = 330.556667;
  static final double W89x_POLASC_MAX = 1.588333;
  static final double W89x_POLASC_MIN = -1.600833;
  static final double W89x_VERTEX_MAX = 394.516667;
  static final double W89x_VERTEX_MIN = 330.556667;
  static final double X0_ARMC_MAX = 360.986667;
  static final double X0_ARMC_MIN = 360.984167;
  static final double X0_ASC_MAX = 393.494420;
  static final double X0_ASC_MIN = 331.162937;
  static final double X0_COASC1_MAX = 394.215000;
  static final double X0_COASC1_MIN = 330.556667;
  static final double X0_COASC2_MAX = 0.000000;
  static final double X0_COASC2_MIN = 0.000000;
  static final double X0_EQUASC_MAX = 394.215000;
  static final double X0_EQUASC_MIN = 330.556667;
  static final double X0_HOUSE10_MAX = 394.215000;
  static final double X0_HOUSE10_MIN = 330.556667;
  static final double X0_HOUSE11_MAX = 394.215000;
  static final double X0_HOUSE11_MIN = 330.556667;
  static final double X0_HOUSE12_MAX = 394.215000;
  static final double X0_HOUSE12_MIN = 330.556667;
  static final double X0_HOUSE1_MAX = 394.215000;
  static final double X0_HOUSE1_MIN = 330.556667;
  static final double X0_HOUSE2_MAX = 394.215000;
  static final double X0_HOUSE2_MIN = 330.556667;
  static final double X0_HOUSE3_MAX = 394.215000;
  static final double X0_HOUSE3_MIN = 330.556667;
  static final double X0_HOUSE4_MAX = 394.215000;
  static final double X0_HOUSE4_MIN = 330.556667;
  static final double X0_HOUSE5_MAX = 394.215000;
  static final double X0_HOUSE5_MIN = 330.556667;
  static final double X0_HOUSE6_MAX = 394.215000;
  static final double X0_HOUSE6_MIN = 330.556667;
  static final double X0_HOUSE7_MAX = 394.215000;
  static final double X0_HOUSE7_MIN = 330.556667;
  static final double X0_HOUSE8_MAX = 394.215000;
  static final double X0_HOUSE8_MIN = 330.556667;
  static final double X0_HOUSE9_MAX = 394.215000;
  static final double X0_HOUSE9_MIN = 330.556667;
  static final double X0_MC_MAX = 394.215000;
  static final double X0_MC_MIN = 330.556667;
  static final double X0_POLASC_MAX = 394.215000;
  static final double X0_POLASC_MIN = 330.556667;
  static final double X0_VERTEX_MAX = 1500000.000000;
  static final double X0_VERTEX_MIN = 0.000000;
  static final double X10_ARMC_MAX = 360.986667;
  static final double X10_ARMC_MIN = 360.984167;
  static final double X10_ASC_MAX = 426.089536;
  static final double X10_ASC_MIN = 328.169552;
  static final double X10_COASC1_MAX = 427.276667;
  static final double X10_COASC1_MIN = 327.558333;
  static final double X10_COASC2_MAX = 2999820.000000;
  static final double X10_COASC2_MIN = -180.000000;
  static final double X10_EQUASC_MAX = 394.215000;
  static final double X10_EQUASC_MIN = 330.556667;
  static final double X10_HOUSE10_MAX = 394.215000;
  static final double X10_HOUSE10_MIN = 330.556667;
  static final double X10_HOUSE11_MAX = 394.215000;
  static final double X10_HOUSE11_MIN = 330.556667;
  static final double X10_HOUSE12_MAX = 394.215000;
  static final double X10_HOUSE12_MIN = 330.556667;
  static final double X10_HOUSE1_MAX = 394.215000;
  static final double X10_HOUSE1_MIN = 330.556667;
  static final double X10_HOUSE2_MAX = 394.215000;
  static final double X10_HOUSE2_MIN = 330.556667;
  static final double X10_HOUSE3_MAX = 394.215000;
  static final double X10_HOUSE3_MIN = 330.556667;
  static final double X10_HOUSE4_MAX = 394.215000;
  static final double X10_HOUSE4_MIN = 330.556667;
  static final double X10_HOUSE5_MAX = 394.215000;
  static final double X10_HOUSE5_MIN = 330.556667;
  static final double X10_HOUSE6_MAX = 394.215000;
  static final double X10_HOUSE6_MIN = 330.556667;
  static final double X10_HOUSE7_MAX = 394.215000;
  static final double X10_HOUSE7_MIN = 330.556667;
  static final double X10_HOUSE8_MAX = 394.215000;
  static final double X10_HOUSE8_MIN = 330.556667;
  static final double X10_HOUSE9_MAX = 394.215000;
  static final double X10_HOUSE9_MIN = 330.556667;
  static final double X10_MC_MAX = 394.215000;
  static final double X10_MC_MIN = 330.556667;
  static final double X10_POLASC_MAX = 427.276667;
  static final double X10_POLASC_MIN = 327.558333;
  static final double X10_VERTEX_MAX = 2999820.000000;
  static final double X10_VERTEX_MIN = -180.000000;
  static final double X20_ARMC_MAX = 360.986667;
  static final double X20_ARMC_MIN = 360.984167;
  static final double X20_ASC_MAX = 467.280896;
  static final double X20_ASC_MIN = 319.225068;
  static final double X20_COASC1_MAX = 469.147500;
  static final double X20_COASC1_MIN = 318.595833;
  static final double X20_COASC2_MAX = 2999819.999167;
  static final double X20_COASC2_MIN = -180.000000;
  static final double X20_EQUASC_MAX = 394.215000;
  static final double X20_EQUASC_MIN = 330.556667;
  static final double X20_HOUSE10_MAX = 394.215000;
  static final double X20_HOUSE10_MIN = 330.556667;
  static final double X20_HOUSE11_MAX = 394.215000;
  static final double X20_HOUSE11_MIN = 330.556667;
  static final double X20_HOUSE12_MAX = 394.215000;
  static final double X20_HOUSE12_MIN = 330.556667;
  static final double X20_HOUSE1_MAX = 394.215000;
  static final double X20_HOUSE1_MIN = 330.556667;
  static final double X20_HOUSE2_MAX = 394.215000;
  static final double X20_HOUSE2_MIN = 330.556667;
  static final double X20_HOUSE3_MAX = 394.215000;
  static final double X20_HOUSE3_MIN = 330.556667;
  static final double X20_HOUSE4_MAX = 394.215000;
  static final double X20_HOUSE4_MIN = 330.556667;
  static final double X20_HOUSE5_MAX = 394.215000;
  static final double X20_HOUSE5_MIN = 330.556667;
  static final double X20_HOUSE6_MAX = 394.215000;
  static final double X20_HOUSE6_MIN = 330.556667;
  static final double X20_HOUSE7_MAX = 394.215000;
  static final double X20_HOUSE7_MIN = 330.556667;
  static final double X20_HOUSE8_MAX = 394.215000;
  static final double X20_HOUSE8_MIN = 330.556667;
  static final double X20_HOUSE9_MAX = 394.215000;
  static final double X20_HOUSE9_MIN = 330.556667;
  static final double X20_MC_MAX = 394.215000;
  static final double X20_MC_MIN = 330.556667;
  static final double X20_POLASC_MAX = 469.147500;
  static final double X20_POLASC_MIN = 318.595833;
  static final double X20_VERTEX_MAX = 2999819.999167;
  static final double X20_VERTEX_MIN = -180.000000;
  static final double X30_ARMC_MAX = 360.986667;
  static final double X30_ARMC_MIN = 360.984167;
  static final double X30_ASC_MAX = 524.994891;
  static final double X30_ASC_MIN = 304.407972;
  static final double X30_COASC1_MAX = 527.985000;
  static final double X30_COASC1_MIN = 303.743333;
  static final double X30_COASC2_MAX = 1643.109167;
  static final double X30_COASC2_MIN = 218.980000;
  static final double X30_EQUASC_MAX = 394.215000;
  static final double X30_EQUASC_MIN = 330.556667;
  static final double X30_HOUSE10_MAX = 394.215000;
  static final double X30_HOUSE10_MIN = 330.556667;
  static final double X30_HOUSE11_MAX = 394.215000;
  static final double X30_HOUSE11_MIN = 330.556667;
  static final double X30_HOUSE12_MAX = 394.215000;
  static final double X30_HOUSE12_MIN = 330.556667;
  static final double X30_HOUSE1_MAX = 394.215000;
  static final double X30_HOUSE1_MIN = 330.556667;
  static final double X30_HOUSE2_MAX = 394.215000;
  static final double X30_HOUSE2_MIN = 330.556667;
  static final double X30_HOUSE3_MAX = 394.215000;
  static final double X30_HOUSE3_MIN = 330.556667;
  static final double X30_HOUSE4_MAX = 394.215000;
  static final double X30_HOUSE4_MIN = 330.556667;
  static final double X30_HOUSE5_MAX = 394.215000;
  static final double X30_HOUSE5_MIN = 330.556667;
  static final double X30_HOUSE6_MAX = 394.215000;
  static final double X30_HOUSE6_MIN = 330.556667;
  static final double X30_HOUSE7_MAX = 394.215000;
  static final double X30_HOUSE7_MIN = 330.556667;
  static final double X30_HOUSE8_MAX = 394.215000;
  static final double X30_HOUSE8_MIN = 330.556667;
  static final double X30_HOUSE9_MAX = 394.215000;
  static final double X30_HOUSE9_MIN = 330.556667;
  static final double X30_MC_MAX = 394.215000;
  static final double X30_MC_MIN = 330.556667;
  static final double X30_POLASC_MAX = 527.985000;
  static final double X30_POLASC_MIN = 303.743333;
  static final double X30_VERTEX_MAX = 1643.108333;
  static final double X30_VERTEX_MIN = 218.980000;
  static final double X40_ARMC_MAX = 360.986667;
  static final double X40_ARMC_MIN = 360.984167;
  static final double X40_ASC_MAX = 618.738596;
  static final double X40_ASC_MIN = 283.720808;
  static final double X40_COASC1_MAX = 623.978333;
  static final double X40_COASC1_MIN = 282.993333;
  static final double X40_COASC2_MAX = 826.410833;
  static final double X40_COASC2_MIN = 255.830833;
  static final double X40_EQUASC_MAX = 394.215000;
  static final double X40_EQUASC_MIN = 330.556667;
  static final double X40_HOUSE10_MAX = 394.215000;
  static final double X40_HOUSE10_MIN = 330.556667;
  static final double X40_HOUSE11_MAX = 394.215000;
  static final double X40_HOUSE11_MIN = 330.556667;
  static final double X40_HOUSE12_MAX = 394.215000;
  static final double X40_HOUSE12_MIN = 330.556667;
  static final double X40_HOUSE1_MAX = 394.215000;
  static final double X40_HOUSE1_MIN = 330.556667;
  static final double X40_HOUSE2_MAX = 394.215000;
  static final double X40_HOUSE2_MIN = 330.556667;
  static final double X40_HOUSE3_MAX = 394.215000;
  static final double X40_HOUSE3_MIN = 330.556667;
  static final double X40_HOUSE4_MAX = 394.215000;
  static final double X40_HOUSE4_MIN = 330.556667;
  static final double X40_HOUSE5_MAX = 394.215000;
  static final double X40_HOUSE5_MIN = 330.556667;
  static final double X40_HOUSE6_MAX = 394.215000;
  static final double X40_HOUSE6_MIN = 330.556667;
  static final double X40_HOUSE7_MAX = 394.215000;
  static final double X40_HOUSE7_MIN = 330.556667;
  static final double X40_HOUSE8_MAX = 394.215000;
  static final double X40_HOUSE8_MIN = 330.556667;
  static final double X40_HOUSE9_MAX = 394.215000;
  static final double X40_HOUSE9_MIN = 330.556667;
  static final double X40_MC_MAX = 394.215000;
  static final double X40_MC_MIN = 330.556667;
  static final double X40_POLASC_MAX = 623.978333;
  static final double X40_POLASC_MIN = 282.993333;
  static final double X40_VERTEX_MAX = 826.410833;
  static final double X40_VERTEX_MIN = 255.830833;
  static final double X50_ARMC_MAX = 360.986667;
  static final double X50_ARMC_MIN = 360.984167;
  static final double X50_ASC_MAX = 814.745889;
  static final double X50_ASC_MIN = 256.684961;
  static final double X50_COASC1_MAX = 826.410833;
  static final double X50_COASC1_MIN = 255.830833;
  static final double X50_COASC2_MAX = 623.978333;
  static final double X50_COASC2_MIN = 282.993333;
  static final double X50_EQUASC_MAX = 394.215000;
  static final double X50_EQUASC_MIN = 330.556667;
  static final double X50_HOUSE10_MAX = 394.215000;
  static final double X50_HOUSE10_MIN = 330.556667;
  static final double X50_HOUSE11_MAX = 394.215000;
  static final double X50_HOUSE11_MIN = 330.556667;
  static final double X50_HOUSE12_MAX = 394.215000;
  static final double X50_HOUSE12_MIN = 330.556667;
  static final double X50_HOUSE1_MAX = 394.215000;
  static final double X50_HOUSE1_MIN = 330.556667;
  static final double X50_HOUSE2_MAX = 394.215000;
  static final double X50_HOUSE2_MIN = 330.556667;
  static final double X50_HOUSE3_MAX = 394.215000;
  static final double X50_HOUSE3_MIN = 330.556667;
  static final double X50_HOUSE4_MAX = 394.215000;
  static final double X50_HOUSE4_MIN = 330.556667;
  static final double X50_HOUSE5_MAX = 394.215000;
  static final double X50_HOUSE5_MIN = 330.556667;
  static final double X50_HOUSE6_MAX = 394.215000;
  static final double X50_HOUSE6_MIN = 330.556667;
  static final double X50_HOUSE7_MAX = 394.215000;
  static final double X50_HOUSE7_MIN = 330.556667;
  static final double X50_HOUSE8_MAX = 394.215000;
  static final double X50_HOUSE8_MIN = 330.556667;
  static final double X50_HOUSE9_MAX = 394.215000;
  static final double X50_HOUSE9_MIN = 330.556667;
  static final double X50_MC_MAX = 394.215000;
  static final double X50_MC_MIN = 330.556667;
  static final double X50_POLASC_MAX = 826.410833;
  static final double X50_POLASC_MIN = 255.830833;
  static final double X50_VERTEX_MAX = 623.978333;
  static final double X50_VERTEX_MIN = 282.993333;
  static final double X60_ARMC_MAX = 360.986667;
  static final double X60_ARMC_MIN = 360.984167;
  static final double X60_ASC_MAX = 1583.084164;
  static final double X60_ASC_MIN = 220.207028;
  static final double X60_COASC1_MAX = 1643.108333;
  static final double X60_COASC1_MIN = 218.980000;
  static final double X60_COASC2_MAX = 527.985000;
  static final double X60_COASC2_MIN = 303.743333;
  static final double X60_EQUASC_MAX = 394.215000;
  static final double X60_EQUASC_MIN = 330.556667;
  static final double X60_HOUSE10_MAX = 394.215000;
  static final double X60_HOUSE10_MIN = 330.556667;
  static final double X60_HOUSE11_MAX = 394.215000;
  static final double X60_HOUSE11_MIN = 330.556667;
  static final double X60_HOUSE12_MAX = 394.215000;
  static final double X60_HOUSE12_MIN = 330.556667;
  static final double X60_HOUSE1_MAX = 394.215000;
  static final double X60_HOUSE1_MIN = 330.556667;
  static final double X60_HOUSE2_MAX = 394.215000;
  static final double X60_HOUSE2_MIN = 330.556667;
  static final double X60_HOUSE3_MAX = 394.215000;
  static final double X60_HOUSE3_MIN = 330.556667;
  static final double X60_HOUSE4_MAX = 394.215000;
  static final double X60_HOUSE4_MIN = 330.556667;
  static final double X60_HOUSE5_MAX = 394.215000;
  static final double X60_HOUSE5_MIN = 330.556667;
  static final double X60_HOUSE6_MAX = 394.215000;
  static final double X60_HOUSE6_MIN = 330.556667;
  static final double X60_HOUSE7_MAX = 394.215000;
  static final double X60_HOUSE7_MIN = 330.556667;
  static final double X60_HOUSE8_MAX = 394.215000;
  static final double X60_HOUSE8_MIN = 330.556667;
  static final double X60_HOUSE9_MAX = 394.215000;
  static final double X60_HOUSE9_MIN = 330.556667;
  static final double X60_MC_MAX = 394.215000;
  static final double X60_MC_MIN = 330.556667;
  static final double X60_POLASC_MAX = 1643.108333;
  static final double X60_POLASC_MIN = 218.980000;
  static final double X60_VERTEX_MAX = 527.985000;
  static final double X60_VERTEX_MIN = 303.743333;
  static final double X66_ARMC_MAX = 360.986667;
  static final double X66_ARMC_MIN = 360.984167;
  static final double X66_ASC_MAX = 15382.763492;
  static final double X66_ASC_MIN = 180.714519;
  static final double X66_COASC1_MAX = 27433.717500;
  static final double X66_COASC1_MIN = 176.632500;
  static final double X66_COASC2_MAX = 489.939167;
  static final double X66_COASC2_MIN = 313.358333;
  static final double X66_EQUASC_MAX = 394.215000;
  static final double X66_EQUASC_MIN = 330.556667;
  static final double X66_HOUSE10_MAX = 394.215000;
  static final double X66_HOUSE10_MIN = 330.556667;
  static final double X66_HOUSE11_MAX = 394.215000;
  static final double X66_HOUSE11_MIN = 330.556667;
  static final double X66_HOUSE12_MAX = 394.215000;
  static final double X66_HOUSE12_MIN = 330.556667;
  static final double X66_HOUSE1_MAX = 394.215000;
  static final double X66_HOUSE1_MIN = 330.556667;
  static final double X66_HOUSE2_MAX = 394.215000;
  static final double X66_HOUSE2_MIN = 330.556667;
  static final double X66_HOUSE3_MAX = 394.215000;
  static final double X66_HOUSE3_MIN = 330.556667;
  static final double X66_HOUSE4_MAX = 394.215000;
  static final double X66_HOUSE4_MIN = 330.556667;
  static final double X66_HOUSE5_MAX = 394.215000;
  static final double X66_HOUSE5_MIN = 330.556667;
  static final double X66_HOUSE6_MAX = 394.215000;
  static final double X66_HOUSE6_MIN = 330.556667;
  static final double X66_HOUSE7_MAX = 394.215000;
  static final double X66_HOUSE7_MIN = 330.556667;
  static final double X66_HOUSE8_MAX = 394.215000;
  static final double X66_HOUSE8_MIN = 330.556667;
  static final double X66_HOUSE9_MAX = 394.215000;
  static final double X66_HOUSE9_MIN = 330.556667;
  static final double X66_MC_MAX = 394.215000;
  static final double X66_MC_MIN = 330.556667;
  static final double X66_POLASC_MAX = 27433.717500;
  static final double X66_POLASC_MIN = 176.632500;
  static final double X66_VERTEX_MAX = 489.939167;
  static final double X66_VERTEX_MIN = 313.358333;
  static final double X70_ARMC_MAX = 360.986667;
  static final double X70_ARMC_MIN = 360.984167;
  static final double X70_ASC_MAX = 179.610407;
  static final double X70_ASC_MIN = -2066.757500;
  static final double X70_COASC1_MAX = 2999819.999167;
  static final double X70_COASC1_MIN = -180.000000;
  static final double X70_COASC2_MAX = 469.147500;
  static final double X70_COASC2_MIN = 318.595833;
  static final double X70_EQUASC_MAX = 394.215000;
  static final double X70_EQUASC_MIN = 330.556667;
  static final double X70_HOUSE10_MAX = 394.215000;
  static final double X70_HOUSE10_MIN = 330.556667;
  static final double X70_HOUSE11_MAX = 394.215000;
  static final double X70_HOUSE11_MIN = 330.556667;
  static final double X70_HOUSE12_MAX = 394.215000;
  static final double X70_HOUSE12_MIN = 330.556667;
  static final double X70_HOUSE1_MAX = 394.215000;
  static final double X70_HOUSE1_MIN = 330.556667;
  static final double X70_HOUSE2_MAX = 394.215000;
  static final double X70_HOUSE2_MIN = 330.556667;
  static final double X70_HOUSE3_MAX = 394.215000;
  static final double X70_HOUSE3_MIN = 330.556667;
  static final double X70_HOUSE4_MAX = 394.215000;
  static final double X70_HOUSE4_MIN = 330.556667;
  static final double X70_HOUSE5_MAX = 394.215000;
  static final double X70_HOUSE5_MIN = 330.556667;
  static final double X70_HOUSE6_MAX = 394.215000;
  static final double X70_HOUSE6_MIN = 330.556667;
  static final double X70_HOUSE7_MAX = 394.215000;
  static final double X70_HOUSE7_MIN = 330.556667;
  static final double X70_HOUSE8_MAX = 394.215000;
  static final double X70_HOUSE8_MIN = 330.556667;
  static final double X70_HOUSE9_MAX = 394.215000;
  static final double X70_HOUSE9_MIN = 330.556667;
  static final double X70_MC_MAX = 394.215000;
  static final double X70_MC_MIN = 330.556667;
  static final double X70_POLASC_MAX = 2999820.000000;
  static final double X70_POLASC_MIN = -180.000000;
  static final double X70_VERTEX_MAX = 469.147500;
  static final double X70_VERTEX_MIN = 318.595833;
  static final double X80_ARMC_MAX = 360.986667;
  static final double X80_ARMC_MIN = 360.984167;
  static final double X80_ASC_MAX = 113.797795;
  static final double X80_ASC_MIN = -269.996070;
  static final double X80_COASC1_MAX = 2999820.000000;
  static final double X80_COASC1_MIN = -180.000000;
  static final double X80_COASC2_MAX = 427.276667;
  static final double X80_COASC2_MIN = 327.558333;
  static final double X80_EQUASC_MAX = 394.215000;
  static final double X80_EQUASC_MIN = 330.556667;
  static final double X80_HOUSE10_MAX = 394.215000;
  static final double X80_HOUSE10_MIN = 330.556667;
  static final double X80_HOUSE11_MAX = 394.215000;
  static final double X80_HOUSE11_MIN = 330.556667;
  static final double X80_HOUSE12_MAX = 394.215000;
  static final double X80_HOUSE12_MIN = 330.556667;
  static final double X80_HOUSE1_MAX = 394.215000;
  static final double X80_HOUSE1_MIN = 330.556667;
  static final double X80_HOUSE2_MAX = 394.215000;
  static final double X80_HOUSE2_MIN = 330.556667;
  static final double X80_HOUSE3_MAX = 394.215000;
  static final double X80_HOUSE3_MIN = 330.556667;
  static final double X80_HOUSE4_MAX = 394.215000;
  static final double X80_HOUSE4_MIN = 330.556667;
  static final double X80_HOUSE5_MAX = 394.215000;
  static final double X80_HOUSE5_MIN = 330.556667;
  static final double X80_HOUSE6_MAX = 394.215000;
  static final double X80_HOUSE6_MIN = 330.556667;
  static final double X80_HOUSE7_MAX = 394.215000;
  static final double X80_HOUSE7_MIN = 330.556667;
  static final double X80_HOUSE8_MAX = 394.215000;
  static final double X80_HOUSE8_MIN = 330.556667;
  static final double X80_HOUSE9_MAX = 394.215000;
  static final double X80_HOUSE9_MIN = 330.556667;
  static final double X80_MC_MAX = 394.215000;
  static final double X80_MC_MIN = 330.556667;
  static final double X80_POLASC_MAX = 2999820.000000;
  static final double X80_POLASC_MIN = -180.000000;
  static final double X80_VERTEX_MAX = 427.276667;
  static final double X80_VERTEX_MIN = 327.558333;
  static final double X85_ARMC_MAX = 360.986667;
  static final double X85_ARMC_MIN = 360.984167;
  static final double X85_ASC_MAX = 66.096028;
  static final double X85_ASC_MIN = -99.544650;
  static final double X85_COASC1_MAX = 2999901.836667;
  static final double X85_COASC1_MIN = -100.323333;
  static final double X85_COASC2_MAX = 409.954167;
  static final double X85_COASC2_MIN = 329.806667;
  static final double X85_EQUASC_MAX = 394.215000;
  static final double X85_EQUASC_MIN = 330.556667;
  static final double X85_HOUSE10_MAX = 394.215000;
  static final double X85_HOUSE10_MIN = 330.556667;
  static final double X85_HOUSE11_MAX = 394.215000;
  static final double X85_HOUSE11_MIN = 330.556667;
  static final double X85_HOUSE12_MAX = 394.215000;
  static final double X85_HOUSE12_MIN = 330.556667;
  static final double X85_HOUSE1_MAX = 394.215000;
  static final double X85_HOUSE1_MIN = 330.556667;
  static final double X85_HOUSE2_MAX = 394.215000;
  static final double X85_HOUSE2_MIN = 330.556667;
  static final double X85_HOUSE3_MAX = 394.215000;
  static final double X85_HOUSE3_MIN = 330.556667;
  static final double X85_HOUSE4_MAX = 394.215000;
  static final double X85_HOUSE4_MIN = 330.556667;
  static final double X85_HOUSE5_MAX = 394.215000;
  static final double X85_HOUSE5_MIN = 330.556667;
  static final double X85_HOUSE6_MAX = 394.215000;
  static final double X85_HOUSE6_MIN = 330.556667;
  static final double X85_HOUSE7_MAX = 394.215000;
  static final double X85_HOUSE7_MIN = 330.556667;
  static final double X85_HOUSE8_MAX = 394.215000;
  static final double X85_HOUSE8_MIN = 330.556667;
  static final double X85_HOUSE9_MAX = 394.215000;
  static final double X85_HOUSE9_MIN = 330.556667;
  static final double X85_MC_MAX = 394.215000;
  static final double X85_MC_MIN = 330.556667;
  static final double X85_POLASC_MAX = 66.413333;
  static final double X85_POLASC_MIN = -100.323333;
  static final double X85_VERTEX_MAX = 409.954167;
  static final double X85_VERTEX_MIN = 329.806667;
  static final double X88_ARMC_MAX = 360.985931;
  static final double X88_ARMC_MIN = 360.985828;
  static final double X88_ASC_MAX = 29.344231;
  static final double X88_ASC_MIN = -34.489311;
  static final double X88_COASC1_MAX = 1555165.554409;
  static final double X88_COASC1_MIN = -34.489296;
  static final double X88_COASC2_MAX = 399.547623;
  static final double X88_COASC2_MIN = 331.043079;
  static final double X88_EQUASC_MAX = 393.494420;
  static final double X88_EQUASC_MIN = 331.162937;
  static final double X88_HOUSE10_MAX = 393.494420;
  static final double X88_HOUSE10_MIN = 331.162936;
  static final double X88_HOUSE11_MAX = 393.494420;
  static final double X88_HOUSE11_MIN = 331.162936;
  static final double X88_HOUSE12_MAX = 393.494420;
  static final double X88_HOUSE12_MIN = 331.162937;
  static final double X88_HOUSE1_MAX = 393.494420;
  static final double X88_HOUSE1_MIN = 331.162937;
  static final double X88_HOUSE2_MAX = 393.494420;
  static final double X88_HOUSE2_MIN = 331.162937;
  static final double X88_HOUSE3_MAX = 393.494421;
  static final double X88_HOUSE3_MIN = 331.162936;
  static final double X88_HOUSE4_MAX = 393.494420;
  static final double X88_HOUSE4_MIN = 331.162936;
  static final double X88_HOUSE5_MAX = 393.494420;
  static final double X88_HOUSE5_MIN = 331.162936;
  static final double X88_HOUSE6_MAX = 393.494420;
  static final double X88_HOUSE6_MIN = 331.162937;
  static final double X88_HOUSE7_MAX = 393.494420;
  static final double X88_HOUSE7_MIN = 331.162937;
  static final double X88_HOUSE8_MAX = 393.494420;
  static final double X88_HOUSE8_MIN = 331.162937;
  static final double X88_HOUSE9_MAX = 393.494421;
  static final double X88_HOUSE9_MIN = 331.162936;
  static final double X88_MC_MAX = 393.494420;
  static final double X88_MC_MIN = 331.162936;
  static final double X88_POLASC_MAX = 29.344230;
  static final double X88_POLASC_MIN = -34.489313;
  static final double X88_VERTEX_MAX = 399.547621;
  static final double X88_VERTEX_MIN = 331.043081;
  static final double X89x_ARMC_MAX = 360.986667;
  static final double X89x_ARMC_MIN = 360.984167;
  static final double X89x_ASC_MAX = 0.000000;
  static final double X89x_ASC_MIN = -0.000000;
  static final double X89x_COASC1_MAX = 2999998.426667;
  static final double X89x_COASC1_MIN = -1.600833;
  static final double X89x_COASC2_MAX = 394.516667;
  static final double X89x_COASC2_MIN = 330.556667;
  static final double X89x_EQUASC_MAX = 394.215000;
  static final double X89x_EQUASC_MIN = 330.556667;
  static final double X89x_HOUSE10_MAX = 394.215000;
  static final double X89x_HOUSE10_MIN = 330.556667;
  static final double X89x_HOUSE11_MAX = 394.215000;
  static final double X89x_HOUSE11_MIN = 330.556667;
  static final double X89x_HOUSE12_MAX = 394.215000;
  static final double X89x_HOUSE12_MIN = 330.556667;
  static final double X89x_HOUSE1_MAX = 394.215000;
  static final double X89x_HOUSE1_MIN = 330.556667;
  static final double X89x_HOUSE2_MAX = 394.215000;
  static final double X89x_HOUSE2_MIN = 330.556667;
  static final double X89x_HOUSE3_MAX = 394.215000;
  static final double X89x_HOUSE3_MIN = 330.556667;
  static final double X89x_HOUSE4_MAX = 394.215000;
  static final double X89x_HOUSE4_MIN = 330.556667;
  static final double X89x_HOUSE5_MAX = 394.215000;
  static final double X89x_HOUSE5_MIN = 330.556667;
  static final double X89x_HOUSE6_MAX = 394.215000;
  static final double X89x_HOUSE6_MIN = 330.556667;
  static final double X89x_HOUSE7_MAX = 394.215000;
  static final double X89x_HOUSE7_MIN = 330.556667;
  static final double X89x_HOUSE8_MAX = 394.215000;
  static final double X89x_HOUSE8_MIN = 330.556667;
  static final double X89x_HOUSE9_MAX = 394.215000;
  static final double X89x_HOUSE9_MIN = 330.556667;
  static final double X89x_MC_MAX = 394.215000;
  static final double X89x_MC_MIN = 330.556667;
  static final double X89x_POLASC_MAX = 1.588333;
  static final double X89x_POLASC_MIN = -1.600833;
  static final double X89x_VERTEX_MAX = 394.516667;
  static final double X89x_VERTEX_MIN = 330.556667;




  // degrees per day
  static double getHouseSpeed(boolean min, int hsys, int object, double geolat) {
    int latrange = Math.abs((int)(geolat))+1;

    latrange = 10 + 10 * (int)(latrange/10);

    if (Math.abs(geolat) <= 66 && Math.abs(geolat) > 60) {
      latrange = 66;
    } else if (Math.abs(geolat) <= 85 && Math.abs(geolat) > 80) {
      latrange = 85;
    } else if (Math.abs(geolat) <= 88 && Math.abs(geolat) > 85) {
      latrange = 88;
    } else if (Math.abs(geolat) > 88) {
      latrange = 90;
    }

    if (object < 0) {	// cusps range from -1 to -12
      object = Math.abs(object) + 7;
    }

    switch(hsys) {
      case SweConst.SE_HSYS_PLACIDUS:
System.err.println("latrange: " + latrange + ", " + object + ", " + min + " [" + minLonP30[object] + " .. " + maxLonP30[object] + "]");
          switch(latrange) {
            case 10: return (min ? minLonP10[object] : maxLonP10[object]);
            case 20: return (min ? minLonP20[object] : maxLonP20[object]);
            case 30: return (min ? minLonP30[object] : maxLonP30[object]);
            case 40: return (min ? minLonP40[object] : maxLonP40[object]);
            case 50: return (min ? minLonP50[object] : maxLonP50[object]);
            case 60: return (min ? minLonP60[object] : maxLonP60[object]);
            case 66: return (min ? minLonP66[object] : maxLonP66[object]);
            case 70: return (min ? minLonP70[object] : maxLonP70[object]);
            case 80: return (min ? minLonP80[object] : maxLonP80[object]);
            case 85: return (min ? minLonP85[object] : maxLonP85[object]);
            case 88: return (min ? minLonP88[object] : maxLonP88[object]);
            case 90: return (min ? minLonP89x[object] : maxLonP89x[object]);
          }
      case SweConst.SE_HSYS_KOCH:
          switch(latrange) {
            case 10: return (min ? minLonK10[object] : maxLonK10[object]);
            case 20: return (min ? minLonK20[object] : maxLonK20[object]);
            case 30: return (min ? minLonK30[object] : maxLonK30[object]);
            case 40: return (min ? minLonK40[object] : maxLonK40[object]);
            case 50: return (min ? minLonK50[object] : maxLonK50[object]);
            case 60: return (min ? minLonK60[object] : maxLonK60[object]);
            case 66: return (min ? minLonK66[object] : maxLonK66[object]);
            case 70: return (min ? minLonK70[object] : maxLonK70[object]);
            case 80: return (min ? minLonK80[object] : maxLonK80[object]);
            case 85: return (min ? minLonK85[object] : maxLonK85[object]);
            case 88: return (min ? minLonK88[object] : maxLonK88[object]);
            case 90: return (min ? minLonK89x[object] : maxLonK89x[object]);
          }
      case SweConst.SE_HSYS_PORPHYRIUS:
          switch(latrange) {
            case 10: return (min ? minLonO10[object] : maxLonO10[object]);
            case 20: return (min ? minLonO20[object] : maxLonO20[object]);
            case 30: return (min ? minLonO30[object] : maxLonO30[object]);
            case 40: return (min ? minLonO40[object] : maxLonO40[object]);
            case 50: return (min ? minLonO50[object] : maxLonO50[object]);
            case 60: return (min ? minLonO60[object] : maxLonO60[object]);
            case 66: return (min ? minLonO66[object] : maxLonO66[object]);
            case 70: return (min ? minLonO70[object] : maxLonO70[object]);
            case 80: return (min ? minLonO80[object] : maxLonO80[object]);
            case 85: return (min ? minLonO85[object] : maxLonO85[object]);
            case 88: return (min ? minLonO88[object] : maxLonO88[object]);
            case 90: return (min ? minLonO89x[object] : maxLonO89x[object]);
          }
      case SweConst.SE_HSYS_REGIOMONTANUS:
          switch(latrange) {
            case 10: return (min ? minLonR10[object] : maxLonR10[object]);
            case 20: return (min ? minLonR20[object] : maxLonR20[object]);
            case 30: return (min ? minLonR30[object] : maxLonR30[object]);
            case 40: return (min ? minLonR40[object] : maxLonR40[object]);
            case 50: return (min ? minLonR50[object] : maxLonR50[object]);
            case 60: return (min ? minLonR60[object] : maxLonR60[object]);
            case 66: return (min ? minLonR66[object] : maxLonR66[object]);
            case 70: return (min ? minLonR70[object] : maxLonR70[object]);
            case 80: return (min ? minLonR80[object] : maxLonR80[object]);
            case 85: return (min ? minLonR85[object] : maxLonR85[object]);
            case 88: return (min ? minLonR88[object] : maxLonR88[object]);
            case 90: return (min ? minLonR89x[object] : maxLonR89x[object]);
          }
      case SweConst.SE_HSYS_CAMPANUS:
          switch(latrange) {
            case 10: return (min ? minLonC10[object] : maxLonC10[object]);
            case 20: return (min ? minLonC20[object] : maxLonC20[object]);
            case 30: return (min ? minLonC30[object] : maxLonC30[object]);
            case 40: return (min ? minLonC40[object] : maxLonC40[object]);
            case 50: return (min ? minLonC50[object] : maxLonC50[object]);
            case 60: return (min ? minLonC60[object] : maxLonC60[object]);
            case 66: return (min ? minLonC66[object] : maxLonC66[object]);
            case 70: return (min ? minLonC70[object] : maxLonC70[object]);
            case 80: return (min ? minLonC80[object] : maxLonC80[object]);
            case 85: return (min ? minLonC85[object] : maxLonC85[object]);
            case 88: return (min ? minLonC88[object] : maxLonC88[object]);
            case 90: return (min ? minLonC89x[object] : maxLonC89x[object]);
          }
      case SweConst.SE_HSYS_EQUAL:
          switch(latrange) {
            case 10: return (min ? minLonE10[object] : maxLonE10[object]);
            case 20: return (min ? minLonE20[object] : maxLonE20[object]);
            case 30: return (min ? minLonE30[object] : maxLonE30[object]);
            case 40: return (min ? minLonE40[object] : maxLonE40[object]);
            case 50: return (min ? minLonE50[object] : maxLonE50[object]);
            case 60: return (min ? minLonE60[object] : maxLonE60[object]);
            case 66: return (min ? minLonE66[object] : maxLonE66[object]);
            case 70: return (min ? minLonE70[object] : maxLonE70[object]);
            case 80: return (min ? minLonE80[object] : maxLonE80[object]);
            case 85: return (min ? minLonE85[object] : maxLonE85[object]);
            case 88: return (min ? minLonE88[object] : maxLonE88[object]);
            case 90: return (min ? minLonE89x[object] : maxLonE89x[object]);
          }
      case SweConst.SE_HSYS_VEHLOW:
          switch(latrange) {
            case 10: return (min ? minLonV10[object] : maxLonV10[object]);
            case 20: return (min ? minLonV20[object] : maxLonV20[object]);
            case 30: return (min ? minLonV30[object] : maxLonV30[object]);
            case 40: return (min ? minLonV40[object] : maxLonV40[object]);
            case 50: return (min ? minLonV50[object] : maxLonV50[object]);
            case 60: return (min ? minLonV60[object] : maxLonV60[object]);
            case 66: return (min ? minLonV66[object] : maxLonV66[object]);
            case 70: return (min ? minLonV70[object] : maxLonV70[object]);
            case 80: return (min ? minLonV80[object] : maxLonV80[object]);
            case 85: return (min ? minLonV85[object] : maxLonV85[object]);
            case 88: return (min ? minLonV88[object] : maxLonV88[object]);
            case 90: return (min ? minLonV89x[object] : maxLonV89x[object]);
          }
      case SweConst.SE_HSYS_MERIDIAN:
          switch(latrange) {
            case 10: return (min ? minLonX10[object] : maxLonX10[object]);
            case 20: return (min ? minLonX20[object] : maxLonX20[object]);
            case 30: return (min ? minLonX30[object] : maxLonX30[object]);
            case 40: return (min ? minLonX40[object] : maxLonX40[object]);
            case 50: return (min ? minLonX50[object] : maxLonX50[object]);
            case 60: return (min ? minLonX60[object] : maxLonX60[object]);
            case 66: return (min ? minLonX66[object] : maxLonX66[object]);
            case 70: return (min ? minLonX70[object] : maxLonX70[object]);
            case 80: return (min ? minLonX80[object] : maxLonX80[object]);
            case 85: return (min ? minLonX85[object] : maxLonX85[object]);
            case 88: return (min ? minLonX88[object] : maxLonX88[object]);
            case 90: return (min ? minLonX89x[object] : maxLonX89x[object]);
          }
      case SweConst.SE_HSYS_HORIZONTAL:
          switch(latrange) {
            case 10: return (min ? minLonH10[object] : maxLonH10[object]);
            case 20: return (min ? minLonH20[object] : maxLonH20[object]);
            case 30: return (min ? minLonH30[object] : maxLonH30[object]);
            case 40: return (min ? minLonH40[object] : maxLonH40[object]);
            case 50: return (min ? minLonH50[object] : maxLonH50[object]);
            case 60: return (min ? minLonH60[object] : maxLonH60[object]);
            case 66: return (min ? minLonH66[object] : maxLonH66[object]);
            case 70: return (min ? minLonH70[object] : maxLonH70[object]);
            case 80: return (min ? minLonH80[object] : maxLonH80[object]);
            case 85: return (min ? minLonH85[object] : maxLonH85[object]);
            case 88: return (min ? minLonH88[object] : maxLonH88[object]);
            case 90: return (min ? minLonH89x[object] : maxLonH89x[object]);
          }
      case SweConst.SE_HSYS_POLICH_PAGE:
          switch(latrange) {
            case 10: return (min ? minLonT10[object] : maxLonT10[object]);
            case 20: return (min ? minLonT20[object] : maxLonT20[object]);
            case 30: return (min ? minLonT30[object] : maxLonT30[object]);
            case 40: return (min ? minLonT40[object] : maxLonT40[object]);
            case 50: return (min ? minLonT50[object] : maxLonT50[object]);
            case 60: return (min ? minLonT60[object] : maxLonT60[object]);
            case 66: return (min ? minLonT66[object] : maxLonT66[object]);
            case 70: return (min ? minLonT70[object] : maxLonT70[object]);
            case 80: return (min ? minLonT80[object] : maxLonT80[object]);
            case 85: return (min ? minLonT85[object] : maxLonT85[object]);
            case 88: return (min ? minLonT88[object] : maxLonT88[object]);
            case 90: return (min ? minLonT89x[object] : maxLonT89x[object]);
          }
      case SweConst.SE_HSYS_ALCABITIUS:
          switch(latrange) {
            case 10: return (min ? minLonB10[object] : maxLonB10[object]);
            case 20: return (min ? minLonB20[object] : maxLonB20[object]);
            case 30: return (min ? minLonB30[object] : maxLonB30[object]);
            case 40: return (min ? minLonB40[object] : maxLonB40[object]);
            case 50: return (min ? minLonB50[object] : maxLonB50[object]);
            case 60: return (min ? minLonB60[object] : maxLonB60[object]);
            case 66: return (min ? minLonB66[object] : maxLonB66[object]);
            case 70: return (min ? minLonB70[object] : maxLonB70[object]);
            case 80: return (min ? minLonB80[object] : maxLonB80[object]);
            case 85: return (min ? minLonB85[object] : maxLonB85[object]);
            case 88: return (min ? minLonB88[object] : maxLonB88[object]);
            case 90: return (min ? minLonB89x[object] : maxLonB89x[object]);
          }
//      case SweConst.SE_HSYS_GAUQUELIN_SECTORS:
//          switch(latrange) {
//            case 10: return (min ? minLonG10[object] : maxLonG10[object]);
//            case 20: return (min ? minLonG20[object] : maxLonG20[object]);
//            case 30: return (min ? minLonG30[object] : maxLonG30[object]);
//            case 40: return (min ? minLonG40[object] : maxLonG40[object]);
//            case 50: return (min ? minLonG50[object] : maxLonG50[object]);
//            case 60: return (min ? minLonG60[object] : maxLonG60[object]);
//            case 66: return (min ? minLonG66[object] : maxLonG66[object]);
//            case 70: return (min ? minLonG70[object] : maxLonG70[object]);
//            case 80: return (min ? minLonG80[object] : maxLonG80[object]);
//            case 85: return (min ? minLonG85[object] : maxLonG85[object]);
//            case 88: return (min ? minLonG88[object] : maxLonG88[object]);
//            case 90: return (min ? minLonG89x[object] : maxLonG89x[object]);
//          }
//      case SweConst.SE_HSYS_MORINUS:
//          switch(latrange) {
//            case 10: return (min ? minLonM10[object] : maxLonM10[object]);
//            case 20: return (min ? minLonM20[object] : maxLonM20[object]);
//            case 30: return (min ? minLonM30[object] : maxLonM30[object]);
//            case 40: return (min ? minLonM40[object] : maxLonM40[object]);
//            case 50: return (min ? minLonM50[object] : maxLonM50[object]);
//            case 60: return (min ? minLonM60[object] : maxLonM60[object]);
//            case 66: return (min ? minLonM66[object] : maxLonM66[object]);
//            case 70: return (min ? minLonM70[object] : maxLonM70[object]);
//            case 80: return (min ? minLonM80[object] : maxLonM80[object]);
//            case 85: return (min ? minLonM85[object] : maxLonM85[object]);
//            case 88: return (min ? minLonM88[object] : maxLonM88[object]);
//            case 90: return (min ? minLonM89x[object] : maxLonM89x[object]);
//          }
//      case SweConst.SE_HSYS_KRUSINSKI:
//          switch(latrange) {
//            case 10: return (min ? minLonU10[object] : maxLonU10[object]);
//            case 20: return (min ? minLonU20[object] : maxLonU20[object]);
//            case 30: return (min ? minLonU30[object] : maxLonU30[object]);
//            case 40: return (min ? minLonU40[object] : maxLonU40[object]);
//            case 50: return (min ? minLonU50[object] : maxLonU50[object]);
//            case 60: return (min ? minLonU60[object] : maxLonU60[object]);
//            case 66: return (min ? minLonU66[object] : maxLonU66[object]);
//            case 70: return (min ? minLonU70[object] : maxLonU70[object]);
//            case 80: return (min ? minLonU80[object] : maxLonU80[object]);
//            case 85: return (min ? minLonU85[object] : maxLonU85[object]);
//            case 88: return (min ? minLonU88[object] : maxLonU88[object]);
//            case 90: return (min ? minLonU89x[object] : maxLonU89x[object]);
//          }
//      case SweConst.SE_HSYS_WHOLE_SIGN:
//          switch(latrange) {
//            case 10: return (min ? minLonW10[object] : maxLonW10[object]);
//            case 20: return (min ? minLonW20[object] : maxLonW20[object]);
//            case 30: return (min ? minLonW30[object] : maxLonW30[object]);
//            case 40: return (min ? minLonW40[object] : maxLonW40[object]);
//            case 50: return (min ? minLonW50[object] : maxLonW50[object]);
//            case 60: return (min ? minLonW60[object] : maxLonW60[object]);
//            case 66: return (min ? minLonW66[object] : maxLonW66[object]);
//            case 70: return (min ? minLonW70[object] : maxLonW70[object]);
//            case 80: return (min ? minLonW80[object] : maxLonW80[object]);
//            case 85: return (min ? minLonW85[object] : maxLonW85[object]);
//            case 88: return (min ? minLonW88[object] : maxLonW88[object]);
//            case 90: return (min ? minLonW89x[object] : maxLonW89x[object]);
//          }
    }
    return (min ? 3200 : 4000); 	// Some default value - whatever
  }
// Speeds:
//  'P'  Placidus
//  'K'  Koch
//  'O'  Porphyrius
//  'R'  Regiomontanus
//  'C'  Campanus
//  'A', 'E'  equal (cusp 1 is ascendant)
//  'V'  Vehlow equal (asc. in middle of house 1)
//  'X'  axial rotation system/ Meridian houses
//  'H'  azimuthal or horizontal system
//  'T'  Polich/Page ('topocentric' system)
//  'B'  Alcabitius
  // Array:
  //  0: SE_ASC
  //  1: SE_MC
  //  2: SE_ARMC
  //  3: SE_VERTEX
  //  4: SE_EQUASC
  //  5: SE_COASC1
  //  6: SE_COASC2
  //  7: SE_POLASC
  //  8: SE_HOUSE1 [-1]
  //  ...
  // 19: SE_HOUSE12 [-12]
  static final double[] minLonP10 = new double[]
      {P10_ASC_MIN,    P10_MC_MIN,      P10_ARMC_MIN,    P10_VERTEX_MIN,
       P10_EQUASC_MIN, P10_COASC1_MIN,  P10_COASC2_MIN,  P10_POLASC_MIN,
       P10_HOUSE1_MIN, P10_HOUSE2_MIN,  P10_HOUSE3_MIN,  P10_HOUSE4_MIN,
       P10_HOUSE5_MIN, P10_HOUSE6_MIN,  P10_HOUSE7_MIN,  P10_HOUSE8_MIN,
       P10_HOUSE9_MIN, P10_HOUSE10_MIN, P10_HOUSE11_MIN, P10_HOUSE12_MIN};
  static final double[] maxLonP10 = new double[]
      {P10_ASC_MAX,    P10_MC_MAX,      P10_ARMC_MAX,    P10_VERTEX_MAX,
       P10_EQUASC_MAX, P10_COASC1_MAX,  P10_COASC2_MAX,  P10_POLASC_MAX,
       P10_HOUSE1_MAX, P10_HOUSE2_MAX,  P10_HOUSE3_MAX,  P10_HOUSE4_MAX,
       P10_HOUSE5_MAX, P10_HOUSE6_MAX,  P10_HOUSE7_MAX,  P10_HOUSE8_MAX,
       P10_HOUSE9_MAX, P10_HOUSE10_MAX, P10_HOUSE11_MAX, P10_HOUSE12_MAX};
  static final double[] minLonP20 = new double[]
      {P20_ASC_MIN,    P20_MC_MIN,      P20_ARMC_MIN,    P20_VERTEX_MIN,
       P20_EQUASC_MIN, P20_COASC1_MIN,  P20_COASC2_MIN,  P20_POLASC_MIN,
       P20_HOUSE1_MIN, P20_HOUSE2_MIN,  P20_HOUSE3_MIN,  P20_HOUSE4_MIN,
       P20_HOUSE5_MIN, P20_HOUSE6_MIN,  P20_HOUSE7_MIN,  P20_HOUSE8_MIN,
       P20_HOUSE9_MIN, P20_HOUSE10_MIN, P20_HOUSE11_MIN, P20_HOUSE12_MIN};
  static final double[] maxLonP20 = new double[]
      {P20_ASC_MAX,    P20_MC_MAX,      P20_ARMC_MAX,    P20_VERTEX_MAX,
       P20_EQUASC_MAX, P20_COASC1_MAX,  P20_COASC2_MAX,  P20_POLASC_MAX,
       P20_HOUSE1_MAX, P20_HOUSE2_MAX,  P20_HOUSE3_MAX,  P20_HOUSE4_MAX,
       P20_HOUSE5_MAX, P20_HOUSE6_MAX,  P20_HOUSE7_MAX,  P20_HOUSE8_MAX,
       P20_HOUSE9_MAX, P20_HOUSE10_MAX, P20_HOUSE11_MAX, P20_HOUSE12_MAX};
  static final double[] minLonP30 = new double[]
      {P30_ASC_MIN,    P30_MC_MIN,      P30_ARMC_MIN,    P30_VERTEX_MIN,
       P30_EQUASC_MIN, P30_COASC1_MIN,  P30_COASC2_MIN,  P30_POLASC_MIN,
       P30_HOUSE1_MIN, P30_HOUSE2_MIN,  P30_HOUSE3_MIN,  P30_HOUSE4_MIN,
       P30_HOUSE5_MIN, P30_HOUSE6_MIN,  P30_HOUSE7_MIN,  P30_HOUSE8_MIN,
       P30_HOUSE9_MIN, P30_HOUSE10_MIN, P30_HOUSE11_MIN, P30_HOUSE12_MIN};
  static final double[] maxLonP30 = new double[]
      {P30_ASC_MAX,    P30_MC_MAX,      P30_ARMC_MAX,    P30_VERTEX_MAX,
       P30_EQUASC_MAX, P30_COASC1_MAX,  P30_COASC2_MAX,  P30_POLASC_MAX,
       P30_HOUSE1_MAX, P30_HOUSE2_MAX,  P30_HOUSE3_MAX,  P30_HOUSE4_MAX,
       P30_HOUSE5_MAX, P30_HOUSE6_MAX,  P30_HOUSE7_MAX,  P30_HOUSE8_MAX,
       P30_HOUSE9_MAX, P30_HOUSE10_MAX, P30_HOUSE11_MAX, P30_HOUSE12_MAX};
  static final double[] minLonP40 = new double[]
      {P40_ASC_MIN,    P40_MC_MIN,      P40_ARMC_MIN,    P40_VERTEX_MIN,
       P40_EQUASC_MIN, P40_COASC1_MIN,  P40_COASC2_MIN,  P40_POLASC_MIN,
       P40_HOUSE1_MIN, P40_HOUSE2_MIN,  P40_HOUSE3_MIN,  P40_HOUSE4_MIN,
       P40_HOUSE5_MIN, P40_HOUSE6_MIN,  P40_HOUSE7_MIN,  P40_HOUSE8_MIN,
       P40_HOUSE9_MIN, P40_HOUSE10_MIN, P40_HOUSE11_MIN, P40_HOUSE12_MIN};
  static final double[] maxLonP40 = new double[]
      {P40_ASC_MAX,    P40_MC_MAX,      P40_ARMC_MAX,    P40_VERTEX_MAX,
       P40_EQUASC_MAX, P40_COASC1_MAX,  P40_COASC2_MAX,  P40_POLASC_MAX,
       P40_HOUSE1_MAX, P40_HOUSE2_MAX,  P40_HOUSE3_MAX,  P40_HOUSE4_MAX,
       P40_HOUSE5_MAX, P40_HOUSE6_MAX,  P40_HOUSE7_MAX,  P40_HOUSE8_MAX,
       P40_HOUSE9_MAX, P40_HOUSE10_MAX, P40_HOUSE11_MAX, P40_HOUSE12_MAX};
  static final double[] minLonP50 = new double[]
      {P50_ASC_MIN,    P50_MC_MIN,      P50_ARMC_MIN,    P50_VERTEX_MIN,
       P50_EQUASC_MIN, P50_COASC1_MIN,  P50_COASC2_MIN,  P50_POLASC_MIN,
       P50_HOUSE1_MIN, P50_HOUSE2_MIN,  P50_HOUSE3_MIN,  P50_HOUSE4_MIN,
       P50_HOUSE5_MIN, P50_HOUSE6_MIN,  P50_HOUSE7_MIN,  P50_HOUSE8_MIN,
       P50_HOUSE9_MIN, P50_HOUSE10_MIN, P50_HOUSE11_MIN, P50_HOUSE12_MIN};
  static final double[] maxLonP50 = new double[]
      {P50_ASC_MAX,    P50_MC_MAX,      P50_ARMC_MAX,    P50_VERTEX_MAX,
       P50_EQUASC_MAX, P50_COASC1_MAX,  P50_COASC2_MAX,  P50_POLASC_MAX,
       P50_HOUSE1_MAX, P50_HOUSE2_MAX,  P50_HOUSE3_MAX,  P50_HOUSE4_MAX,
       P50_HOUSE5_MAX, P50_HOUSE6_MAX,  P50_HOUSE7_MAX,  P50_HOUSE8_MAX,
       P50_HOUSE9_MAX, P50_HOUSE10_MAX, P50_HOUSE11_MAX, P50_HOUSE12_MAX};
  static final double[] minLonP60 = new double[]
      {P60_ASC_MIN,    P60_MC_MIN,      P60_ARMC_MIN,    P60_VERTEX_MIN,
       P60_EQUASC_MIN, P60_COASC1_MIN,  P60_COASC2_MIN,  P60_POLASC_MIN,
       P60_HOUSE1_MIN, P60_HOUSE2_MIN,  P60_HOUSE3_MIN,  P60_HOUSE4_MIN,
       P60_HOUSE5_MIN, P60_HOUSE6_MIN,  P60_HOUSE7_MIN,  P60_HOUSE8_MIN,
       P60_HOUSE9_MIN, P60_HOUSE10_MIN, P60_HOUSE11_MIN, P60_HOUSE12_MIN};
  static final double[] maxLonP60 = new double[]
      {P60_ASC_MAX,    P60_MC_MAX,      P60_ARMC_MAX,    P60_VERTEX_MAX,
       P60_EQUASC_MAX, P60_COASC1_MAX,  P60_COASC2_MAX,  P60_POLASC_MAX,
       P60_HOUSE1_MAX, P60_HOUSE2_MAX,  P60_HOUSE3_MAX,  P60_HOUSE4_MAX,
       P60_HOUSE5_MAX, P60_HOUSE6_MAX,  P60_HOUSE7_MAX,  P60_HOUSE8_MAX,
       P60_HOUSE9_MAX, P60_HOUSE10_MAX, P60_HOUSE11_MAX, P60_HOUSE12_MAX};
  static final double[] minLonP66 = new double[]
      {P66_ASC_MIN,    P66_MC_MIN,      P66_ARMC_MIN,    P66_VERTEX_MIN,
       P66_EQUASC_MIN, P66_COASC1_MIN,  P66_COASC2_MIN,  P66_POLASC_MIN,
       P66_HOUSE1_MIN, P66_HOUSE2_MIN,  P66_HOUSE3_MIN,  P66_HOUSE4_MIN,
       P66_HOUSE5_MIN, P66_HOUSE6_MIN,  P66_HOUSE7_MIN,  P66_HOUSE8_MIN,
       P66_HOUSE9_MIN, P66_HOUSE10_MIN, P66_HOUSE11_MIN, P66_HOUSE12_MIN};
  static final double[] maxLonP66 = new double[]
      {P66_ASC_MAX,    P66_MC_MAX,      P66_ARMC_MAX,    P66_VERTEX_MAX,
       P66_EQUASC_MAX, P66_COASC1_MAX,  P66_COASC2_MAX,  P66_POLASC_MAX,
       P66_HOUSE1_MAX, P66_HOUSE2_MAX,  P66_HOUSE3_MAX,  P66_HOUSE4_MAX,
       P66_HOUSE5_MAX, P66_HOUSE6_MAX,  P66_HOUSE7_MAX,  P66_HOUSE8_MAX,
       P66_HOUSE9_MAX, P66_HOUSE10_MAX, P66_HOUSE11_MAX, P66_HOUSE12_MAX};
  static final double[] minLonP70 = new double[]
      {P70_ASC_MIN,    P70_MC_MIN,      P70_ARMC_MIN,    P70_VERTEX_MIN,
       P70_EQUASC_MIN, P70_COASC1_MIN,  P70_COASC2_MIN,  P70_POLASC_MIN,
       P70_HOUSE1_MIN, P70_HOUSE2_MIN,  P70_HOUSE3_MIN,  P70_HOUSE4_MIN,
       P70_HOUSE5_MIN, P70_HOUSE6_MIN,  P70_HOUSE7_MIN,  P70_HOUSE8_MIN,
       P70_HOUSE9_MIN, P70_HOUSE10_MIN, P70_HOUSE11_MIN, P70_HOUSE12_MIN};
  static final double[] maxLonP70 = new double[]
      {P70_ASC_MAX,    P70_MC_MAX,      P70_ARMC_MAX,    P70_VERTEX_MAX,
       P70_EQUASC_MAX, P70_COASC1_MAX,  P70_COASC2_MAX,  P70_POLASC_MAX,
       P70_HOUSE1_MAX, P70_HOUSE2_MAX,  P70_HOUSE3_MAX,  P70_HOUSE4_MAX,
       P70_HOUSE5_MAX, P70_HOUSE6_MAX,  P70_HOUSE7_MAX,  P70_HOUSE8_MAX,
       P70_HOUSE9_MAX, P70_HOUSE10_MAX, P70_HOUSE11_MAX, P70_HOUSE12_MAX};
  static final double[] minLonP80 = new double[]
      {P80_ASC_MIN,    P80_MC_MIN,      P80_ARMC_MIN,    P80_VERTEX_MIN,
       P80_EQUASC_MIN, P80_COASC1_MIN,  P80_COASC2_MIN,  P80_POLASC_MIN,
       P80_HOUSE1_MIN, P80_HOUSE2_MIN,  P80_HOUSE3_MIN,  P80_HOUSE4_MIN,
       P80_HOUSE5_MIN, P80_HOUSE6_MIN,  P80_HOUSE7_MIN,  P80_HOUSE8_MIN,
       P80_HOUSE9_MIN, P80_HOUSE10_MIN, P80_HOUSE11_MIN, P80_HOUSE12_MIN};
  static final double[] maxLonP80 = new double[]
      {P80_ASC_MAX,    P80_MC_MAX,      P80_ARMC_MAX,    P80_VERTEX_MAX,
       P80_EQUASC_MAX, P80_COASC1_MAX,  P80_COASC2_MAX,  P80_POLASC_MAX,
       P80_HOUSE1_MAX, P80_HOUSE2_MAX,  P80_HOUSE3_MAX,  P80_HOUSE4_MAX,
       P80_HOUSE5_MAX, P80_HOUSE6_MAX,  P80_HOUSE7_MAX,  P80_HOUSE8_MAX,
       P80_HOUSE9_MAX, P80_HOUSE10_MAX, P80_HOUSE11_MAX, P80_HOUSE12_MAX};
  static final double[] minLonP85 = new double[]
      {P85_ASC_MIN,    P85_MC_MIN,      P85_ARMC_MIN,    P85_VERTEX_MIN,
       P85_EQUASC_MIN, P85_COASC1_MIN,  P85_COASC2_MIN,  P85_POLASC_MIN,
       P85_HOUSE1_MIN, P85_HOUSE2_MIN,  P85_HOUSE3_MIN,  P85_HOUSE4_MIN,
       P85_HOUSE5_MIN, P85_HOUSE6_MIN,  P85_HOUSE7_MIN,  P85_HOUSE8_MIN,
       P85_HOUSE9_MIN, P85_HOUSE10_MIN, P85_HOUSE11_MIN, P85_HOUSE12_MIN};
  static final double[] maxLonP85 = new double[]
      {P85_ASC_MAX,    P85_MC_MAX,      P85_ARMC_MAX,    P85_VERTEX_MAX,
       P85_EQUASC_MAX, P85_COASC1_MAX,  P85_COASC2_MAX,  P85_POLASC_MAX,
       P85_HOUSE1_MAX, P85_HOUSE2_MAX,  P85_HOUSE3_MAX,  P85_HOUSE4_MAX,
       P85_HOUSE5_MAX, P85_HOUSE6_MAX,  P85_HOUSE7_MAX,  P85_HOUSE8_MAX,
       P85_HOUSE9_MAX, P85_HOUSE10_MAX, P85_HOUSE11_MAX, P85_HOUSE12_MAX};
  static final double[] minLonP88 = new double[]
      {P88_ASC_MIN,    P88_MC_MIN,      P88_ARMC_MIN,    P88_VERTEX_MIN,
       P88_EQUASC_MIN, P88_COASC1_MIN,  P88_COASC2_MIN,  P88_POLASC_MIN,
       P88_HOUSE1_MIN, P88_HOUSE2_MIN,  P88_HOUSE3_MIN,  P88_HOUSE4_MIN,
       P88_HOUSE5_MIN, P88_HOUSE6_MIN,  P88_HOUSE7_MIN,  P88_HOUSE8_MIN,
       P88_HOUSE9_MIN, P88_HOUSE10_MIN, P88_HOUSE11_MIN, P88_HOUSE12_MIN};
  static final double[] maxLonP88 = new double[]
      {P88_ASC_MAX,    P88_MC_MAX,      P88_ARMC_MAX,    P88_VERTEX_MAX,
       P88_EQUASC_MAX, P88_COASC1_MAX,  P88_COASC2_MAX,  P88_POLASC_MAX,
       P88_HOUSE1_MAX, P88_HOUSE2_MAX,  P88_HOUSE3_MAX,  P88_HOUSE4_MAX,
       P88_HOUSE5_MAX, P88_HOUSE6_MAX,  P88_HOUSE7_MAX,  P88_HOUSE8_MAX,
       P88_HOUSE9_MAX, P88_HOUSE10_MAX, P88_HOUSE11_MAX, P88_HOUSE12_MAX};
  static final double[] minLonP89x = new double[]
      {P89x_ASC_MIN,    P89x_MC_MIN,      P89x_ARMC_MIN,    P89x_VERTEX_MIN,
       P89x_EQUASC_MIN, P89x_COASC1_MIN,  P89x_COASC2_MIN,  P89x_POLASC_MIN,
       P89x_HOUSE1_MIN, P89x_HOUSE2_MIN,  P89x_HOUSE3_MIN,  P89x_HOUSE4_MIN,
       P89x_HOUSE5_MIN, P89x_HOUSE6_MIN,  P89x_HOUSE7_MIN,  P89x_HOUSE8_MIN,
       P89x_HOUSE9_MIN, P89x_HOUSE10_MIN, P89x_HOUSE11_MIN, P89x_HOUSE12_MIN};
  static final double[] maxLonP89x = new double[]
      {P89x_ASC_MAX,    P89x_MC_MAX,      P89x_ARMC_MAX,    P89x_VERTEX_MAX,
       P89x_EQUASC_MAX, P89x_COASC1_MAX,  P89x_COASC2_MAX,  P89x_POLASC_MAX,
       P89x_HOUSE1_MAX, P89x_HOUSE2_MAX,  P89x_HOUSE3_MAX,  P89x_HOUSE4_MAX,
       P89x_HOUSE5_MAX, P89x_HOUSE6_MAX,  P89x_HOUSE7_MAX,  P89x_HOUSE8_MAX,
       P89x_HOUSE9_MAX, P89x_HOUSE10_MAX, P89x_HOUSE11_MAX, P89x_HOUSE12_MAX};

  static final double[] minLonK10 = new double[]
      {K10_ASC_MIN,    K10_MC_MIN,      K10_ARMC_MIN,    K10_VERTEX_MIN,
       K10_EQUASC_MIN, K10_COASC1_MIN,  K10_COASC2_MIN,  K10_POLASC_MIN,
       K10_HOUSE1_MIN, K10_HOUSE2_MIN,  K10_HOUSE3_MIN,  K10_HOUSE4_MIN,
       K10_HOUSE5_MIN, K10_HOUSE6_MIN,  K10_HOUSE7_MIN,  K10_HOUSE8_MIN,
       K10_HOUSE9_MIN, K10_HOUSE10_MIN, K10_HOUSE11_MIN, K10_HOUSE12_MIN};
  static final double[] maxLonK10 = new double[]
      {K10_ASC_MAX,    K10_MC_MAX,      K10_ARMC_MAX,    K10_VERTEX_MAX,
       K10_EQUASC_MAX, K10_COASC1_MAX,  K10_COASC2_MAX,  K10_POLASC_MAX,
       K10_HOUSE1_MAX, K10_HOUSE2_MAX,  K10_HOUSE3_MAX,  K10_HOUSE4_MAX,
       K10_HOUSE5_MAX, K10_HOUSE6_MAX,  K10_HOUSE7_MAX,  K10_HOUSE8_MAX,
       K10_HOUSE9_MAX, K10_HOUSE10_MAX, K10_HOUSE11_MAX, K10_HOUSE12_MAX};
  static final double[] minLonK20 = new double[]
      {K20_ASC_MIN,    K20_MC_MIN,      K20_ARMC_MIN,    K20_VERTEX_MIN,
       K20_EQUASC_MIN, K20_COASC1_MIN,  K20_COASC2_MIN,  K20_POLASC_MIN,
       K20_HOUSE1_MIN, K20_HOUSE2_MIN,  K20_HOUSE3_MIN,  K20_HOUSE4_MIN,
       K20_HOUSE5_MIN, K20_HOUSE6_MIN,  K20_HOUSE7_MIN,  K20_HOUSE8_MIN,
       K20_HOUSE9_MIN, K20_HOUSE10_MIN, K20_HOUSE11_MIN, K20_HOUSE12_MIN};
  static final double[] maxLonK20 = new double[]
      {K20_ASC_MAX,    K20_MC_MAX,      K20_ARMC_MAX,    K20_VERTEX_MAX,
       K20_EQUASC_MAX, K20_COASC1_MAX,  K20_COASC2_MAX,  K20_POLASC_MAX,
       K20_HOUSE1_MAX, K20_HOUSE2_MAX,  K20_HOUSE3_MAX,  K20_HOUSE4_MAX,
       K20_HOUSE5_MAX, K20_HOUSE6_MAX,  K20_HOUSE7_MAX,  K20_HOUSE8_MAX,
       K20_HOUSE9_MAX, K20_HOUSE10_MAX, K20_HOUSE11_MAX, K20_HOUSE12_MAX};
  static final double[] minLonK30 = new double[]
      {K30_ASC_MIN,    K30_MC_MIN,      K30_ARMC_MIN,    K30_VERTEX_MIN,
       K30_EQUASC_MIN, K30_COASC1_MIN,  K30_COASC2_MIN,  K30_POLASC_MIN,
       K30_HOUSE1_MIN, K30_HOUSE2_MIN,  K30_HOUSE3_MIN,  K30_HOUSE4_MIN,
       K30_HOUSE5_MIN, K30_HOUSE6_MIN,  K30_HOUSE7_MIN,  K30_HOUSE8_MIN,
       K30_HOUSE9_MIN, K30_HOUSE10_MIN, K30_HOUSE11_MIN, K30_HOUSE12_MIN};
  static final double[] maxLonK30 = new double[]
      {K30_ASC_MAX,    K30_MC_MAX,      K30_ARMC_MAX,    K30_VERTEX_MAX,
       K30_EQUASC_MAX, K30_COASC1_MAX,  K30_COASC2_MAX,  K30_POLASC_MAX,
       K30_HOUSE1_MAX, K30_HOUSE2_MAX,  K30_HOUSE3_MAX,  K30_HOUSE4_MAX,
       K30_HOUSE5_MAX, K30_HOUSE6_MAX,  K30_HOUSE7_MAX,  K30_HOUSE8_MAX,
       K30_HOUSE9_MAX, K30_HOUSE10_MAX, K30_HOUSE11_MAX, K30_HOUSE12_MAX};
  static final double[] minLonK40 = new double[]
      {K40_ASC_MIN,    K40_MC_MIN,      K40_ARMC_MIN,    K40_VERTEX_MIN,
       K40_EQUASC_MIN, K40_COASC1_MIN,  K40_COASC2_MIN,  K40_POLASC_MIN,
       K40_HOUSE1_MIN, K40_HOUSE2_MIN,  K40_HOUSE3_MIN,  K40_HOUSE4_MIN,
       K40_HOUSE5_MIN, K40_HOUSE6_MIN,  K40_HOUSE7_MIN,  K40_HOUSE8_MIN,
       K40_HOUSE9_MIN, K40_HOUSE10_MIN, K40_HOUSE11_MIN, K40_HOUSE12_MIN};
  static final double[] maxLonK40 = new double[]
      {K40_ASC_MAX,    K40_MC_MAX,      K40_ARMC_MAX,    K40_VERTEX_MAX,
       K40_EQUASC_MAX, K40_COASC1_MAX,  K40_COASC2_MAX,  K40_POLASC_MAX,
       K40_HOUSE1_MAX, K40_HOUSE2_MAX,  K40_HOUSE3_MAX,  K40_HOUSE4_MAX,
       K40_HOUSE5_MAX, K40_HOUSE6_MAX,  K40_HOUSE7_MAX,  K40_HOUSE8_MAX,
       K40_HOUSE9_MAX, K40_HOUSE10_MAX, K40_HOUSE11_MAX, K40_HOUSE12_MAX};
  static final double[] minLonK50 = new double[]
      {K50_ASC_MIN,    K50_MC_MIN,      K50_ARMC_MIN,    K50_VERTEX_MIN,
       K50_EQUASC_MIN, K50_COASC1_MIN,  K50_COASC2_MIN,  K50_POLASC_MIN,
       K50_HOUSE1_MIN, K50_HOUSE2_MIN,  K50_HOUSE3_MIN,  K50_HOUSE4_MIN,
       K50_HOUSE5_MIN, K50_HOUSE6_MIN,  K50_HOUSE7_MIN,  K50_HOUSE8_MIN,
       K50_HOUSE9_MIN, K50_HOUSE10_MIN, K50_HOUSE11_MIN, K50_HOUSE12_MIN};
  static final double[] maxLonK50 = new double[]
      {K50_ASC_MAX,    K50_MC_MAX,      K50_ARMC_MAX,    K50_VERTEX_MAX,
       K50_EQUASC_MAX, K50_COASC1_MAX,  K50_COASC2_MAX,  K50_POLASC_MAX,
       K50_HOUSE1_MAX, K50_HOUSE2_MAX,  K50_HOUSE3_MAX,  K50_HOUSE4_MAX,
       K50_HOUSE5_MAX, K50_HOUSE6_MAX,  K50_HOUSE7_MAX,  K50_HOUSE8_MAX,
       K50_HOUSE9_MAX, K50_HOUSE10_MAX, K50_HOUSE11_MAX, K50_HOUSE12_MAX};
  static final double[] minLonK60 = new double[]
      {K60_ASC_MIN,    K60_MC_MIN,      K60_ARMC_MIN,    K60_VERTEX_MIN,
       K60_EQUASC_MIN, K60_COASC1_MIN,  K60_COASC2_MIN,  K60_POLASC_MIN,
       K60_HOUSE1_MIN, K60_HOUSE2_MIN,  K60_HOUSE3_MIN,  K60_HOUSE4_MIN,
       K60_HOUSE5_MIN, K60_HOUSE6_MIN,  K60_HOUSE7_MIN,  K60_HOUSE8_MIN,
       K60_HOUSE9_MIN, K60_HOUSE10_MIN, K60_HOUSE11_MIN, K60_HOUSE12_MIN};
  static final double[] maxLonK60 = new double[]
      {K60_ASC_MAX,    K60_MC_MAX,      K60_ARMC_MAX,    K60_VERTEX_MAX,
       K60_EQUASC_MAX, K60_COASC1_MAX,  K60_COASC2_MAX,  K60_POLASC_MAX,
       K60_HOUSE1_MAX, K60_HOUSE2_MAX,  K60_HOUSE3_MAX,  K60_HOUSE4_MAX,
       K60_HOUSE5_MAX, K60_HOUSE6_MAX,  K60_HOUSE7_MAX,  K60_HOUSE8_MAX,
       K60_HOUSE9_MAX, K60_HOUSE10_MAX, K60_HOUSE11_MAX, K60_HOUSE12_MAX};
  static final double[] minLonK66 = new double[]
      {K66_ASC_MIN,    K66_MC_MIN,      K66_ARMC_MIN,    K66_VERTEX_MIN,
       K66_EQUASC_MIN, K66_COASC1_MIN,  K66_COASC2_MIN,  K66_POLASC_MIN,
       K66_HOUSE1_MIN, K66_HOUSE2_MIN,  K66_HOUSE3_MIN,  K66_HOUSE4_MIN,
       K66_HOUSE5_MIN, K66_HOUSE6_MIN,  K66_HOUSE7_MIN,  K66_HOUSE8_MIN,
       K66_HOUSE9_MIN, K66_HOUSE10_MIN, K66_HOUSE11_MIN, K66_HOUSE12_MIN};
  static final double[] maxLonK66 = new double[]
      {K66_ASC_MAX,    K66_MC_MAX,      K66_ARMC_MAX,    K66_VERTEX_MAX,
       K66_EQUASC_MAX, K66_COASC1_MAX,  K66_COASC2_MAX,  K66_POLASC_MAX,
       K66_HOUSE1_MAX, K66_HOUSE2_MAX,  K66_HOUSE3_MAX,  K66_HOUSE4_MAX,
       K66_HOUSE5_MAX, K66_HOUSE6_MAX,  K66_HOUSE7_MAX,  K66_HOUSE8_MAX,
       K66_HOUSE9_MAX, K66_HOUSE10_MAX, K66_HOUSE11_MAX, K66_HOUSE12_MAX};
  static final double[] minLonK70 = new double[]
      {K70_ASC_MIN,    K70_MC_MIN,      K70_ARMC_MIN,    K70_VERTEX_MIN,
       K70_EQUASC_MIN, K70_COASC1_MIN,  K70_COASC2_MIN,  K70_POLASC_MIN,
       K70_HOUSE1_MIN, K70_HOUSE2_MIN,  K70_HOUSE3_MIN,  K70_HOUSE4_MIN,
       K70_HOUSE5_MIN, K70_HOUSE6_MIN,  K70_HOUSE7_MIN,  K70_HOUSE8_MIN,
       K70_HOUSE9_MIN, K70_HOUSE10_MIN, K70_HOUSE11_MIN, K70_HOUSE12_MIN};
  static final double[] maxLonK70 = new double[]
      {K70_ASC_MAX,    K70_MC_MAX,      K70_ARMC_MAX,    K70_VERTEX_MAX,
       K70_EQUASC_MAX, K70_COASC1_MAX,  K70_COASC2_MAX,  K70_POLASC_MAX,
       K70_HOUSE1_MAX, K70_HOUSE2_MAX,  K70_HOUSE3_MAX,  K70_HOUSE4_MAX,
       K70_HOUSE5_MAX, K70_HOUSE6_MAX,  K70_HOUSE7_MAX,  K70_HOUSE8_MAX,
       K70_HOUSE9_MAX, K70_HOUSE10_MAX, K70_HOUSE11_MAX, K70_HOUSE12_MAX};
  static final double[] minLonK80 = new double[]
      {K80_ASC_MIN,    K80_MC_MIN,      K80_ARMC_MIN,    K80_VERTEX_MIN,
       K80_EQUASC_MIN, K80_COASC1_MIN,  K80_COASC2_MIN,  K80_POLASC_MIN,
       K80_HOUSE1_MIN, K80_HOUSE2_MIN,  K80_HOUSE3_MIN,  K80_HOUSE4_MIN,
       K80_HOUSE5_MIN, K80_HOUSE6_MIN,  K80_HOUSE7_MIN,  K80_HOUSE8_MIN,
       K80_HOUSE9_MIN, K80_HOUSE10_MIN, K80_HOUSE11_MIN, K80_HOUSE12_MIN};
  static final double[] maxLonK80 = new double[]
      {K80_ASC_MAX,    K80_MC_MAX,      K80_ARMC_MAX,    K80_VERTEX_MAX,
       K80_EQUASC_MAX, K80_COASC1_MAX,  K80_COASC2_MAX,  K80_POLASC_MAX,
       K80_HOUSE1_MAX, K80_HOUSE2_MAX,  K80_HOUSE3_MAX,  K80_HOUSE4_MAX,
       K80_HOUSE5_MAX, K80_HOUSE6_MAX,  K80_HOUSE7_MAX,  K80_HOUSE8_MAX,
       K80_HOUSE9_MAX, K80_HOUSE10_MAX, K80_HOUSE11_MAX, K80_HOUSE12_MAX};
  static final double[] minLonK85 = new double[]
      {K85_ASC_MIN,    K85_MC_MIN,      K85_ARMC_MIN,    K85_VERTEX_MIN,
       K85_EQUASC_MIN, K85_COASC1_MIN,  K85_COASC2_MIN,  K85_POLASC_MIN,
       K85_HOUSE1_MIN, K85_HOUSE2_MIN,  K85_HOUSE3_MIN,  K85_HOUSE4_MIN,
       K85_HOUSE5_MIN, K85_HOUSE6_MIN,  K85_HOUSE7_MIN,  K85_HOUSE8_MIN,
       K85_HOUSE9_MIN, K85_HOUSE10_MIN, K85_HOUSE11_MIN, K85_HOUSE12_MIN};
  static final double[] maxLonK85 = new double[]
      {K85_ASC_MAX,    K85_MC_MAX,      K85_ARMC_MAX,    K85_VERTEX_MAX,
       K85_EQUASC_MAX, K85_COASC1_MAX,  K85_COASC2_MAX,  K85_POLASC_MAX,
       K85_HOUSE1_MAX, K85_HOUSE2_MAX,  K85_HOUSE3_MAX,  K85_HOUSE4_MAX,
       K85_HOUSE5_MAX, K85_HOUSE6_MAX,  K85_HOUSE7_MAX,  K85_HOUSE8_MAX,
       K85_HOUSE9_MAX, K85_HOUSE10_MAX, K85_HOUSE11_MAX, K85_HOUSE12_MAX};
  static final double[] minLonK88 = new double[]
      {K88_ASC_MIN,    K88_MC_MIN,      K88_ARMC_MIN,    K88_VERTEX_MIN,
       K88_EQUASC_MIN, K88_COASC1_MIN,  K88_COASC2_MIN,  K88_POLASC_MIN,
       K88_HOUSE1_MIN, K88_HOUSE2_MIN,  K88_HOUSE3_MIN,  K88_HOUSE4_MIN,
       K88_HOUSE5_MIN, K88_HOUSE6_MIN,  K88_HOUSE7_MIN,  K88_HOUSE8_MIN,
       K88_HOUSE9_MIN, K88_HOUSE10_MIN, K88_HOUSE11_MIN, K88_HOUSE12_MIN};
  static final double[] maxLonK88 = new double[]
      {K88_ASC_MAX,    K88_MC_MAX,      K88_ARMC_MAX,    K88_VERTEX_MAX,
       K88_EQUASC_MAX, K88_COASC1_MAX,  K88_COASC2_MAX,  K88_POLASC_MAX,
       K88_HOUSE1_MAX, K88_HOUSE2_MAX,  K88_HOUSE3_MAX,  K88_HOUSE4_MAX,
       K88_HOUSE5_MAX, K88_HOUSE6_MAX,  K88_HOUSE7_MAX,  K88_HOUSE8_MAX,
       K88_HOUSE9_MAX, K88_HOUSE10_MAX, K88_HOUSE11_MAX, K88_HOUSE12_MAX};
  static final double[] minLonK89x = new double[]
      {K89x_ASC_MIN,    K89x_MC_MIN,      K89x_ARMC_MIN,    K89x_VERTEX_MIN,
       K89x_EQUASC_MIN, K89x_COASC1_MIN,  K89x_COASC2_MIN,  K89x_POLASC_MIN,
       K89x_HOUSE1_MIN, K89x_HOUSE2_MIN,  K89x_HOUSE3_MIN,  K89x_HOUSE4_MIN,
       K89x_HOUSE5_MIN, K89x_HOUSE6_MIN,  K89x_HOUSE7_MIN,  K89x_HOUSE8_MIN,
       K89x_HOUSE9_MIN, K89x_HOUSE10_MIN, K89x_HOUSE11_MIN, K89x_HOUSE12_MIN};
  static final double[] maxLonK89x = new double[]
      {K89x_ASC_MAX,    K89x_MC_MAX,      K89x_ARMC_MAX,    K89x_VERTEX_MAX,
       K89x_EQUASC_MAX, K89x_COASC1_MAX,  K89x_COASC2_MAX,  K89x_POLASC_MAX,
       K89x_HOUSE1_MAX, K89x_HOUSE2_MAX,  K89x_HOUSE3_MAX,  K89x_HOUSE4_MAX,
       K89x_HOUSE5_MAX, K89x_HOUSE6_MAX,  K89x_HOUSE7_MAX,  K89x_HOUSE8_MAX,
       K89x_HOUSE9_MAX, K89x_HOUSE10_MAX, K89x_HOUSE11_MAX, K89x_HOUSE12_MAX};

  static final double[] minLonO10 = new double[]
      {O10_ASC_MIN,    O10_MC_MIN,      O10_ARMC_MIN,    O10_VERTEX_MIN,
       O10_EQUASC_MIN, O10_COASC1_MIN,  O10_COASC2_MIN,  O10_POLASC_MIN,
       O10_HOUSE1_MIN, O10_HOUSE2_MIN,  O10_HOUSE3_MIN,  O10_HOUSE4_MIN,
       O10_HOUSE5_MIN, O10_HOUSE6_MIN,  O10_HOUSE7_MIN,  O10_HOUSE8_MIN,
       O10_HOUSE9_MIN, O10_HOUSE10_MIN, O10_HOUSE11_MIN, O10_HOUSE12_MIN};
  static final double[] maxLonO10 = new double[]
      {O10_ASC_MAX,    O10_MC_MAX,      O10_ARMC_MAX,    O10_VERTEX_MAX,
       O10_EQUASC_MAX, O10_COASC1_MAX,  O10_COASC2_MAX,  O10_POLASC_MAX,
       O10_HOUSE1_MAX, O10_HOUSE2_MAX,  O10_HOUSE3_MAX,  O10_HOUSE4_MAX,
       O10_HOUSE5_MAX, O10_HOUSE6_MAX,  O10_HOUSE7_MAX,  O10_HOUSE8_MAX,
       O10_HOUSE9_MAX, O10_HOUSE10_MAX, O10_HOUSE11_MAX, O10_HOUSE12_MAX};
  static final double[] minLonO20 = new double[]
      {O20_ASC_MIN,    O20_MC_MIN,      O20_ARMC_MIN,    O20_VERTEX_MIN,
       O20_EQUASC_MIN, O20_COASC1_MIN,  O20_COASC2_MIN,  O20_POLASC_MIN,
       O20_HOUSE1_MIN, O20_HOUSE2_MIN,  O20_HOUSE3_MIN,  O20_HOUSE4_MIN,
       O20_HOUSE5_MIN, O20_HOUSE6_MIN,  O20_HOUSE7_MIN,  O20_HOUSE8_MIN,
       O20_HOUSE9_MIN, O20_HOUSE10_MIN, O20_HOUSE11_MIN, O20_HOUSE12_MIN};
  static final double[] maxLonO20 = new double[]
      {O20_ASC_MAX,    O20_MC_MAX,      O20_ARMC_MAX,    O20_VERTEX_MAX,
       O20_EQUASC_MAX, O20_COASC1_MAX,  O20_COASC2_MAX,  O20_POLASC_MAX,
       O20_HOUSE1_MAX, O20_HOUSE2_MAX,  O20_HOUSE3_MAX,  O20_HOUSE4_MAX,
       O20_HOUSE5_MAX, O20_HOUSE6_MAX,  O20_HOUSE7_MAX,  O20_HOUSE8_MAX,
       O20_HOUSE9_MAX, O20_HOUSE10_MAX, O20_HOUSE11_MAX, O20_HOUSE12_MAX};
  static final double[] minLonO30 = new double[]
      {O30_ASC_MIN,    O30_MC_MIN,      O30_ARMC_MIN,    O30_VERTEX_MIN,
       O30_EQUASC_MIN, O30_COASC1_MIN,  O30_COASC2_MIN,  O30_POLASC_MIN,
       O30_HOUSE1_MIN, O30_HOUSE2_MIN,  O30_HOUSE3_MIN,  O30_HOUSE4_MIN,
       O30_HOUSE5_MIN, O30_HOUSE6_MIN,  O30_HOUSE7_MIN,  O30_HOUSE8_MIN,
       O30_HOUSE9_MIN, O30_HOUSE10_MIN, O30_HOUSE11_MIN, O30_HOUSE12_MIN};
  static final double[] maxLonO30 = new double[]
      {O30_ASC_MAX,    O30_MC_MAX,      O30_ARMC_MAX,    O30_VERTEX_MAX,
       O30_EQUASC_MAX, O30_COASC1_MAX,  O30_COASC2_MAX,  O30_POLASC_MAX,
       O30_HOUSE1_MAX, O30_HOUSE2_MAX,  O30_HOUSE3_MAX,  O30_HOUSE4_MAX,
       O30_HOUSE5_MAX, O30_HOUSE6_MAX,  O30_HOUSE7_MAX,  O30_HOUSE8_MAX,
       O30_HOUSE9_MAX, O30_HOUSE10_MAX, O30_HOUSE11_MAX, O30_HOUSE12_MAX};
  static final double[] minLonO40 = new double[]
      {O40_ASC_MIN,    O40_MC_MIN,      O40_ARMC_MIN,    O40_VERTEX_MIN,
       O40_EQUASC_MIN, O40_COASC1_MIN,  O40_COASC2_MIN,  O40_POLASC_MIN,
       O40_HOUSE1_MIN, O40_HOUSE2_MIN,  O40_HOUSE3_MIN,  O40_HOUSE4_MIN,
       O40_HOUSE5_MIN, O40_HOUSE6_MIN,  O40_HOUSE7_MIN,  O40_HOUSE8_MIN,
       O40_HOUSE9_MIN, O40_HOUSE10_MIN, O40_HOUSE11_MIN, O40_HOUSE12_MIN};
  static final double[] maxLonO40 = new double[]
      {O40_ASC_MAX,    O40_MC_MAX,      O40_ARMC_MAX,    O40_VERTEX_MAX,
       O40_EQUASC_MAX, O40_COASC1_MAX,  O40_COASC2_MAX,  O40_POLASC_MAX,
       O40_HOUSE1_MAX, O40_HOUSE2_MAX,  O40_HOUSE3_MAX,  O40_HOUSE4_MAX,
       O40_HOUSE5_MAX, O40_HOUSE6_MAX,  O40_HOUSE7_MAX,  O40_HOUSE8_MAX,
       O40_HOUSE9_MAX, O40_HOUSE10_MAX, O40_HOUSE11_MAX, O40_HOUSE12_MAX};
  static final double[] minLonO50 = new double[]
      {O50_ASC_MIN,    O50_MC_MIN,      O50_ARMC_MIN,    O50_VERTEX_MIN,
       O50_EQUASC_MIN, O50_COASC1_MIN,  O50_COASC2_MIN,  O50_POLASC_MIN,
       O50_HOUSE1_MIN, O50_HOUSE2_MIN,  O50_HOUSE3_MIN,  O50_HOUSE4_MIN,
       O50_HOUSE5_MIN, O50_HOUSE6_MIN,  O50_HOUSE7_MIN,  O50_HOUSE8_MIN,
       O50_HOUSE9_MIN, O50_HOUSE10_MIN, O50_HOUSE11_MIN, O50_HOUSE12_MIN};
  static final double[] maxLonO50 = new double[]
      {O50_ASC_MAX,    O50_MC_MAX,      O50_ARMC_MAX,    O50_VERTEX_MAX,
       O50_EQUASC_MAX, O50_COASC1_MAX,  O50_COASC2_MAX,  O50_POLASC_MAX,
       O50_HOUSE1_MAX, O50_HOUSE2_MAX,  O50_HOUSE3_MAX,  O50_HOUSE4_MAX,
       O50_HOUSE5_MAX, O50_HOUSE6_MAX,  O50_HOUSE7_MAX,  O50_HOUSE8_MAX,
       O50_HOUSE9_MAX, O50_HOUSE10_MAX, O50_HOUSE11_MAX, O50_HOUSE12_MAX};
  static final double[] minLonO60 = new double[]
      {O60_ASC_MIN,    O60_MC_MIN,      O60_ARMC_MIN,    O60_VERTEX_MIN,
       O60_EQUASC_MIN, O60_COASC1_MIN,  O60_COASC2_MIN,  O60_POLASC_MIN,
       O60_HOUSE1_MIN, O60_HOUSE2_MIN,  O60_HOUSE3_MIN,  O60_HOUSE4_MIN,
       O60_HOUSE5_MIN, O60_HOUSE6_MIN,  O60_HOUSE7_MIN,  O60_HOUSE8_MIN,
       O60_HOUSE9_MIN, O60_HOUSE10_MIN, O60_HOUSE11_MIN, O60_HOUSE12_MIN};
  static final double[] maxLonO60 = new double[]
      {O60_ASC_MAX,    O60_MC_MAX,      O60_ARMC_MAX,    O60_VERTEX_MAX,
       O60_EQUASC_MAX, O60_COASC1_MAX,  O60_COASC2_MAX,  O60_POLASC_MAX,
       O60_HOUSE1_MAX, O60_HOUSE2_MAX,  O60_HOUSE3_MAX,  O60_HOUSE4_MAX,
       O60_HOUSE5_MAX, O60_HOUSE6_MAX,  O60_HOUSE7_MAX,  O60_HOUSE8_MAX,
       O60_HOUSE9_MAX, O60_HOUSE10_MAX, O60_HOUSE11_MAX, O60_HOUSE12_MAX};
  static final double[] minLonO66 = new double[]
      {O66_ASC_MIN,    O66_MC_MIN,      O66_ARMC_MIN,    O66_VERTEX_MIN,
       O66_EQUASC_MIN, O66_COASC1_MIN,  O66_COASC2_MIN,  O66_POLASC_MIN,
       O66_HOUSE1_MIN, O66_HOUSE2_MIN,  O66_HOUSE3_MIN,  O66_HOUSE4_MIN,
       O66_HOUSE5_MIN, O66_HOUSE6_MIN,  O66_HOUSE7_MIN,  O66_HOUSE8_MIN,
       O66_HOUSE9_MIN, O66_HOUSE10_MIN, O66_HOUSE11_MIN, O66_HOUSE12_MIN};
  static final double[] maxLonO66 = new double[]
      {O66_ASC_MAX,    O66_MC_MAX,      O66_ARMC_MAX,    O66_VERTEX_MAX,
       O66_EQUASC_MAX, O66_COASC1_MAX,  O66_COASC2_MAX,  O66_POLASC_MAX,
       O66_HOUSE1_MAX, O66_HOUSE2_MAX,  O66_HOUSE3_MAX,  O66_HOUSE4_MAX,
       O66_HOUSE5_MAX, O66_HOUSE6_MAX,  O66_HOUSE7_MAX,  O66_HOUSE8_MAX,
       O66_HOUSE9_MAX, O66_HOUSE10_MAX, O66_HOUSE11_MAX, O66_HOUSE12_MAX};
  static final double[] minLonO70 = new double[]
      {O70_ASC_MIN,    O70_MC_MIN,      O70_ARMC_MIN,    O70_VERTEX_MIN,
       O70_EQUASC_MIN, O70_COASC1_MIN,  O70_COASC2_MIN,  O70_POLASC_MIN,
       O70_HOUSE1_MIN, O70_HOUSE2_MIN,  O70_HOUSE3_MIN,  O70_HOUSE4_MIN,
       O70_HOUSE5_MIN, O70_HOUSE6_MIN,  O70_HOUSE7_MIN,  O70_HOUSE8_MIN,
       O70_HOUSE9_MIN, O70_HOUSE10_MIN, O70_HOUSE11_MIN, O70_HOUSE12_MIN};
  static final double[] maxLonO70 = new double[]
      {O70_ASC_MAX,    O70_MC_MAX,      O70_ARMC_MAX,    O70_VERTEX_MAX,
       O70_EQUASC_MAX, O70_COASC1_MAX,  O70_COASC2_MAX,  O70_POLASC_MAX,
       O70_HOUSE1_MAX, O70_HOUSE2_MAX,  O70_HOUSE3_MAX,  O70_HOUSE4_MAX,
       O70_HOUSE5_MAX, O70_HOUSE6_MAX,  O70_HOUSE7_MAX,  O70_HOUSE8_MAX,
       O70_HOUSE9_MAX, O70_HOUSE10_MAX, O70_HOUSE11_MAX, O70_HOUSE12_MAX};
  static final double[] minLonO80 = new double[]
      {O80_ASC_MIN,    O80_MC_MIN,      O80_ARMC_MIN,    O80_VERTEX_MIN,
       O80_EQUASC_MIN, O80_COASC1_MIN,  O80_COASC2_MIN,  O80_POLASC_MIN,
       O80_HOUSE1_MIN, O80_HOUSE2_MIN,  O80_HOUSE3_MIN,  O80_HOUSE4_MIN,
       O80_HOUSE5_MIN, O80_HOUSE6_MIN,  O80_HOUSE7_MIN,  O80_HOUSE8_MIN,
       O80_HOUSE9_MIN, O80_HOUSE10_MIN, O80_HOUSE11_MIN, O80_HOUSE12_MIN};
  static final double[] maxLonO80 = new double[]
      {O80_ASC_MAX,    O80_MC_MAX,      O80_ARMC_MAX,    O80_VERTEX_MAX,
       O80_EQUASC_MAX, O80_COASC1_MAX,  O80_COASC2_MAX,  O80_POLASC_MAX,
       O80_HOUSE1_MAX, O80_HOUSE2_MAX,  O80_HOUSE3_MAX,  O80_HOUSE4_MAX,
       O80_HOUSE5_MAX, O80_HOUSE6_MAX,  O80_HOUSE7_MAX,  O80_HOUSE8_MAX,
       O80_HOUSE9_MAX, O80_HOUSE10_MAX, O80_HOUSE11_MAX, O80_HOUSE12_MAX};
  static final double[] minLonO85 = new double[]
      {O85_ASC_MIN,    O85_MC_MIN,      O85_ARMC_MIN,    O85_VERTEX_MIN,
       O85_EQUASC_MIN, O85_COASC1_MIN,  O85_COASC2_MIN,  O85_POLASC_MIN,
       O85_HOUSE1_MIN, O85_HOUSE2_MIN,  O85_HOUSE3_MIN,  O85_HOUSE4_MIN,
       O85_HOUSE5_MIN, O85_HOUSE6_MIN,  O85_HOUSE7_MIN,  O85_HOUSE8_MIN,
       O85_HOUSE9_MIN, O85_HOUSE10_MIN, O85_HOUSE11_MIN, O85_HOUSE12_MIN};
  static final double[] maxLonO85 = new double[]
      {O85_ASC_MAX,    O85_MC_MAX,      O85_ARMC_MAX,    O85_VERTEX_MAX,
       O85_EQUASC_MAX, O85_COASC1_MAX,  O85_COASC2_MAX,  O85_POLASC_MAX,
       O85_HOUSE1_MAX, O85_HOUSE2_MAX,  O85_HOUSE3_MAX,  O85_HOUSE4_MAX,
       O85_HOUSE5_MAX, O85_HOUSE6_MAX,  O85_HOUSE7_MAX,  O85_HOUSE8_MAX,
       O85_HOUSE9_MAX, O85_HOUSE10_MAX, O85_HOUSE11_MAX, O85_HOUSE12_MAX};
  static final double[] minLonO88 = new double[]
      {O88_ASC_MIN,    O88_MC_MIN,      O88_ARMC_MIN,    O88_VERTEX_MIN,
       O88_EQUASC_MIN, O88_COASC1_MIN,  O88_COASC2_MIN,  O88_POLASC_MIN,
       O88_HOUSE1_MIN, O88_HOUSE2_MIN,  O88_HOUSE3_MIN,  O88_HOUSE4_MIN,
       O88_HOUSE5_MIN, O88_HOUSE6_MIN,  O88_HOUSE7_MIN,  O88_HOUSE8_MIN,
       O88_HOUSE9_MIN, O88_HOUSE10_MIN, O88_HOUSE11_MIN, O88_HOUSE12_MIN};
  static final double[] maxLonO88 = new double[]
      {O88_ASC_MAX,    O88_MC_MAX,      O88_ARMC_MAX,    O88_VERTEX_MAX,
       O88_EQUASC_MAX, O88_COASC1_MAX,  O88_COASC2_MAX,  O88_POLASC_MAX,
       O88_HOUSE1_MAX, O88_HOUSE2_MAX,  O88_HOUSE3_MAX,  O88_HOUSE4_MAX,
       O88_HOUSE5_MAX, O88_HOUSE6_MAX,  O88_HOUSE7_MAX,  O88_HOUSE8_MAX,
       O88_HOUSE9_MAX, O88_HOUSE10_MAX, O88_HOUSE11_MAX, O88_HOUSE12_MAX};
  static final double[] minLonO89x = new double[]
      {O89x_ASC_MIN,    O89x_MC_MIN,      O89x_ARMC_MIN,    O89x_VERTEX_MIN,
       O89x_EQUASC_MIN, O89x_COASC1_MIN,  O89x_COASC2_MIN,  O89x_POLASC_MIN,
       O89x_HOUSE1_MIN, O89x_HOUSE2_MIN,  O89x_HOUSE3_MIN,  O89x_HOUSE4_MIN,
       O89x_HOUSE5_MIN, O89x_HOUSE6_MIN,  O89x_HOUSE7_MIN,  O89x_HOUSE8_MIN,
       O89x_HOUSE9_MIN, O89x_HOUSE10_MIN, O89x_HOUSE11_MIN, O89x_HOUSE12_MIN};
  static final double[] maxLonO89x = new double[]
      {O89x_ASC_MAX,    O89x_MC_MAX,      O89x_ARMC_MAX,    O89x_VERTEX_MAX,
       O89x_EQUASC_MAX, O89x_COASC1_MAX,  O89x_COASC2_MAX,  O89x_POLASC_MAX,
       O89x_HOUSE1_MAX, O89x_HOUSE2_MAX,  O89x_HOUSE3_MAX,  O89x_HOUSE4_MAX,
       O89x_HOUSE5_MAX, O89x_HOUSE6_MAX,  O89x_HOUSE7_MAX,  O89x_HOUSE8_MAX,
       O89x_HOUSE9_MAX, O89x_HOUSE10_MAX, O89x_HOUSE11_MAX, O89x_HOUSE12_MAX};

  static final double[] minLonR10 = new double[]
      {R10_ASC_MIN,    R10_MC_MIN,      R10_ARMC_MIN,    R10_VERTEX_MIN,
       R10_EQUASC_MIN, R10_COASC1_MIN,  R10_COASC2_MIN,  R10_POLASC_MIN,
       R10_HOUSE1_MIN, R10_HOUSE2_MIN,  R10_HOUSE3_MIN,  R10_HOUSE4_MIN,
       R10_HOUSE5_MIN, R10_HOUSE6_MIN,  R10_HOUSE7_MIN,  R10_HOUSE8_MIN,
       R10_HOUSE9_MIN, R10_HOUSE10_MIN, R10_HOUSE11_MIN, R10_HOUSE12_MIN};
  static final double[] maxLonR10 = new double[]
      {R10_ASC_MAX,    R10_MC_MAX,      R10_ARMC_MAX,    R10_VERTEX_MAX,
       R10_EQUASC_MAX, R10_COASC1_MAX,  R10_COASC2_MAX,  R10_POLASC_MAX,
       R10_HOUSE1_MAX, R10_HOUSE2_MAX,  R10_HOUSE3_MAX,  R10_HOUSE4_MAX,
       R10_HOUSE5_MAX, R10_HOUSE6_MAX,  R10_HOUSE7_MAX,  R10_HOUSE8_MAX,
       R10_HOUSE9_MAX, R10_HOUSE10_MAX, R10_HOUSE11_MAX, R10_HOUSE12_MAX};
  static final double[] minLonR20 = new double[]
      {R20_ASC_MIN,    R20_MC_MIN,      R20_ARMC_MIN,    R20_VERTEX_MIN,
       R20_EQUASC_MIN, R20_COASC1_MIN,  R20_COASC2_MIN,  R20_POLASC_MIN,
       R20_HOUSE1_MIN, R20_HOUSE2_MIN,  R20_HOUSE3_MIN,  R20_HOUSE4_MIN,
       R20_HOUSE5_MIN, R20_HOUSE6_MIN,  R20_HOUSE7_MIN,  R20_HOUSE8_MIN,
       R20_HOUSE9_MIN, R20_HOUSE10_MIN, R20_HOUSE11_MIN, R20_HOUSE12_MIN};
  static final double[] maxLonR20 = new double[]
      {R20_ASC_MAX,    R20_MC_MAX,      R20_ARMC_MAX,    R20_VERTEX_MAX,
       R20_EQUASC_MAX, R20_COASC1_MAX,  R20_COASC2_MAX,  R20_POLASC_MAX,
       R20_HOUSE1_MAX, R20_HOUSE2_MAX,  R20_HOUSE3_MAX,  R20_HOUSE4_MAX,
       R20_HOUSE5_MAX, R20_HOUSE6_MAX,  R20_HOUSE7_MAX,  R20_HOUSE8_MAX,
       R20_HOUSE9_MAX, R20_HOUSE10_MAX, R20_HOUSE11_MAX, R20_HOUSE12_MAX};
  static final double[] minLonR30 = new double[]
      {R30_ASC_MIN,    R30_MC_MIN,      R30_ARMC_MIN,    R30_VERTEX_MIN,
       R30_EQUASC_MIN, R30_COASC1_MIN,  R30_COASC2_MIN,  R30_POLASC_MIN,
       R30_HOUSE1_MIN, R30_HOUSE2_MIN,  R30_HOUSE3_MIN,  R30_HOUSE4_MIN,
       R30_HOUSE5_MIN, R30_HOUSE6_MIN,  R30_HOUSE7_MIN,  R30_HOUSE8_MIN,
       R30_HOUSE9_MIN, R30_HOUSE10_MIN, R30_HOUSE11_MIN, R30_HOUSE12_MIN};
  static final double[] maxLonR30 = new double[]
      {R30_ASC_MAX,    R30_MC_MAX,      R30_ARMC_MAX,    R30_VERTEX_MAX,
       R30_EQUASC_MAX, R30_COASC1_MAX,  R30_COASC2_MAX,  R30_POLASC_MAX,
       R30_HOUSE1_MAX, R30_HOUSE2_MAX,  R30_HOUSE3_MAX,  R30_HOUSE4_MAX,
       R30_HOUSE5_MAX, R30_HOUSE6_MAX,  R30_HOUSE7_MAX,  R30_HOUSE8_MAX,
       R30_HOUSE9_MAX, R30_HOUSE10_MAX, R30_HOUSE11_MAX, R30_HOUSE12_MAX};
  static final double[] minLonR40 = new double[]
      {R40_ASC_MIN,    R40_MC_MIN,      R40_ARMC_MIN,    R40_VERTEX_MIN,
       R40_EQUASC_MIN, R40_COASC1_MIN,  R40_COASC2_MIN,  R40_POLASC_MIN,
       R40_HOUSE1_MIN, R40_HOUSE2_MIN,  R40_HOUSE3_MIN,  R40_HOUSE4_MIN,
       R40_HOUSE5_MIN, R40_HOUSE6_MIN,  R40_HOUSE7_MIN,  R40_HOUSE8_MIN,
       R40_HOUSE9_MIN, R40_HOUSE10_MIN, R40_HOUSE11_MIN, R40_HOUSE12_MIN};
  static final double[] maxLonR40 = new double[]
      {R40_ASC_MAX,    R40_MC_MAX,      R40_ARMC_MAX,    R40_VERTEX_MAX,
       R40_EQUASC_MAX, R40_COASC1_MAX,  R40_COASC2_MAX,  R40_POLASC_MAX,
       R40_HOUSE1_MAX, R40_HOUSE2_MAX,  R40_HOUSE3_MAX,  R40_HOUSE4_MAX,
       R40_HOUSE5_MAX, R40_HOUSE6_MAX,  R40_HOUSE7_MAX,  R40_HOUSE8_MAX,
       R40_HOUSE9_MAX, R40_HOUSE10_MAX, R40_HOUSE11_MAX, R40_HOUSE12_MAX};
  static final double[] minLonR50 = new double[]
      {R50_ASC_MIN,    R50_MC_MIN,      R50_ARMC_MIN,    R50_VERTEX_MIN,
       R50_EQUASC_MIN, R50_COASC1_MIN,  R50_COASC2_MIN,  R50_POLASC_MIN,
       R50_HOUSE1_MIN, R50_HOUSE2_MIN,  R50_HOUSE3_MIN,  R50_HOUSE4_MIN,
       R50_HOUSE5_MIN, R50_HOUSE6_MIN,  R50_HOUSE7_MIN,  R50_HOUSE8_MIN,
       R50_HOUSE9_MIN, R50_HOUSE10_MIN, R50_HOUSE11_MIN, R50_HOUSE12_MIN};
  static final double[] maxLonR50 = new double[]
      {R50_ASC_MAX,    R50_MC_MAX,      R50_ARMC_MAX,    R50_VERTEX_MAX,
       R50_EQUASC_MAX, R50_COASC1_MAX,  R50_COASC2_MAX,  R50_POLASC_MAX,
       R50_HOUSE1_MAX, R50_HOUSE2_MAX,  R50_HOUSE3_MAX,  R50_HOUSE4_MAX,
       R50_HOUSE5_MAX, R50_HOUSE6_MAX,  R50_HOUSE7_MAX,  R50_HOUSE8_MAX,
       R50_HOUSE9_MAX, R50_HOUSE10_MAX, R50_HOUSE11_MAX, R50_HOUSE12_MAX};
  static final double[] minLonR60 = new double[]
      {R60_ASC_MIN,    R60_MC_MIN,      R60_ARMC_MIN,    R60_VERTEX_MIN,
       R60_EQUASC_MIN, R60_COASC1_MIN,  R60_COASC2_MIN,  R60_POLASC_MIN,
       R60_HOUSE1_MIN, R60_HOUSE2_MIN,  R60_HOUSE3_MIN,  R60_HOUSE4_MIN,
       R60_HOUSE5_MIN, R60_HOUSE6_MIN,  R60_HOUSE7_MIN,  R60_HOUSE8_MIN,
       R60_HOUSE9_MIN, R60_HOUSE10_MIN, R60_HOUSE11_MIN, R60_HOUSE12_MIN};
  static final double[] maxLonR60 = new double[]
      {R60_ASC_MAX,    R60_MC_MAX,      R60_ARMC_MAX,    R60_VERTEX_MAX,
       R60_EQUASC_MAX, R60_COASC1_MAX,  R60_COASC2_MAX,  R60_POLASC_MAX,
       R60_HOUSE1_MAX, R60_HOUSE2_MAX,  R60_HOUSE3_MAX,  R60_HOUSE4_MAX,
       R60_HOUSE5_MAX, R60_HOUSE6_MAX,  R60_HOUSE7_MAX,  R60_HOUSE8_MAX,
       R60_HOUSE9_MAX, R60_HOUSE10_MAX, R60_HOUSE11_MAX, R60_HOUSE12_MAX};
  static final double[] minLonR66 = new double[]
      {R66_ASC_MIN,    R66_MC_MIN,      R66_ARMC_MIN,    R66_VERTEX_MIN,
       R66_EQUASC_MIN, R66_COASC1_MIN,  R66_COASC2_MIN,  R66_POLASC_MIN,
       R66_HOUSE1_MIN, R66_HOUSE2_MIN,  R66_HOUSE3_MIN,  R66_HOUSE4_MIN,
       R66_HOUSE5_MIN, R66_HOUSE6_MIN,  R66_HOUSE7_MIN,  R66_HOUSE8_MIN,
       R66_HOUSE9_MIN, R66_HOUSE10_MIN, R66_HOUSE11_MIN, R66_HOUSE12_MIN};
  static final double[] maxLonR66 = new double[]
      {R66_ASC_MAX,    R66_MC_MAX,      R66_ARMC_MAX,    R66_VERTEX_MAX,
       R66_EQUASC_MAX, R66_COASC1_MAX,  R66_COASC2_MAX,  R66_POLASC_MAX,
       R66_HOUSE1_MAX, R66_HOUSE2_MAX,  R66_HOUSE3_MAX,  R66_HOUSE4_MAX,
       R66_HOUSE5_MAX, R66_HOUSE6_MAX,  R66_HOUSE7_MAX,  R66_HOUSE8_MAX,
       R66_HOUSE9_MAX, R66_HOUSE10_MAX, R66_HOUSE11_MAX, R66_HOUSE12_MAX};
  static final double[] minLonR70 = new double[]
      {R70_ASC_MIN,    R70_MC_MIN,      R70_ARMC_MIN,    R70_VERTEX_MIN,
       R70_EQUASC_MIN, R70_COASC1_MIN,  R70_COASC2_MIN,  R70_POLASC_MIN,
       R70_HOUSE1_MIN, R70_HOUSE2_MIN,  R70_HOUSE3_MIN,  R70_HOUSE4_MIN,
       R70_HOUSE5_MIN, R70_HOUSE6_MIN,  R70_HOUSE7_MIN,  R70_HOUSE8_MIN,
       R70_HOUSE9_MIN, R70_HOUSE10_MIN, R70_HOUSE11_MIN, R70_HOUSE12_MIN};
  static final double[] maxLonR70 = new double[]
      {R70_ASC_MAX,    R70_MC_MAX,      R70_ARMC_MAX,    R70_VERTEX_MAX,
       R70_EQUASC_MAX, R70_COASC1_MAX,  R70_COASC2_MAX,  R70_POLASC_MAX,
       R70_HOUSE1_MAX, R70_HOUSE2_MAX,  R70_HOUSE3_MAX,  R70_HOUSE4_MAX,
       R70_HOUSE5_MAX, R70_HOUSE6_MAX,  R70_HOUSE7_MAX,  R70_HOUSE8_MAX,
       R70_HOUSE9_MAX, R70_HOUSE10_MAX, R70_HOUSE11_MAX, R70_HOUSE12_MAX};
  static final double[] minLonR80 = new double[]
      {R80_ASC_MIN,    R80_MC_MIN,      R80_ARMC_MIN,    R80_VERTEX_MIN,
       R80_EQUASC_MIN, R80_COASC1_MIN,  R80_COASC2_MIN,  R80_POLASC_MIN,
       R80_HOUSE1_MIN, R80_HOUSE2_MIN,  R80_HOUSE3_MIN,  R80_HOUSE4_MIN,
       R80_HOUSE5_MIN, R80_HOUSE6_MIN,  R80_HOUSE7_MIN,  R80_HOUSE8_MIN,
       R80_HOUSE9_MIN, R80_HOUSE10_MIN, R80_HOUSE11_MIN, R80_HOUSE12_MIN};
  static final double[] maxLonR80 = new double[]
      {R80_ASC_MAX,    R80_MC_MAX,      R80_ARMC_MAX,    R80_VERTEX_MAX,
       R80_EQUASC_MAX, R80_COASC1_MAX,  R80_COASC2_MAX,  R80_POLASC_MAX,
       R80_HOUSE1_MAX, R80_HOUSE2_MAX,  R80_HOUSE3_MAX,  R80_HOUSE4_MAX,
       R80_HOUSE5_MAX, R80_HOUSE6_MAX,  R80_HOUSE7_MAX,  R80_HOUSE8_MAX,
       R80_HOUSE9_MAX, R80_HOUSE10_MAX, R80_HOUSE11_MAX, R80_HOUSE12_MAX};
  static final double[] minLonR85 = new double[]
      {R85_ASC_MIN,    R85_MC_MIN,      R85_ARMC_MIN,    R85_VERTEX_MIN,
       R85_EQUASC_MIN, R85_COASC1_MIN,  R85_COASC2_MIN,  R85_POLASC_MIN,
       R85_HOUSE1_MIN, R85_HOUSE2_MIN,  R85_HOUSE3_MIN,  R85_HOUSE4_MIN,
       R85_HOUSE5_MIN, R85_HOUSE6_MIN,  R85_HOUSE7_MIN,  R85_HOUSE8_MIN,
       R85_HOUSE9_MIN, R85_HOUSE10_MIN, R85_HOUSE11_MIN, R85_HOUSE12_MIN};
  static final double[] maxLonR85 = new double[]
      {R85_ASC_MAX,    R85_MC_MAX,      R85_ARMC_MAX,    R85_VERTEX_MAX,
       R85_EQUASC_MAX, R85_COASC1_MAX,  R85_COASC2_MAX,  R85_POLASC_MAX,
       R85_HOUSE1_MAX, R85_HOUSE2_MAX,  R85_HOUSE3_MAX,  R85_HOUSE4_MAX,
       R85_HOUSE5_MAX, R85_HOUSE6_MAX,  R85_HOUSE7_MAX,  R85_HOUSE8_MAX,
       R85_HOUSE9_MAX, R85_HOUSE10_MAX, R85_HOUSE11_MAX, R85_HOUSE12_MAX};
  static final double[] minLonR88 = new double[]
      {R88_ASC_MIN,    R88_MC_MIN,      R88_ARMC_MIN,    R88_VERTEX_MIN,
       R88_EQUASC_MIN, R88_COASC1_MIN,  R88_COASC2_MIN,  R88_POLASC_MIN,
       R88_HOUSE1_MIN, R88_HOUSE2_MIN,  R88_HOUSE3_MIN,  R88_HOUSE4_MIN,
       R88_HOUSE5_MIN, R88_HOUSE6_MIN,  R88_HOUSE7_MIN,  R88_HOUSE8_MIN,
       R88_HOUSE9_MIN, R88_HOUSE10_MIN, R88_HOUSE11_MIN, R88_HOUSE12_MIN};
  static final double[] maxLonR88 = new double[]
      {R88_ASC_MAX,    R88_MC_MAX,      R88_ARMC_MAX,    R88_VERTEX_MAX,
       R88_EQUASC_MAX, R88_COASC1_MAX,  R88_COASC2_MAX,  R88_POLASC_MAX,
       R88_HOUSE1_MAX, R88_HOUSE2_MAX,  R88_HOUSE3_MAX,  R88_HOUSE4_MAX,
       R88_HOUSE5_MAX, R88_HOUSE6_MAX,  R88_HOUSE7_MAX,  R88_HOUSE8_MAX,
       R88_HOUSE9_MAX, R88_HOUSE10_MAX, R88_HOUSE11_MAX, R88_HOUSE12_MAX};
  static final double[] minLonR89x = new double[]
      {R89x_ASC_MIN,    R89x_MC_MIN,      R89x_ARMC_MIN,    R89x_VERTEX_MIN,
       R89x_EQUASC_MIN, R89x_COASC1_MIN,  R89x_COASC2_MIN,  R89x_POLASC_MIN,
       R89x_HOUSE1_MIN, R89x_HOUSE2_MIN,  R89x_HOUSE3_MIN,  R89x_HOUSE4_MIN,
       R89x_HOUSE5_MIN, R89x_HOUSE6_MIN,  R89x_HOUSE7_MIN,  R89x_HOUSE8_MIN,
       R89x_HOUSE9_MIN, R89x_HOUSE10_MIN, R89x_HOUSE11_MIN, R89x_HOUSE12_MIN};
  static final double[] maxLonR89x = new double[]
      {R89x_ASC_MAX,    R89x_MC_MAX,      R89x_ARMC_MAX,    R89x_VERTEX_MAX,
       R89x_EQUASC_MAX, R89x_COASC1_MAX,  R89x_COASC2_MAX,  R89x_POLASC_MAX,
       R89x_HOUSE1_MAX, R89x_HOUSE2_MAX,  R89x_HOUSE3_MAX,  R89x_HOUSE4_MAX,
       R89x_HOUSE5_MAX, R89x_HOUSE6_MAX,  R89x_HOUSE7_MAX,  R89x_HOUSE8_MAX,
       R89x_HOUSE9_MAX, R89x_HOUSE10_MAX, R89x_HOUSE11_MAX, R89x_HOUSE12_MAX};

  static final double[] minLonC10 = new double[]
      {C10_ASC_MIN,    C10_MC_MIN,      C10_ARMC_MIN,    C10_VERTEX_MIN,
       C10_EQUASC_MIN, C10_COASC1_MIN,  C10_COASC2_MIN,  C10_POLASC_MIN,
       C10_HOUSE1_MIN, C10_HOUSE2_MIN,  C10_HOUSE3_MIN,  C10_HOUSE4_MIN,
       C10_HOUSE5_MIN, C10_HOUSE6_MIN,  C10_HOUSE7_MIN,  C10_HOUSE8_MIN,
       C10_HOUSE9_MIN, C10_HOUSE10_MIN, C10_HOUSE11_MIN, C10_HOUSE12_MIN};
  static final double[] maxLonC10 = new double[]
      {C10_ASC_MAX,    C10_MC_MAX,      C10_ARMC_MAX,    C10_VERTEX_MAX,
       C10_EQUASC_MAX, C10_COASC1_MAX,  C10_COASC2_MAX,  C10_POLASC_MAX,
       C10_HOUSE1_MAX, C10_HOUSE2_MAX,  C10_HOUSE3_MAX,  C10_HOUSE4_MAX,
       C10_HOUSE5_MAX, C10_HOUSE6_MAX,  C10_HOUSE7_MAX,  C10_HOUSE8_MAX,
       C10_HOUSE9_MAX, C10_HOUSE10_MAX, C10_HOUSE11_MAX, C10_HOUSE12_MAX};
  static final double[] minLonC20 = new double[]
      {C20_ASC_MIN,    C20_MC_MIN,      C20_ARMC_MIN,    C20_VERTEX_MIN,
       C20_EQUASC_MIN, C20_COASC1_MIN,  C20_COASC2_MIN,  C20_POLASC_MIN,
       C20_HOUSE1_MIN, C20_HOUSE2_MIN,  C20_HOUSE3_MIN,  C20_HOUSE4_MIN,
       C20_HOUSE5_MIN, C20_HOUSE6_MIN,  C20_HOUSE7_MIN,  C20_HOUSE8_MIN,
       C20_HOUSE9_MIN, C20_HOUSE10_MIN, C20_HOUSE11_MIN, C20_HOUSE12_MIN};
  static final double[] maxLonC20 = new double[]
      {C20_ASC_MAX,    C20_MC_MAX,      C20_ARMC_MAX,    C20_VERTEX_MAX,
       C20_EQUASC_MAX, C20_COASC1_MAX,  C20_COASC2_MAX,  C20_POLASC_MAX,
       C20_HOUSE1_MAX, C20_HOUSE2_MAX,  C20_HOUSE3_MAX,  C20_HOUSE4_MAX,
       C20_HOUSE5_MAX, C20_HOUSE6_MAX,  C20_HOUSE7_MAX,  C20_HOUSE8_MAX,
       C20_HOUSE9_MAX, C20_HOUSE10_MAX, C20_HOUSE11_MAX, C20_HOUSE12_MAX};
  static final double[] minLonC30 = new double[]
      {C30_ASC_MIN,    C30_MC_MIN,      C30_ARMC_MIN,    C30_VERTEX_MIN,
       C30_EQUASC_MIN, C30_COASC1_MIN,  C30_COASC2_MIN,  C30_POLASC_MIN,
       C30_HOUSE1_MIN, C30_HOUSE2_MIN,  C30_HOUSE3_MIN,  C30_HOUSE4_MIN,
       C30_HOUSE5_MIN, C30_HOUSE6_MIN,  C30_HOUSE7_MIN,  C30_HOUSE8_MIN,
       C30_HOUSE9_MIN, C30_HOUSE10_MIN, C30_HOUSE11_MIN, C30_HOUSE12_MIN};
  static final double[] maxLonC30 = new double[]
      {C30_ASC_MAX,    C30_MC_MAX,      C30_ARMC_MAX,    C30_VERTEX_MAX,
       C30_EQUASC_MAX, C30_COASC1_MAX,  C30_COASC2_MAX,  C30_POLASC_MAX,
       C30_HOUSE1_MAX, C30_HOUSE2_MAX,  C30_HOUSE3_MAX,  C30_HOUSE4_MAX,
       C30_HOUSE5_MAX, C30_HOUSE6_MAX,  C30_HOUSE7_MAX,  C30_HOUSE8_MAX,
       C30_HOUSE9_MAX, C30_HOUSE10_MAX, C30_HOUSE11_MAX, C30_HOUSE12_MAX};
  static final double[] minLonC40 = new double[]
      {C40_ASC_MIN,    C40_MC_MIN,      C40_ARMC_MIN,    C40_VERTEX_MIN,
       C40_EQUASC_MIN, C40_COASC1_MIN,  C40_COASC2_MIN,  C40_POLASC_MIN,
       C40_HOUSE1_MIN, C40_HOUSE2_MIN,  C40_HOUSE3_MIN,  C40_HOUSE4_MIN,
       C40_HOUSE5_MIN, C40_HOUSE6_MIN,  C40_HOUSE7_MIN,  C40_HOUSE8_MIN,
       C40_HOUSE9_MIN, C40_HOUSE10_MIN, C40_HOUSE11_MIN, C40_HOUSE12_MIN};
  static final double[] maxLonC40 = new double[]
      {C40_ASC_MAX,    C40_MC_MAX,      C40_ARMC_MAX,    C40_VERTEX_MAX,
       C40_EQUASC_MAX, C40_COASC1_MAX,  C40_COASC2_MAX,  C40_POLASC_MAX,
       C40_HOUSE1_MAX, C40_HOUSE2_MAX,  C40_HOUSE3_MAX,  C40_HOUSE4_MAX,
       C40_HOUSE5_MAX, C40_HOUSE6_MAX,  C40_HOUSE7_MAX,  C40_HOUSE8_MAX,
       C40_HOUSE9_MAX, C40_HOUSE10_MAX, C40_HOUSE11_MAX, C40_HOUSE12_MAX};
  static final double[] minLonC50 = new double[]
      {C50_ASC_MIN,    C50_MC_MIN,      C50_ARMC_MIN,    C50_VERTEX_MIN,
       C50_EQUASC_MIN, C50_COASC1_MIN,  C50_COASC2_MIN,  C50_POLASC_MIN,
       C50_HOUSE1_MIN, C50_HOUSE2_MIN,  C50_HOUSE3_MIN,  C50_HOUSE4_MIN,
       C50_HOUSE5_MIN, C50_HOUSE6_MIN,  C50_HOUSE7_MIN,  C50_HOUSE8_MIN,
       C50_HOUSE9_MIN, C50_HOUSE10_MIN, C50_HOUSE11_MIN, C50_HOUSE12_MIN};
  static final double[] maxLonC50 = new double[]
      {C50_ASC_MAX,    C50_MC_MAX,      C50_ARMC_MAX,    C50_VERTEX_MAX,
       C50_EQUASC_MAX, C50_COASC1_MAX,  C50_COASC2_MAX,  C50_POLASC_MAX,
       C50_HOUSE1_MAX, C50_HOUSE2_MAX,  C50_HOUSE3_MAX,  C50_HOUSE4_MAX,
       C50_HOUSE5_MAX, C50_HOUSE6_MAX,  C50_HOUSE7_MAX,  C50_HOUSE8_MAX,
       C50_HOUSE9_MAX, C50_HOUSE10_MAX, C50_HOUSE11_MAX, C50_HOUSE12_MAX};
  static final double[] minLonC60 = new double[]
      {C60_ASC_MIN,    C60_MC_MIN,      C60_ARMC_MIN,    C60_VERTEX_MIN,
       C60_EQUASC_MIN, C60_COASC1_MIN,  C60_COASC2_MIN,  C60_POLASC_MIN,
       C60_HOUSE1_MIN, C60_HOUSE2_MIN,  C60_HOUSE3_MIN,  C60_HOUSE4_MIN,
       C60_HOUSE5_MIN, C60_HOUSE6_MIN,  C60_HOUSE7_MIN,  C60_HOUSE8_MIN,
       C60_HOUSE9_MIN, C60_HOUSE10_MIN, C60_HOUSE11_MIN, C60_HOUSE12_MIN};
  static final double[] maxLonC60 = new double[]
      {C60_ASC_MAX,    C60_MC_MAX,      C60_ARMC_MAX,    C60_VERTEX_MAX,
       C60_EQUASC_MAX, C60_COASC1_MAX,  C60_COASC2_MAX,  C60_POLASC_MAX,
       C60_HOUSE1_MAX, C60_HOUSE2_MAX,  C60_HOUSE3_MAX,  C60_HOUSE4_MAX,
       C60_HOUSE5_MAX, C60_HOUSE6_MAX,  C60_HOUSE7_MAX,  C60_HOUSE8_MAX,
       C60_HOUSE9_MAX, C60_HOUSE10_MAX, C60_HOUSE11_MAX, C60_HOUSE12_MAX};
  static final double[] minLonC66 = new double[]
      {C66_ASC_MIN,    C66_MC_MIN,      C66_ARMC_MIN,    C66_VERTEX_MIN,
       C66_EQUASC_MIN, C66_COASC1_MIN,  C66_COASC2_MIN,  C66_POLASC_MIN,
       C66_HOUSE1_MIN, C66_HOUSE2_MIN,  C66_HOUSE3_MIN,  C66_HOUSE4_MIN,
       C66_HOUSE5_MIN, C66_HOUSE6_MIN,  C66_HOUSE7_MIN,  C66_HOUSE8_MIN,
       C66_HOUSE9_MIN, C66_HOUSE10_MIN, C66_HOUSE11_MIN, C66_HOUSE12_MIN};
  static final double[] maxLonC66 = new double[]
      {C66_ASC_MAX,    C66_MC_MAX,      C66_ARMC_MAX,    C66_VERTEX_MAX,
       C66_EQUASC_MAX, C66_COASC1_MAX,  C66_COASC2_MAX,  C66_POLASC_MAX,
       C66_HOUSE1_MAX, C66_HOUSE2_MAX,  C66_HOUSE3_MAX,  C66_HOUSE4_MAX,
       C66_HOUSE5_MAX, C66_HOUSE6_MAX,  C66_HOUSE7_MAX,  C66_HOUSE8_MAX,
       C66_HOUSE9_MAX, C66_HOUSE10_MAX, C66_HOUSE11_MAX, C66_HOUSE12_MAX};
  static final double[] minLonC70 = new double[]
      {C70_ASC_MIN,    C70_MC_MIN,      C70_ARMC_MIN,    C70_VERTEX_MIN,
       C70_EQUASC_MIN, C70_COASC1_MIN,  C70_COASC2_MIN,  C70_POLASC_MIN,
       C70_HOUSE1_MIN, C70_HOUSE2_MIN,  C70_HOUSE3_MIN,  C70_HOUSE4_MIN,
       C70_HOUSE5_MIN, C70_HOUSE6_MIN,  C70_HOUSE7_MIN,  C70_HOUSE8_MIN,
       C70_HOUSE9_MIN, C70_HOUSE10_MIN, C70_HOUSE11_MIN, C70_HOUSE12_MIN};
  static final double[] maxLonC70 = new double[]
      {C70_ASC_MAX,    C70_MC_MAX,      C70_ARMC_MAX,    C70_VERTEX_MAX,
       C70_EQUASC_MAX, C70_COASC1_MAX,  C70_COASC2_MAX,  C70_POLASC_MAX,
       C70_HOUSE1_MAX, C70_HOUSE2_MAX,  C70_HOUSE3_MAX,  C70_HOUSE4_MAX,
       C70_HOUSE5_MAX, C70_HOUSE6_MAX,  C70_HOUSE7_MAX,  C70_HOUSE8_MAX,
       C70_HOUSE9_MAX, C70_HOUSE10_MAX, C70_HOUSE11_MAX, C70_HOUSE12_MAX};
  static final double[] minLonC80 = new double[]
      {C80_ASC_MIN,    C80_MC_MIN,      C80_ARMC_MIN,    C80_VERTEX_MIN,
       C80_EQUASC_MIN, C80_COASC1_MIN,  C80_COASC2_MIN,  C80_POLASC_MIN,
       C80_HOUSE1_MIN, C80_HOUSE2_MIN,  C80_HOUSE3_MIN,  C80_HOUSE4_MIN,
       C80_HOUSE5_MIN, C80_HOUSE6_MIN,  C80_HOUSE7_MIN,  C80_HOUSE8_MIN,
       C80_HOUSE9_MIN, C80_HOUSE10_MIN, C80_HOUSE11_MIN, C80_HOUSE12_MIN};
  static final double[] maxLonC80 = new double[]
      {C80_ASC_MAX,    C80_MC_MAX,      C80_ARMC_MAX,    C80_VERTEX_MAX,
       C80_EQUASC_MAX, C80_COASC1_MAX,  C80_COASC2_MAX,  C80_POLASC_MAX,
       C80_HOUSE1_MAX, C80_HOUSE2_MAX,  C80_HOUSE3_MAX,  C80_HOUSE4_MAX,
       C80_HOUSE5_MAX, C80_HOUSE6_MAX,  C80_HOUSE7_MAX,  C80_HOUSE8_MAX,
       C80_HOUSE9_MAX, C80_HOUSE10_MAX, C80_HOUSE11_MAX, C80_HOUSE12_MAX};
  static final double[] minLonC85 = new double[]
      {C85_ASC_MIN,    C85_MC_MIN,      C85_ARMC_MIN,    C85_VERTEX_MIN,
       C85_EQUASC_MIN, C85_COASC1_MIN,  C85_COASC2_MIN,  C85_POLASC_MIN,
       C85_HOUSE1_MIN, C85_HOUSE2_MIN,  C85_HOUSE3_MIN,  C85_HOUSE4_MIN,
       C85_HOUSE5_MIN, C85_HOUSE6_MIN,  C85_HOUSE7_MIN,  C85_HOUSE8_MIN,
       C85_HOUSE9_MIN, C85_HOUSE10_MIN, C85_HOUSE11_MIN, C85_HOUSE12_MIN};
  static final double[] maxLonC85 = new double[]
      {C85_ASC_MAX,    C85_MC_MAX,      C85_ARMC_MAX,    C85_VERTEX_MAX,
       C85_EQUASC_MAX, C85_COASC1_MAX,  C85_COASC2_MAX,  C85_POLASC_MAX,
       C85_HOUSE1_MAX, C85_HOUSE2_MAX,  C85_HOUSE3_MAX,  C85_HOUSE4_MAX,
       C85_HOUSE5_MAX, C85_HOUSE6_MAX,  C85_HOUSE7_MAX,  C85_HOUSE8_MAX,
       C85_HOUSE9_MAX, C85_HOUSE10_MAX, C85_HOUSE11_MAX, C85_HOUSE12_MAX};
  static final double[] minLonC88 = new double[]
      {C88_ASC_MIN,    C88_MC_MIN,      C88_ARMC_MIN,    C88_VERTEX_MIN,
       C88_EQUASC_MIN, C88_COASC1_MIN,  C88_COASC2_MIN,  C88_POLASC_MIN,
       C88_HOUSE1_MIN, C88_HOUSE2_MIN,  C88_HOUSE3_MIN,  C88_HOUSE4_MIN,
       C88_HOUSE5_MIN, C88_HOUSE6_MIN,  C88_HOUSE7_MIN,  C88_HOUSE8_MIN,
       C88_HOUSE9_MIN, C88_HOUSE10_MIN, C88_HOUSE11_MIN, C88_HOUSE12_MIN};
  static final double[] maxLonC88 = new double[]
      {C88_ASC_MAX,    C88_MC_MAX,      C88_ARMC_MAX,    C88_VERTEX_MAX,
       C88_EQUASC_MAX, C88_COASC1_MAX,  C88_COASC2_MAX,  C88_POLASC_MAX,
       C88_HOUSE1_MAX, C88_HOUSE2_MAX,  C88_HOUSE3_MAX,  C88_HOUSE4_MAX,
       C88_HOUSE5_MAX, C88_HOUSE6_MAX,  C88_HOUSE7_MAX,  C88_HOUSE8_MAX,
       C88_HOUSE9_MAX, C88_HOUSE10_MAX, C88_HOUSE11_MAX, C88_HOUSE12_MAX};
  static final double[] minLonC89x = new double[]
      {C89x_ASC_MIN,    C89x_MC_MIN,      C89x_ARMC_MIN,    C89x_VERTEX_MIN,
       C89x_EQUASC_MIN, C89x_COASC1_MIN,  C89x_COASC2_MIN,  C89x_POLASC_MIN,
       C89x_HOUSE1_MIN, C89x_HOUSE2_MIN,  C89x_HOUSE3_MIN,  C89x_HOUSE4_MIN,
       C89x_HOUSE5_MIN, C89x_HOUSE6_MIN,  C89x_HOUSE7_MIN,  C89x_HOUSE8_MIN,
       C89x_HOUSE9_MIN, C89x_HOUSE10_MIN, C89x_HOUSE11_MIN, C89x_HOUSE12_MIN};
  static final double[] maxLonC89x = new double[]
      {C89x_ASC_MAX,    C89x_MC_MAX,      C89x_ARMC_MAX,    C89x_VERTEX_MAX,
       C89x_EQUASC_MAX, C89x_COASC1_MAX,  C89x_COASC2_MAX,  C89x_POLASC_MAX,
       C89x_HOUSE1_MAX, C89x_HOUSE2_MAX,  C89x_HOUSE3_MAX,  C89x_HOUSE4_MAX,
       C89x_HOUSE5_MAX, C89x_HOUSE6_MAX,  C89x_HOUSE7_MAX,  C89x_HOUSE8_MAX,
       C89x_HOUSE9_MAX, C89x_HOUSE10_MAX, C89x_HOUSE11_MAX, C89x_HOUSE12_MAX};

  static final double[] minLonE10 = new double[]
      {E10_ASC_MIN,    E10_MC_MIN,      E10_ARMC_MIN,    E10_VERTEX_MIN,
       E10_EQUASC_MIN, E10_COASC1_MIN,  E10_COASC2_MIN,  E10_POLASC_MIN,
       E10_HOUSE1_MIN, E10_HOUSE2_MIN,  E10_HOUSE3_MIN,  E10_HOUSE4_MIN,
       E10_HOUSE5_MIN, E10_HOUSE6_MIN,  E10_HOUSE7_MIN,  E10_HOUSE8_MIN,
       E10_HOUSE9_MIN, E10_HOUSE10_MIN, E10_HOUSE11_MIN, E10_HOUSE12_MIN};
  static final double[] maxLonE10 = new double[]
      {E10_ASC_MAX,    E10_MC_MAX,      E10_ARMC_MAX,    E10_VERTEX_MAX,
       E10_EQUASC_MAX, E10_COASC1_MAX,  E10_COASC2_MAX,  E10_POLASC_MAX,
       E10_HOUSE1_MAX, E10_HOUSE2_MAX,  E10_HOUSE3_MAX,  E10_HOUSE4_MAX,
       E10_HOUSE5_MAX, E10_HOUSE6_MAX,  E10_HOUSE7_MAX,  E10_HOUSE8_MAX,
       E10_HOUSE9_MAX, E10_HOUSE10_MAX, E10_HOUSE11_MAX, E10_HOUSE12_MAX};
  static final double[] minLonE20 = new double[]
      {E20_ASC_MIN,    E20_MC_MIN,      E20_ARMC_MIN,    E20_VERTEX_MIN,
       E20_EQUASC_MIN, E20_COASC1_MIN,  E20_COASC2_MIN,  E20_POLASC_MIN,
       E20_HOUSE1_MIN, E20_HOUSE2_MIN,  E20_HOUSE3_MIN,  E20_HOUSE4_MIN,
       E20_HOUSE5_MIN, E20_HOUSE6_MIN,  E20_HOUSE7_MIN,  E20_HOUSE8_MIN,
       E20_HOUSE9_MIN, E20_HOUSE10_MIN, E20_HOUSE11_MIN, E20_HOUSE12_MIN};
  static final double[] maxLonE20 = new double[]
      {E20_ASC_MAX,    E20_MC_MAX,      E20_ARMC_MAX,    E20_VERTEX_MAX,
       E20_EQUASC_MAX, E20_COASC1_MAX,  E20_COASC2_MAX,  E20_POLASC_MAX,
       E20_HOUSE1_MAX, E20_HOUSE2_MAX,  E20_HOUSE3_MAX,  E20_HOUSE4_MAX,
       E20_HOUSE5_MAX, E20_HOUSE6_MAX,  E20_HOUSE7_MAX,  E20_HOUSE8_MAX,
       E20_HOUSE9_MAX, E20_HOUSE10_MAX, E20_HOUSE11_MAX, E20_HOUSE12_MAX};
  static final double[] minLonE30 = new double[]
      {E30_ASC_MIN,    E30_MC_MIN,      E30_ARMC_MIN,    E30_VERTEX_MIN,
       E30_EQUASC_MIN, E30_COASC1_MIN,  E30_COASC2_MIN,  E30_POLASC_MIN,
       E30_HOUSE1_MIN, E30_HOUSE2_MIN,  E30_HOUSE3_MIN,  E30_HOUSE4_MIN,
       E30_HOUSE5_MIN, E30_HOUSE6_MIN,  E30_HOUSE7_MIN,  E30_HOUSE8_MIN,
       E30_HOUSE9_MIN, E30_HOUSE10_MIN, E30_HOUSE11_MIN, E30_HOUSE12_MIN};
  static final double[] maxLonE30 = new double[]
      {E30_ASC_MAX,    E30_MC_MAX,      E30_ARMC_MAX,    E30_VERTEX_MAX,
       E30_EQUASC_MAX, E30_COASC1_MAX,  E30_COASC2_MAX,  E30_POLASC_MAX,
       E30_HOUSE1_MAX, E30_HOUSE2_MAX,  E30_HOUSE3_MAX,  E30_HOUSE4_MAX,
       E30_HOUSE5_MAX, E30_HOUSE6_MAX,  E30_HOUSE7_MAX,  E30_HOUSE8_MAX,
       E30_HOUSE9_MAX, E30_HOUSE10_MAX, E30_HOUSE11_MAX, E30_HOUSE12_MAX};
  static final double[] minLonE40 = new double[]
      {E40_ASC_MIN,    E40_MC_MIN,      E40_ARMC_MIN,    E40_VERTEX_MIN,
       E40_EQUASC_MIN, E40_COASC1_MIN,  E40_COASC2_MIN,  E40_POLASC_MIN,
       E40_HOUSE1_MIN, E40_HOUSE2_MIN,  E40_HOUSE3_MIN,  E40_HOUSE4_MIN,
       E40_HOUSE5_MIN, E40_HOUSE6_MIN,  E40_HOUSE7_MIN,  E40_HOUSE8_MIN,
       E40_HOUSE9_MIN, E40_HOUSE10_MIN, E40_HOUSE11_MIN, E40_HOUSE12_MIN};
  static final double[] maxLonE40 = new double[]
      {E40_ASC_MAX,    E40_MC_MAX,      E40_ARMC_MAX,    E40_VERTEX_MAX,
       E40_EQUASC_MAX, E40_COASC1_MAX,  E40_COASC2_MAX,  E40_POLASC_MAX,
       E40_HOUSE1_MAX, E40_HOUSE2_MAX,  E40_HOUSE3_MAX,  E40_HOUSE4_MAX,
       E40_HOUSE5_MAX, E40_HOUSE6_MAX,  E40_HOUSE7_MAX,  E40_HOUSE8_MAX,
       E40_HOUSE9_MAX, E40_HOUSE10_MAX, E40_HOUSE11_MAX, E40_HOUSE12_MAX};
  static final double[] minLonE50 = new double[]
      {E50_ASC_MIN,    E50_MC_MIN,      E50_ARMC_MIN,    E50_VERTEX_MIN,
       E50_EQUASC_MIN, E50_COASC1_MIN,  E50_COASC2_MIN,  E50_POLASC_MIN,
       E50_HOUSE1_MIN, E50_HOUSE2_MIN,  E50_HOUSE3_MIN,  E50_HOUSE4_MIN,
       E50_HOUSE5_MIN, E50_HOUSE6_MIN,  E50_HOUSE7_MIN,  E50_HOUSE8_MIN,
       E50_HOUSE9_MIN, E50_HOUSE10_MIN, E50_HOUSE11_MIN, E50_HOUSE12_MIN};
  static final double[] maxLonE50 = new double[]
      {E50_ASC_MAX,    E50_MC_MAX,      E50_ARMC_MAX,    E50_VERTEX_MAX,
       E50_EQUASC_MAX, E50_COASC1_MAX,  E50_COASC2_MAX,  E50_POLASC_MAX,
       E50_HOUSE1_MAX, E50_HOUSE2_MAX,  E50_HOUSE3_MAX,  E50_HOUSE4_MAX,
       E50_HOUSE5_MAX, E50_HOUSE6_MAX,  E50_HOUSE7_MAX,  E50_HOUSE8_MAX,
       E50_HOUSE9_MAX, E50_HOUSE10_MAX, E50_HOUSE11_MAX, E50_HOUSE12_MAX};
  static final double[] minLonE60 = new double[]
      {E60_ASC_MIN,    E60_MC_MIN,      E60_ARMC_MIN,    E60_VERTEX_MIN,
       E60_EQUASC_MIN, E60_COASC1_MIN,  E60_COASC2_MIN,  E60_POLASC_MIN,
       E60_HOUSE1_MIN, E60_HOUSE2_MIN,  E60_HOUSE3_MIN,  E60_HOUSE4_MIN,
       E60_HOUSE5_MIN, E60_HOUSE6_MIN,  E60_HOUSE7_MIN,  E60_HOUSE8_MIN,
       E60_HOUSE9_MIN, E60_HOUSE10_MIN, E60_HOUSE11_MIN, E60_HOUSE12_MIN};
  static final double[] maxLonE60 = new double[]
      {E60_ASC_MAX,    E60_MC_MAX,      E60_ARMC_MAX,    E60_VERTEX_MAX,
       E60_EQUASC_MAX, E60_COASC1_MAX,  E60_COASC2_MAX,  E60_POLASC_MAX,
       E60_HOUSE1_MAX, E60_HOUSE2_MAX,  E60_HOUSE3_MAX,  E60_HOUSE4_MAX,
       E60_HOUSE5_MAX, E60_HOUSE6_MAX,  E60_HOUSE7_MAX,  E60_HOUSE8_MAX,
       E60_HOUSE9_MAX, E60_HOUSE10_MAX, E60_HOUSE11_MAX, E60_HOUSE12_MAX};
  static final double[] minLonE66 = new double[]
      {E66_ASC_MIN,    E66_MC_MIN,      E66_ARMC_MIN,    E66_VERTEX_MIN,
       E66_EQUASC_MIN, E66_COASC1_MIN,  E66_COASC2_MIN,  E66_POLASC_MIN,
       E66_HOUSE1_MIN, E66_HOUSE2_MIN,  E66_HOUSE3_MIN,  E66_HOUSE4_MIN,
       E66_HOUSE5_MIN, E66_HOUSE6_MIN,  E66_HOUSE7_MIN,  E66_HOUSE8_MIN,
       E66_HOUSE9_MIN, E66_HOUSE10_MIN, E66_HOUSE11_MIN, E66_HOUSE12_MIN};
  static final double[] maxLonE66 = new double[]
      {E66_ASC_MAX,    E66_MC_MAX,      E66_ARMC_MAX,    E66_VERTEX_MAX,
       E66_EQUASC_MAX, E66_COASC1_MAX,  E66_COASC2_MAX,  E66_POLASC_MAX,
       E66_HOUSE1_MAX, E66_HOUSE2_MAX,  E66_HOUSE3_MAX,  E66_HOUSE4_MAX,
       E66_HOUSE5_MAX, E66_HOUSE6_MAX,  E66_HOUSE7_MAX,  E66_HOUSE8_MAX,
       E66_HOUSE9_MAX, E66_HOUSE10_MAX, E66_HOUSE11_MAX, E66_HOUSE12_MAX};
  static final double[] minLonE70 = new double[]
      {E70_ASC_MIN,    E70_MC_MIN,      E70_ARMC_MIN,    E70_VERTEX_MIN,
       E70_EQUASC_MIN, E70_COASC1_MIN,  E70_COASC2_MIN,  E70_POLASC_MIN,
       E70_HOUSE1_MIN, E70_HOUSE2_MIN,  E70_HOUSE3_MIN,  E70_HOUSE4_MIN,
       E70_HOUSE5_MIN, E70_HOUSE6_MIN,  E70_HOUSE7_MIN,  E70_HOUSE8_MIN,
       E70_HOUSE9_MIN, E70_HOUSE10_MIN, E70_HOUSE11_MIN, E70_HOUSE12_MIN};
  static final double[] maxLonE70 = new double[]
      {E70_ASC_MAX,    E70_MC_MAX,      E70_ARMC_MAX,    E70_VERTEX_MAX,
       E70_EQUASC_MAX, E70_COASC1_MAX,  E70_COASC2_MAX,  E70_POLASC_MAX,
       E70_HOUSE1_MAX, E70_HOUSE2_MAX,  E70_HOUSE3_MAX,  E70_HOUSE4_MAX,
       E70_HOUSE5_MAX, E70_HOUSE6_MAX,  E70_HOUSE7_MAX,  E70_HOUSE8_MAX,
       E70_HOUSE9_MAX, E70_HOUSE10_MAX, E70_HOUSE11_MAX, E70_HOUSE12_MAX};
  static final double[] minLonE80 = new double[]
      {E80_ASC_MIN,    E80_MC_MIN,      E80_ARMC_MIN,    E80_VERTEX_MIN,
       E80_EQUASC_MIN, E80_COASC1_MIN,  E80_COASC2_MIN,  E80_POLASC_MIN,
       E80_HOUSE1_MIN, E80_HOUSE2_MIN,  E80_HOUSE3_MIN,  E80_HOUSE4_MIN,
       E80_HOUSE5_MIN, E80_HOUSE6_MIN,  E80_HOUSE7_MIN,  E80_HOUSE8_MIN,
       E80_HOUSE9_MIN, E80_HOUSE10_MIN, E80_HOUSE11_MIN, E80_HOUSE12_MIN};
  static final double[] maxLonE80 = new double[]
      {E80_ASC_MAX,    E80_MC_MAX,      E80_ARMC_MAX,    E80_VERTEX_MAX,
       E80_EQUASC_MAX, E80_COASC1_MAX,  E80_COASC2_MAX,  E80_POLASC_MAX,
       E80_HOUSE1_MAX, E80_HOUSE2_MAX,  E80_HOUSE3_MAX,  E80_HOUSE4_MAX,
       E80_HOUSE5_MAX, E80_HOUSE6_MAX,  E80_HOUSE7_MAX,  E80_HOUSE8_MAX,
       E80_HOUSE9_MAX, E80_HOUSE10_MAX, E80_HOUSE11_MAX, E80_HOUSE12_MAX};
  static final double[] minLonE85 = new double[]
      {E85_ASC_MIN,    E85_MC_MIN,      E85_ARMC_MIN,    E85_VERTEX_MIN,
       E85_EQUASC_MIN, E85_COASC1_MIN,  E85_COASC2_MIN,  E85_POLASC_MIN,
       E85_HOUSE1_MIN, E85_HOUSE2_MIN,  E85_HOUSE3_MIN,  E85_HOUSE4_MIN,
       E85_HOUSE5_MIN, E85_HOUSE6_MIN,  E85_HOUSE7_MIN,  E85_HOUSE8_MIN,
       E85_HOUSE9_MIN, E85_HOUSE10_MIN, E85_HOUSE11_MIN, E85_HOUSE12_MIN};
  static final double[] maxLonE85 = new double[]
      {E85_ASC_MAX,    E85_MC_MAX,      E85_ARMC_MAX,    E85_VERTEX_MAX,
       E85_EQUASC_MAX, E85_COASC1_MAX,  E85_COASC2_MAX,  E85_POLASC_MAX,
       E85_HOUSE1_MAX, E85_HOUSE2_MAX,  E85_HOUSE3_MAX,  E85_HOUSE4_MAX,
       E85_HOUSE5_MAX, E85_HOUSE6_MAX,  E85_HOUSE7_MAX,  E85_HOUSE8_MAX,
       E85_HOUSE9_MAX, E85_HOUSE10_MAX, E85_HOUSE11_MAX, E85_HOUSE12_MAX};
  static final double[] minLonE88 = new double[]
      {E88_ASC_MIN,    E88_MC_MIN,      E88_ARMC_MIN,    E88_VERTEX_MIN,
       E88_EQUASC_MIN, E88_COASC1_MIN,  E88_COASC2_MIN,  E88_POLASC_MIN,
       E88_HOUSE1_MIN, E88_HOUSE2_MIN,  E88_HOUSE3_MIN,  E88_HOUSE4_MIN,
       E88_HOUSE5_MIN, E88_HOUSE6_MIN,  E88_HOUSE7_MIN,  E88_HOUSE8_MIN,
       E88_HOUSE9_MIN, E88_HOUSE10_MIN, E88_HOUSE11_MIN, E88_HOUSE12_MIN};
  static final double[] maxLonE88 = new double[]
      {E88_ASC_MAX,    E88_MC_MAX,      E88_ARMC_MAX,    E88_VERTEX_MAX,
       E88_EQUASC_MAX, E88_COASC1_MAX,  E88_COASC2_MAX,  E88_POLASC_MAX,
       E88_HOUSE1_MAX, E88_HOUSE2_MAX,  E88_HOUSE3_MAX,  E88_HOUSE4_MAX,
       E88_HOUSE5_MAX, E88_HOUSE6_MAX,  E88_HOUSE7_MAX,  E88_HOUSE8_MAX,
       E88_HOUSE9_MAX, E88_HOUSE10_MAX, E88_HOUSE11_MAX, E88_HOUSE12_MAX};
  static final double[] minLonE89x = new double[]
      {E89x_ASC_MIN,    E89x_MC_MIN,      E89x_ARMC_MIN,    E89x_VERTEX_MIN,
       E89x_EQUASC_MIN, E89x_COASC1_MIN,  E89x_COASC2_MIN,  E89x_POLASC_MIN,
       E89x_HOUSE1_MIN, E89x_HOUSE2_MIN,  E89x_HOUSE3_MIN,  E89x_HOUSE4_MIN,
       E89x_HOUSE5_MIN, E89x_HOUSE6_MIN,  E89x_HOUSE7_MIN,  E89x_HOUSE8_MIN,
       E89x_HOUSE9_MIN, E89x_HOUSE10_MIN, E89x_HOUSE11_MIN, E89x_HOUSE12_MIN};
  static final double[] maxLonE89x = new double[]
      {E89x_ASC_MAX,    E89x_MC_MAX,      E89x_ARMC_MAX,    E89x_VERTEX_MAX,
       E89x_EQUASC_MAX, E89x_COASC1_MAX,  E89x_COASC2_MAX,  E89x_POLASC_MAX,
       E89x_HOUSE1_MAX, E89x_HOUSE2_MAX,  E89x_HOUSE3_MAX,  E89x_HOUSE4_MAX,
       E89x_HOUSE5_MAX, E89x_HOUSE6_MAX,  E89x_HOUSE7_MAX,  E89x_HOUSE8_MAX,
       E89x_HOUSE9_MAX, E89x_HOUSE10_MAX, E89x_HOUSE11_MAX, E89x_HOUSE12_MAX};

  static final double[] minLonV10 = new double[]
      {V10_ASC_MIN,    V10_MC_MIN,      V10_ARMC_MIN,    V10_VERTEX_MIN,
       V10_EQUASC_MIN, V10_COASC1_MIN,  V10_COASC2_MIN,  V10_POLASC_MIN,
       V10_HOUSE1_MIN, V10_HOUSE2_MIN,  V10_HOUSE3_MIN,  V10_HOUSE4_MIN,
       V10_HOUSE5_MIN, V10_HOUSE6_MIN,  V10_HOUSE7_MIN,  V10_HOUSE8_MIN,
       V10_HOUSE9_MIN, V10_HOUSE10_MIN, V10_HOUSE11_MIN, V10_HOUSE12_MIN};
  static final double[] maxLonV10 = new double[]
      {V10_ASC_MAX,    V10_MC_MAX,      V10_ARMC_MAX,    V10_VERTEX_MAX,
       V10_EQUASC_MAX, V10_COASC1_MAX,  V10_COASC2_MAX,  V10_POLASC_MAX,
       V10_HOUSE1_MAX, V10_HOUSE2_MAX,  V10_HOUSE3_MAX,  V10_HOUSE4_MAX,
       V10_HOUSE5_MAX, V10_HOUSE6_MAX,  V10_HOUSE7_MAX,  V10_HOUSE8_MAX,
       V10_HOUSE9_MAX, V10_HOUSE10_MAX, V10_HOUSE11_MAX, V10_HOUSE12_MAX};
  static final double[] minLonV20 = new double[]
      {V20_ASC_MIN,    V20_MC_MIN,      V20_ARMC_MIN,    V20_VERTEX_MIN,
       V20_EQUASC_MIN, V20_COASC1_MIN,  V20_COASC2_MIN,  V20_POLASC_MIN,
       V20_HOUSE1_MIN, V20_HOUSE2_MIN,  V20_HOUSE3_MIN,  V20_HOUSE4_MIN,
       V20_HOUSE5_MIN, V20_HOUSE6_MIN,  V20_HOUSE7_MIN,  V20_HOUSE8_MIN,
       V20_HOUSE9_MIN, V20_HOUSE10_MIN, V20_HOUSE11_MIN, V20_HOUSE12_MIN};
  static final double[] maxLonV20 = new double[]
      {V20_ASC_MAX,    V20_MC_MAX,      V20_ARMC_MAX,    V20_VERTEX_MAX,
       V20_EQUASC_MAX, V20_COASC1_MAX,  V20_COASC2_MAX,  V20_POLASC_MAX,
       V20_HOUSE1_MAX, V20_HOUSE2_MAX,  V20_HOUSE3_MAX,  V20_HOUSE4_MAX,
       V20_HOUSE5_MAX, V20_HOUSE6_MAX,  V20_HOUSE7_MAX,  V20_HOUSE8_MAX,
       V20_HOUSE9_MAX, V20_HOUSE10_MAX, V20_HOUSE11_MAX, V20_HOUSE12_MAX};
  static final double[] minLonV30 = new double[]
      {V30_ASC_MIN,    V30_MC_MIN,      V30_ARMC_MIN,    V30_VERTEX_MIN,
       V30_EQUASC_MIN, V30_COASC1_MIN,  V30_COASC2_MIN,  V30_POLASC_MIN,
       V30_HOUSE1_MIN, V30_HOUSE2_MIN,  V30_HOUSE3_MIN,  V30_HOUSE4_MIN,
       V30_HOUSE5_MIN, V30_HOUSE6_MIN,  V30_HOUSE7_MIN,  V30_HOUSE8_MIN,
       V30_HOUSE9_MIN, V30_HOUSE10_MIN, V30_HOUSE11_MIN, V30_HOUSE12_MIN};
  static final double[] maxLonV30 = new double[]
      {V30_ASC_MAX,    V30_MC_MAX,      V30_ARMC_MAX,    V30_VERTEX_MAX,
       V30_EQUASC_MAX, V30_COASC1_MAX,  V30_COASC2_MAX,  V30_POLASC_MAX,
       V30_HOUSE1_MAX, V30_HOUSE2_MAX,  V30_HOUSE3_MAX,  V30_HOUSE4_MAX,
       V30_HOUSE5_MAX, V30_HOUSE6_MAX,  V30_HOUSE7_MAX,  V30_HOUSE8_MAX,
       V30_HOUSE9_MAX, V30_HOUSE10_MAX, V30_HOUSE11_MAX, V30_HOUSE12_MAX};
  static final double[] minLonV40 = new double[]
      {V40_ASC_MIN,    V40_MC_MIN,      V40_ARMC_MIN,    V40_VERTEX_MIN,
       V40_EQUASC_MIN, V40_COASC1_MIN,  V40_COASC2_MIN,  V40_POLASC_MIN,
       V40_HOUSE1_MIN, V40_HOUSE2_MIN,  V40_HOUSE3_MIN,  V40_HOUSE4_MIN,
       V40_HOUSE5_MIN, V40_HOUSE6_MIN,  V40_HOUSE7_MIN,  V40_HOUSE8_MIN,
       V40_HOUSE9_MIN, V40_HOUSE10_MIN, V40_HOUSE11_MIN, V40_HOUSE12_MIN};
  static final double[] maxLonV40 = new double[]
      {V40_ASC_MAX,    V40_MC_MAX,      V40_ARMC_MAX,    V40_VERTEX_MAX,
       V40_EQUASC_MAX, V40_COASC1_MAX,  V40_COASC2_MAX,  V40_POLASC_MAX,
       V40_HOUSE1_MAX, V40_HOUSE2_MAX,  V40_HOUSE3_MAX,  V40_HOUSE4_MAX,
       V40_HOUSE5_MAX, V40_HOUSE6_MAX,  V40_HOUSE7_MAX,  V40_HOUSE8_MAX,
       V40_HOUSE9_MAX, V40_HOUSE10_MAX, V40_HOUSE11_MAX, V40_HOUSE12_MAX};
  static final double[] minLonV50 = new double[]
      {V50_ASC_MIN,    V50_MC_MIN,      V50_ARMC_MIN,    V50_VERTEX_MIN,
       V50_EQUASC_MIN, V50_COASC1_MIN,  V50_COASC2_MIN,  V50_POLASC_MIN,
       V50_HOUSE1_MIN, V50_HOUSE2_MIN,  V50_HOUSE3_MIN,  V50_HOUSE4_MIN,
       V50_HOUSE5_MIN, V50_HOUSE6_MIN,  V50_HOUSE7_MIN,  V50_HOUSE8_MIN,
       V50_HOUSE9_MIN, V50_HOUSE10_MIN, V50_HOUSE11_MIN, V50_HOUSE12_MIN};
  static final double[] maxLonV50 = new double[]
      {V50_ASC_MAX,    V50_MC_MAX,      V50_ARMC_MAX,    V50_VERTEX_MAX,
       V50_EQUASC_MAX, V50_COASC1_MAX,  V50_COASC2_MAX,  V50_POLASC_MAX,
       V50_HOUSE1_MAX, V50_HOUSE2_MAX,  V50_HOUSE3_MAX,  V50_HOUSE4_MAX,
       V50_HOUSE5_MAX, V50_HOUSE6_MAX,  V50_HOUSE7_MAX,  V50_HOUSE8_MAX,
       V50_HOUSE9_MAX, V50_HOUSE10_MAX, V50_HOUSE11_MAX, V50_HOUSE12_MAX};
  static final double[] minLonV60 = new double[]
      {V60_ASC_MIN,    V60_MC_MIN,      V60_ARMC_MIN,    V60_VERTEX_MIN,
       V60_EQUASC_MIN, V60_COASC1_MIN,  V60_COASC2_MIN,  V60_POLASC_MIN,
       V60_HOUSE1_MIN, V60_HOUSE2_MIN,  V60_HOUSE3_MIN,  V60_HOUSE4_MIN,
       V60_HOUSE5_MIN, V60_HOUSE6_MIN,  V60_HOUSE7_MIN,  V60_HOUSE8_MIN,
       V60_HOUSE9_MIN, V60_HOUSE10_MIN, V60_HOUSE11_MIN, V60_HOUSE12_MIN};
  static final double[] maxLonV60 = new double[]
      {V60_ASC_MAX,    V60_MC_MAX,      V60_ARMC_MAX,    V60_VERTEX_MAX,
       V60_EQUASC_MAX, V60_COASC1_MAX,  V60_COASC2_MAX,  V60_POLASC_MAX,
       V60_HOUSE1_MAX, V60_HOUSE2_MAX,  V60_HOUSE3_MAX,  V60_HOUSE4_MAX,
       V60_HOUSE5_MAX, V60_HOUSE6_MAX,  V60_HOUSE7_MAX,  V60_HOUSE8_MAX,
       V60_HOUSE9_MAX, V60_HOUSE10_MAX, V60_HOUSE11_MAX, V60_HOUSE12_MAX};
  static final double[] minLonV66 = new double[]
      {V66_ASC_MIN,    V66_MC_MIN,      V66_ARMC_MIN,    V66_VERTEX_MIN,
       V66_EQUASC_MIN, V66_COASC1_MIN,  V66_COASC2_MIN,  V66_POLASC_MIN,
       V66_HOUSE1_MIN, V66_HOUSE2_MIN,  V66_HOUSE3_MIN,  V66_HOUSE4_MIN,
       V66_HOUSE5_MIN, V66_HOUSE6_MIN,  V66_HOUSE7_MIN,  V66_HOUSE8_MIN,
       V66_HOUSE9_MIN, V66_HOUSE10_MIN, V66_HOUSE11_MIN, V66_HOUSE12_MIN};
  static final double[] maxLonV66 = new double[]
      {V66_ASC_MAX,    V66_MC_MAX,      V66_ARMC_MAX,    V66_VERTEX_MAX,
       V66_EQUASC_MAX, V66_COASC1_MAX,  V66_COASC2_MAX,  V66_POLASC_MAX,
       V66_HOUSE1_MAX, V66_HOUSE2_MAX,  V66_HOUSE3_MAX,  V66_HOUSE4_MAX,
       V66_HOUSE5_MAX, V66_HOUSE6_MAX,  V66_HOUSE7_MAX,  V66_HOUSE8_MAX,
       V66_HOUSE9_MAX, V66_HOUSE10_MAX, V66_HOUSE11_MAX, V66_HOUSE12_MAX};
  static final double[] minLonV70 = new double[]
      {V70_ASC_MIN,    V70_MC_MIN,      V70_ARMC_MIN,    V70_VERTEX_MIN,
       V70_EQUASC_MIN, V70_COASC1_MIN,  V70_COASC2_MIN,  V70_POLASC_MIN,
       V70_HOUSE1_MIN, V70_HOUSE2_MIN,  V70_HOUSE3_MIN,  V70_HOUSE4_MIN,
       V70_HOUSE5_MIN, V70_HOUSE6_MIN,  V70_HOUSE7_MIN,  V70_HOUSE8_MIN,
       V70_HOUSE9_MIN, V70_HOUSE10_MIN, V70_HOUSE11_MIN, V70_HOUSE12_MIN};
  static final double[] maxLonV70 = new double[]
      {V70_ASC_MAX,    V70_MC_MAX,      V70_ARMC_MAX,    V70_VERTEX_MAX,
       V70_EQUASC_MAX, V70_COASC1_MAX,  V70_COASC2_MAX,  V70_POLASC_MAX,
       V70_HOUSE1_MAX, V70_HOUSE2_MAX,  V70_HOUSE3_MAX,  V70_HOUSE4_MAX,
       V70_HOUSE5_MAX, V70_HOUSE6_MAX,  V70_HOUSE7_MAX,  V70_HOUSE8_MAX,
       V70_HOUSE9_MAX, V70_HOUSE10_MAX, V70_HOUSE11_MAX, V70_HOUSE12_MAX};
  static final double[] minLonV80 = new double[]
      {V80_ASC_MIN,    V80_MC_MIN,      V80_ARMC_MIN,    V80_VERTEX_MIN,
       V80_EQUASC_MIN, V80_COASC1_MIN,  V80_COASC2_MIN,  V80_POLASC_MIN,
       V80_HOUSE1_MIN, V80_HOUSE2_MIN,  V80_HOUSE3_MIN,  V80_HOUSE4_MIN,
       V80_HOUSE5_MIN, V80_HOUSE6_MIN,  V80_HOUSE7_MIN,  V80_HOUSE8_MIN,
       V80_HOUSE9_MIN, V80_HOUSE10_MIN, V80_HOUSE11_MIN, V80_HOUSE12_MIN};
  static final double[] maxLonV80 = new double[]
      {V80_ASC_MAX,    V80_MC_MAX,      V80_ARMC_MAX,    V80_VERTEX_MAX,
       V80_EQUASC_MAX, V80_COASC1_MAX,  V80_COASC2_MAX,  V80_POLASC_MAX,
       V80_HOUSE1_MAX, V80_HOUSE2_MAX,  V80_HOUSE3_MAX,  V80_HOUSE4_MAX,
       V80_HOUSE5_MAX, V80_HOUSE6_MAX,  V80_HOUSE7_MAX,  V80_HOUSE8_MAX,
       V80_HOUSE9_MAX, V80_HOUSE10_MAX, V80_HOUSE11_MAX, V80_HOUSE12_MAX};
  static final double[] minLonV85 = new double[]
      {V85_ASC_MIN,    V85_MC_MIN,      V85_ARMC_MIN,    V85_VERTEX_MIN,
       V85_EQUASC_MIN, V85_COASC1_MIN,  V85_COASC2_MIN,  V85_POLASC_MIN,
       V85_HOUSE1_MIN, V85_HOUSE2_MIN,  V85_HOUSE3_MIN,  V85_HOUSE4_MIN,
       V85_HOUSE5_MIN, V85_HOUSE6_MIN,  V85_HOUSE7_MIN,  V85_HOUSE8_MIN,
       V85_HOUSE9_MIN, V85_HOUSE10_MIN, V85_HOUSE11_MIN, V85_HOUSE12_MIN};
  static final double[] maxLonV85 = new double[]
      {V85_ASC_MAX,    V85_MC_MAX,      V85_ARMC_MAX,    V85_VERTEX_MAX,
       V85_EQUASC_MAX, V85_COASC1_MAX,  V85_COASC2_MAX,  V85_POLASC_MAX,
       V85_HOUSE1_MAX, V85_HOUSE2_MAX,  V85_HOUSE3_MAX,  V85_HOUSE4_MAX,
       V85_HOUSE5_MAX, V85_HOUSE6_MAX,  V85_HOUSE7_MAX,  V85_HOUSE8_MAX,
       V85_HOUSE9_MAX, V85_HOUSE10_MAX, V85_HOUSE11_MAX, V85_HOUSE12_MAX};
  static final double[] minLonV88 = new double[]
      {V88_ASC_MIN,    V88_MC_MIN,      V88_ARMC_MIN,    V88_VERTEX_MIN,
       V88_EQUASC_MIN, V88_COASC1_MIN,  V88_COASC2_MIN,  V88_POLASC_MIN,
       V88_HOUSE1_MIN, V88_HOUSE2_MIN,  V88_HOUSE3_MIN,  V88_HOUSE4_MIN,
       V88_HOUSE5_MIN, V88_HOUSE6_MIN,  V88_HOUSE7_MIN,  V88_HOUSE8_MIN,
       V88_HOUSE9_MIN, V88_HOUSE10_MIN, V88_HOUSE11_MIN, V88_HOUSE12_MIN};
  static final double[] maxLonV88 = new double[]
      {V88_ASC_MAX,    V88_MC_MAX,      V88_ARMC_MAX,    V88_VERTEX_MAX,
       V88_EQUASC_MAX, V88_COASC1_MAX,  V88_COASC2_MAX,  V88_POLASC_MAX,
       V88_HOUSE1_MAX, V88_HOUSE2_MAX,  V88_HOUSE3_MAX,  V88_HOUSE4_MAX,
       V88_HOUSE5_MAX, V88_HOUSE6_MAX,  V88_HOUSE7_MAX,  V88_HOUSE8_MAX,
       V88_HOUSE9_MAX, V88_HOUSE10_MAX, V88_HOUSE11_MAX, V88_HOUSE12_MAX};
  static final double[] minLonV89x = new double[]
      {V89x_ASC_MIN,    V89x_MC_MIN,      V89x_ARMC_MIN,    V89x_VERTEX_MIN,
       V89x_EQUASC_MIN, V89x_COASC1_MIN,  V89x_COASC2_MIN,  V89x_POLASC_MIN,
       V89x_HOUSE1_MIN, V89x_HOUSE2_MIN,  V89x_HOUSE3_MIN,  V89x_HOUSE4_MIN,
       V89x_HOUSE5_MIN, V89x_HOUSE6_MIN,  V89x_HOUSE7_MIN,  V89x_HOUSE8_MIN,
       V89x_HOUSE9_MIN, V89x_HOUSE10_MIN, V89x_HOUSE11_MIN, V89x_HOUSE12_MIN};
  static final double[] maxLonV89x = new double[]
      {V89x_ASC_MAX,    V89x_MC_MAX,      V89x_ARMC_MAX,    V89x_VERTEX_MAX,
       V89x_EQUASC_MAX, V89x_COASC1_MAX,  V89x_COASC2_MAX,  V89x_POLASC_MAX,
       V89x_HOUSE1_MAX, V89x_HOUSE2_MAX,  V89x_HOUSE3_MAX,  V89x_HOUSE4_MAX,
       V89x_HOUSE5_MAX, V89x_HOUSE6_MAX,  V89x_HOUSE7_MAX,  V89x_HOUSE8_MAX,
       V89x_HOUSE9_MAX, V89x_HOUSE10_MAX, V89x_HOUSE11_MAX, V89x_HOUSE12_MAX};

  static final double[] minLonX10 = new double[]
      {X10_ASC_MIN,    X10_MC_MIN,      X10_ARMC_MIN,    X10_VERTEX_MIN,
       X10_EQUASC_MIN, X10_COASC1_MIN,  X10_COASC2_MIN,  X10_POLASC_MIN,
       X10_HOUSE1_MIN, X10_HOUSE2_MIN,  X10_HOUSE3_MIN,  X10_HOUSE4_MIN,
       X10_HOUSE5_MIN, X10_HOUSE6_MIN,  X10_HOUSE7_MIN,  X10_HOUSE8_MIN,
       X10_HOUSE9_MIN, X10_HOUSE10_MIN, X10_HOUSE11_MIN, X10_HOUSE12_MIN};
  static final double[] maxLonX10 = new double[]
      {X10_ASC_MAX,    X10_MC_MAX,      X10_ARMC_MAX,    X10_VERTEX_MAX,
       X10_EQUASC_MAX, X10_COASC1_MAX,  X10_COASC2_MAX,  X10_POLASC_MAX,
       X10_HOUSE1_MAX, X10_HOUSE2_MAX,  X10_HOUSE3_MAX,  X10_HOUSE4_MAX,
       X10_HOUSE5_MAX, X10_HOUSE6_MAX,  X10_HOUSE7_MAX,  X10_HOUSE8_MAX,
       X10_HOUSE9_MAX, X10_HOUSE10_MAX, X10_HOUSE11_MAX, X10_HOUSE12_MAX};
  static final double[] minLonX20 = new double[]
      {X20_ASC_MIN,    X20_MC_MIN,      X20_ARMC_MIN,    X20_VERTEX_MIN,
       X20_EQUASC_MIN, X20_COASC1_MIN,  X20_COASC2_MIN,  X20_POLASC_MIN,
       X20_HOUSE1_MIN, X20_HOUSE2_MIN,  X20_HOUSE3_MIN,  X20_HOUSE4_MIN,
       X20_HOUSE5_MIN, X20_HOUSE6_MIN,  X20_HOUSE7_MIN,  X20_HOUSE8_MIN,
       X20_HOUSE9_MIN, X20_HOUSE10_MIN, X20_HOUSE11_MIN, X20_HOUSE12_MIN};
  static final double[] maxLonX20 = new double[]
      {X20_ASC_MAX,    X20_MC_MAX,      X20_ARMC_MAX,    X20_VERTEX_MAX,
       X20_EQUASC_MAX, X20_COASC1_MAX,  X20_COASC2_MAX,  X20_POLASC_MAX,
       X20_HOUSE1_MAX, X20_HOUSE2_MAX,  X20_HOUSE3_MAX,  X20_HOUSE4_MAX,
       X20_HOUSE5_MAX, X20_HOUSE6_MAX,  X20_HOUSE7_MAX,  X20_HOUSE8_MAX,
       X20_HOUSE9_MAX, X20_HOUSE10_MAX, X20_HOUSE11_MAX, X20_HOUSE12_MAX};
  static final double[] minLonX30 = new double[]
      {X30_ASC_MIN,    X30_MC_MIN,      X30_ARMC_MIN,    X30_VERTEX_MIN,
       X30_EQUASC_MIN, X30_COASC1_MIN,  X30_COASC2_MIN,  X30_POLASC_MIN,
       X30_HOUSE1_MIN, X30_HOUSE2_MIN,  X30_HOUSE3_MIN,  X30_HOUSE4_MIN,
       X30_HOUSE5_MIN, X30_HOUSE6_MIN,  X30_HOUSE7_MIN,  X30_HOUSE8_MIN,
       X30_HOUSE9_MIN, X30_HOUSE10_MIN, X30_HOUSE11_MIN, X30_HOUSE12_MIN};
  static final double[] maxLonX30 = new double[]
      {X30_ASC_MAX,    X30_MC_MAX,      X30_ARMC_MAX,    X30_VERTEX_MAX,
       X30_EQUASC_MAX, X30_COASC1_MAX,  X30_COASC2_MAX,  X30_POLASC_MAX,
       X30_HOUSE1_MAX, X30_HOUSE2_MAX,  X30_HOUSE3_MAX,  X30_HOUSE4_MAX,
       X30_HOUSE5_MAX, X30_HOUSE6_MAX,  X30_HOUSE7_MAX,  X30_HOUSE8_MAX,
       X30_HOUSE9_MAX, X30_HOUSE10_MAX, X30_HOUSE11_MAX, X30_HOUSE12_MAX};
  static final double[] minLonX40 = new double[]
      {X40_ASC_MIN,    X40_MC_MIN,      X40_ARMC_MIN,    X40_VERTEX_MIN,
       X40_EQUASC_MIN, X40_COASC1_MIN,  X40_COASC2_MIN,  X40_POLASC_MIN,
       X40_HOUSE1_MIN, X40_HOUSE2_MIN,  X40_HOUSE3_MIN,  X40_HOUSE4_MIN,
       X40_HOUSE5_MIN, X40_HOUSE6_MIN,  X40_HOUSE7_MIN,  X40_HOUSE8_MIN,
       X40_HOUSE9_MIN, X40_HOUSE10_MIN, X40_HOUSE11_MIN, X40_HOUSE12_MIN};
  static final double[] maxLonX40 = new double[]
      {X40_ASC_MAX,    X40_MC_MAX,      X40_ARMC_MAX,    X40_VERTEX_MAX,
       X40_EQUASC_MAX, X40_COASC1_MAX,  X40_COASC2_MAX,  X40_POLASC_MAX,
       X40_HOUSE1_MAX, X40_HOUSE2_MAX,  X40_HOUSE3_MAX,  X40_HOUSE4_MAX,
       X40_HOUSE5_MAX, X40_HOUSE6_MAX,  X40_HOUSE7_MAX,  X40_HOUSE8_MAX,
       X40_HOUSE9_MAX, X40_HOUSE10_MAX, X40_HOUSE11_MAX, X40_HOUSE12_MAX};
  static final double[] minLonX50 = new double[]
      {X50_ASC_MIN,    X50_MC_MIN,      X50_ARMC_MIN,    X50_VERTEX_MIN,
       X50_EQUASC_MIN, X50_COASC1_MIN,  X50_COASC2_MIN,  X50_POLASC_MIN,
       X50_HOUSE1_MIN, X50_HOUSE2_MIN,  X50_HOUSE3_MIN,  X50_HOUSE4_MIN,
       X50_HOUSE5_MIN, X50_HOUSE6_MIN,  X50_HOUSE7_MIN,  X50_HOUSE8_MIN,
       X50_HOUSE9_MIN, X50_HOUSE10_MIN, X50_HOUSE11_MIN, X50_HOUSE12_MIN};
  static final double[] maxLonX50 = new double[]
      {X50_ASC_MAX,    X50_MC_MAX,      X50_ARMC_MAX,    X50_VERTEX_MAX,
       X50_EQUASC_MAX, X50_COASC1_MAX,  X50_COASC2_MAX,  X50_POLASC_MAX,
       X50_HOUSE1_MAX, X50_HOUSE2_MAX,  X50_HOUSE3_MAX,  X50_HOUSE4_MAX,
       X50_HOUSE5_MAX, X50_HOUSE6_MAX,  X50_HOUSE7_MAX,  X50_HOUSE8_MAX,
       X50_HOUSE9_MAX, X50_HOUSE10_MAX, X50_HOUSE11_MAX, X50_HOUSE12_MAX};
  static final double[] minLonX60 = new double[]
      {X60_ASC_MIN,    X60_MC_MIN,      X60_ARMC_MIN,    X60_VERTEX_MIN,
       X60_EQUASC_MIN, X60_COASC1_MIN,  X60_COASC2_MIN,  X60_POLASC_MIN,
       X60_HOUSE1_MIN, X60_HOUSE2_MIN,  X60_HOUSE3_MIN,  X60_HOUSE4_MIN,
       X60_HOUSE5_MIN, X60_HOUSE6_MIN,  X60_HOUSE7_MIN,  X60_HOUSE8_MIN,
       X60_HOUSE9_MIN, X60_HOUSE10_MIN, X60_HOUSE11_MIN, X60_HOUSE12_MIN};
  static final double[] maxLonX60 = new double[]
      {X60_ASC_MAX,    X60_MC_MAX,      X60_ARMC_MAX,    X60_VERTEX_MAX,
       X60_EQUASC_MAX, X60_COASC1_MAX,  X60_COASC2_MAX,  X60_POLASC_MAX,
       X60_HOUSE1_MAX, X60_HOUSE2_MAX,  X60_HOUSE3_MAX,  X60_HOUSE4_MAX,
       X60_HOUSE5_MAX, X60_HOUSE6_MAX,  X60_HOUSE7_MAX,  X60_HOUSE8_MAX,
       X60_HOUSE9_MAX, X60_HOUSE10_MAX, X60_HOUSE11_MAX, X60_HOUSE12_MAX};
  static final double[] minLonX66 = new double[]
      {X66_ASC_MIN,    X66_MC_MIN,      X66_ARMC_MIN,    X66_VERTEX_MIN,
       X66_EQUASC_MIN, X66_COASC1_MIN,  X66_COASC2_MIN,  X66_POLASC_MIN,
       X66_HOUSE1_MIN, X66_HOUSE2_MIN,  X66_HOUSE3_MIN,  X66_HOUSE4_MIN,
       X66_HOUSE5_MIN, X66_HOUSE6_MIN,  X66_HOUSE7_MIN,  X66_HOUSE8_MIN,
       X66_HOUSE9_MIN, X66_HOUSE10_MIN, X66_HOUSE11_MIN, X66_HOUSE12_MIN};
  static final double[] maxLonX66 = new double[]
      {X66_ASC_MAX,    X66_MC_MAX,      X66_ARMC_MAX,    X66_VERTEX_MAX,
       X66_EQUASC_MAX, X66_COASC1_MAX,  X66_COASC2_MAX,  X66_POLASC_MAX,
       X66_HOUSE1_MAX, X66_HOUSE2_MAX,  X66_HOUSE3_MAX,  X66_HOUSE4_MAX,
       X66_HOUSE5_MAX, X66_HOUSE6_MAX,  X66_HOUSE7_MAX,  X66_HOUSE8_MAX,
       X66_HOUSE9_MAX, X66_HOUSE10_MAX, X66_HOUSE11_MAX, X66_HOUSE12_MAX};
  static final double[] minLonX70 = new double[]
      {X70_ASC_MIN,    X70_MC_MIN,      X70_ARMC_MIN,    X70_VERTEX_MIN,
       X70_EQUASC_MIN, X70_COASC1_MIN,  X70_COASC2_MIN,  X70_POLASC_MIN,
       X70_HOUSE1_MIN, X70_HOUSE2_MIN,  X70_HOUSE3_MIN,  X70_HOUSE4_MIN,
       X70_HOUSE5_MIN, X70_HOUSE6_MIN,  X70_HOUSE7_MIN,  X70_HOUSE8_MIN,
       X70_HOUSE9_MIN, X70_HOUSE10_MIN, X70_HOUSE11_MIN, X70_HOUSE12_MIN};
  static final double[] maxLonX70 = new double[]
      {X70_ASC_MAX,    X70_MC_MAX,      X70_ARMC_MAX,    X70_VERTEX_MAX,
       X70_EQUASC_MAX, X70_COASC1_MAX,  X70_COASC2_MAX,  X70_POLASC_MAX,
       X70_HOUSE1_MAX, X70_HOUSE2_MAX,  X70_HOUSE3_MAX,  X70_HOUSE4_MAX,
       X70_HOUSE5_MAX, X70_HOUSE6_MAX,  X70_HOUSE7_MAX,  X70_HOUSE8_MAX,
       X70_HOUSE9_MAX, X70_HOUSE10_MAX, X70_HOUSE11_MAX, X70_HOUSE12_MAX};
  static final double[] minLonX80 = new double[]
      {X80_ASC_MIN,    X80_MC_MIN,      X80_ARMC_MIN,    X80_VERTEX_MIN,
       X80_EQUASC_MIN, X80_COASC1_MIN,  X80_COASC2_MIN,  X80_POLASC_MIN,
       X80_HOUSE1_MIN, X80_HOUSE2_MIN,  X80_HOUSE3_MIN,  X80_HOUSE4_MIN,
       X80_HOUSE5_MIN, X80_HOUSE6_MIN,  X80_HOUSE7_MIN,  X80_HOUSE8_MIN,
       X80_HOUSE9_MIN, X80_HOUSE10_MIN, X80_HOUSE11_MIN, X80_HOUSE12_MIN};
  static final double[] maxLonX80 = new double[]
      {X80_ASC_MAX,    X80_MC_MAX,      X80_ARMC_MAX,    X80_VERTEX_MAX,
       X80_EQUASC_MAX, X80_COASC1_MAX,  X80_COASC2_MAX,  X80_POLASC_MAX,
       X80_HOUSE1_MAX, X80_HOUSE2_MAX,  X80_HOUSE3_MAX,  X80_HOUSE4_MAX,
       X80_HOUSE5_MAX, X80_HOUSE6_MAX,  X80_HOUSE7_MAX,  X80_HOUSE8_MAX,
       X80_HOUSE9_MAX, X80_HOUSE10_MAX, X80_HOUSE11_MAX, X80_HOUSE12_MAX};
  static final double[] minLonX85 = new double[]
      {X85_ASC_MIN,    X85_MC_MIN,      X85_ARMC_MIN,    X85_VERTEX_MIN,
       X85_EQUASC_MIN, X85_COASC1_MIN,  X85_COASC2_MIN,  X85_POLASC_MIN,
       X85_HOUSE1_MIN, X85_HOUSE2_MIN,  X85_HOUSE3_MIN,  X85_HOUSE4_MIN,
       X85_HOUSE5_MIN, X85_HOUSE6_MIN,  X85_HOUSE7_MIN,  X85_HOUSE8_MIN,
       X85_HOUSE9_MIN, X85_HOUSE10_MIN, X85_HOUSE11_MIN, X85_HOUSE12_MIN};
  static final double[] maxLonX85 = new double[]
      {X85_ASC_MAX,    X85_MC_MAX,      X85_ARMC_MAX,    X85_VERTEX_MAX,
       X85_EQUASC_MAX, X85_COASC1_MAX,  X85_COASC2_MAX,  X85_POLASC_MAX,
       X85_HOUSE1_MAX, X85_HOUSE2_MAX,  X85_HOUSE3_MAX,  X85_HOUSE4_MAX,
       X85_HOUSE5_MAX, X85_HOUSE6_MAX,  X85_HOUSE7_MAX,  X85_HOUSE8_MAX,
       X85_HOUSE9_MAX, X85_HOUSE10_MAX, X85_HOUSE11_MAX, X85_HOUSE12_MAX};
  static final double[] minLonX88 = new double[]
      {X88_ASC_MIN,    X88_MC_MIN,      X88_ARMC_MIN,    X88_VERTEX_MIN,
       X88_EQUASC_MIN, X88_COASC1_MIN,  X88_COASC2_MIN,  X88_POLASC_MIN,
       X88_HOUSE1_MIN, X88_HOUSE2_MIN,  X88_HOUSE3_MIN,  X88_HOUSE4_MIN,
       X88_HOUSE5_MIN, X88_HOUSE6_MIN,  X88_HOUSE7_MIN,  X88_HOUSE8_MIN,
       X88_HOUSE9_MIN, X88_HOUSE10_MIN, X88_HOUSE11_MIN, X88_HOUSE12_MIN};
  static final double[] maxLonX88 = new double[]
      {X88_ASC_MAX,    X88_MC_MAX,      X88_ARMC_MAX,    X88_VERTEX_MAX,
       X88_EQUASC_MAX, X88_COASC1_MAX,  X88_COASC2_MAX,  X88_POLASC_MAX,
       X88_HOUSE1_MAX, X88_HOUSE2_MAX,  X88_HOUSE3_MAX,  X88_HOUSE4_MAX,
       X88_HOUSE5_MAX, X88_HOUSE6_MAX,  X88_HOUSE7_MAX,  X88_HOUSE8_MAX,
       X88_HOUSE9_MAX, X88_HOUSE10_MAX, X88_HOUSE11_MAX, X88_HOUSE12_MAX};
  static final double[] minLonX89x = new double[]
      {X89x_ASC_MIN,    X89x_MC_MIN,      X89x_ARMC_MIN,    X89x_VERTEX_MIN,
       X89x_EQUASC_MIN, X89x_COASC1_MIN,  X89x_COASC2_MIN,  X89x_POLASC_MIN,
       X89x_HOUSE1_MIN, X89x_HOUSE2_MIN,  X89x_HOUSE3_MIN,  X89x_HOUSE4_MIN,
       X89x_HOUSE5_MIN, X89x_HOUSE6_MIN,  X89x_HOUSE7_MIN,  X89x_HOUSE8_MIN,
       X89x_HOUSE9_MIN, X89x_HOUSE10_MIN, X89x_HOUSE11_MIN, X89x_HOUSE12_MIN};
  static final double[] maxLonX89x = new double[]
      {X89x_ASC_MAX,    X89x_MC_MAX,      X89x_ARMC_MAX,    X89x_VERTEX_MAX,
       X89x_EQUASC_MAX, X89x_COASC1_MAX,  X89x_COASC2_MAX,  X89x_POLASC_MAX,
       X89x_HOUSE1_MAX, X89x_HOUSE2_MAX,  X89x_HOUSE3_MAX,  X89x_HOUSE4_MAX,
       X89x_HOUSE5_MAX, X89x_HOUSE6_MAX,  X89x_HOUSE7_MAX,  X89x_HOUSE8_MAX,
       X89x_HOUSE9_MAX, X89x_HOUSE10_MAX, X89x_HOUSE11_MAX, X89x_HOUSE12_MAX};

  static final double[] minLonH10 = new double[]
      {H10_ASC_MIN,    H10_MC_MIN,      H10_ARMC_MIN,    H10_VERTEX_MIN,
       H10_EQUASC_MIN, H10_COASC1_MIN,  H10_COASC2_MIN,  H10_POLASC_MIN,
       H10_HOUSE1_MIN, H10_HOUSE2_MIN,  H10_HOUSE3_MIN,  H10_HOUSE4_MIN,
       H10_HOUSE5_MIN, H10_HOUSE6_MIN,  H10_HOUSE7_MIN,  H10_HOUSE8_MIN,
       H10_HOUSE9_MIN, H10_HOUSE10_MIN, H10_HOUSE11_MIN, H10_HOUSE12_MIN};
  static final double[] maxLonH10 = new double[]
      {H10_ASC_MAX,    H10_MC_MAX,      H10_ARMC_MAX,    H10_VERTEX_MAX,
       H10_EQUASC_MAX, H10_COASC1_MAX,  H10_COASC2_MAX,  H10_POLASC_MAX,
       H10_HOUSE1_MAX, H10_HOUSE2_MAX,  H10_HOUSE3_MAX,  H10_HOUSE4_MAX,
       H10_HOUSE5_MAX, H10_HOUSE6_MAX,  H10_HOUSE7_MAX,  H10_HOUSE8_MAX,
       H10_HOUSE9_MAX, H10_HOUSE10_MAX, H10_HOUSE11_MAX, H10_HOUSE12_MAX};
  static final double[] minLonH20 = new double[]
      {H20_ASC_MIN,    H20_MC_MIN,      H20_ARMC_MIN,    H20_VERTEX_MIN,
       H20_EQUASC_MIN, H20_COASC1_MIN,  H20_COASC2_MIN,  H20_POLASC_MIN,
       H20_HOUSE1_MIN, H20_HOUSE2_MIN,  H20_HOUSE3_MIN,  H20_HOUSE4_MIN,
       H20_HOUSE5_MIN, H20_HOUSE6_MIN,  H20_HOUSE7_MIN,  H20_HOUSE8_MIN,
       H20_HOUSE9_MIN, H20_HOUSE10_MIN, H20_HOUSE11_MIN, H20_HOUSE12_MIN};
  static final double[] maxLonH20 = new double[]
      {H20_ASC_MAX,    H20_MC_MAX,      H20_ARMC_MAX,    H20_VERTEX_MAX,
       H20_EQUASC_MAX, H20_COASC1_MAX,  H20_COASC2_MAX,  H20_POLASC_MAX,
       H20_HOUSE1_MAX, H20_HOUSE2_MAX,  H20_HOUSE3_MAX,  H20_HOUSE4_MAX,
       H20_HOUSE5_MAX, H20_HOUSE6_MAX,  H20_HOUSE7_MAX,  H20_HOUSE8_MAX,
       H20_HOUSE9_MAX, H20_HOUSE10_MAX, H20_HOUSE11_MAX, H20_HOUSE12_MAX};
  static final double[] minLonH30 = new double[]
      {H30_ASC_MIN,    H30_MC_MIN,      H30_ARMC_MIN,    H30_VERTEX_MIN,
       H30_EQUASC_MIN, H30_COASC1_MIN,  H30_COASC2_MIN,  H30_POLASC_MIN,
       H30_HOUSE1_MIN, H30_HOUSE2_MIN,  H30_HOUSE3_MIN,  H30_HOUSE4_MIN,
       H30_HOUSE5_MIN, H30_HOUSE6_MIN,  H30_HOUSE7_MIN,  H30_HOUSE8_MIN,
       H30_HOUSE9_MIN, H30_HOUSE10_MIN, H30_HOUSE11_MIN, H30_HOUSE12_MIN};
  static final double[] maxLonH30 = new double[]
      {H30_ASC_MAX,    H30_MC_MAX,      H30_ARMC_MAX,    H30_VERTEX_MAX,
       H30_EQUASC_MAX, H30_COASC1_MAX,  H30_COASC2_MAX,  H30_POLASC_MAX,
       H30_HOUSE1_MAX, H30_HOUSE2_MAX,  H30_HOUSE3_MAX,  H30_HOUSE4_MAX,
       H30_HOUSE5_MAX, H30_HOUSE6_MAX,  H30_HOUSE7_MAX,  H30_HOUSE8_MAX,
       H30_HOUSE9_MAX, H30_HOUSE10_MAX, H30_HOUSE11_MAX, H30_HOUSE12_MAX};
  static final double[] minLonH40 = new double[]
      {H40_ASC_MIN,    H40_MC_MIN,      H40_ARMC_MIN,    H40_VERTEX_MIN,
       H40_EQUASC_MIN, H40_COASC1_MIN,  H40_COASC2_MIN,  H40_POLASC_MIN,
       H40_HOUSE1_MIN, H40_HOUSE2_MIN,  H40_HOUSE3_MIN,  H40_HOUSE4_MIN,
       H40_HOUSE5_MIN, H40_HOUSE6_MIN,  H40_HOUSE7_MIN,  H40_HOUSE8_MIN,
       H40_HOUSE9_MIN, H40_HOUSE10_MIN, H40_HOUSE11_MIN, H40_HOUSE12_MIN};
  static final double[] maxLonH40 = new double[]
      {H40_ASC_MAX,    H40_MC_MAX,      H40_ARMC_MAX,    H40_VERTEX_MAX,
       H40_EQUASC_MAX, H40_COASC1_MAX,  H40_COASC2_MAX,  H40_POLASC_MAX,
       H40_HOUSE1_MAX, H40_HOUSE2_MAX,  H40_HOUSE3_MAX,  H40_HOUSE4_MAX,
       H40_HOUSE5_MAX, H40_HOUSE6_MAX,  H40_HOUSE7_MAX,  H40_HOUSE8_MAX,
       H40_HOUSE9_MAX, H40_HOUSE10_MAX, H40_HOUSE11_MAX, H40_HOUSE12_MAX};
  static final double[] minLonH50 = new double[]
      {H50_ASC_MIN,    H50_MC_MIN,      H50_ARMC_MIN,    H50_VERTEX_MIN,
       H50_EQUASC_MIN, H50_COASC1_MIN,  H50_COASC2_MIN,  H50_POLASC_MIN,
       H50_HOUSE1_MIN, H50_HOUSE2_MIN,  H50_HOUSE3_MIN,  H50_HOUSE4_MIN,
       H50_HOUSE5_MIN, H50_HOUSE6_MIN,  H50_HOUSE7_MIN,  H50_HOUSE8_MIN,
       H50_HOUSE9_MIN, H50_HOUSE10_MIN, H50_HOUSE11_MIN, H50_HOUSE12_MIN};
  static final double[] maxLonH50 = new double[]
      {H50_ASC_MAX,    H50_MC_MAX,      H50_ARMC_MAX,    H50_VERTEX_MAX,
       H50_EQUASC_MAX, H50_COASC1_MAX,  H50_COASC2_MAX,  H50_POLASC_MAX,
       H50_HOUSE1_MAX, H50_HOUSE2_MAX,  H50_HOUSE3_MAX,  H50_HOUSE4_MAX,
       H50_HOUSE5_MAX, H50_HOUSE6_MAX,  H50_HOUSE7_MAX,  H50_HOUSE8_MAX,
       H50_HOUSE9_MAX, H50_HOUSE10_MAX, H50_HOUSE11_MAX, H50_HOUSE12_MAX};
  static final double[] minLonH60 = new double[]
      {H60_ASC_MIN,    H60_MC_MIN,      H60_ARMC_MIN,    H60_VERTEX_MIN,
       H60_EQUASC_MIN, H60_COASC1_MIN,  H60_COASC2_MIN,  H60_POLASC_MIN,
       H60_HOUSE1_MIN, H60_HOUSE2_MIN,  H60_HOUSE3_MIN,  H60_HOUSE4_MIN,
       H60_HOUSE5_MIN, H60_HOUSE6_MIN,  H60_HOUSE7_MIN,  H60_HOUSE8_MIN,
       H60_HOUSE9_MIN, H60_HOUSE10_MIN, H60_HOUSE11_MIN, H60_HOUSE12_MIN};
  static final double[] maxLonH60 = new double[]
      {H60_ASC_MAX,    H60_MC_MAX,      H60_ARMC_MAX,    H60_VERTEX_MAX,
       H60_EQUASC_MAX, H60_COASC1_MAX,  H60_COASC2_MAX,  H60_POLASC_MAX,
       H60_HOUSE1_MAX, H60_HOUSE2_MAX,  H60_HOUSE3_MAX,  H60_HOUSE4_MAX,
       H60_HOUSE5_MAX, H60_HOUSE6_MAX,  H60_HOUSE7_MAX,  H60_HOUSE8_MAX,
       H60_HOUSE9_MAX, H60_HOUSE10_MAX, H60_HOUSE11_MAX, H60_HOUSE12_MAX};
  static final double[] minLonH66 = new double[]
      {H66_ASC_MIN,    H66_MC_MIN,      H66_ARMC_MIN,    H66_VERTEX_MIN,
       H66_EQUASC_MIN, H66_COASC1_MIN,  H66_COASC2_MIN,  H66_POLASC_MIN,
       H66_HOUSE1_MIN, H66_HOUSE2_MIN,  H66_HOUSE3_MIN,  H66_HOUSE4_MIN,
       H66_HOUSE5_MIN, H66_HOUSE6_MIN,  H66_HOUSE7_MIN,  H66_HOUSE8_MIN,
       H66_HOUSE9_MIN, H66_HOUSE10_MIN, H66_HOUSE11_MIN, H66_HOUSE12_MIN};
  static final double[] maxLonH66 = new double[]
      {H66_ASC_MAX,    H66_MC_MAX,      H66_ARMC_MAX,    H66_VERTEX_MAX,
       H66_EQUASC_MAX, H66_COASC1_MAX,  H66_COASC2_MAX,  H66_POLASC_MAX,
       H66_HOUSE1_MAX, H66_HOUSE2_MAX,  H66_HOUSE3_MAX,  H66_HOUSE4_MAX,
       H66_HOUSE5_MAX, H66_HOUSE6_MAX,  H66_HOUSE7_MAX,  H66_HOUSE8_MAX,
       H66_HOUSE9_MAX, H66_HOUSE10_MAX, H66_HOUSE11_MAX, H66_HOUSE12_MAX};
  static final double[] minLonH70 = new double[]
      {H70_ASC_MIN,    H70_MC_MIN,      H70_ARMC_MIN,    H70_VERTEX_MIN,
       H70_EQUASC_MIN, H70_COASC1_MIN,  H70_COASC2_MIN,  H70_POLASC_MIN,
       H70_HOUSE1_MIN, H70_HOUSE2_MIN,  H70_HOUSE3_MIN,  H70_HOUSE4_MIN,
       H70_HOUSE5_MIN, H70_HOUSE6_MIN,  H70_HOUSE7_MIN,  H70_HOUSE8_MIN,
       H70_HOUSE9_MIN, H70_HOUSE10_MIN, H70_HOUSE11_MIN, H70_HOUSE12_MIN};
  static final double[] maxLonH70 = new double[]
      {H70_ASC_MAX,    H70_MC_MAX,      H70_ARMC_MAX,    H70_VERTEX_MAX,
       H70_EQUASC_MAX, H70_COASC1_MAX,  H70_COASC2_MAX,  H70_POLASC_MAX,
       H70_HOUSE1_MAX, H70_HOUSE2_MAX,  H70_HOUSE3_MAX,  H70_HOUSE4_MAX,
       H70_HOUSE5_MAX, H70_HOUSE6_MAX,  H70_HOUSE7_MAX,  H70_HOUSE8_MAX,
       H70_HOUSE9_MAX, H70_HOUSE10_MAX, H70_HOUSE11_MAX, H70_HOUSE12_MAX};
  static final double[] minLonH80 = new double[]
      {H80_ASC_MIN,    H80_MC_MIN,      H80_ARMC_MIN,    H80_VERTEX_MIN,
       H80_EQUASC_MIN, H80_COASC1_MIN,  H80_COASC2_MIN,  H80_POLASC_MIN,
       H80_HOUSE1_MIN, H80_HOUSE2_MIN,  H80_HOUSE3_MIN,  H80_HOUSE4_MIN,
       H80_HOUSE5_MIN, H80_HOUSE6_MIN,  H80_HOUSE7_MIN,  H80_HOUSE8_MIN,
       H80_HOUSE9_MIN, H80_HOUSE10_MIN, H80_HOUSE11_MIN, H80_HOUSE12_MIN};
  static final double[] maxLonH80 = new double[]
      {H80_ASC_MAX,    H80_MC_MAX,      H80_ARMC_MAX,    H80_VERTEX_MAX,
       H80_EQUASC_MAX, H80_COASC1_MAX,  H80_COASC2_MAX,  H80_POLASC_MAX,
       H80_HOUSE1_MAX, H80_HOUSE2_MAX,  H80_HOUSE3_MAX,  H80_HOUSE4_MAX,
       H80_HOUSE5_MAX, H80_HOUSE6_MAX,  H80_HOUSE7_MAX,  H80_HOUSE8_MAX,
       H80_HOUSE9_MAX, H80_HOUSE10_MAX, H80_HOUSE11_MAX, H80_HOUSE12_MAX};
  static final double[] minLonH85 = new double[]
      {H85_ASC_MIN,    H85_MC_MIN,      H85_ARMC_MIN,    H85_VERTEX_MIN,
       H85_EQUASC_MIN, H85_COASC1_MIN,  H85_COASC2_MIN,  H85_POLASC_MIN,
       H85_HOUSE1_MIN, H85_HOUSE2_MIN,  H85_HOUSE3_MIN,  H85_HOUSE4_MIN,
       H85_HOUSE5_MIN, H85_HOUSE6_MIN,  H85_HOUSE7_MIN,  H85_HOUSE8_MIN,
       H85_HOUSE9_MIN, H85_HOUSE10_MIN, H85_HOUSE11_MIN, H85_HOUSE12_MIN};
  static final double[] maxLonH85 = new double[]
      {H85_ASC_MAX,    H85_MC_MAX,      H85_ARMC_MAX,    H85_VERTEX_MAX,
       H85_EQUASC_MAX, H85_COASC1_MAX,  H85_COASC2_MAX,  H85_POLASC_MAX,
       H85_HOUSE1_MAX, H85_HOUSE2_MAX,  H85_HOUSE3_MAX,  H85_HOUSE4_MAX,
       H85_HOUSE5_MAX, H85_HOUSE6_MAX,  H85_HOUSE7_MAX,  H85_HOUSE8_MAX,
       H85_HOUSE9_MAX, H85_HOUSE10_MAX, H85_HOUSE11_MAX, H85_HOUSE12_MAX};
  static final double[] minLonH88 = new double[]
      {H88_ASC_MIN,    H88_MC_MIN,      H88_ARMC_MIN,    H88_VERTEX_MIN,
       H88_EQUASC_MIN, H88_COASC1_MIN,  H88_COASC2_MIN,  H88_POLASC_MIN,
       H88_HOUSE1_MIN, H88_HOUSE2_MIN,  H88_HOUSE3_MIN,  H88_HOUSE4_MIN,
       H88_HOUSE5_MIN, H88_HOUSE6_MIN,  H88_HOUSE7_MIN,  H88_HOUSE8_MIN,
       H88_HOUSE9_MIN, H88_HOUSE10_MIN, H88_HOUSE11_MIN, H88_HOUSE12_MIN};
  static final double[] maxLonH88 = new double[]
      {H88_ASC_MAX,    H88_MC_MAX,      H88_ARMC_MAX,    H88_VERTEX_MAX,
       H88_EQUASC_MAX, H88_COASC1_MAX,  H88_COASC2_MAX,  H88_POLASC_MAX,
       H88_HOUSE1_MAX, H88_HOUSE2_MAX,  H88_HOUSE3_MAX,  H88_HOUSE4_MAX,
       H88_HOUSE5_MAX, H88_HOUSE6_MAX,  H88_HOUSE7_MAX,  H88_HOUSE8_MAX,
       H88_HOUSE9_MAX, H88_HOUSE10_MAX, H88_HOUSE11_MAX, H88_HOUSE12_MAX};
  static final double[] minLonH89x = new double[]
      {H89x_ASC_MIN,    H89x_MC_MIN,      H89x_ARMC_MIN,    H89x_VERTEX_MIN,
       H89x_EQUASC_MIN, H89x_COASC1_MIN,  H89x_COASC2_MIN,  H89x_POLASC_MIN,
       H89x_HOUSE1_MIN, H89x_HOUSE2_MIN,  H89x_HOUSE3_MIN,  H89x_HOUSE4_MIN,
       H89x_HOUSE5_MIN, H89x_HOUSE6_MIN,  H89x_HOUSE7_MIN,  H89x_HOUSE8_MIN,
       H89x_HOUSE9_MIN, H89x_HOUSE10_MIN, H89x_HOUSE11_MIN, H89x_HOUSE12_MIN};
  static final double[] maxLonH89x = new double[]
      {H89x_ASC_MAX,    H89x_MC_MAX,      H89x_ARMC_MAX,    H89x_VERTEX_MAX,
       H89x_EQUASC_MAX, H89x_COASC1_MAX,  H89x_COASC2_MAX,  H89x_POLASC_MAX,
       H89x_HOUSE1_MAX, H89x_HOUSE2_MAX,  H89x_HOUSE3_MAX,  H89x_HOUSE4_MAX,
       H89x_HOUSE5_MAX, H89x_HOUSE6_MAX,  H89x_HOUSE7_MAX,  H89x_HOUSE8_MAX,
       H89x_HOUSE9_MAX, H89x_HOUSE10_MAX, H89x_HOUSE11_MAX, H89x_HOUSE12_MAX};

  static final double[] minLonT10 = new double[]
      {T10_ASC_MIN,    T10_MC_MIN,      T10_ARMC_MIN,    T10_VERTEX_MIN,
       T10_EQUASC_MIN, T10_COASC1_MIN,  T10_COASC2_MIN,  T10_POLASC_MIN,
       T10_HOUSE1_MIN, T10_HOUSE2_MIN,  T10_HOUSE3_MIN,  T10_HOUSE4_MIN,
       T10_HOUSE5_MIN, T10_HOUSE6_MIN,  T10_HOUSE7_MIN,  T10_HOUSE8_MIN,
       T10_HOUSE9_MIN, T10_HOUSE10_MIN, T10_HOUSE11_MIN, T10_HOUSE12_MIN};
  static final double[] maxLonT10 = new double[]
      {T10_ASC_MAX,    T10_MC_MAX,      T10_ARMC_MAX,    T10_VERTEX_MAX,
       T10_EQUASC_MAX, T10_COASC1_MAX,  T10_COASC2_MAX,  T10_POLASC_MAX,
       T10_HOUSE1_MAX, T10_HOUSE2_MAX,  T10_HOUSE3_MAX,  T10_HOUSE4_MAX,
       T10_HOUSE5_MAX, T10_HOUSE6_MAX,  T10_HOUSE7_MAX,  T10_HOUSE8_MAX,
       T10_HOUSE9_MAX, T10_HOUSE10_MAX, T10_HOUSE11_MAX, T10_HOUSE12_MAX};
  static final double[] minLonT20 = new double[]
      {T20_ASC_MIN,    T20_MC_MIN,      T20_ARMC_MIN,    T20_VERTEX_MIN,
       T20_EQUASC_MIN, T20_COASC1_MIN,  T20_COASC2_MIN,  T20_POLASC_MIN,
       T20_HOUSE1_MIN, T20_HOUSE2_MIN,  T20_HOUSE3_MIN,  T20_HOUSE4_MIN,
       T20_HOUSE5_MIN, T20_HOUSE6_MIN,  T20_HOUSE7_MIN,  T20_HOUSE8_MIN,
       T20_HOUSE9_MIN, T20_HOUSE10_MIN, T20_HOUSE11_MIN, T20_HOUSE12_MIN};
  static final double[] maxLonT20 = new double[]
      {T20_ASC_MAX,    T20_MC_MAX,      T20_ARMC_MAX,    T20_VERTEX_MAX,
       T20_EQUASC_MAX, T20_COASC1_MAX,  T20_COASC2_MAX,  T20_POLASC_MAX,
       T20_HOUSE1_MAX, T20_HOUSE2_MAX,  T20_HOUSE3_MAX,  T20_HOUSE4_MAX,
       T20_HOUSE5_MAX, T20_HOUSE6_MAX,  T20_HOUSE7_MAX,  T20_HOUSE8_MAX,
       T20_HOUSE9_MAX, T20_HOUSE10_MAX, T20_HOUSE11_MAX, T20_HOUSE12_MAX};
  static final double[] minLonT30 = new double[]
      {T30_ASC_MIN,    T30_MC_MIN,      T30_ARMC_MIN,    T30_VERTEX_MIN,
       T30_EQUASC_MIN, T30_COASC1_MIN,  T30_COASC2_MIN,  T30_POLASC_MIN,
       T30_HOUSE1_MIN, T30_HOUSE2_MIN,  T30_HOUSE3_MIN,  T30_HOUSE4_MIN,
       T30_HOUSE5_MIN, T30_HOUSE6_MIN,  T30_HOUSE7_MIN,  T30_HOUSE8_MIN,
       T30_HOUSE9_MIN, T30_HOUSE10_MIN, T30_HOUSE11_MIN, T30_HOUSE12_MIN};
  static final double[] maxLonT30 = new double[]
      {T30_ASC_MAX,    T30_MC_MAX,      T30_ARMC_MAX,    T30_VERTEX_MAX,
       T30_EQUASC_MAX, T30_COASC1_MAX,  T30_COASC2_MAX,  T30_POLASC_MAX,
       T30_HOUSE1_MAX, T30_HOUSE2_MAX,  T30_HOUSE3_MAX,  T30_HOUSE4_MAX,
       T30_HOUSE5_MAX, T30_HOUSE6_MAX,  T30_HOUSE7_MAX,  T30_HOUSE8_MAX,
       T30_HOUSE9_MAX, T30_HOUSE10_MAX, T30_HOUSE11_MAX, T30_HOUSE12_MAX};
  static final double[] minLonT40 = new double[]
      {T40_ASC_MIN,    T40_MC_MIN,      T40_ARMC_MIN,    T40_VERTEX_MIN,
       T40_EQUASC_MIN, T40_COASC1_MIN,  T40_COASC2_MIN,  T40_POLASC_MIN,
       T40_HOUSE1_MIN, T40_HOUSE2_MIN,  T40_HOUSE3_MIN,  T40_HOUSE4_MIN,
       T40_HOUSE5_MIN, T40_HOUSE6_MIN,  T40_HOUSE7_MIN,  T40_HOUSE8_MIN,
       T40_HOUSE9_MIN, T40_HOUSE10_MIN, T40_HOUSE11_MIN, T40_HOUSE12_MIN};
  static final double[] maxLonT40 = new double[]
      {T40_ASC_MAX,    T40_MC_MAX,      T40_ARMC_MAX,    T40_VERTEX_MAX,
       T40_EQUASC_MAX, T40_COASC1_MAX,  T40_COASC2_MAX,  T40_POLASC_MAX,
       T40_HOUSE1_MAX, T40_HOUSE2_MAX,  T40_HOUSE3_MAX,  T40_HOUSE4_MAX,
       T40_HOUSE5_MAX, T40_HOUSE6_MAX,  T40_HOUSE7_MAX,  T40_HOUSE8_MAX,
       T40_HOUSE9_MAX, T40_HOUSE10_MAX, T40_HOUSE11_MAX, T40_HOUSE12_MAX};
  static final double[] minLonT50 = new double[]
      {T50_ASC_MIN,    T50_MC_MIN,      T50_ARMC_MIN,    T50_VERTEX_MIN,
       T50_EQUASC_MIN, T50_COASC1_MIN,  T50_COASC2_MIN,  T50_POLASC_MIN,
       T50_HOUSE1_MIN, T50_HOUSE2_MIN,  T50_HOUSE3_MIN,  T50_HOUSE4_MIN,
       T50_HOUSE5_MIN, T50_HOUSE6_MIN,  T50_HOUSE7_MIN,  T50_HOUSE8_MIN,
       T50_HOUSE9_MIN, T50_HOUSE10_MIN, T50_HOUSE11_MIN, T50_HOUSE12_MIN};
  static final double[] maxLonT50 = new double[]
      {T50_ASC_MAX,    T50_MC_MAX,      T50_ARMC_MAX,    T50_VERTEX_MAX,
       T50_EQUASC_MAX, T50_COASC1_MAX,  T50_COASC2_MAX,  T50_POLASC_MAX,
       T50_HOUSE1_MAX, T50_HOUSE2_MAX,  T50_HOUSE3_MAX,  T50_HOUSE4_MAX,
       T50_HOUSE5_MAX, T50_HOUSE6_MAX,  T50_HOUSE7_MAX,  T50_HOUSE8_MAX,
       T50_HOUSE9_MAX, T50_HOUSE10_MAX, T50_HOUSE11_MAX, T50_HOUSE12_MAX};
  static final double[] minLonT60 = new double[]
      {T60_ASC_MIN,    T60_MC_MIN,      T60_ARMC_MIN,    T60_VERTEX_MIN,
       T60_EQUASC_MIN, T60_COASC1_MIN,  T60_COASC2_MIN,  T60_POLASC_MIN,
       T60_HOUSE1_MIN, T60_HOUSE2_MIN,  T60_HOUSE3_MIN,  T60_HOUSE4_MIN,
       T60_HOUSE5_MIN, T60_HOUSE6_MIN,  T60_HOUSE7_MIN,  T60_HOUSE8_MIN,
       T60_HOUSE9_MIN, T60_HOUSE10_MIN, T60_HOUSE11_MIN, T60_HOUSE12_MIN};
  static final double[] maxLonT60 = new double[]
      {T60_ASC_MAX,    T60_MC_MAX,      T60_ARMC_MAX,    T60_VERTEX_MAX,
       T60_EQUASC_MAX, T60_COASC1_MAX,  T60_COASC2_MAX,  T60_POLASC_MAX,
       T60_HOUSE1_MAX, T60_HOUSE2_MAX,  T60_HOUSE3_MAX,  T60_HOUSE4_MAX,
       T60_HOUSE5_MAX, T60_HOUSE6_MAX,  T60_HOUSE7_MAX,  T60_HOUSE8_MAX,
       T60_HOUSE9_MAX, T60_HOUSE10_MAX, T60_HOUSE11_MAX, T60_HOUSE12_MAX};
  static final double[] minLonT66 = new double[]
      {T66_ASC_MIN,    T66_MC_MIN,      T66_ARMC_MIN,    T66_VERTEX_MIN,
       T66_EQUASC_MIN, T66_COASC1_MIN,  T66_COASC2_MIN,  T66_POLASC_MIN,
       T66_HOUSE1_MIN, T66_HOUSE2_MIN,  T66_HOUSE3_MIN,  T66_HOUSE4_MIN,
       T66_HOUSE5_MIN, T66_HOUSE6_MIN,  T66_HOUSE7_MIN,  T66_HOUSE8_MIN,
       T66_HOUSE9_MIN, T66_HOUSE10_MIN, T66_HOUSE11_MIN, T66_HOUSE12_MIN};
  static final double[] maxLonT66 = new double[]
      {T66_ASC_MAX,    T66_MC_MAX,      T66_ARMC_MAX,    T66_VERTEX_MAX,
       T66_EQUASC_MAX, T66_COASC1_MAX,  T66_COASC2_MAX,  T66_POLASC_MAX,
       T66_HOUSE1_MAX, T66_HOUSE2_MAX,  T66_HOUSE3_MAX,  T66_HOUSE4_MAX,
       T66_HOUSE5_MAX, T66_HOUSE6_MAX,  T66_HOUSE7_MAX,  T66_HOUSE8_MAX,
       T66_HOUSE9_MAX, T66_HOUSE10_MAX, T66_HOUSE11_MAX, T66_HOUSE12_MAX};
  static final double[] minLonT70 = new double[]
      {T70_ASC_MIN,    T70_MC_MIN,      T70_ARMC_MIN,    T70_VERTEX_MIN,
       T70_EQUASC_MIN, T70_COASC1_MIN,  T70_COASC2_MIN,  T70_POLASC_MIN,
       T70_HOUSE1_MIN, T70_HOUSE2_MIN,  T70_HOUSE3_MIN,  T70_HOUSE4_MIN,
       T70_HOUSE5_MIN, T70_HOUSE6_MIN,  T70_HOUSE7_MIN,  T70_HOUSE8_MIN,
       T70_HOUSE9_MIN, T70_HOUSE10_MIN, T70_HOUSE11_MIN, T70_HOUSE12_MIN};
  static final double[] maxLonT70 = new double[]
      {T70_ASC_MAX,    T70_MC_MAX,      T70_ARMC_MAX,    T70_VERTEX_MAX,
       T70_EQUASC_MAX, T70_COASC1_MAX,  T70_COASC2_MAX,  T70_POLASC_MAX,
       T70_HOUSE1_MAX, T70_HOUSE2_MAX,  T70_HOUSE3_MAX,  T70_HOUSE4_MAX,
       T70_HOUSE5_MAX, T70_HOUSE6_MAX,  T70_HOUSE7_MAX,  T70_HOUSE8_MAX,
       T70_HOUSE9_MAX, T70_HOUSE10_MAX, T70_HOUSE11_MAX, T70_HOUSE12_MAX};
  static final double[] minLonT80 = new double[]
      {T80_ASC_MIN,    T80_MC_MIN,      T80_ARMC_MIN,    T80_VERTEX_MIN,
       T80_EQUASC_MIN, T80_COASC1_MIN,  T80_COASC2_MIN,  T80_POLASC_MIN,
       T80_HOUSE1_MIN, T80_HOUSE2_MIN,  T80_HOUSE3_MIN,  T80_HOUSE4_MIN,
       T80_HOUSE5_MIN, T80_HOUSE6_MIN,  T80_HOUSE7_MIN,  T80_HOUSE8_MIN,
       T80_HOUSE9_MIN, T80_HOUSE10_MIN, T80_HOUSE11_MIN, T80_HOUSE12_MIN};
  static final double[] maxLonT80 = new double[]
      {T80_ASC_MAX,    T80_MC_MAX,      T80_ARMC_MAX,    T80_VERTEX_MAX,
       T80_EQUASC_MAX, T80_COASC1_MAX,  T80_COASC2_MAX,  T80_POLASC_MAX,
       T80_HOUSE1_MAX, T80_HOUSE2_MAX,  T80_HOUSE3_MAX,  T80_HOUSE4_MAX,
       T80_HOUSE5_MAX, T80_HOUSE6_MAX,  T80_HOUSE7_MAX,  T80_HOUSE8_MAX,
       T80_HOUSE9_MAX, T80_HOUSE10_MAX, T80_HOUSE11_MAX, T80_HOUSE12_MAX};
  static final double[] minLonT85 = new double[]
      {T85_ASC_MIN,    T85_MC_MIN,      T85_ARMC_MIN,    T85_VERTEX_MIN,
       T85_EQUASC_MIN, T85_COASC1_MIN,  T85_COASC2_MIN,  T85_POLASC_MIN,
       T85_HOUSE1_MIN, T85_HOUSE2_MIN,  T85_HOUSE3_MIN,  T85_HOUSE4_MIN,
       T85_HOUSE5_MIN, T85_HOUSE6_MIN,  T85_HOUSE7_MIN,  T85_HOUSE8_MIN,
       T85_HOUSE9_MIN, T85_HOUSE10_MIN, T85_HOUSE11_MIN, T85_HOUSE12_MIN};
  static final double[] maxLonT85 = new double[]
      {T85_ASC_MAX,    T85_MC_MAX,      T85_ARMC_MAX,    T85_VERTEX_MAX,
       T85_EQUASC_MAX, T85_COASC1_MAX,  T85_COASC2_MAX,  T85_POLASC_MAX,
       T85_HOUSE1_MAX, T85_HOUSE2_MAX,  T85_HOUSE3_MAX,  T85_HOUSE4_MAX,
       T85_HOUSE5_MAX, T85_HOUSE6_MAX,  T85_HOUSE7_MAX,  T85_HOUSE8_MAX,
       T85_HOUSE9_MAX, T85_HOUSE10_MAX, T85_HOUSE11_MAX, T85_HOUSE12_MAX};
  static final double[] minLonT88 = new double[]
      {T88_ASC_MIN,    T88_MC_MIN,      T88_ARMC_MIN,    T88_VERTEX_MIN,
       T88_EQUASC_MIN, T88_COASC1_MIN,  T88_COASC2_MIN,  T88_POLASC_MIN,
       T88_HOUSE1_MIN, T88_HOUSE2_MIN,  T88_HOUSE3_MIN,  T88_HOUSE4_MIN,
       T88_HOUSE5_MIN, T88_HOUSE6_MIN,  T88_HOUSE7_MIN,  T88_HOUSE8_MIN,
       T88_HOUSE9_MIN, T88_HOUSE10_MIN, T88_HOUSE11_MIN, T88_HOUSE12_MIN};
  static final double[] maxLonT88 = new double[]
      {T88_ASC_MAX,    T88_MC_MAX,      T88_ARMC_MAX,    T88_VERTEX_MAX,
       T88_EQUASC_MAX, T88_COASC1_MAX,  T88_COASC2_MAX,  T88_POLASC_MAX,
       T88_HOUSE1_MAX, T88_HOUSE2_MAX,  T88_HOUSE3_MAX,  T88_HOUSE4_MAX,
       T88_HOUSE5_MAX, T88_HOUSE6_MAX,  T88_HOUSE7_MAX,  T88_HOUSE8_MAX,
       T88_HOUSE9_MAX, T88_HOUSE10_MAX, T88_HOUSE11_MAX, T88_HOUSE12_MAX};
  static final double[] minLonT89x = new double[]
      {T89x_ASC_MIN,    T89x_MC_MIN,      T89x_ARMC_MIN,    T89x_VERTEX_MIN,
       T89x_EQUASC_MIN, T89x_COASC1_MIN,  T89x_COASC2_MIN,  T89x_POLASC_MIN,
       T89x_HOUSE1_MIN, T89x_HOUSE2_MIN,  T89x_HOUSE3_MIN,  T89x_HOUSE4_MIN,
       T89x_HOUSE5_MIN, T89x_HOUSE6_MIN,  T89x_HOUSE7_MIN,  T89x_HOUSE8_MIN,
       T89x_HOUSE9_MIN, T89x_HOUSE10_MIN, T89x_HOUSE11_MIN, T89x_HOUSE12_MIN};
  static final double[] maxLonT89x = new double[]
      {T89x_ASC_MAX,    T89x_MC_MAX,      T89x_ARMC_MAX,    T89x_VERTEX_MAX,
       T89x_EQUASC_MAX, T89x_COASC1_MAX,  T89x_COASC2_MAX,  T89x_POLASC_MAX,
       T89x_HOUSE1_MAX, T89x_HOUSE2_MAX,  T89x_HOUSE3_MAX,  T89x_HOUSE4_MAX,
       T89x_HOUSE5_MAX, T89x_HOUSE6_MAX,  T89x_HOUSE7_MAX,  T89x_HOUSE8_MAX,
       T89x_HOUSE9_MAX, T89x_HOUSE10_MAX, T89x_HOUSE11_MAX, T89x_HOUSE12_MAX};

  static final double[] minLonB10 = new double[]
      {B10_ASC_MIN,    B10_MC_MIN,      B10_ARMC_MIN,    B10_VERTEX_MIN,
       B10_EQUASC_MIN, B10_COASC1_MIN,  B10_COASC2_MIN,  B10_POLASC_MIN,
       B10_HOUSE1_MIN, B10_HOUSE2_MIN,  B10_HOUSE3_MIN,  B10_HOUSE4_MIN,
       B10_HOUSE5_MIN, B10_HOUSE6_MIN,  B10_HOUSE7_MIN,  B10_HOUSE8_MIN,
       B10_HOUSE9_MIN, B10_HOUSE10_MIN, B10_HOUSE11_MIN, B10_HOUSE12_MIN};
  static final double[] maxLonB10 = new double[]
      {B10_ASC_MAX,    B10_MC_MAX,      B10_ARMC_MAX,    B10_VERTEX_MAX,
       B10_EQUASC_MAX, B10_COASC1_MAX,  B10_COASC2_MAX,  B10_POLASC_MAX,
       B10_HOUSE1_MAX, B10_HOUSE2_MAX,  B10_HOUSE3_MAX,  B10_HOUSE4_MAX,
       B10_HOUSE5_MAX, B10_HOUSE6_MAX,  B10_HOUSE7_MAX,  B10_HOUSE8_MAX,
       B10_HOUSE9_MAX, B10_HOUSE10_MAX, B10_HOUSE11_MAX, B10_HOUSE12_MAX};
  static final double[] minLonB20 = new double[]
      {B20_ASC_MIN,    B20_MC_MIN,      B20_ARMC_MIN,    B20_VERTEX_MIN,
       B20_EQUASC_MIN, B20_COASC1_MIN,  B20_COASC2_MIN,  B20_POLASC_MIN,
       B20_HOUSE1_MIN, B20_HOUSE2_MIN,  B20_HOUSE3_MIN,  B20_HOUSE4_MIN,
       B20_HOUSE5_MIN, B20_HOUSE6_MIN,  B20_HOUSE7_MIN,  B20_HOUSE8_MIN,
       B20_HOUSE9_MIN, B20_HOUSE10_MIN, B20_HOUSE11_MIN, B20_HOUSE12_MIN};
  static final double[] maxLonB20 = new double[]
      {B20_ASC_MAX,    B20_MC_MAX,      B20_ARMC_MAX,    B20_VERTEX_MAX,
       B20_EQUASC_MAX, B20_COASC1_MAX,  B20_COASC2_MAX,  B20_POLASC_MAX,
       B20_HOUSE1_MAX, B20_HOUSE2_MAX,  B20_HOUSE3_MAX,  B20_HOUSE4_MAX,
       B20_HOUSE5_MAX, B20_HOUSE6_MAX,  B20_HOUSE7_MAX,  B20_HOUSE8_MAX,
       B20_HOUSE9_MAX, B20_HOUSE10_MAX, B20_HOUSE11_MAX, B20_HOUSE12_MAX};
  static final double[] minLonB30 = new double[]
      {B30_ASC_MIN,    B30_MC_MIN,      B30_ARMC_MIN,    B30_VERTEX_MIN,
       B30_EQUASC_MIN, B30_COASC1_MIN,  B30_COASC2_MIN,  B30_POLASC_MIN,
       B30_HOUSE1_MIN, B30_HOUSE2_MIN,  B30_HOUSE3_MIN,  B30_HOUSE4_MIN,
       B30_HOUSE5_MIN, B30_HOUSE6_MIN,  B30_HOUSE7_MIN,  B30_HOUSE8_MIN,
       B30_HOUSE9_MIN, B30_HOUSE10_MIN, B30_HOUSE11_MIN, B30_HOUSE12_MIN};
  static final double[] maxLonB30 = new double[]
      {B30_ASC_MAX,    B30_MC_MAX,      B30_ARMC_MAX,    B30_VERTEX_MAX,
       B30_EQUASC_MAX, B30_COASC1_MAX,  B30_COASC2_MAX,  B30_POLASC_MAX,
       B30_HOUSE1_MAX, B30_HOUSE2_MAX,  B30_HOUSE3_MAX,  B30_HOUSE4_MAX,
       B30_HOUSE5_MAX, B30_HOUSE6_MAX,  B30_HOUSE7_MAX,  B30_HOUSE8_MAX,
       B30_HOUSE9_MAX, B30_HOUSE10_MAX, B30_HOUSE11_MAX, B30_HOUSE12_MAX};
  static final double[] minLonB40 = new double[]
      {B40_ASC_MIN,    B40_MC_MIN,      B40_ARMC_MIN,    B40_VERTEX_MIN,
       B40_EQUASC_MIN, B40_COASC1_MIN,  B40_COASC2_MIN,  B40_POLASC_MIN,
       B40_HOUSE1_MIN, B40_HOUSE2_MIN,  B40_HOUSE3_MIN,  B40_HOUSE4_MIN,
       B40_HOUSE5_MIN, B40_HOUSE6_MIN,  B40_HOUSE7_MIN,  B40_HOUSE8_MIN,
       B40_HOUSE9_MIN, B40_HOUSE10_MIN, B40_HOUSE11_MIN, B40_HOUSE12_MIN};
  static final double[] maxLonB40 = new double[]
      {B40_ASC_MAX,    B40_MC_MAX,      B40_ARMC_MAX,    B40_VERTEX_MAX,
       B40_EQUASC_MAX, B40_COASC1_MAX,  B40_COASC2_MAX,  B40_POLASC_MAX,
       B40_HOUSE1_MAX, B40_HOUSE2_MAX,  B40_HOUSE3_MAX,  B40_HOUSE4_MAX,
       B40_HOUSE5_MAX, B40_HOUSE6_MAX,  B40_HOUSE7_MAX,  B40_HOUSE8_MAX,
       B40_HOUSE9_MAX, B40_HOUSE10_MAX, B40_HOUSE11_MAX, B40_HOUSE12_MAX};
  static final double[] minLonB50 = new double[]
      {B50_ASC_MIN,    B50_MC_MIN,      B50_ARMC_MIN,    B50_VERTEX_MIN,
       B50_EQUASC_MIN, B50_COASC1_MIN,  B50_COASC2_MIN,  B50_POLASC_MIN,
       B50_HOUSE1_MIN, B50_HOUSE2_MIN,  B50_HOUSE3_MIN,  B50_HOUSE4_MIN,
       B50_HOUSE5_MIN, B50_HOUSE6_MIN,  B50_HOUSE7_MIN,  B50_HOUSE8_MIN,
       B50_HOUSE9_MIN, B50_HOUSE10_MIN, B50_HOUSE11_MIN, B50_HOUSE12_MIN};
  static final double[] maxLonB50 = new double[]
      {B50_ASC_MAX,    B50_MC_MAX,      B50_ARMC_MAX,    B50_VERTEX_MAX,
       B50_EQUASC_MAX, B50_COASC1_MAX,  B50_COASC2_MAX,  B50_POLASC_MAX,
       B50_HOUSE1_MAX, B50_HOUSE2_MAX,  B50_HOUSE3_MAX,  B50_HOUSE4_MAX,
       B50_HOUSE5_MAX, B50_HOUSE6_MAX,  B50_HOUSE7_MAX,  B50_HOUSE8_MAX,
       B50_HOUSE9_MAX, B50_HOUSE10_MAX, B50_HOUSE11_MAX, B50_HOUSE12_MAX};
  static final double[] minLonB60 = new double[]
      {B60_ASC_MIN,    B60_MC_MIN,      B60_ARMC_MIN,    B60_VERTEX_MIN,
       B60_EQUASC_MIN, B60_COASC1_MIN,  B60_COASC2_MIN,  B60_POLASC_MIN,
       B60_HOUSE1_MIN, B60_HOUSE2_MIN,  B60_HOUSE3_MIN,  B60_HOUSE4_MIN,
       B60_HOUSE5_MIN, B60_HOUSE6_MIN,  B60_HOUSE7_MIN,  B60_HOUSE8_MIN,
       B60_HOUSE9_MIN, B60_HOUSE10_MIN, B60_HOUSE11_MIN, B60_HOUSE12_MIN};
  static final double[] maxLonB60 = new double[]
      {B60_ASC_MAX,    B60_MC_MAX,      B60_ARMC_MAX,    B60_VERTEX_MAX,
       B60_EQUASC_MAX, B60_COASC1_MAX,  B60_COASC2_MAX,  B60_POLASC_MAX,
       B60_HOUSE1_MAX, B60_HOUSE2_MAX,  B60_HOUSE3_MAX,  B60_HOUSE4_MAX,
       B60_HOUSE5_MAX, B60_HOUSE6_MAX,  B60_HOUSE7_MAX,  B60_HOUSE8_MAX,
       B60_HOUSE9_MAX, B60_HOUSE10_MAX, B60_HOUSE11_MAX, B60_HOUSE12_MAX};
  static final double[] minLonB66 = new double[]
      {B66_ASC_MIN,    B66_MC_MIN,      B66_ARMC_MIN,    B66_VERTEX_MIN,
       B66_EQUASC_MIN, B66_COASC1_MIN,  B66_COASC2_MIN,  B66_POLASC_MIN,
       B66_HOUSE1_MIN, B66_HOUSE2_MIN,  B66_HOUSE3_MIN,  B66_HOUSE4_MIN,
       B66_HOUSE5_MIN, B66_HOUSE6_MIN,  B66_HOUSE7_MIN,  B66_HOUSE8_MIN,
       B66_HOUSE9_MIN, B66_HOUSE10_MIN, B66_HOUSE11_MIN, B66_HOUSE12_MIN};
  static final double[] maxLonB66 = new double[]
      {B66_ASC_MAX,    B66_MC_MAX,      B66_ARMC_MAX,    B66_VERTEX_MAX,
       B66_EQUASC_MAX, B66_COASC1_MAX,  B66_COASC2_MAX,  B66_POLASC_MAX,
       B66_HOUSE1_MAX, B66_HOUSE2_MAX,  B66_HOUSE3_MAX,  B66_HOUSE4_MAX,
       B66_HOUSE5_MAX, B66_HOUSE6_MAX,  B66_HOUSE7_MAX,  B66_HOUSE8_MAX,
       B66_HOUSE9_MAX, B66_HOUSE10_MAX, B66_HOUSE11_MAX, B66_HOUSE12_MAX};
  static final double[] minLonB70 = new double[]
      {B70_ASC_MIN,    B70_MC_MIN,      B70_ARMC_MIN,    B70_VERTEX_MIN,
       B70_EQUASC_MIN, B70_COASC1_MIN,  B70_COASC2_MIN,  B70_POLASC_MIN,
       B70_HOUSE1_MIN, B70_HOUSE2_MIN,  B70_HOUSE3_MIN,  B70_HOUSE4_MIN,
       B70_HOUSE5_MIN, B70_HOUSE6_MIN,  B70_HOUSE7_MIN,  B70_HOUSE8_MIN,
       B70_HOUSE9_MIN, B70_HOUSE10_MIN, B70_HOUSE11_MIN, B70_HOUSE12_MIN};
  static final double[] maxLonB70 = new double[]
      {B70_ASC_MAX,    B70_MC_MAX,      B70_ARMC_MAX,    B70_VERTEX_MAX,
       B70_EQUASC_MAX, B70_COASC1_MAX,  B70_COASC2_MAX,  B70_POLASC_MAX,
       B70_HOUSE1_MAX, B70_HOUSE2_MAX,  B70_HOUSE3_MAX,  B70_HOUSE4_MAX,
       B70_HOUSE5_MAX, B70_HOUSE6_MAX,  B70_HOUSE7_MAX,  B70_HOUSE8_MAX,
       B70_HOUSE9_MAX, B70_HOUSE10_MAX, B70_HOUSE11_MAX, B70_HOUSE12_MAX};
  static final double[] minLonB80 = new double[]
      {B80_ASC_MIN,    B80_MC_MIN,      B80_ARMC_MIN,    B80_VERTEX_MIN,
       B80_EQUASC_MIN, B80_COASC1_MIN,  B80_COASC2_MIN,  B80_POLASC_MIN,
       B80_HOUSE1_MIN, B80_HOUSE2_MIN,  B80_HOUSE3_MIN,  B80_HOUSE4_MIN,
       B80_HOUSE5_MIN, B80_HOUSE6_MIN,  B80_HOUSE7_MIN,  B80_HOUSE8_MIN,
       B80_HOUSE9_MIN, B80_HOUSE10_MIN, B80_HOUSE11_MIN, B80_HOUSE12_MIN};
  static final double[] maxLonB80 = new double[]
      {B80_ASC_MAX,    B80_MC_MAX,      B80_ARMC_MAX,    B80_VERTEX_MAX,
       B80_EQUASC_MAX, B80_COASC1_MAX,  B80_COASC2_MAX,  B80_POLASC_MAX,
       B80_HOUSE1_MAX, B80_HOUSE2_MAX,  B80_HOUSE3_MAX,  B80_HOUSE4_MAX,
       B80_HOUSE5_MAX, B80_HOUSE6_MAX,  B80_HOUSE7_MAX,  B80_HOUSE8_MAX,
       B80_HOUSE9_MAX, B80_HOUSE10_MAX, B80_HOUSE11_MAX, B80_HOUSE12_MAX};
  static final double[] minLonB85 = new double[]
      {B85_ASC_MIN,    B85_MC_MIN,      B85_ARMC_MIN,    B85_VERTEX_MIN,
       B85_EQUASC_MIN, B85_COASC1_MIN,  B85_COASC2_MIN,  B85_POLASC_MIN,
       B85_HOUSE1_MIN, B85_HOUSE2_MIN,  B85_HOUSE3_MIN,  B85_HOUSE4_MIN,
       B85_HOUSE5_MIN, B85_HOUSE6_MIN,  B85_HOUSE7_MIN,  B85_HOUSE8_MIN,
       B85_HOUSE9_MIN, B85_HOUSE10_MIN, B85_HOUSE11_MIN, B85_HOUSE12_MIN};
  static final double[] maxLonB85 = new double[]
      {B85_ASC_MAX,    B85_MC_MAX,      B85_ARMC_MAX,    B85_VERTEX_MAX,
       B85_EQUASC_MAX, B85_COASC1_MAX,  B85_COASC2_MAX,  B85_POLASC_MAX,
       B85_HOUSE1_MAX, B85_HOUSE2_MAX,  B85_HOUSE3_MAX,  B85_HOUSE4_MAX,
       B85_HOUSE5_MAX, B85_HOUSE6_MAX,  B85_HOUSE7_MAX,  B85_HOUSE8_MAX,
       B85_HOUSE9_MAX, B85_HOUSE10_MAX, B85_HOUSE11_MAX, B85_HOUSE12_MAX};
  static final double[] minLonB88 = new double[]
      {B88_ASC_MIN,    B88_MC_MIN,      B88_ARMC_MIN,    B88_VERTEX_MIN,
       B88_EQUASC_MIN, B88_COASC1_MIN,  B88_COASC2_MIN,  B88_POLASC_MIN,
       B88_HOUSE1_MIN, B88_HOUSE2_MIN,  B88_HOUSE3_MIN,  B88_HOUSE4_MIN,
       B88_HOUSE5_MIN, B88_HOUSE6_MIN,  B88_HOUSE7_MIN,  B88_HOUSE8_MIN,
       B88_HOUSE9_MIN, B88_HOUSE10_MIN, B88_HOUSE11_MIN, B88_HOUSE12_MIN};
  static final double[] maxLonB88 = new double[]
      {B88_ASC_MAX,    B88_MC_MAX,      B88_ARMC_MAX,    B88_VERTEX_MAX,
       B88_EQUASC_MAX, B88_COASC1_MAX,  B88_COASC2_MAX,  B88_POLASC_MAX,
       B88_HOUSE1_MAX, B88_HOUSE2_MAX,  B88_HOUSE3_MAX,  B88_HOUSE4_MAX,
       B88_HOUSE5_MAX, B88_HOUSE6_MAX,  B88_HOUSE7_MAX,  B88_HOUSE8_MAX,
       B88_HOUSE9_MAX, B88_HOUSE10_MAX, B88_HOUSE11_MAX, B88_HOUSE12_MAX};
  static final double[] minLonB89x = new double[]
      {B89x_ASC_MIN,    B89x_MC_MIN,      B89x_ARMC_MIN,    B89x_VERTEX_MIN,
       B89x_EQUASC_MIN, B89x_COASC1_MIN,  B89x_COASC2_MIN,  B89x_POLASC_MIN,
       B89x_HOUSE1_MIN, B89x_HOUSE2_MIN,  B89x_HOUSE3_MIN,  B89x_HOUSE4_MIN,
       B89x_HOUSE5_MIN, B89x_HOUSE6_MIN,  B89x_HOUSE7_MIN,  B89x_HOUSE8_MIN,
       B89x_HOUSE9_MIN, B89x_HOUSE10_MIN, B89x_HOUSE11_MIN, B89x_HOUSE12_MIN};
  static final double[] maxLonB89x = new double[]
      {B89x_ASC_MAX,    B89x_MC_MAX,      B89x_ARMC_MAX,    B89x_VERTEX_MAX,
       B89x_EQUASC_MAX, B89x_COASC1_MAX,  B89x_COASC2_MAX,  B89x_POLASC_MAX,
       B89x_HOUSE1_MAX, B89x_HOUSE2_MAX,  B89x_HOUSE3_MAX,  B89x_HOUSE4_MAX,
       B89x_HOUSE5_MAX, B89x_HOUSE6_MAX,  B89x_HOUSE7_MAX,  B89x_HOUSE8_MAX,
       B89x_HOUSE9_MAX, B89x_HOUSE10_MAX, B89x_HOUSE11_MAX, B89x_HOUSE12_MAX};
}
