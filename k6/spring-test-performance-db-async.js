import { check } from "k6";
import http from "k6/http";
import { Rate } from 'k6/metrics';
const errorRate = new Rate('error_rate')
export const options = {
  stages: [
    { duration: "1m", target: 100 },
    { duration: "5m", target: 100 },
  ],
  thresholds: {
    'error_rate': ['rate<0.1'],
    'http_req_duration': ['p(95)<500'],
  }
};
export default function () {
  const url =
    "http://spring-test-performance-db-async:8080/api/v1/personal-information";
  const payload = JSON.stringify({
    firstName: "chon",
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
}
