import axios, { AxiosResponse } from "axios";
import axiosClient from "./axiosClient";
import { AuthResponse, LoginResponse } from "@/types/authTypes";

export const registerUser = async (email: string, password: string): Promise<AuthResponse> => {
    try {
        const response: AxiosResponse<AuthResponse> = await axiosClient.post<AuthResponse>("/register", { email, password });
        return response.data;
    } catch (error: unknown) {
        if (axios.isAxiosError(error) && error.response) {
            throw error.response.data; // Return the error from the server
        }
        throw { message: "Something went wrong" }; // Fallback error
    }
};

export const loginUser = async (email: string, password: string): Promise<LoginResponse> => {
    try {
        const response: AxiosResponse<LoginResponse> = await axiosClient.post<LoginResponse>("/login", { email, password });
        return response.data;
    } catch (error: unknown) {
        if (axios.isAxiosError(error) && error.response) {
            throw error.response.data; // Return the error from the server
        }
        throw { message: "Something went wrong" }; // Fallback error
    }
};
