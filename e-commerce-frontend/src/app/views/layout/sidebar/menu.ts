import { MenuItem } from './menu.model';

export const MENU: MenuItem[] = [

  {
    label: 'Início',
    isTitle: true
  }
  ,
  {
    label: 'Catálogo de produtos',
    icon: 'layout',
    subItems: [
      {
        label: 'Produtos',
        link: '/components/products'
      }
    ]
  }
  ,
  {
    label: 'Cadastros',
    icon: 'layout',
    subItems: [
      {
        label: 'Login',
        link: '/auth/login'
      },
      {
        label: 'Cadastro',
        link: '/auth/register'
      },
      {
        label: 'Cadastrar Produto',
        link: '/components/register-products'
      }
    ]
  }

];
