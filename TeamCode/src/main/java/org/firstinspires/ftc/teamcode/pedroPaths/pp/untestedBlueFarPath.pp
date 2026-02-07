{
  "startPoint": {
    "x": 56,
    "y": 8,
    "heading": "linear",
    "startDeg": 90,
    "endDeg": 180,
    "locked": false
  },
  "lines": [
    {
      "id": "line-atb04c13w4",
      "name": "preload",
      "endPoint": {
        "x": 56,
        "y": 90,
        "heading": "linear",
        "startDeg": 90,
        "endDeg": 134
      },
      "controlPoints": [],
      "color": "#BA89D9",
      "locked": false,
      "waitBeforeMs": 0,
      "waitAfterMs": 0,
      "waitBeforeName": "",
      "waitAfterName": ""
    },
    {
      "id": "mkhxajm2-62tc49",
      "name": "align3",
      "endPoint": {
        "x": 43.218,
        "y": 34.924,
        "heading": "linear",
        "reverse": false,
        "startDeg": 134,
        "endDeg": 180
      },
      "controlPoints": [],
      "color": "#55699A",
      "waitBeforeMs": 0,
      "waitAfterMs": 0,
      "waitBeforeName": "",
      "waitAfterName": ""
    },
    {
      "id": "mkhxbjql-i6s5xm",
      "name": "entry3",
      "endPoint": {
        "x": 10.27,
        "y": 34.924,
        "heading": "tangential",
        "reverse": false
      },
      "controlPoints": [],
      "color": "#B7D6A7",
      "waitBeforeMs": 0,
      "waitAfterMs": 0,
      "waitBeforeName": "",
      "waitAfterName": ""
    },
    {
      "id": "mkhxd4x5-opdxw4",
      "name": "exit3",
      "endPoint": {
        "x": 56.143329658213894,
        "y": 89.79933847850054,
        "heading": "linear",
        "reverse": false,
        "startDeg": 180,
        "endDeg": 134
      },
      "controlPoints": [
        {
          "x": 56.72,
          "y": 38.86
        }
      ],
      "color": "#DAA5A5",
      "waitBeforeMs": 0,
      "waitAfterMs": 0,
      "waitBeforeName": "",
      "waitAfterName": ""
    },
    {
      "id": "mkhxel2v-50bnxo",
      "name": "leave",
      "endPoint": {
        "x": 56,
        "y": 38,
        "heading": "linear",
        "reverse": false,
        "startDeg": 134,
        "endDeg": 180
      },
      "controlPoints": [],
      "color": "#7DACA8",
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
      "lineId": "line-atb04c13w4"
    },
    {
      "kind": "path",
      "lineId": "mkhxajm2-62tc49"
    },
    {
      "kind": "path",
      "lineId": "mkhxbjql-i6s5xm"
    },
    {
      "kind": "path",
      "lineId": "mkhxd4x5-opdxw4"
    },
    {
      "kind": "path",
      "lineId": "mkhxel2v-50bnxo"
    }
  ],
  "version": "1.2.1",
  "timestamp": "2026-01-17T06:37:15.845Z"
}