{
  "startPoint": {
    "x": 56,
    "y": 9,
    "heading": "linear",
    "startDeg": 90,
    "endDeg": 180,
    "locked": true
  },
  "lines": [
    {
      "id": "line-49sjyurq2fx",
      "name": "exit",
      "endPoint": {
        "x": 56,
        "y": 14,
        "heading": "linear",
        "startDeg": 90,
        "endDeg": 90
      },
      "controlPoints": [],
      "color": "#9A67AB",
      "locked": false,
      "waitBeforeMs": 0,
      "waitAfterMs": 0,
      "waitBeforeName": "",
      "waitAfterName": ""
    },
    {
      "id": "mla16ofl-in4clu",
      "name": "preload",
      "endPoint": {
        "x": 60,
        "y": 14,
        "heading": "constant",
        "reverse": false,
        "degrees": 108
      },
      "controlPoints": [],
      "color": "#7CCAA7",
      "waitBeforeMs": 0,
      "waitAfterMs": 0,
      "waitBeforeName": "",
      "waitAfterName": ""
    },
    {
      "id": "mlah6d4j-0q3g5t",
      "name": "grab1",
      "endPoint": {
        "x": 13.592356687898093,
        "y": 11.74522292993631,
        "heading": "tangential",
        "reverse": false
      },
      "controlPoints": [],
      "color": "#8CABD9",
      "waitBeforeMs": 0,
      "waitAfterMs": 0,
      "waitBeforeName": "",
      "waitAfterName": ""
    },
    {
      "id": "mlah6od4-1chm6q",
      "name": "exit1",
      "endPoint": {
        "x": 60,
        "y": 14,
        "heading": "linear",
        "reverse": false,
        "startDeg": 180,
        "endDeg": 108
      },
      "controlPoints": [],
      "color": "#77A969",
      "waitBeforeMs": 0,
      "waitAfterMs": 0,
      "waitBeforeName": "",
      "waitAfterName": ""
    },
    {
      "id": "mlah71bx-onblxu",
      "name": "leave",
      "endPoint": {
        "x": 32.84713375796177,
        "y": 14.012738853503215,
        "heading": "tangential",
        "reverse": false
      },
      "controlPoints": [],
      "color": "#787C68",
      "waitBeforeMs": 0,
      "waitAfterMs": 0,
      "waitBeforeName": "",
      "waitAfterName": ""
    }
  ],
  "shapes": [
    {
      "id": "triangle-1",
      "name": "Red Goal",
      "vertices": [
        {
          "x": 144,
          "y": 70
        },
        {
          "x": 144,
          "y": 144
        },
        {
          "x": 120,
          "y": 144
        },
        {
          "x": 138,
          "y": 119
        },
        {
          "x": 138,
          "y": 70
        }
      ],
      "color": "#dc2626",
      "fillColor": "#ff6b6b"
    },
    {
      "id": "triangle-2",
      "name": "Blue Goal",
      "vertices": [
        {
          "x": 6,
          "y": 119
        },
        {
          "x": 25,
          "y": 144
        },
        {
          "x": 0,
          "y": 144
        },
        {
          "x": 0,
          "y": 70
        },
        {
          "x": 7,
          "y": 70
        }
      ],
      "color": "#2563eb",
      "fillColor": "#60a5fa"
    }
  ],
  "sequence": [
    {
      "kind": "path",
      "lineId": "line-49sjyurq2fx"
    },
    {
      "kind": "path",
      "lineId": "mla16ofl-in4clu"
    },
    {
      "kind": "path",
      "lineId": "mlah6d4j-0q3g5t"
    },
    {
      "kind": "path",
      "lineId": "mlah6od4-1chm6q"
    },
    {
      "kind": "path",
      "lineId": "mlah71bx-onblxu"
    }
  ],
  "version": "1.2.1",
  "timestamp": "2026-02-07T11:43:44.343Z"
}