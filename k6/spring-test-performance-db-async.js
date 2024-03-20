import { check } from "k6";
import http from "k6/http";
import { Rate, Trend } from 'k6/metrics';
const errorRate = new Rate('error_rate');
let http_res_time_avg = new Trend('http_res_time_avg')
let index = 1;
export const options = {
  // vus: 100,
  // duration: '10m',
  stages: [
    { duration: "5m", target: 100 },
    { duration: "10m", target: 1000 },
    { duration: "5m", target: 0 },
  ],
  thresholds: {
    'error_rate': ['rate<0.1'],
    'http_req_duration': ['p(95)<500'],
  }
};
export default function () {
  // const url =
  //   "http://spring-test-performance-db-async:8080/api/v1/personal-information";
  const url =
    "http://localhost:8080/api/v1/personal-information";
  const payload = JSON.stringify({
    firstName: `chon${index}`,
    lastName: "bu",
    age: 26,
    identityCard: "1234567890123",
  });

  const params = {
    headers: {
      "Content-Type": "application/json",
    },
  };

  const res = http.post(url, payload, params);
  const passed = check(res, {
    "is status 200": (r) => r.status === 200,
  });
  errorRate.add(!passed);
  http_res_time_avg.add(res.timings.duration);
  index++;
}
