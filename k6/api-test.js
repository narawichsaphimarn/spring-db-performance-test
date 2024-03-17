import { check } from "k6";
import http from "k6/http";

export const options = {
  vus: 1,
  duration: "1m",
};
export default function () {
  const url =
    "http://spring-test-performance-db-general:8080/api/v1/personal-information";
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

  check(res, {
    "is status 200": (r) => r.status === 200,
  });
}
