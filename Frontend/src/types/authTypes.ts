export interface UserLoginDto {
  userName: string;
  password: string;
}

export interface TokenResponse {
  access_token: string;
}
