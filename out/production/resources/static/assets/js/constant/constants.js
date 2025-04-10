const paymentMethod = [
  {
    cardCompany           : "현대카드",
    value                 : "HD",
    brand                 : "MASTER",
    monthlyInstallmentPlan: [
      {
        name : "일시불",
        value: 0,
      },
      {
        name : "1개월",
        value: 1,
      },
      {
        name : "2개월",
        value: 2,
      },
      {
        name : "3개월",
        value: 3,
      },
    ],
  },
  {
    cardCompany           : "신한카드",
    value                 : "SH",
    brand                 : "VISA",
    monthlyInstallmentPlan: [
      {
        name : "일시불",
        value: 0,
      },
    ],
  },
  {
    cardCompany           : "농협카드",
    value                 : "NH",
    brand                 : "VISA",
    monthlyInstallmentPlan: [
      {
        name : "일시불",
        value: 0,
      },
    ],
  },
];

const payment = {
  method: [
    {name: "신용카드", key: "CREDITCARD"},
    {name: "실시간 계좌이체", key: "TRANSPORT"},
  ],
}