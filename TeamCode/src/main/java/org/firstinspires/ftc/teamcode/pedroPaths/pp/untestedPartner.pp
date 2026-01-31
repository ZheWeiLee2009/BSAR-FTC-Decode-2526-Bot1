{
  "startPoint": {
    "x": 18.155,
    "y": 121.307,
    "heading": "linear",
    "startDeg": 90,
    "endDeg": 180,
    "locked": true
  },
  "lines": [
    {
      "id": "line-roqz1lyl6p",
      "name": "preload",
      "endPoint": {
        "x": 53.02,
        "y": 89.948,
        "heading": "linear",
        "startDeg": 143,
        "endDeg": 134
      },
      "controlPoints": [],
      "color": "#5C6CAD",
      "locked": false,
      "waitBeforeMs": 0,
      "waitAfterMs": 0,
      "waitBeforeName": "",
      "waitAfterName": ""
    },
    {
      "id": "mkhm0n4k-ipu93w",
      "name": "entry1",
      "endPoint": {
        "x": 15.7,
        "y": 83.76,
        "heading": "tangential",
        "reverse": false,
        "degrees": 180
      },
      "controlPoints": [
        {
          "x": 35.56339581036384,
          "y": 83.51047409040793
        }
      ],
      "color": "#A578D6",
      "waitBeforeMs": 0,
      "waitAfterMs": 0,
      "waitBeforeName": "",
      "waitAfterName": ""
    },
    {
      "id": "ml1syb09-r6kfr3",
      "name": "gateOpen",
      "endPoint": {
        "x": 15.2,
        "y": 76.09812568908491,
        "heading": "constant",
        "reverse": false,
        "degrees": 180
      },
      "controlPoints": [
        {
          "x": 25.460247658816936,
          "y": 77.3348451137242
        }
      ],
      "color": "#879959",
      "waitBeforeMs": 0,
      "waitAfterMs": 0,
      "waitBeforeName": "",
      "waitAfterName": ""
    },
    {
      "id": "ml1t9pkq-umyq3f",
      "name": "exit1",
      "endPoint": {
        "x": 53.433,
        "y": 89.948,
        "heading": "linear",
        "reverse": false,
        "startDeg": 180,
        "endDeg": 134
      },
      "controlPoints": [],
      "color": "#9CA98C",
      "waitBeforeMs": 0,
      "waitAfterMs": 0,
      "waitBeforeName": "",
      "waitAfterName": ""
    },
    {
      "id": "ml1taesf-s8l4eh",
      "name": "align2",
      "endPoint": {
        "x": 43.218,
        "y": 59.209,
        "heading": "linear",
        "reverse": false,
        "startDeg": 134,
        "endDeg": 180
      },
      "controlPoints": [],
      "color": "#CD9D99",
      "waitBeforeMs": 0,
      "waitAfterMs": 0,
      "waitBeforeName": "",
      "waitAfterName": ""
    },
    {
      "id": "ml1taqas-yigi0i",
      "name": "entry2",
      "endPoint": {
        "x": 11.5,
        "y": 59.209,
        "heading": "tangential",
        "reverse": false
      },
      "controlPoints": [],
      "color": "#6DB8B5",
      "waitBeforeMs": 0,
      "waitAfterMs": 0,
      "waitBeforeName": "",
      "waitAfterName": ""
    },
    {
      "id": "ml1tax5e-ioxjbc",
      "name": "exit2",
      "endPoint": {
        "x": 53.226,
        "y": 89.948,
        "heading": "linear",
        "reverse": false,
        "startDeg": 180,
        "endDeg": 134
      },
      "controlPoints": [
        {
          "x": 43.3,
          "y": 59.2
        }
      ],
      "color": "#BC698D",
      "waitBeforeMs": 0,
      "waitAfterMs": 0,
      "waitBeforeName": "",
      "waitAfterName": ""
    },
    {
      "id": "ml1tcpof-0heo2d",
      "name": "grabN1",
      "endPoint": {
        "x": 11.8180815876516,
        "y": 20.6295479603087,
        "heading": "tangential",
        "reverse": false,
        "startDeg": 134,
        "endDeg": 230
      },
      "controlPoints": [],
      "color": "#567C55",
      "waitBeforeMs": 0,
      "waitAfterMs": 0,
      "waitBeforeName": "",
      "waitAfterName": ""
    },
    {
      "id": "ml1u6jwi-0pu6ux",
      "name": "ExitN1",
      "endPoint": {
        "x": 53.226,
        "y": 89.948,
        "heading": "linear",
        "reverse": false,
        "endDeg": 134,
        "startDeg": 238
      },
      "controlPoints": [],
      "color": "#BBCB97",
      "waitBeforeMs": 0,
      "waitAfterMs": 0,
      "waitBeforeName": "",
      "waitAfterName": ""
    },
    {
      "id": "ml1ud033-jjfaob",
      "name": "leave",
      "endPoint": {
        "x": 32.41234840132303,
        "y": 77.32304299889746,
        "heading": "linear",
        "reverse": false,
        "startDeg": 134,
        "endDeg": 180
      },
      "controlPoints": [],
      "color": "#767595",
      "waitBeforeMs": 0,
      "waitAfterMs": 0,
      "waitBeforeName": "",
      "waitAfterName": ""
    }
  ],
  "shapes": [],
  "sequence": [
    {
      "kind": "path",
      "lineId": "line-roqz1lyl6p"
    },
    {
      "kind": "path",
      "lineId": "mkhm0n4k-ipu93w"
    },
    {
      "kind": "path",
      "lineId": "ml1syb09-r6kfr3"
    },
    {
      "kind": "wait",
      "id": "ml1t48ms-6ldou8",
      "name": "gateOpenPause",
      "durationMs": 500,
      "locked": false
    },
    {
      "kind": "path",
      "lineId": "ml1t9pkq-umyq3f"
    },
    {
      "kind": "path",
      "lineId": "ml1taesf-s8l4eh"
    },
    {
      "kind": "path",
      "lineId": "ml1taqas-yigi0i"
    },
    {
      "kind": "path",
      "lineId": "ml1tax5e-ioxjbc"
    },
    {
      "kind": "path",
      "lineId": "ml1tcpof-0heo2d"
    },
    {
      "kind": "path",
      "lineId": "ml1u6jwi-0pu6ux"
    },
    {
      "kind": "path",
      "lineId": "ml1ud033-jjfaob"
    }
  ],
  "version": "1.2.1",
  "timestamp": "2026-01-31T05:20:10.931Z"
}