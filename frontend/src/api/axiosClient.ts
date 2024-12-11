import axios, {AxiosInstance} from "axios";

const axiosClient: AxiosInstance = axios.create({
    baseURL: "http://localhost:8080/api", // Backend Base URL
    headers: {
        "Content-Type": "application/json",
    },
});

export default axiosClient;
