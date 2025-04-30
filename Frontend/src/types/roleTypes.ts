export enum Roles {
  USER = 'USER',
  ADMIN = 'ADMIN',
}

export interface RoleDto {
  id: number;
  role: Roles;
}
